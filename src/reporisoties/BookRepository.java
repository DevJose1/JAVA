package reporisoties;

import java.io.*;
import java.util.*;



import entities.*;

public class BookRepository implements IRepository<Book> {

	private String uri;
	private List<Book> cache = null;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public BookRepository(String uri) throws IOException, MediaException {
		this.uri = uri;
		getAll();
	}

	@Override
	public List<Book> getAll() throws IOException, MediaException {
		if(cache == null) {
			BufferedReader reader = new BufferedReader(new FileReader(uri));
			String line = reader.readLine();
			line = reader.readLine();
			List<Book> books = new ArrayList<Book>();
			while(line != null) {
				Book book = new Book();
				StringTokenizer st = new StringTokenizer(line, "\t");
				String token = st.nextToken();
				int id = Integer.parseInt(token.trim());
				String title = st.nextToken();
				String isbn = st.nextToken();
				token = st.nextToken();
				double price = Double.parseDouble(token);
				line = reader.readLine();
				book.setId(id);
				book.setPrice(price);
				book.setTitle(title);
				book.setIsbn(isbn);
				books.add(book);
			}
			reader.close();
			cache = books;
		}
		return cache;
	}
	
	public void clear() {
		cache = null;
	}

	@Override
	public List<Book> getByPrice(double price) throws IOException, MediaException {
		List<Book> books = new ArrayList<Book>();
		for(Book b : cache) {
			if(b.getPrice() <= price) {
				books.add(b);
			}
		}
		return books;
	}

	@Override
	public List<Book> getByTitle(String title) throws IOException, MediaException {
		List<Book> books = new ArrayList<Book>();
		for(Book b : cache) {
			if(b.getTitle().toUpperCase().contains(title.toUpperCase())) {
				books.add(b);
			}
		}
		return books;
	}

}
