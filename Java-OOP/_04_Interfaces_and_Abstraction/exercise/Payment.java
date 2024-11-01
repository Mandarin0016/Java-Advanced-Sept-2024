public abstract class Payment implements Payable{

    private String username;

    public Payment(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public abstract void report();
}
