/**
 * Sales person account
 */
public class SalesPersonAccount extends Account {

    /**
     * Default constructor with specified parameter
     *
     * @param username
     * @param password
     */
    public SalesPersonAccount(String username, String password) {
        super(username, password);
        setType(AccountType.SALESPERSON);
    }
}
