
/**
 * Represents a crew of a ship or vehicle, holding information about the number of crew members.
 */
public class Crew
{
    private int numberOfMembers;
    /**
     * Constructor to initialize the crew with a specified number of members.
     * 
     * @param numberOfMembers The number of members in the crew.
     */
    public Crew(int numberOfMembers)    
    {
        this.numberOfMembers = numberOfMembers;
    }    
    /**
     * Retrieves the current number of members in the crew.
     * 
     * @return The number of crew members.
     */
    public int getNumberOfMembers()    
    {
        return numberOfMembers;
    }  
    /**
     * Returns a string representation of the crew, including the number of members.
     * 
     * @return A string describing the crew and the number of persons.
     */
    @Override
    public String toString()    
    {
        return "Crew consists of " + numberOfMembers + " persons";
    }
}
