public class Circle extends Figure {
	// Attributes
	private Point2D center;
	private double radius;

	// Constructor
	public Circle(Point2D center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	// Methods
	public double calcDiameter() {
		double diameter = this.radius * 2;
		return diameter;
	}

	public double calcPerimeter() {
		double perimeter = Math.PI * 2 * this.radius;
		return perimeter;
	}

	public double calcArea() {
		double area = Math.PI * Math.pow(this.radius, 2);
		return area;
	}

	public void move(double dx, double dy) {
		this.center.move(dx, dy);
	}

	public void print() {
		System.out.println("\nCircle");
		System.out.format("Center point at (%.2f, %.2f)\n", this.center.getX(), this.center.getY());
		System.out.format("Diameter = %.2f cm\n", calcDiameter());
		System.out.format("Perimeter = %.2f cm\n", calcPerimeter());
		System.out.format("Area = %.2f cm²\n", calcArea());
	}
}
