import java.io.*;
import java.util.*;

public class ExeCmd {
    private String cmd;
    private String arg;

    public ExeCmd() {
        this.cmd = "";
        this.arg = "";
    }

    public void setExeCmd(String cmd, String arg) {
        this.cmd = cmd;
        this.arg = arg;
    }

    public String execute() throws IOException {
        Dns dns = new Dns();
        dns.initDatabase();
        String result = "";

        if (this.arg.equals("machineToIp")) {
            MachineName command = new MachineName(this.cmd);
            result = dns.getItem(command).getIp().toString();
            return result;
        }
        if (this.arg.equals("ipToMachine")) {
            IPAddress command = new IPAddress(this.cmd);
            result = dns.getItem(command).getMachineName().toString();
            return result;
        }
        if (this.arg.equals("ls")) {
            ArrayList<String> domList = dns.getItems(cmd, 'm');
            Iterator<String> iter = domList.iterator();

            while (iter.hasNext()) {
                result = result + iter.next() + "\n";
            }

            return result;
        }
        if (this.arg.equals("ls -a")) {
            ArrayList<String> domList = dns.getItems(cmd, 'a');
            Iterator<String> iter = domList.iterator();

            while (iter.hasNext()) {
                result = result + iter.next() + "\n";
            }

            return result;
        } else {
            System.out.println("Error: method execute() did not run correctly");
            return null;
        }
    }
}
