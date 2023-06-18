/**
 * Laptop is kind of computer
 */
public class Laptop extends DesktopPC {
    private double screenSize;

    /**
     * Default constructor with specified parameters
     *
     * @param category
     * @param type
     * @param id
     * @param brand
     * @param price
     * @param CPU
     * @param memorySize
     * @param SSDSize
     */
    public Laptop(String category, String type, String id, String brand, int price,
                  String CPU, int memorySize, int SSDSize, double screenSize) {
        super(category, type, id, brand, price, CPU, memorySize, SSDSize);
        this.screenSize = screenSize;
    }

    /**
     * Get the screen size of the laptop
     * @return screen size of the laptop
     */
    public double getScreenSize() {
        return screenSize;
    }

}
