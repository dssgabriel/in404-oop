import java.io.*;
import java.lang.*;
import java.util.*;

public class Dns {
    private HashMap<IPAddress, MachineName> ipToMachine;
    private HashMap<MachineName, IPAddress> machineToIp;

    public Dns() {
        this.ipToMachine = new HashMap<IPAddress, MachineName>();
        this.machineToIp = new HashMap<MachineName, IPAddress>();
    }

    public void initDatabase() throws IOException {
        String filename = "database.txt";
        String line = "";
        BufferedReader input = null;

        try {
            input = new BufferedReader(new FileReader(filename));
            while((line = input.readLine()) != null) {
                int space = 0;
                while(!Character.isWhitespace(line.charAt(space))) {
                    space++;
                }
                MachineName machineName = new MachineName(line.substring(0, space));
                IPAddress ip = new IPAddress(line.substring(space + 1, line.length()));
                this.ipToMachine.put(ip, machineName);
                this.machineToIp.put(machineName, ip);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Error: cannot open file " + filename);
            System.exit(1);
        }
    }

    public DnsItem getItem(MachineName machine) {
        for (Map.Entry<MachineName, IPAddress> element : this.machineToIp.entrySet()) {
            if (element.getKey().toString().equals(machine.toString())) {
                return new DnsItem(element.getValue(), machine);
            }
        }

        IPAddress address = new IPAddress("Unknown IP adress for " + machine + "\nPlease check that you have typed correctly");
        return new DnsItem(address, machine);
    }

    public DnsItem getItem(IPAddress address) {
        for (Map.Entry<IPAddress, MachineName> element : this.ipToMachine.entrySet()) {
            if (element.getKey().toString().equals(address.toString())) {
                return new DnsItem(address, element.getValue());
            }
        }
        MachineName machine = new MachineName("Unknown machine name for " + address + "\nPlease check that you have typed correctly");
        return new DnsItem(address, machine);
    }

    public ArrayList<String> getItems(String domain, char mode) {
        ArrayList<String> match = new ArrayList<String>();

        for (Map.Entry<MachineName, IPAddress> element : this.machineToIp.entrySet()) {
            String machine = element.getKey().toString();
            String dom = trim(machine);

            if (dom.equals(domain)) {
                if (mode == 'm') {
                    match.add(element.getKey().toString());
                }
                if (mode == 'a') {
                    match.add(element.getValue().toString());
                }
            }
        }
        return match;
    }

    public String trim(String machine) {
        String dom = "";
        int domStart = 0;
        for (int i = 0; i < machine.length(); i++) {
            char tmp = machine.charAt(i);
            if (tmp == '.') {
                domStart = i;
                dom = machine.substring(domStart + 1, machine.length());
                break;
            }
        }
        return dom;
    }
}
