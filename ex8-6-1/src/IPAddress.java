public class IPAddress {
    private String ip;

    public IPAddress(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return this.ip;
    }
}
