import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.jar.JarEntry;

/**
 * Computer update page GUI
 */
public class ComputerUpdatePage extends JFrame {
    private JPanel panel;
    private JLabel idLabel;
    private JTextField idText;
    private JLabel categoryLabel;

    private JLabel typeLabel;
    private JComboBox catgoryBox;
    private JComboBox typeBox;
    private JLabel brandLabel;
    private JTextField brandText;
    private JLabel CPULabel;
    private JTextField cpuText;
    private JLabel memoryLabel;
    private JTextField memoryText;

    private JLabel ssdLabel;
    private JTextField ssdText;
    private JLabel screenLabel;
    private JTextField screenText;
    private JLabel priceLabel;
    private JTextField priceText;
    private JButton addBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JButton clearBtn;
    private ArrayList<Computer> computers;
    private int idx;
    private AccountType accountType;

    private static final String[] labels = {"Model ID", "Category", "Type", "Brand", "CPU Family",
                                            "Memory Size", "SSD Capacity", "Screen Size", "Price"};
    private static final String[] categories = {"Desktop PC", "Tablet", "Laptop"};
    private static final String[] types = {"Gaming", "Home & Study", "Business", "Compact",
            "Thin & Light", "Android", "Apple", "Windows"};

    /**
     * Get the index of the type in the system
     * @return
     */
    private int getTypeIndex() {
        Computer computer = computers.get(idx);
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(computer.getType())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Set the text value in the panel according to the computer object
     */
    private void setTextValue() {
        Computer computer = computers.get(idx);
        idText.setText(computer.getId());
        brandText.setText(computer.getBrand());
        cpuText.setText(computer.getCPU());
        priceText.setText(Integer.toString(computer.getPrice()));
        if (computer.getCategory().equals("Desktop PC")) {
            catgoryBox.setSelectedIndex(0);
            memoryText.setText(Integer.toString(((DesktopPC)computer).getMemorySize()));
            ssdText.setText(Integer.toString(((DesktopPC)computer).getSSDSize()));
        }
        else if (computer.getCategory().equals("Laptop")) {
            catgoryBox.setSelectedIndex(1);
            memoryText.setText(Integer.toString(((Laptop)computer).getMemorySize()));
            ssdText.setText(Integer.toString(((Laptop)computer).getSSDSize()));
            screenText.setText(Double.toString(((Laptop)computer).getScreenSize()));
        }
        else if (computer.getCategory().equals("Tablet")) {
            catgoryBox.setSelectedIndex(2);
            screenText.setText(Double.toString(((Tablet)computer).getScreenSize()));
        }
        typeBox.setSelectedIndex(getTypeIndex());
    }

    /**
     * Check if the specified id exist in the computers
     * @param id
     * @return
     */
    private int isIDExist(String id) {
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the computer object according to the category and type
     * @return
     */
    private Computer getComputerObj() {
        String category = (String) catgoryBox.getSelectedItem();
        String id = idText.getText();
        String brand = brandText.getText();
        String CPU = cpuText.getText();
        int price = Integer.parseInt(priceText.getText());
        String type = (String) typeBox.getSelectedItem();
        if (category.equals("Desktop PC")) {
            int memory = Integer.parseInt(memoryText.getText());
            int ssd = Integer.parseInt(ssdText.getText());
            return new DesktopPC(category, type, id, brand, price, CPU, memory, ssd);
        }
        else if (category.equals("Laptop")) {
            int memory = Integer.parseInt(memoryText.getText());
            int ssd = Integer.parseInt(ssdText.getText());
            double screen = Double.parseDouble(screenText.getText());
            return new Laptop(category, type, id, brand, price, CPU, memory, ssd, screen);
        }
        else if (category.equals("Tablet")) {
            double screen = Double.parseDouble(screenText.getText());
            return new Tablet(category, type, id, brand, price, CPU, screen);
        }
        else {
            return null;
        }
    }

    /**
     * Set the action listener for this panel component
     */
    private void setActionListener() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isIDExist(idText.getText()) != -1) {
                    JOptionPane.showMessageDialog(null, "The id " + idText.getText() +
                            " already exist in the system");
                }
                else {
                    computers.add(getComputerObj());
                    JOptionPane.showMessageDialog(null, "A new computer had been added to the system.");
                }
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idIdx = isIDExist(idText.getText());
                if (idIdx == -1) {
                    JOptionPane.showMessageDialog(null, "The input id is not exist, can not update");
                }
                else {
                    computers.remove(idIdx);
                    computers.add(idIdx, getComputerObj());
                    JOptionPane.showMessageDialog(null, "The record for the computer is updated successfully");
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idIdx = isIDExist(idText.getText());
                if (idIdx == -1) {
                    JOptionPane.showMessageDialog(null, "The input id is not exist, can not delete");
                }
                else {
                    computers.remove(idIdx);
                    JOptionPane.showMessageDialog(null, "The record for the computer is deleted successfully");
                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idText.setText("");
                brandText.setText("");
                cpuText.setText("");
                memoryText.setText("");
                ssdText.setText("");
                screenText.setText("");
                priceText.setText("");
            }
        });
    }

    /**
     * Initialize all resources for this panel
     */
    private void init() {
        panel = new JPanel(new GridLayout(11, 2));
        idLabel = new JLabel(labels[0]);
        idText = new JTextField();
        categoryLabel = new JLabel(labels[1]);
        typeLabel = new JLabel(labels[2]);
        brandLabel = new JLabel(labels[3]);
        brandText = new JTextField();
        CPULabel = new JLabel(labels[4]);
        cpuText = new JTextField();
        memoryLabel = new JLabel(labels[5]);
        memoryText = new JTextField();
        ssdLabel = new JLabel(labels[6]);
        ssdText = new JTextField();
        screenLabel = new JLabel(labels[7]);
        screenText = new JTextField();
        priceLabel = new JLabel(labels[8]);
        priceText = new JTextField();

        catgoryBox = new JComboBox(categories);
        typeBox = new JComboBox(types);

        panel.add(idLabel);
        panel.add(idText);
        panel.add(categoryLabel);
        panel.add(catgoryBox);
        panel.add(typeLabel);
        panel.add(typeBox);
        panel.add(brandLabel);
        panel.add(brandText);
        panel.add(CPULabel);
        panel.add(cpuText);
        panel.add(memoryLabel);
        panel.add(memoryText);
        panel.add(ssdLabel);
        panel.add(ssdText);
        panel.add(screenLabel);
        panel.add(screenText);
        panel.add(priceLabel);
        panel.add(priceText);

        addBtn = new JButton("Add");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");

        if (accountType.equals(AccountType.SALESPERSON)) {
            idText.setEnabled(false);
            catgoryBox.setEnabled(false);
            typeBox.setEnabled(false);
            brandText.setEnabled(false);
            cpuText.setEnabled(false);
            memoryText.setEnabled(false);
            ssdText.setEnabled(false);
            screenText.setEnabled(false);
            priceText.setEnabled(false);
            addBtn.setEnabled(false);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            clearBtn.setEnabled(false);
        }
        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        panel.add(clearBtn);

        setContentPane(panel);
        setSize(400, 500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Check/Update Products Details");
        setLocationRelativeTo(null);

        setTextValue();
        setActionListener();
    }

    /**
     * default constructor for ComputerUpdatePage
     * @param computers
     * @param index
     * @param accountType
     */
    public ComputerUpdatePage(ArrayList<Computer> computers, int index, AccountType accountType) {
        this.computers = computers;
        this.idx = index;
        this.accountType = accountType;
        init();
    }
}
