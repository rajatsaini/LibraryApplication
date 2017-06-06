package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.AuthorDao;
import dao.BookAuthorDao;
import dao.BookDao;
import model.Author;

public class BookAuthorService {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Autowired
	private BookAuthorDao bookAuthorDao;
	
	public List<Author> getAllAuthors(){
		return authorDao.getAllAuthors();
	}
}
