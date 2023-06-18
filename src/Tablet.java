/**
 * Tablet is kind of computer
 */
public class Tablet extends Computer {
    private double screenSize;

    /**
     * Default constructor with specified parameters
     *
     * @param category
     * @param type
     * @param id
     * @param brand
     * @param price
     */
    public Tablet(String category, String type, String id, String brand, int price,
                  String CPU, double screenSize) {
        super(category, type, id, brand, price, CPU);
        this.screenSize = screenSize;
    }

    /**
     * Get the screen size of the tablet
     * @return screen size
     */
    public double getScreenSize() {
        return screenSize;
    }
}
