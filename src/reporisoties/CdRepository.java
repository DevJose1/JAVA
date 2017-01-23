package reporisoties;
import entities.*;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.*;


public class CdRepository extends AbstractRepository<Cd> {

	@Override
	public List<Cd> getAll() throws IOException, MediaException, SQLException, ClassNotFoundException {
		return getBySql("select * from media where type = 1");
	}
	
	@Override
	public List<Cd> getByPrice(double price) throws IOException, MediaException, ClassNotFoundException, SQLException {
		return getBySql("select * from media where type = 1 and price <= "+price);
	}

	@Override
	public List<Cd> getByTitle(String title) throws IOException, MediaException, ClassNotFoundException, SQLException {
		return getBySql("select * from media where type = 1 and upper(title) like '%"+title.toUpperCase()+"%'");
	}

	@Override
	protected Cd getByResultSet(ResultSet rs) throws SQLException, MediaException {
		Cd cd = new Cd();
		 cd.setTitle(rs.getString("title"));
		 cd.setPrice(rs.getDouble("price"));
		 cd.setId(rs.getInt("id"));
		 cd.setNbTrack(rs.getInt("nbtrack"));
		 return cd;
	}


}
