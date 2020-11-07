import java.io.*;
import java.lang.*;

public class DnsTUI
{
    // Attribute
    private ExeCmd cmd;

    // Constructor
    public DnsTUI()
    {
        this.cmd = new ExeCmd();
    }

    public void nextCommand(String command) throws IOException
    {
        // Get number of dots in the command to know wether it is an AdresseIP or a NomMachine
        int dotCount = 0;
        for (int i = 0; i < command.length(); i++)
        {
            char tmp = command.charAt(i);
            if (tmp == '.')
                dotCount++;
        }

        // If it is a NomMachine
        if (dotCount == 2)
        {
            this.cmd.setExeCmd(command, "machineToIp");
            show(this.cmd.execute());
        }
        // If it is an AdresseIP
        else if (dotCount == 3)
        {
            this.cmd.setExeCmd(command, "ipToMachine");
            show(this.cmd.execute());
        }
        // If command is 'ls' (lists IPs or machines of a domain depending on argument)
        else if (command.contains("ls"))
        {
            // If '-a' argument: list corresponding AdresseIP
            if (command.contains("-a"))
            {
                String domain = "";
                int spaceCount = 0;
                for (int i = 0; i < command.length(); i++)
                {
                    if (Character.isWhitespace(command.charAt(i)))
                        spaceCount++;
                    if (spaceCount == 2)
                    {
                        domain = command.substring(i + 1, command.length());
                        break;
                    }
                }
                this.cmd.setExeCmd(domain, "ls -a");
                show(this.cmd.execute());
            }
            // If no argument: list corresponding NomMachine
            else
            {
                String domain = "";
                int spaceCount = 0;
                for (int i = 0; i < command.length(); i++)
                {
                    if (Character.isWhitespace(command.charAt(i)))
                    {
                        spaceCount++;
                        domain = command.substring(i + 1, command.length());
                        break;
                    }
                }
                this.cmd.setExeCmd(domain, "ls");
                show(this.cmd.execute());
            }
        }
        // If user exits program
        else if (command.equals("q"))
        {
            System.exit(0);
        }
        // Typing error
        else
        {
            show("Error: unknown command\n"
                    + "Please check that you have typed correctly");
        }
    }

    // Show result of method execute()
    public void show(String result)
    {
        System.out.println(result);
    }
}
