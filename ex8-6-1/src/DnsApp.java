import java.io.*;
import java.util.*;

public class DnsApp 
{
	// Attribute
	private DnsTUI tui;

	// Constructor
	public DnsApp()
	{
		this.tui = new DnsTUI();
	}

	// Main program function
	public static void main(String[] args) throws IOException
	{
		// Print useful information to the user
		System.out.println("\nType 'q' to exit the program.\n");
		System.out.println("Please type an IP address (i.e. '127.0.0.1') " +
			"or a machine name (i.e. 'example.machine.name')");
		System.out.println("You can type 'ls [domain]' to list all machine names on the given domain " +
			"or add '-a' optional argument to list IP adresses on the given domain");

		DnsApp app = new DnsApp();

		// Main program loop
		while(true)
			app.run();
	}

	public void run() throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		String command = null;

		System.out.print("\n\t> ");
		// Get user input from the command line
		if (scanner.hasNextLine())
		{
			command = scanner.nextLine();
			this.tui.nextCommand(command);
		}
	}
}
