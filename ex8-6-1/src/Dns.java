import java.io.*;
import java.lang.*;
import java.util.*;

public class Dns
{
    // Attributes
    private HashMap<AdresseIP, NomMachine> ipToMachine;
    private HashMap<NomMachine, AdresseIP> machineToIp;

    // Constructor
    public Dns()
    {
        // Two hashmaps: 
        // First one is to get the NomMachine if an AdresseIP is passed in the command line
        // Second one is to get the AdresseIP if a NomMachine is passed in the command line
        this.ipToMachine = new HashMap<AdresseIP, NomMachine>();
        this.machineToIp = new HashMap<NomMachine, AdresseIP>();
    }

    // Initialize database from txt file
    public void initDatabase() throws IOException
    {
        // Initialize variables
        String filename = "database.txt";
        String line = "";
        BufferedReader input = null;

        try
        {
            input = new BufferedReader(new FileReader(filename));

            // Read file until EOF
            while((line = input.readLine()) != null)
            {
                // Get position of the white space in the line
                int space = 0;
                while(!Character.isWhitespace(line.charAt(space)))
                    space++;

                // Parse NomMachine (first part of the line until a space)
                NomMachine machineName = new NomMachine(line.substring(0, space));
                // Parse AdresseIP (rest of the line)
                AdresseIP ip = new AdresseIP(line.substring(space + 1, line.length()));

                // Fill both hashmaps with parsed NomMachine and AdresseIP
                this.ipToMachine.put(ip, machineName);
                this.machineToIp.put(machineName, ip);
            }
        }
        catch(FileNotFoundException e) // if the file could not be opened 
        {
            System.out.println("Error: cannot open file " + filename);
            System.exit(1);
        }
    }

    // Machine name getter
    public DnsItem getItem(NomMachine machine)
    {
        // Look for corresponding NomMachine in the hashmap; return as DnsItem if found
        for (Map.Entry<NomMachine, AdresseIP> element : this.machineToIp.entrySet())
            if (element.getKey().toString().equals(machine.toString()))
                return new DnsItem(element.getValue(), machine);

        // If not found, return as an unkown IP adress
        AdresseIP adress = new AdresseIP("Unknown IP adress for " + machine 
            + "\nPlease check that you have typed correctly");
        return new DnsItem(adress, machine);
    }

    // IP adress getter
    public DnsItem getItem(AdresseIP adress)
    {
        // Look for corresponding AdresseIP in the hashmap; return as DnsItem if found
        for (Map.Entry<AdresseIP, NomMachine> element : this.ipToMachine.entrySet())
            if (element.getKey().toString().equals(adress.toString()))
                return new DnsItem(adress, element.getValue());

        // If not found, return as an unknown NomMachine
        NomMachine machine = new NomMachine("Unknown machine name for " + adress 
            + "\nPlease check that you have typed correctly");
        return new DnsItem(adress, machine);
    }

    // Collection of DNS items getter
    public ArrayList<String> getItems(String domain, char mode)
    {
        // Initialize ArrayList of Strings to be returned
        ArrayList<String> match = new ArrayList<String>();

        // Go through hashmap
        for (Map.Entry<NomMachine, AdresseIP> element : this.machineToIp.entrySet())
        {
            // Get NomMachine and trim to domain component only
            String machine = element.getKey().toString();
            String dom = trim(machine);

            // Look for matching elements
            if (dom.equals(domain))
            {
                // Add to list corresponding NomMachine if no argument 
                if (mode == 'm')
                    match.add(element.getKey().toString());
                // Add to list corresponding AdresseIP if '-a' argument
                if (mode == 'a')
                    match.add(element.getValue().toString());
            }
        }
        return match;
    }

    // Trim domain component from NomMachine element
    public String trim(String machine)
    {
        String dom = "";
        int domStart = 0;
        for (int i = 0; i < machine.length(); i++)
        {
            char tmp = machine.charAt(i);
            // Get first dot position in NomMachine
            if (tmp == '.')
            {
                domStart = i;
                dom = machine.substring(domStart + 1, machine.length());
                break;
            }
        }
        return dom;
    }
}
