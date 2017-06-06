package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Author;

@Repository
public class AuthorDao {
	
	@Autowired
	private JdbcTemplate template;
	
	private static final String INSERT_AUTHOR
							= "INSERT INTO AUTHOR VALUES(AUTHOR_SEQ.NEXTVAL,?)";
	
	private static final String AUTHOR_GET_ALL
							= "SELECT AUTHOR_ID,AUTHOR_NAME FROM AUTHOR";
	
	private static final String GET_AUTHOR_ID_BY_NAME
							= "SELECT AUTHOR_ID FROM AUTHOR WHERE AUTHOR_NAME=?";
	
	private static final String GET_AUTHOR_BY_AUTHOR_ID
							= "SELECT AUTHOR_ID,AUTHOR_NAME FROM AUTHOR WHERE AUTHOR_ID=?";
	
	public int insertAuthor(String name){
		return template.update(INSERT_AUTHOR,
								name);
	}
	
	public List<Author> getAllAuthors(){
		return template.query(AUTHOR_GET_ALL, new AuthorMapper());
	}
	
	public int getAuthorByName(String authorName){
		return template.queryForObject(GET_AUTHOR_ID_BY_NAME,Integer.class,authorName);
	}
	
	public Author getAuthorById(int authorId){
		return template.queryForObject(GET_AUTHOR_BY_AUTHOR_ID, new AuthorMapper(),authorId);
	}
	
	private class AuthorMapper implements RowMapper<Author>{
		@Override
		public Author mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Author(rs.getInt(1),rs.getString(2));
		}
	}
	
}
