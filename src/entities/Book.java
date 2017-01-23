package entities;

public class Book extends Media {
	
	private int nbPage;
	private String isbn;
	private static int nbBook = 0;
	private Category category;
	
	public Book(int id, String title) {
		super(id,title);
		nbBook++;
		
	}
	public Book() {
		this(0,null);
	}
	
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public static int getNbBook() {
		return nbBook;
	}


	
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public double getVATPrice() {
		return getPrice() * (1 + 0.05);
	}

	

}
