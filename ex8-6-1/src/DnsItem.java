public class DnsItem {
    private IPAddress ip;
    private MachineName machineName;

    public DnsItem(IPAddress ip, MachineName machineName) {
        this.ip = ip;
        this.machineName = machineName;
    }

    public IPAddress getIp() {
        return this.ip;
    }

    public MachineName getMachineName() {
        return this.machineName;
    }

    public String getDnsItem() {
        return this.ip.toString() + " " + this.machineName.toString();
    }
}
