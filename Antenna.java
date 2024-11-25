
import java.io.IOException;
/**
 * Represents an antenna used for sending and receiving signals, including SOS and location data.
 * It contains functionality for transmitting a new signal, sending a location-based signal, and sending an SOS signal.
 */
public class Antenna 
{
    private int frequency_HZ;
    private String MAYDAY;
    private String locator;
    /**
     * Constructor to initialize the antenna with a default frequency of 2400 Hz, 
     * and sets the default location and MAYDAY signal.
     * 
     * @param frequency The frequency (in Hz) to set for the antenna, though it's ignored in this version.
     */
    public Antenna(int frequency)   
    {
        this.frequency_HZ = 2400;
        this.MAYDAY = "MAYDAY!!!";
        this.locator = "location  ";
    }   
    /**
     * Updates the antenna's locator with a new location and returns the new location.
     * This method simulates sending the location information.
     * 
     * @param newLocation The new location string to set as the antenna's locator.
     * @return The updated location string.
     * @throws IOException if an error occurs during the signal update process.
     */
    public String new_signal(String newLocation) throws IOException 
    {
        locator = newLocation;
        return newLocation;
    }
    /**
     * Sends the current locator information as the signal, returning the current location.
     * This method is used to get the current location of the antenna.
     * 
     * @return The current location stored in the antenna.
     */
    public String send_signal()
    {        	
    	return locator;
    }
    /**
     * Sends an SOS signal along with the current locator, including a predefined MAYDAY message.
     * The method also logs the SOS action.
     * 
     * @throws IOException if an error occurs while logging the action or during signal transmission.
     */
    public void sendSOS() throws IOException 
    {
        logAction("Антенна отправила сигнал SOS", "", "SOS отправлен");
        System.out.println("SOS: Координаты: " + locator + MAYDAY);
    }
    /**
     * Returns the current frequency of the antenna in Hz.
     * 
     * @return The transmission frequency of the antenna in Hz.
     */
    public int Frequency()    
    {
        return frequency_HZ;
    }     
    /**
     * Logs the action performed by the antenna. This is a placeholder method for logging.
     * 
     * @param string Action description.
     * @param string2 Additional details (currently unused).
     * @param string3 Result of the action (currently unused).
     */
    private void logAction(String string, String string2, String string3) 
    {
		// TODO Auto-generated method stub		
	}
    /**
     * Returns a string representation of the antenna, including its transmission frequency in Hz.
     * 
     * @return A string describing the antenna's frequency.
     */
	@Override
    public String toString()   
    {
        return "Transmittion frequency is " + frequency_HZ + " HZ";
    }
}
