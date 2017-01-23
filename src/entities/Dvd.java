package entities;

public class Dvd extends Media {

	public Dvd(int id, String title) {
		super(id, title);
	}

	public Dvd() {
	}
	
	private int region;

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}
	
	@Override
	public double getVATPrice() {
		return getPrice() * 1.2;
	}

}
