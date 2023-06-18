/**
 * Manager account
 */
public class Manager extends Account {
    /**
     * Default constructor with specified parameter
     *
     * @param username
     * @param password
     */
    public Manager(String username, String password) {
        super(username, password);
        setType(AccountType.MANAGER);
    }
}
