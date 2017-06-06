package model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	
	/*@Min(value=12,message="Should be 13")*/
	private long isbn;
	
	/*@NotEmpty(message="{invalidName}")
	@Size(min=4,message="{inavlidLength}")*/
	private String title;
	
	private String category;
	private List<Author> authors = new ArrayList<>();
	private int publishingYear;
	private int edition;
	private int noOfCopies;
	
	public Book(){}
	
	public Book(long isbn,String title){
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(long isbn, String title, String category, int publishingYear, int edition, int noOfCopies) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.publishingYear = publishingYear;
		this.edition = edition;
		this.noOfCopies = noOfCopies;
	}

	public void addAuthor(String name){
		Author author = new Author(name);
		getAuthors().add(author);
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
		
}
