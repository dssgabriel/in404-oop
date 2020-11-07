import java.util.*;

public class UserInterface {
	// Attributes
	private String[] knownCommands;
	private String[] knownFigures;
	private int maxDrawnFigures;
	private int currentlyDrawnFigures;
	private Figure[] drawnFigures;

	// Constructor
	public UserInterface() {
		this.knownCommands = new String[] {"help", "quit", "new", "show", "move", "clear"};
		this.knownFigures = new String[] {"rectangle", "triangle", "circle", "quit"};
		this.maxDrawnFigures = 10;
		this.currentlyDrawnFigures = 0;
		this.drawnFigures = new Figure[maxDrawnFigures];
	}

	// Methods
	public void printCommands() {
		System.out.println("\nAvailable commands:");
		System.out.println("\thelp:\tprints this help");
		System.out.println("\tnew:\tcreate a new figure");
		System.out.println("\tshow:\tshow a figure's informations");
		System.out.println("\tmove:\tmove a figure");
		System.out.println("\tclear:\tclear a figure");
		System.out.println("\tquit:\texit the program");
	}

	public void printFigures() {
		System.out.println("\nAvailable figures:");
		System.out.println("\trectangle");
		System.out.println("\ttriangle");
		System.out.println("\tcircle");
	}

	public void readCommand() {
		System.out.print("\nPlease type a command:\n\t>> ");
		Scanner userInput = new Scanner(System.in);
		String command = userInput.nextLine();
		if (command.equals(this.knownCommands[0])) {
				printCommands();
		}
		else if (command.equals(this.knownCommands[1])) {
			System.exit(0);
		}
		else if (command.equals(this.knownCommands[2])) {
			newFigure();
		}
		else if (command.equals(this.knownCommands[3])) {
			showFigure();
		}
		else if (command.equals(this.knownCommands[4])) {
			moveFigure();
		}
		else if (command.equals(this.knownCommands[5])) {
				clearFigure();
		}
		else {
			System.out.println("Error: unknown command");
		}
	}

	public Point2D newPoint() {
		double x, y;
		System.out.print("Coordinate on the x axis:\n\t>> ");
		Scanner userInput = new Scanner(System.in);
		try {
			x = userInput.nextDouble();
		} 
		catch(InputMismatchException e) {
			System.out.println("Error: user input is of incorrect type");
			x = 0;
		}

		userInput = null;
		System.out.print("Coordinate on the y axis:\n\t>> ");
		userInput = new Scanner(System.in);
		try {
			y = userInput.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Error: user input is of incorrect type");
			y = 0;
		}

		return new Point2D(x, y);
	}

	public Rectangle newRectangle() {
		System.out.println("Please type the coordinates of the bottom left corner of your rectangle:");
		Point2D bottomLeft = newPoint();
		System.out.println("Please type the coordinates of the top right corner of your rectangle:");
		Point2D topRight = newPoint();
		if (bottomLeft.getX() > topRight.getX() || bottomLeft.getY() > topRight.getY()) {
			System.out.println("Error: impossible coordinates for bottom left and top right corner");
		}
		return new Rectangle(bottomLeft, topRight);
	}

	public Triangle newTriangle() {
		System.out.println("Please type the coordinates of the first corner of your triangle:");
		Point2D a = newPoint();
		System.out.println("Please type the coordinates of the second corner of your triangle:");
		Point2D b = newPoint();
		System.out.println("Please type the coordinates of the third corner of your triangle:");
		Point2D c = newPoint();
		return new Triangle(a, b, c);
	}

	public Circle newCircle() {
		System.out.println("Please type the coordinates of the center of your circle:");
		Point2D center = newPoint();
		System.out.print("Please type the radius of your circle:\n\t>> ");
		Scanner userInput = new Scanner(System.in);
		double radius;
		try {
			radius = userInput.nextDouble();
		}
		catch(InputMismatchException e) {
			System.out.println("Error: user input is of incorrect type");
			radius = 5;
		}
		return new Circle(center, radius);
	}

	public void newFigure() {
		printFigures();
		System.out.print("\nPlease type the name of the figure you want to draw:\n\t>> ");
		Scanner userInput = new Scanner(System.in);
		String figure = userInput.nextLine();
		if (currentlyDrawnFigures < maxDrawnFigures) {
			if (figure.equals(knownFigures[0])) {
				drawnFigures[currentlyDrawnFigures] = newRectangle();
				System.out.println("Your figure was drawn successfully!");
				currentlyDrawnFigures++;
			}
			else if (figure.equals(knownFigures[1])) {
				drawnFigures[currentlyDrawnFigures] = newTriangle();
				System.out.println("Your figure was drawn successfully!");
				currentlyDrawnFigures++;
			}
			else if (figure.equals(knownFigures[2])) {
				drawnFigures[currentlyDrawnFigures] = newCircle();
				System.out.println("Your figure was drawn successfully!");
				currentlyDrawnFigures++;
			}
			else if (figure.equals(knownFigures[3])) {
				System.exit(0);
			}
			else {
				System.out.println("Error: unknow figure");
			}
		}
		else {
			System.out.println("Error: maximum number of drawable figures has been reached");
		}
	}

	public void showFigure() {
		if (currentlyDrawnFigures > 0) {
			System.out.format("There are %d figures drawn currently\n", currentlyDrawnFigures);
			List<Integer> figuresToMove = new ArrayList<>();
			int figureNb;
			
			do {
				System.out.print("Of which one would you like to get its informations? Type '0' if you don't want to show any\n\t>> Figure n°");
				Scanner userInput = new Scanner(System.in);
				figureNb = userInput.nextInt();
				if (figureNb != 0) {
					figuresToMove.add(figureNb);
				}
			}
			while (figureNb != 0);

			for (int i = 0; i < figuresToMove.size(); i++) {
				figureNb = figuresToMove.get(i) - 1;
				if (figureNb <= currentlyDrawnFigures) {
					drawnFigures[figureNb].print();
				}
				else {
					System.out.println("Error: input is greater than the number of figures currently drawn");
				}
			}
		} 
		else {
			System.out.println("There is no figure to show!");
		}
	}

	public void moveFigure() {
		if (currentlyDrawnFigures > 0) {
			System.out.format("There are %d figures drawn currently\n", currentlyDrawnFigures);
			List<Integer> figuresToMove = new ArrayList<>();
			int figureNb;

			do {
				System.out.print("Which one would you like to move? Type '0' if you don't want to move any\n\t>> Figure n°");
				Scanner userInput = new Scanner(System.in);
				figureNb = userInput.nextInt();
				if (figureNb != 0) {
					figuresToMove.add(figureNb);
				}
			}
			while (figureNb != 0);

			double dx, dy;
			Scanner userInput = new Scanner(System.in);
			System.out.print("By how much would you like to shift the figure on x axis?\n\t>> ");
			userInput = new Scanner(System.in);
			dx = userInput.nextDouble();

			userInput = null;
			System.out.print("By how much would you like to shift the figure on y axis?\n\t>> ");
			userInput = new Scanner(System.in);
			dy = userInput.nextDouble();
			
			for (int i = 0; i < figuresToMove.size(); i++) {
				figureNb = figuresToMove.get(i) - 1;
				if (figureNb <= currentlyDrawnFigures) {
					drawnFigures[figureNb].move(dx, dy);
					System.out.println("Your figure was moved successfully!");
				}
				else {
					System.out.println("Error: input is greater than the number of figures currently drawn");
				}
			}
		} 
		else {
			System.out.println("There is no figure to move!");
		}
	}

	public void clearFigure() {
		if (currentlyDrawnFigures > 0) {
			System.out.format("There are %d figures drawn currently\n", currentlyDrawnFigures);
			System.out.print("Do you want to clear everything? [Y/n]\n\t>> ");
			Scanner userInput = new Scanner(System.in);
			String answer = userInput.nextLine();

			if (answer.equals("Y")) {
				for (int i = 0; i < currentlyDrawnFigures; i++) {
					drawnFigures[i] = null;
				}
				currentlyDrawnFigures = 0;
			} 
			else if (answer.equals("n")) {
				List<Integer> figuresToMove = new ArrayList<>();
				int figureNb;

				do {
					System.out.print("Which one would you like to clear? Type '0' if you don't want to clear any\n\t>> Figure n°");
					userInput = null;
					userInput = new Scanner(System.in);
					figureNb = userInput.nextInt();
					if (figureNb != 0) {
						figuresToMove.add(figureNb);
					}
				}
				while (figureNb != 0);

				for (int i = 0; i < figuresToMove.size(); i++) {
					figureNb = figuresToMove.get(i) - 1;
					if (figureNb <= currentlyDrawnFigures) {
						drawnFigures[figureNb] = null;
						currentlyDrawnFigures--;
						System.out.println("Your figure was cleared successfully!");
					}
					else {
						System.out.println("Error: input is greater than the number of figures currently drawn");
					}
				}
			}
		} 
		else {
			System.out.println("There is no figure to clear!");
		}
	}
}
