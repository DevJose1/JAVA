package entities;

public class Point {
	
	private double x;
	private double y;
	
	
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		x = 0;
		y = 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "("+x+","+y+")";
	}
	
	public void move(double newx, double newy) {
		x = newx;
		y = newy;
	}

}
