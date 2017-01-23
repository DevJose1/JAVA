package entities;

import java.util.GregorianCalendar;

public interface IMedia {

	void addAuthor(Author author);

	Publisher getPublisher();

	void setPublisher(Publisher publisher);

	int getId();

	void setId(int id);

	String getEan13();

	void setEan13(String ean13);

	String getTitle();

	void setTitle(String title);

	double getPrice();

	void setPrice(double price) throws MediaException;

	int getWeight();

	void setWeight(int weight);

	GregorianCalendar getParutionDate();

	void setParutionDate(GregorianCalendar parutionDate);

	String getSummary();

	void setSummary(String summary);

	double getVatRate();

	double getVATPrice();

}