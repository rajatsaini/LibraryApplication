package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AuthorDao;
import dao.BookAuthorDao;
import dao.BookDao;
import model.Author;
import model.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private BookAuthorDao bookAuthorDao;
	
	@RequestMapping(value="/addBookDetails")
	public String bookDetailsForm(){
		return "bookDetailsForm";
	}
	
	@RequestMapping(value="/addAuthorsDetail",method=RequestMethod.POST)
	public String addNewRegion(@RequestParam("isbn") long isbn,
							   @RequestParam("title") String title,
							   @RequestParam("category") String category,
							   @RequestParam("publishingYear") int publishingYear,
							   @RequestParam("edition") int edition,
							   @RequestParam("noOfCopies") int noOfCopies,
							   HttpSession session,
							   HttpServletRequest request,
								Model model){
		
		Book newBook = new Book(isbn,title);
		newBook.setCategory(category);
		newBook.setPublishingYear(publishingYear);
		newBook.setEdition(edition);
		newBook.setNoOfCopies(noOfCopies);		
		try{
			//int inserted = bookDao.insertBook(newBook);
			
				model.addAttribute("msg","Book Details Saved. Choose the Author(s).");
				List<Author> authors = authorDao.getAllAuthors();
				model.addAttribute("authors",authors);
				session.invalidate();
				session = request.getSession();
				if(session ==null){
					System.out.println("Session not created yet in addAuthors Detial.");
				}
				session.setAttribute("sessionIsbn", isbn);
				session.setAttribute("book", newBook);
				return "addAuthorsDetail";
		}
		catch(DuplicateKeyException e){
			model.addAttribute("msg","Book already exists");
			return "bookDetailsForm";
		}		
		
	}
	
	@RequestMapping(value="/addAuthorForm")
	public String addAuthorForm(){
		return "addAuthorForm";
	}
	
	@RequestMapping(value="/addNewAuthor",method=RequestMethod.POST)
	public String addNewAuthor(@RequestParam("authorName") String authorName,
								Model model){
		int inserted = authorDao.insertAuthor(authorName);
		if(inserted>0){
			model.addAttribute("msg", "Author Added Successfully !");
		}
		else{
			model.addAttribute("msg", "Author Couldn't be Added !!");
		}
		return "addNewAuthor";
	}
	
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addNewBook(HttpServletRequest request,HttpSession session,
								Model model){	
		session = request.getSession(false);
		if(session ==null){
			System.out.println("Session not received in addBook.");
		}
		long isbn = (long) session.getAttribute("sessionIsbn");
		String[] authors = request.getParameterValues("author");
		Book newBook = (Book) session.getAttribute("newBook");
		int insert = bookDao.insertBook(newBook);
		for(String s:authors){
			int authorId = Integer.parseInt(s);
			int inserted = bookAuthorDao.insertBookAuthor(isbn,authorId);
		}
		return "bookInserted";
	}
	
	/*@RequestMapping(value="/addAuthorsDetail",method=RequestMethod.POST)
	public String addNewRegion(@Valid @ModelAttribute("book") Book newBook,
								Errors errors,
								Model model,
								HttpSession session){
		Book newBook = new Book(isbn,title);
		newBook.setCategory(category);
		newBook.setPublishingYear(publishingYear);
		newBook.setEdition(edition);
		newBook.setNoOfCopies(noOfCopies);
		if(errors.hasErrors()){
			System.out.println("Inccorect Book Detials.");
			model.addAttribute("msg","Incorrect Book details.<br>"
					+ "ISBN should have 13 digits & title should be atleast 4 characters.");
			return "bookDetailsForm";
		}		
		try{
			int inserted = bookDao.insertBook(newBook);
			if(inserted>0){
				System.out.println("Book details received");
				model.addAttribute("msg","Book Details Saved. Choose the Author(s).");
				session.setAttribute("sessionBook", newBook);
			}
		}
		catch(DuplicateKeyException e){
			System.out.println("Book already existed.");
			model.addAttribute("msg","Book already exists");
			return "bookDetailsForm";
		}		
		return "addAuthorsDetail";
	}*/
	
	@RequestMapping(value="/findBookForm")
	public String findBookForm(){
		return "findBookForm";
	}
	
	@RequestMapping(value="/searchBookResult")
	public String searchBookResult(@RequestParam("type") String searchType,
								   @RequestParam("searchString") String searchString,
								   Model model){
		
		System.out.println(searchType+" "+searchString);
		if(searchType.equals("category")){
			List<Book> bookWithCategory = bookDao.getBookWithCategory(searchString.toUpperCase());
			model.addAttribute("books",bookWithCategory);
			List<ArrayList<Author>> listOfAuthorsList = new ArrayList<ArrayList<Author>>();
			int noOfBooks = bookWithCategory.size();
			for(int i=0;i<noOfBooks;i++){
				long tempIsbn = bookWithCategory.get(i).getIsbn();
				System.out.println("ISBN: "+tempIsbn);
				List<Integer> authorIdListWithIsbn = bookAuthorDao.getAuthorIdListWithIsbn(tempIsbn);
				for(Integer m:authorIdListWithIsbn){
					System.out.println("List of author ID: "+m);
				}
				int authorIdSize = authorIdListWithIsbn.size();
				ArrayList<Author> tempAuthorList = new ArrayList<>();
				for(int j=0;j<authorIdSize;j++){
					System.out.println("Id with searching: "+authorIdListWithIsbn.get(j));
					Author author =  authorDao.getAuthorById(authorIdListWithIsbn.get(j));
					System.out.println("Author : "+author.getAuthorName());
					tempAuthorList.add(author);
				}
				listOfAuthorsList.add(tempAuthorList);				
			}
			model.addAttribute("listOfAuthorList",listOfAuthorsList);
			int sizeOfListList = listOfAuthorsList.size();
			System.out.println("Size of List of List"+sizeOfListList);
			for(int i=0;i<sizeOfListList;i++){
				for(int j=0;j<listOfAuthorsList.get(i).size();j++){
					System.out.print(listOfAuthorsList.get(i).get(j).getAuthorName()+" "+i+ " "+j);
				}
				System.out.println();
			}
			
			return "searchBookResult";
		}
		else if(searchType.equals("bookName")){
			List<Book> bookWithTitle = bookDao.getBookWithTitle(searchString.toUpperCase());
			model.addAttribute("books",bookWithTitle);
			return "searchBookResult";
		}
		else if(searchType.equals("isbnNumber")){
			long isbn = Long.parseLong(searchString);
			Book bookWithIsbn = bookDao.getBookWithIsbn(isbn);
			model.addAttribute("books",bookWithIsbn);
			return "searchBookResult";
		}
		else if(searchType.equals("author")){
			int authorId = authorDao.getAuthorByName(searchString);
			List<Long> isbnList = bookAuthorDao.getBookIsbnListWithAuthorId(authorId);
			int listSize = isbnList.size();
			List<Book> bookWithIsbn = new ArrayList<>();
			for(int i=0;i<listSize;i++){
				bookWithIsbn.add(bookDao.getBookWithIsbn(isbnList.get(i)));
			}
			model.addAttribute("books",bookWithIsbn);
			return "searchBookResult";
		}
		return "searchBookResult";
	}
	
	@RequestMapping(value="/searchBookByAuthor")
	public String findBookByAuthor(@RequestParam("authorId") int authorId,
									Model model){
		
		List<Long> isbnList = bookAuthorDao.getBookIsbnListWithAuthorId(authorId);
		int listSize = isbnList.size();
		List<Book> bookWithIsbn = new ArrayList<>();
		for(int i=0;i<listSize;i++){
			bookWithIsbn.add(bookDao.getBookWithIsbn(isbnList.get(i)));
		}
		model.addAttribute("books",bookWithIsbn);
		return "findBookByAuthor";
	}
	
	
}
