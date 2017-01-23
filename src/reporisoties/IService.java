package reporisoties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Author;
import entities.Book;
import entities.Media;
import entities.MediaException;

public interface IService<T> {
	
	ArrayList <T>  search(String word) throws IOException, MediaException;
	ArrayList <T>  search(double price) throws IOException, MediaException;
	
	List<T> getById(String title) throws ClassNotFoundException, SQLException, IOException, MediaException;

	void addToCart(Media Cart) throws IOException,MediaException;
	
	


	

	
	
	
	
}
