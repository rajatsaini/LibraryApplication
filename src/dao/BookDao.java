package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public class BookDao {
	
	@Autowired
	private JdbcTemplate template;
	
	private static final String INSERT_BOOK
								= "INSERT INTO BOOK VALUES(?,?,?,?,?,?)";
	
	private static final String GET_BOOK_WITH_CATEGORY
								= "SELECT ISBN,"
										+ "TITLE,"
										+ "CATEGORY,"
										+ "PUBLISHING_YEAR,"
										+ "EDITION,"
										+ "NO_OF_COPIES FROM BOOK WHERE UPPER(CATEGORY)=?";
	
	private static final String GET_BOOK_WITH_TITLE
								= "SELECT ISBN,"
										+ "TITLE,"
										+ "CATEGORY,"
										+ "PUBLISHING_YEAR,"
										+ "EDITION,"
										+ "NO_OF_COPIES FROM BOOK WHERE UPPER(TITLE) = ?";
	
	private static final String GET_BOOK_WITH_ISBN
								= "SELECT ISBN,"
										+ "TITLE,"
										+ "CATEGORY,"
										+ "PUBLISHING_YEAR,"
										+ "EDITION,"
										+ "NO_OF_COPIES FROM BOOK WHERE ISBN = ?";
	
	public int insertBook(Book book){
		return template.update(INSERT_BOOK,
						book.getIsbn(),
						book.getTitle(),
						book.getCategory(),
						book.getPublishingYear(),
						book.getEdition(),
						book.getNoOfCopies());
	}
	
	public List<Book> getBookWithCategory(String category){
		return template.query(GET_BOOK_WITH_CATEGORY, new BookMapper(),category);
	}
	
	public List<Book> getBookWithTitle(String title){
		return template.query(GET_BOOK_WITH_TITLE, new BookMapper(),title);
	}
	
	public Book getBookWithIsbn(long isbn){
		return template.queryForObject(GET_BOOK_WITH_ISBN, new BookMapper(),isbn);
	}
	
	private class BookMapper implements RowMapper<Book>{
		@Override
		public Book mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Book(rs.getLong(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4),
							rs.getInt(5),
							rs.getInt(6));
		}
	}
	
	
}
