/**
 * Computer is the base class for the different kinds of computers
 */
public class Computer {
    private String category;
    private String type;
    private String id;
    private String brand;
    private int price;
    private String CPU;

    /**
     * Default constructor with specified parameters
     * @param category
     * @param type
     * @param id
     * @param brand
     * @param price
     */
    public Computer(String category, String type, String id, String brand, int price, String CPU) {
        this.category = category;
        this.type = type;
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.CPU = CPU;
    }

    /**
     * Get the CPU of the computer
     * @return
     */
    public String getCPU() {
        return CPU;
    }

    /**
     * Get the category of the computer
     * @return category of the computer
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get the type of the computer
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Get the id of the computer
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the brand of the computer
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Get the price of the computer
     * @return price
     */
    public int getPrice() {
        return price;
    }
}
