public class DnsItem
{
    // Attributes
    private AdresseIP ip;
    private NomMachine machineName;

    // Constructor
    public DnsItem(AdresseIP ip, NomMachine machineName)
    {
        this.ip = ip;
        this.machineName = machineName;
    }

    // IP adress getter
    public AdresseIP getIp()
    {
        return this.ip;
    }

    // Machine name getter
    public NomMachine getMachineName()
    {
        return this.machineName;
    }

    // DNS item getter
    public String getDnsItem()
    {
        return this.ip.toString() + " " + this.machineName.toString();
    }
}
