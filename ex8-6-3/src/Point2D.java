public class Point2D {
	// Attributes
	private double x;
	private double y;

	// Constructor
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;	
	}

	// Methods
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void print() {
		System.out.println("x = " + this.x + ", y = " + this.y);
	}
}
