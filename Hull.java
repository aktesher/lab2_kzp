
/**
 * Represents the hull of a ship with attributes such as material, length, tonnage, cabin count, and durability.
 * Provides methods to get hull attributes and manage its durability.
 */
public class Hull 
{
    private String material;
    private double length;
    private double tonnage;
    private int cabin;
    private int durability;
    /**
     * Constructor to initialize the hull with specific material, length, tonnage, cabin count, and durability.
     * 
     * @param material The material of the hull (e.g., "Steel", "Aluminum").
     * @param length The length of the hull in meters.
     * @param tonnage The tonnage (weight) of the hull in tons.
     * @param cabin The number of cabins on the ship.
     * @param durability The durability of the hull, representing its structural integrity.
     */
    public Hull(String material, double length, double tonnage, int cabin, int durability) 
    {
        this.material = material;
        this.length = length;
    	this.tonnage = tonnage;
    	this.cabin = cabin;
        this.durability = durability;
    }
    /**
     * Retrieves the material of the hull.
     * 
     * @return The material of the hull (e.g., "Steel").
     */
    public String getMaterial(){
        return material;
    }
    /**
     * Retrieves the length of the hull in meters.
     * 
     * @return The length of the hull in meters.
     */
    public double getLength()  
    {
        return length;
    }
    /**
     * Retrieves the tonnage (weight) of the hull in tons.
     * 
     * @return The tonnage of the hull in tons.
     */
    public double getTonnage()
    {
        return tonnage;
    }
    /**
     * Retrieves the number of cabins on the ship.
     * 
     * @return The number of cabins on the ship.
     */
    public double getCabin() 
    {
        return cabin;
    }
    /**
     * Retrieves the durability of the hull, representing its structural integrity.
     * 
     * @return The durability of the hull as an integer value.
     */
    public int getDurability() 
    {
        return durability;
    }
    /**
     * Decreases the durability of the hull by 1, simulating wear or damage.
     * The durability cannot go below 0.
     * 
     * @return The updated durability of the hull after the decrease.
     */
    public int decreaseDurability() 
    {
        if (durability > 0) 
        {
            durability--;
        }
        return durability;
    }
    /**
     * Returns a string representation of the hull, including material, length, tonnage, and cabin count.
     * 
     * @return A string describing the hull's material, length, tonnage, and number of cabins.
     */
    @Override
    public String toString()
    {
        return "Material is " + material + ", length is " + length + 
        		" м, " + " tonnage is " + tonnage + " tonns, amount of cabins is " + cabin;
    }
}
