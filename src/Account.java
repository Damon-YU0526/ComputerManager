enum AccountType{
    SALESPERSON,
    MANAGER
}

/**
 * Account class shows the basic info of a account
 * such as the username, password and account type
 */
public class Account {
    private String username;
    private String password;
    private AccountType type;

    /**
     * Default constructor with specified parameter
     * @param username
     * @param password
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = null;
    }

    /**
     * Set the account type
     * @param type
     */
    public void setType(AccountType type) {
        this.type = type;
    }

    /**
     * Get the user name
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the type of the account
     * @return account type
     */
    public AccountType getType() {
        return type;
    }
}
