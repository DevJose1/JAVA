package reporisoties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.*;


public abstract class AbstractRepository<T extends IMedia> implements IRepository<T> {

	private String uri;
	
	@Override
	public String getUri() {
		return this.uri;
	}

	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}
	

	protected List<T> getBySql(String sql) throws ClassNotFoundException, SQLException, MediaException {
		 Class.forName("org.postgresql.Driver");
		 Connection conn = DriverManager.getConnection(getUri());
		 Statement st = conn.createStatement();
		 ResultSet rs = st.executeQuery(sql);
		 List<T> list = new ArrayList<T>();
		 while(rs.next()) {
			 T entity = getByResultSet(rs);
		 	 list.add(entity);
		 }
		 conn.close(); 
		 return list;
	}

	protected abstract T getByResultSet(ResultSet rs) throws SQLException, MediaException;
	
	


}
