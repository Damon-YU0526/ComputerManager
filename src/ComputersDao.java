import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ComputerDao used to store the computer objects and query them in the system
 */
public class ComputersDao {
    // 2-dimensional array used to store the computer object attributes
    private Object[][] data;
    // list of computer objects
    private ArrayList<Computer> computers;

    private static String[] columns = {"Category", "Type", "ID", "Brand", "CPU Family", "Price($)"};

    /**
     * Get the computer object 2-dimensional array data
     * @return
     */
    public Object[][] getData() {
        return data;
    }

    /**
     * Get the computers list
     * @return
     */
    public ArrayList<Computer> getComputers() {
        return computers;
    }

    /**
     * Get the specified computer category and type number
     * @param category
     * @param type
     * @return
     */
    private int getSpecifiedComputerNum(String category, String type) {
        int cnt = 0;
        if (category.equals("All")) {
            for (Computer computer : computers) {
                if (computer.getType().equals(type)) {
                    cnt += 1;
                }
            }
        }
        else if (type.equals("All")) {
            for (Computer computer : computers) {
                if (computer.getCategory().equals(category)) {
                    cnt += 1;
                }
            }
        }
        else {
            for (Computer computer : computers) {
                if (computer.getCategory().equals(category) && computer.getType().equals(type)) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    /**
     * Get the specified category and type computer and return it as a 2-dimensional array
     * @param cnt
     * @param category
     * @param type
     * @return
     */
    private Object[][] getSpecifiedComputer(int cnt, String category, String type) {
        Object[][] tmpData = new Object[cnt][columns.length];
        cnt = 0;
        if (category.equals("All")) {
            // if the category is all
            for (Computer computer : computers) {
                if (computer.getType().equals(type)) {
                    tmpData[cnt][0] = computer.getCategory();
                    tmpData[cnt][1] = computer.getType();
                    tmpData[cnt][2] = computer.getId();
                    tmpData[cnt][3] = computer.getBrand();
                    tmpData[cnt][4] = computer.getCPU();
                    tmpData[cnt][5] = computer.getPrice();
                    cnt += 1;
                }
            }
        }
        else if (type.equals("All")) {
            // if the type is All
            for (Computer computer : computers) {
                if (computer.getCategory().equals(category)) {
                    tmpData[cnt][0] = computer.getCategory();
                    tmpData[cnt][1] = computer.getType();
                    tmpData[cnt][2] = computer.getId();
                    tmpData[cnt][3] = computer.getBrand();
                    tmpData[cnt][4] = computer.getCPU();
                    tmpData[cnt][5] = computer.getPrice();
                    cnt += 1;
                }
            }
        }
        else {
            for (Computer computer : computers) {
                if (computer.getCategory().equals(category) && computer.getType().equals(type)) {
                    tmpData[cnt][0] = computer.getCategory();
                    tmpData[cnt][1] = computer.getType();
                    tmpData[cnt][2] = computer.getId();
                    tmpData[cnt][3] = computer.getBrand();
                    tmpData[cnt][4] = computer.getCPU();
                    tmpData[cnt][5] = computer.getPrice();
                    cnt += 1;
                }
            }
        }
        return tmpData;
    }

    /**
     * Update the data 2-dimensional array
     * @param category
     * @param type
     */
    public void updateData(String category, String type) {
        data = null;
        if (category.equals("All") && type.equals("All")) {
            data = new Object[computers.size()][columns.length];
            for (int i = 0; i < computers.size(); i++) {
                data[i][0] = computers.get(i).getCategory();
                data[i][1] = computers.get(i).getType();
                data[i][2] = computers.get(i).getId();
                data[i][3] = computers.get(i).getBrand();
                data[i][4] = computers.get(i).getCPU();
                data[i][5] = computers.get(i).getPrice();
            }
        }
        else {
            // update the data according to the category and type
            int cnt = getSpecifiedComputerNum(category, type);
            data = getSpecifiedComputer(cnt, category, type);
        }
    }

    /**
     * Load the computers from the specified file
     */
    private void loadComputers() {
        computers = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("computers.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                if (items[0].equals("Desktop PC")) {
                    computers.add(new DesktopPC(items[0], items[1], items[2], items[3],
                            Integer.parseInt(items[7]), items[4],
                            Integer.parseInt(items[5]),
                            Integer.parseInt(items[6])));
                }
                else if (items[0].equals("Laptop")) {
                    computers.add(new Laptop(items[0], items[1], items[2], items[3],
                            Integer.parseInt(items[8]), items[4],
                            Integer.parseInt(items[5]),
                            Integer.parseInt(items[6]),
                            Double.parseDouble(items[7])));
                }
                else if (items[0].equals("Tablet")) {
                    computers.add(new Tablet(items[0], items[1], items[2], items[3],
                            Integer.parseInt(items[6]), items[4],
                            Double.parseDouble(items[5])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Default constructor
     */
    public ComputersDao() {
        loadComputers();
    }

}
