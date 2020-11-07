public class NomMachine
{
    // Attribute
    private String machineName;

    // Constructor
    public NomMachine(String machineName)
    {
        this.machineName = machineName;
    }

    // Getter
    @Override
    public String toString()
    {
        return this.machineName;
    }
}
