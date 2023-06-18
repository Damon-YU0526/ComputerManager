/**
 * DesktopPC is kind of computer
 */

public class DesktopPC extends Computer {
    private int memorySize;
    private int SSDSize;
    /**
     * Default constructor with specified parameters
     * @param category
     * @param type
     * @param id
     * @param brand
     * @param price
     * @param CPU
     * @param memorySize
     * @param SSDSize
     */
    public DesktopPC(String category, String type, String id, String brand, int price,
                     String CPU, int memorySize, int SSDSize) {
        super(category, type, id, brand, price, CPU);
        this.memorySize = memorySize;
        this.SSDSize = SSDSize;
    }

    /**
     * Get the memory size of the computer
     * @return memory size
     */
    public int getMemorySize() {
        return memorySize;
    }

    /**
     * Get the SSD of the computer
     * @return SSD
     */
    public int getSSDSize() {
        return SSDSize;
    }
}
