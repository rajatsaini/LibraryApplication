package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public class BookAuthorDao {
	
	@Autowired
	private JdbcTemplate template;
	
	private static final String INSERT_BOOK_AUTHOR
									= "INSERT INTO BOOK_AUTHOR VALUES(?,?)";
	
	private static final String GET_BOOK_ISBN_LIST_WITH_AUTHOR_ID
									= "SELECT ISBN FROM BOOK_AUTHOR WHERE AUTHOR_ID=?";
	
	private static final String GET_AUTHOR_LIST_WITH_ISBN
									= "SELECT AUTHOR_ID FROM BOOK_AUTHOR WHERE ISBN=?";
	
	public int insertBookAuthor(long isbn,int authorId){
		return template.update(INSERT_BOOK_AUTHOR,
						isbn,
						authorId);
	}

	public List<Long> getBookIsbnListWithAuthorId(int authorId){
		return template.queryForList(GET_BOOK_ISBN_LIST_WITH_AUTHOR_ID, Long.class,authorId);
	}
	
	public List<Integer> getAuthorIdListWithIsbn(long isbn){
		return template.queryForList(GET_AUTHOR_LIST_WITH_ISBN, Integer.class,isbn);
	}
}
