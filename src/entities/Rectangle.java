package entities;

public class Rectangle {

	private double width;
	private double heigth;
	private Point origin;
	
	
	
	public Rectangle(double width, double heigth) {
		super();
		this.width = width;
		this.heigth = heigth;
	}
	public Rectangle() {
		
	}

	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public double getArray() {
		return width * heigth;
	}
	
	public double computeArray() {
		return width * heigth;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeigth() {
		return heigth;
	}
	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
	
}
