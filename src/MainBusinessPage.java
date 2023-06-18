import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 * Main business page of the overall system
 */
public class MainBusinessPage extends JFrame {
    private JPanel businessPanel;
    private JLabel categoryLabel;
    private JLabel typeLabel;
    private JComboBox categoryBox;
    private JComboBox typeBox;

    private ComputersDao computersDao;

    private JTable table;
    private DefaultTableModel model;

    private JPanel bottomPanel;

    private JButton exitBtn;

    private JLabel logoLabel;

    private AccountType accountType;
    private static String[] columns = {"Category", "Type", "ID", "Brand", "CPU Family", "Price($)"};

    private static final String[] categories = {"All", "Desktop PC", "Tablet", "Laptop"};
    private static final String[] types = {"All", "Gaming", "Home & Study", "Business", "Compact",
                                            "Thin & Light", "Android", "Apple", "Windows"};

    /**
     * Initialize all resources for this page
     */
    private void init() {
        computersDao = new ComputersDao();

        businessPanel = new JPanel();
        categoryLabel = new JLabel("Computer Category");
        typeLabel = new JLabel("Computer Type");

        categoryBox = new JComboBox(categories);
        typeBox = new JComboBox(types);
        JPanel boxPanel = new JPanel(new GridLayout(2, 2));
        boxPanel.add(categoryLabel);
        boxPanel.add(categoryBox);
        boxPanel.add(typeLabel);
        boxPanel.add(typeBox);
        businessPanel.add(boxPanel);

        setContentPane(businessPanel);

        model = new DefaultTableModel();
        table = new JTable(model);
        updateJTable();
        JScrollPane jsp = new JScrollPane(table);
        businessPanel.add(jsp);

        bottomPanel = new JPanel(new GridLayout(1, 2));
        logoLabel = new JLabel();
        logoLabel.setIcon(new ImageIcon("./images/logo.png"));
        bottomPanel.add(logoLabel);

        exitBtn = new JButton("Click to Log out");
        exitBtn.setFont(new Font("arial", Font.BOLD, 25));
        bottomPanel.add(exitBtn);

        businessPanel.add(bottomPanel);

        setTitle("Computer Products Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        Timer timer = new Timer(1000, e -> {
            updateJTable();
            table.validate();
            table.updateUI();
        });
        timer.start();
    }

    /**
     * Update the data in the JTable
     */
    public void updateJTable() {
        String category = (String) categoryBox.getSelectedItem();
        String type = (String) typeBox.getSelectedItem();
        computersDao.updateData(category, type);
        model.setDataVector(computersDao.getData(), columns);
    }

    /**
     * default constructor for the MainBusinessPage
     * @param accountType
     */
    public MainBusinessPage(AccountType accountType) {
        this.accountType = accountType;
        init();

        categoryBox.addActionListener(e -> updateJTable());
        typeBox.addActionListener(e -> updateJTable());
        exitBtn.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        table.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIdx = table.getSelectedRow();
                if (rowIdx >= 0 || rowIdx < computersDao.getComputers().size()) {
                    new ComputerUpdatePage(computersDao.getComputers(), rowIdx, accountType);
                }
            }
        });

    }

    /*
    public static void main(String[] args) {
        new MainBusinessPage(AccountType.MANAGER);
    }
    */
}
