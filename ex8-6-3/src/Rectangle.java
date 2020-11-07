public class Rectangle extends Figure {
	// Attributes
	private Point2D bottomLeft;
	private Point2D topRight;

	// Constructor
	public Rectangle(Point2D bottomLeft, Point2D topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}

	// Methods
	public double calcLength() {
		double length = this.topRight.getX() - this.bottomLeft.getX();
		return length;
	}

	public double calcWidth() {
		double width = this.topRight.getY() - this.bottomLeft.getY();
		return width;
	}

	public double calcPerimeter() {
		double length = calcLength();
		double width = calcWidth();
		double perimeter = (length * 2) + (width * 2);
		return perimeter;
	}

	public double calcArea() {
		double length = calcLength();
		double width = calcWidth();
		double area = length * width;
		return area;
	}

	public void move(double dx, double dy) {
		this.bottomLeft.move(dx, dy);
		this.topRight.move(dx, dy);
	}

	public void print() {
		System.out.println("\nRectangle");
		System.out.format("Bottom left point at (%.2f, %.2f)\n", this.bottomLeft.getX(), this.bottomLeft.getY());
		System.out.format("Top right point at (%.2f, %.2f)\n", this.topRight.getX(), this.topRight.getY());
		System.out.format("Perimeter = %.2f cm\n", calcPerimeter());
		System.out.format("Area = %.2f cm²\n", calcArea());
	}
}
