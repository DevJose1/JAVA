package tests;
import entities.*;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


import entities.Book;
import entities.Cart;
import entities.IMedia;
import entities.MediaException;
import reporisoties.BookRepository;
import reporisoties.IRepository;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.StringTokenizer;



public class MediaTests {

	@Test
	public void firstTest() {
		//Arrange
		int i = 1;
		//Act
		i += 1;
		//Assert
		assertEquals(2, i);
		
	}
	
	@Test
	public void secondTest() {
		//Arrange
		double i = 1;
		//Act
		i += 1;
		//Assert
		assertEquals(2, i,0.00001);
		assertTrue(i == 2);
		
	}
	
	@Test
	public void mediaPriceTest() throws MediaException {
		Book b = new Book();
		b.setPrice(10);
		assertEquals(10.5,b.getVATPrice(),0.00001);
	}

	@Test(expected=MediaException.class)
	public void mediaNegativePriceTest() throws MediaException {
		Book b = new Book();
		b.setPrice(-10);
	}
	
	@Test
	public void cartPriceTest() throws MediaException {
		Book b = new Book();
		b.setPrice(10);
		Cd cd = new Cd();
		cd.setPrice(10);
		Cart cart = new Cart();
		cart.getMedias().add(b);
		cart.getMedias().add(cd);
		assertEquals(22.5, cart.getTotalPrice(),0.00001);
	}
	
	@Test
	public void cartValidatedTest() throws MediaException {
		Cart cart = new Cart();
		assertFalse(cart.isValidated());
		cart.validate();
		assertTrue(cart.isValidated());
	}
	
	@Test
	@Ignore
	public void cartWithoutMediaImplementationTest() throws MediaException {
		Cart cart = new Cart();
		IMedia media = null;
		cart.getMedias().add(media);
		assertEquals(1, cart.getMedias().size());
		media.setPrice(10);
		assertEquals(10.5,cart.getTotalPrice(),0.00001);

	}
	
	@Test
	public void readCSVFile() throws IOException, MediaException, ClassNotFoundException, SQLException {
		IRepository repository = new BookRepository("/Users/adams/Documents/ressources");
		List<Book> list = repository.getAll();
		assertEquals(2, list.size());
		assertEquals(20, list.get(1).getPrice(),0.00001);
		Cart cart = new Cart();
		for(Book b : list) {
			cart.getMedias().add(b);
		}
		assertEquals(30.15, cart.getTotalPrice(), 0.00001);
	}
	
	 @Test
	 public void getBooksByPrice() throws IOException, MediaException, ClassNotFoundException, SQLException {
		 IRepository repository = new BookRepository("./ressources/books.txt");
		 List<Book> list = repository.getByPrice(15.0);
		 assertEquals(1, list.size()); 
	 }
	 
	 @Test
	 public void getBooksByTitle() throws IOException, MediaException, ClassNotFoundException, SQLException {
		 IRepository repository = new BookRepository("./ressources/books.txt");
		 List<Book> list = repository.getByTitle("java");
		 assertEquals(1, list.size()); 
	 }
	 
	 /*@Test
	 public void insertBook() throws IOException, MediaException {
		 IBookRepository repository = new BookRepository("./ressources/books.txt");
		 Book b = new Book(3,"Java 8");
		 int nbBook = repository.getAll().size();
		 repository.add(b);
		 assertEquals(nbBook + 1 , repository.getAll().size()); 
	 }*/
	 
	 @Test
	 public void firstJDBCTest() throws ClassNotFoundException, SQLException {
		 Class.forName("org.postgresql.Driver");
		 
		 //1.get connection to dabatase
		 Connection conn = DriverManager.getConnection
         ("jdbc:postgresql://localhost:5432/formation","postgres","formation");
		 //2.create a statement
		 Statement st = conn.createStatement();
		 //3.Execute SQL query
		 ResultSet rs = st.executeQuery("select * from media");
		 String title = null;
		 //4.Process the result set
		 while(rs.next()) {
			 title = rs.getString("title");
			 System.out.println(title);
		 }
		 assertEquals("White album", title);
		 conn.close(); 
	 }
	
}
