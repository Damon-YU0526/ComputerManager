import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Login page GUI of the overall system
 */
public class LoginPage extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginBtn;
    private JButton cancelBtn;

    private Accounts accounts;

    /**
     * Init the Login panel
     */
    private void init() {
        this.accounts = new Accounts();

        loginPanel = new JPanel(new GridLayout(3, 2));
        setContentPane(loginPanel);

        usernameLabel = new JLabel("Username");
        usernameText = new JTextField();
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameText);

        passwordLabel = new JLabel("Password");
        passwordText = new JPasswordField();
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordText);

        loginBtn = new JButton("Login");
        cancelBtn = new JButton("Cancel");
        loginPanel.add(loginBtn);
        loginPanel.add(cancelBtn);

        setTitle("Sales Person Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 140);
        setLocationRelativeTo(null);
        setVisible(true);

        // add login action listener to the login button
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(new String(passwordText.getPassword()));
                AccountType type = accounts.getAccountType(usernameText.getText(), new String(passwordText.getPassword()));
                dispose();
                // if there is no such account in the system
                if (type == null) {
                    JOptionPane.showMessageDialog(null, "No such user in the system");
                    dispose();
                    System.exit(0);
                }
                // open the business page with role of manager
                if (type == AccountType.MANAGER) {
                    new MainBusinessPage(AccountType.MANAGER);
                }
                else if (type == AccountType.SALESPERSON) {
                    // open the business page with role of sales person
                    new MainBusinessPage(AccountType.SALESPERSON);
                }
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Default constructor for the Login Page
     */
    public LoginPage() {
        init();
    }


    public static void main(String[] args) {
        new LoginPage();
    }
}
