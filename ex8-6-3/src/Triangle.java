public class Triangle extends Figure {
	// Attributes
	private Point2D a;
	private Point2D b;
	private Point2D c;

	// Constructor
	public Triangle(Point2D a, Point2D b, Point2D c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// Methods
	public double lenSideA() {
		double length = Math.sqrt(Math.pow(this.b.getX() - this.c.getX(), 2) + Math.pow(this.b.getY() - this.c.getY(), 2));
		return length;
	}

	public double lenSideB() {
		double length = Math.sqrt(Math.pow(this.a.getX() - this.c.getX(), 2) + Math.pow(this.a.getY() - this.c.getY(), 2));
		return length;
	}

	public double lenSideC() {
		double length = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2));
		return length;
	}

	public double calcPerimeter() {
		double perimeter = lenSideA() + lenSideB() + lenSideC();
		return perimeter;
	}

	public double calcArea() {
		double semiPerimeter = calcPerimeter() / 2;
		double area = Math.sqrt(semiPerimeter * ((semiPerimeter - lenSideA()) * (semiPerimeter - lenSideB()) * (semiPerimeter - lenSideC())));
		return area;
	}

	public void move(double dx, double dy) {
		this.a.move(dx, dy);
		this.b.move(dx, dy);
		this.c.move(dx, dy);
	}

	public void print() {
		System.out.println("\nTriangle");
		System.out.format("A point at (%.2f, %.2f)\n", this.a.getX(), this.a.getY());
		System.out.format("B point at (%.2f, %.2f)\n", this.b.getX(), this.b.getY());
		System.out.format("C point at (%.2f, %.2f)\n", this.c.getX(), this.c.getY());
		System.out.format("Perimeter = %.2f cm\n", calcPerimeter());
		System.out.format("Area = %.2f cm²\n", calcArea());
	}
}
