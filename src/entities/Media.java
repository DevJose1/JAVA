package entities;

import java.util.GregorianCalendar;

public abstract class Media implements IMedia {

	private int id;
	private String ean13;
	private String title;
	private double price;
	private int weight;
	private GregorianCalendar parutionDate;
	private String summary;
	public final double vatRate = 0.05;
	private Publisher publisher;
	private Author[] authors = new Author[10];
	private int nbAuthor = 0;

	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#addAuthor(com.m2i.formationjava.Author)
	 */
	@Override
	public void addAuthor(Author author) {
		authors[nbAuthor++]=author;
	}
	
	
	public Media(int id, String title) {
		this();
		this.id = id;
		this.title = title;
		
	}
	public Media() {
		this.price = 0;
	}
	
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getPublisher()
	 */
	@Override
	public Publisher getPublisher() {
		return publisher;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setPublisher(com.m2i.formationjava.Publisher)
	 */
	@Override
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getEan13()
	 */
	@Override
	public String getEan13() {
		return ean13;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setEan13(java.lang.String)
	 */
	@Override
	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getPrice()
	 */
	@Override
	public double getPrice() {
		return price;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setPrice(double)
	 */
	@Override
	public void setPrice(double price) throws MediaException {
		if(price <= 0) {
			throw new MediaException("Negative price");
		}
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getWeight()
	 */
	@Override
	public int getWeight() {
		return weight;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setWeight(int)
	 */
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getParutionDate()
	 */
	@Override
	public GregorianCalendar getParutionDate() {
		return parutionDate;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setParutionDate(java.util.GregorianCalendar)
	 */
	@Override
	public void setParutionDate(GregorianCalendar parutionDate) {
		this.parutionDate = parutionDate;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getSummary()
	 */
	@Override
	public String getSummary() {
		return summary;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#setSummary(java.lang.String)
	 */
	@Override
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getVatRate()
	 */
	@Override
	public double getVatRate() {
		return vatRate;
	}
	
	/* (non-Javadoc)
	 * @see com.m2i.formationjava.IMedia#getVATPrice()
	 */
	@Override
	public abstract double getVATPrice();

}
