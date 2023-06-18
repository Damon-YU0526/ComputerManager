import java.io.*;
import java.util.ArrayList;

/**
 * Container class used to store and query the account of the system
 */
public class Accounts {
    // container used to store the account
    private ArrayList<Account> accounts;

    /**
     * Load account info from the specified file
     */
    private void loadAccount() {
        accounts = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("account.txt")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                if (items[2].equals("p")) {
                    accounts.add(new SalesPersonAccount(items[0], items[1]));
                }
                else {
                    accounts.add(new Manager(items[0], items[1]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return the account type for the specified username and password
     * @param username username of the account
     * @param password password of the account
     * @return account type
     */
    public AccountType getAccountType(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) &&
                    accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i).getType();
            }
        }
        return null;
    }

    /**
     * Default constructor
     */
    public Accounts() {
        loadAccount();
    }
}
