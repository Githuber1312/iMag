package entity;

public class User {
    private long id;
    private String username;
    private String password;
    private boolean isVerified;
    private boolean isBuyer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    public boolean isBuyer() {
        return isBuyer;
    }

    public void setBuyer(boolean buyer) {
        isBuyer = buyer;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isVerified +
                ", isBuyer=" + isBuyer +
                '}';
    }

    public User(String username, String password, boolean isverified, boolean isBuyer) {
        this.username = username;
        this.password = password;
        this.isVerified = isverified;
        this.isBuyer = isBuyer;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
