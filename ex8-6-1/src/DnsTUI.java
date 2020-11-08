import java.io.*;
import java.lang.*;

public class DnsTUI {
    private ExeCmd cmd;

    public DnsTUI() {
        this.cmd = new ExeCmd();
    }

    public void nextCommand(String command) throws IOException {
        int dotCount = 0;
        for (int i = 0; i < command.length(); i++) {
            char tmp = command.charAt(i);
            if (tmp == '.') {
                dotCount++;
            }
        }

        if (dotCount == 2) {
            this.cmd.setExeCmd(command, "machineToIp");
            show(this.cmd.execute());
        } else if (dotCount == 3) {
            this.cmd.setExeCmd(command, "ipToMachine");
            show(this.cmd.execute());
        } else if (command.contains("ls")) {
            if (command.contains("-a")) {
                String domain = "";
                int spaceCount = 0;
                for (int i = 0; i < command.length(); i++) {
                    if (Character.isWhitespace(command.charAt(i))) {
                        spaceCount++;
                    }
                    if (spaceCount == 2) {
                        domain = command.substring(i + 1, command.length());
                        break;
                    }
                }
                this.cmd.setExeCmd(domain, "ls -a");
                show(this.cmd.execute());
            } else {
                String domain = "";
                int spaceCount = 0;
                for (int i = 0; i < command.length(); i++) {
                    if (Character.isWhitespace(command.charAt(i))) {
                        spaceCount++;
                        domain = command.substring(i + 1, command.length());
                        break;
                    }
                }
                this.cmd.setExeCmd(domain, "ls");
                show(this.cmd.execute());
            }
        } else if (command.equals("q")) {
            System.exit(0);
        } else {
            show("Error: unknown command\n" + "Please check that you have typed correctly");
        }
    }

    public void show(String result) {
        System.out.println(result);
    }
}
