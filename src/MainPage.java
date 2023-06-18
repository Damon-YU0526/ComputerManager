import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    private JPanel loginPanel;
    private JButton loginBtn;

    /**
     * Init the main page of the overall system
     */
    public void init() {
        loginPanel = new JPanel(new GridLayout(1, 2));

        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("./images/logo.png"));
        loginPanel.add(logoLabel);
        loginBtn = new JButton("Click to Login");
        loginBtn.setFont(new Font("arial", Font.BOLD, 25));
        loginPanel.add(loginBtn);

        setContentPane(loginPanel);
        setTitle("Computer Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * default constructor
     */
    public MainPage() {
        init();
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
    }

    /**
     * Main entrance of the overall program
     * @param args
     */
    public static void main(String[] args) {
        new MainPage();
    }
}
