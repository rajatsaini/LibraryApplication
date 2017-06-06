package model;

public class Author {
	
	private int    authorId;
	private String authorName;
	
	public Author(){}
	
	public Author(int id,String name){
		this.authorId = id;
		this.authorName = name;
	}
	
	public Author(String name) {
		this.authorName = name;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
}
