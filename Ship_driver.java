
import java.io.IOException;
/**
 * Driver class for simulating ship operations. This class creates a new ship, initializes its components,
 * and allows the captain to issue commands to control the ship's movement, engine, and crew. It also logs
 * all actions performed during the simulation.
 */
public class Ship_driver{ 
	/**
     * Main method to start the simulation. Initializes the ship components (engine, hull, crew, antenna)
     * and begins the journey.
     * @param args Command-line arguments (not used)
     */
	public static void main(String[] args){
        try{
            // creating parts of ship
            Engine engine_n = new Engine("Diesel", 5000);
            Hull hull_n = new Hull("steel", 50, 275, 20, 2);
            Crew crew_n = new Crew(10);
            Antenna antenna_n = new Antenna(2400);
            // creating ship
            Ship ship_n = new Ship(engine_n, hull_n, crew_n, antenna_n);
            ship_n.getShipInfo();
            ship_n.startJourney();
        } catch (IOException e) {
        	System.out.println("Произошла ошибка при работе с файлом.");
        }
    }
}
