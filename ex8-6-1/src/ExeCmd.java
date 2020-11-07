import java.io.*;
import java.util.*;

public class ExeCmd {
    // Attribute
    private String cmd;
    private String arg;

    // Constructor
    public ExeCmd()
    {
        this.cmd = "";
        this.arg = "";
    }

    // Setter
    public void setExeCmd(String cmd, String arg)
    {
        this.cmd = cmd;
        this.arg = arg;
    }

    // Main executing method
    public String execute() throws IOException
    {
        // Create hashmaps from config file
        Dns dns = new Dns();
        dns.initDatabase();
        String result = "";

        // If user input is a NomMachine
        if (this.arg.equals("machineToIp"))
        {
            NomMachine command = new NomMachine(this.cmd);
            result = dns.getItem(command).getIp().toString();
            return result;
        }
        // If user input is an AdresseIP
        if (this.arg.equals("ipToMachine"))
        {
            AdresseIP command = new AdresseIP(this.cmd);
            result = dns.getItem(command).getMachineName().toString();
            return result;
        }
        // If user input is a 'ls' command
        if (this.arg.equals("ls"))
        {
            ArrayList<String> domList = dns.getItems(cmd, 'm');
            Iterator<String> iter = domList.iterator();

            while (iter.hasNext())
                result = result + iter.next() + "\n";

            return result;
        }
        // If user input is a 'ls -a' command
        if (this.arg.equals("ls -a"))
        {
            ArrayList<String> domList = dns.getItems(cmd, 'a');
            Iterator<String> iter = domList.iterator();

            while (iter.hasNext())
                result = result + iter.next() + "\n";

            return result;
        }
        else
        {
            System.out.println("Error: method execute() did not run correctly");
            return null;
        }
    }
}
