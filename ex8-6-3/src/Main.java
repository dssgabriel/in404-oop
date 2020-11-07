import java.util.*;

public class Main {
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.printCommands();
		while(true) {
			ui.readCommand();
		}
	}
}
