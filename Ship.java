import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Represents a ship with an engine, hull, crew, and antenna. Provides functionality to start the ship's journey,
 * change components, adjust speed, and log actions. The ship is also capable of handling an emergency when the hull is damaged.
 */
public class Ship 
{
    private Engine E;
    private Hull H;
    private Antenna A;
    private Crew C;
    private FileWriter logWriter;
    private Scanner scanner;
    private boolean isEngineOn = false; 
    /**
     * Constructs a ship with the specified components and initializes a log file.
     * @param engine_ The engine of the ship
     * @param hull_ The hull of the ship
     * @param crew_ The crew of the ship
     * @param antenna_ The antenna of the ship
     * @throws IOException if there is an error initializing the log file
     */
    public Ship(Engine engine_, Hull hull_, Crew crew_, Antenna antenna_) throws IOException 
    {
        this.E = engine_;
        this.H = hull_;
        this.A = antenna_;
        this.C = crew_;
        this.logWriter = new FileWriter("shipLog.txt", true);
        this.scanner = new Scanner(System.in);
        logAction("Start log.", "Creating new ship", "Ship is created.");

    }
    /**
     * Logs a ship's action to the log file.
     * @param question The command or question being processed
     * @param answer The response to the question or command
     * @param result The result of the action
     * @throws IOException if there is an error writing to the log file
     */
    private void logAction(String question, String answer, String result) throws IOException 
    {
    	if ("Start log.".equals(question)) 
    	{ 
            logWriter.write("\n<--- --- --- --- --- --- ---> \n");   
    	}
        logWriter.write("\n"+"Command: " + question + "\n");
        logWriter.write("Response: " + answer + "\n");
        logWriter.write("Result: " + result + "\n");
        if ("Printing parameters...".equals(result)) 
        { 
   	        logWriter.write("Hull: " + H +"\n"+ "Crew: " + C  +"\n"+ "Engine: " + E  +"\n"+ "Antenna: " + A +"\n");
        }
        logWriter.flush();
    }   
    /**
     * Starts the journey of the ship, allowing the captain to enter commands to control the ship's actions.
     * The loop will continue until the captain commands to return to port or the ship is damaged.
     * @throws IOException if there is an error processing commands or interacting with components
     */
    public void startJourney() throws IOException 
    {
        int command;
        System.out.println("Captain, please enter a command for your new ship");
        while (true) 
        {
            System.out.print("""
            		Menu:
            		1. Change engine
            		2. Change crew
            		
            		3.1 Move forward
            		3.2 Driftway
            		
            		4.. Change speed   
            		         		
            		5.1 Turn north
            		5.2 Turn south
            		5.3 Turn east
            		5.4 Turn west 
            		           		
            		6. Return to port
            		
            		7. Check location
            		""");
            command = scanner.nextInt();
            if (command == 6) 
            {
                returnToPort();
                break;
            }
            switch (command) 
            {
                
                case 1:
                	replaceEngine();
                    break;
                case 2:
                    changeCrew();
                    break;
                case 3:
                	move();
                    break;
                case 4:
                	adjustSpeed();
                    break;                
                case 5:
                    turn();
                    break;
                case 7:
                    String signal = A.send_signal();  // Убедитесь, что метод  реализован в Antenna
                    logAction("Check location", "Launching antenna", signal);
                    break;
                default:
                    System.out.println("Unknown command. Please re-enter.");
            }
        }
    }
    /**
     * Displays the ship's current information such as the hull, crew, engine, and antenna.
     * @throws IOException if there is an error logging the ship's information
     */
    public void getShipInfo() throws IOException 
    {
        logAction("Get ship info", "", "Printing parameters...");
        System.out.println(H);
        System.out.println(E);
        System.out.println(C);
        System.out.println(A);
    }
    /**
     * Allows the captain to replace the engine with a new one. Logs the action and updates the engine's parameters.
     * @throws IOException if there is an error processing the engine replacement
     */
    public void replaceEngine() throws IOException 
    {
        System.out.println("Do you want to change engine? (yes - 1/no - 0)");
        int response = scanner.nextInt();
        scanner.nextLine(); // Очистка символа новой строки после nextInt()
        if (response == 1) 
        {
            System.out.print("Enter engine type: ");
            String newType = scanner.nextLine(); // Ждем ввода типа двигателя

            System.out.print("Enter engine power: ");
            int newPower = scanner.nextInt();
            scanner.nextLine();  // Очистка символа новой строки после nextInt()

            E = new Engine(newType, newPower);
            logAction("Changing engine", "Type: " + newType + ", Power: " + newPower, "Engine changed");
            System.out.println("Engine changed successfully.");
        }
    }
    /**
     * Allows the captain to change the crew size. The crew size must be between 5 and 50.
     * @throws IOException if there is an error processing the crew change
     */
    public void changeCrew() throws IOException 
    {
        System.out.println("Do you want to change amount of crew? (yes - 1/no - 0)");
        int response = scanner.nextInt();
        scanner.nextLine(); // Очистка символа новой строки после nextInt()
        if (response == 1) 
        {
            System.out.print("Enter new crew amount: ");
            int newCrewSize = scanner.nextInt();
            scanner.nextLine();  // Очищаем сканер после nextInt()
            if (newCrewSize >= 5 && newCrewSize <= 50) 
            {
                new Crew(newCrewSize);
                logAction("Changing crew quantity", Integer.toString(newCrewSize), "Crew changed");
            } 
            else 
            {
                logAction("Changing crew quantity", Integer.toString(newCrewSize), "Error: forbidden amount");
                System.out.println("Error: number must be from 5 to 50.");
            }
        }
    }
    /**
     * Controls the movement of the ship by turning the engine on or off.
     * The captain is prompted to enter the engine mode (1 for turning the engine on, 2 for turning it off).
     * Based on the input, the engine is either powered up to full capacity or turned off, causing the ship
     * to either move forward or drift.
     *
     * @return boolean The current state of the engine after the action (true if the engine is on, false if off).
     * @throws IOException if there is an error logging the action to the log file.
     */
    public boolean move() throws IOException 
    {
        System.out.print("Enter engine mode (1 - turn on, 2 - turn off): ");
        int fuel = scanner.nextInt();
        scanner.nextLine();

        if (fuel == 1)
        {
            isEngineOn = true;
            logAction("Move forward", "Engine full power", "Ship moves forward");
            System.out.println("Ship moves forward.");
        }
        else if (fuel == 2)
        {
            isEngineOn = false;
            logAction("Driftway", "Engine zero power", "Ship drifts");
            System.out.println("Ship drifts.");
        }
        
        return isEngineOn; // Возвращаем состояние двигателя после действия
    }
    /**
     * Adjusts the ship's speed. The captain can set the speed up to a maximum of 9 knots. If the engine is off,
     * the speed cannot be changed.
     * @throws IOException if there is an error processing the speed change
     */
    public void adjustSpeed() throws IOException 
    {  
    	if (isEngineOn) 
    	{
    		System.out.println("Do you want to change speed? (yes - 1/no - 0)");
    		int response = scanner.nextInt();
    		scanner.nextLine(); // Очистка символа новой строки после nextInt()
    		if (response == 1) 
    		{
    			System.out.print("Enter new speed (max 9 knots): ");
    			int newSpeed = scanner.nextInt();
    			scanner.nextLine();  // Очищаем сканер после nextInt()
    			if (newSpeed <= 9) 
    			{
    				E.setSpeed(newSpeed);
    				logAction("Changing speed", Integer.toString(newSpeed), "Speed set at " + newSpeed + " knots");
                	if (newSpeed == 9) 
                	{
                		checkHullIntegrity();
                	}
    			} 
    			else 
    			{
    				logAction("Changing speed", Integer.toString(newSpeed), "Error: limit exceeded");
    				System.out.println("Error: speed limit is 9 knots.");
    			}
    		} 
        } 
    	else 
    	{
            System.out.println("Cannot adjust speed. Engine is off.");
            logAction("Cannot adjust speed","", " Engine is off.");
        }
    }
    /**
     * Turns the ship in a specified direction. Logs the action and applies the direction.
     * @throws IOException if there is an error processing the turn
     */
    public void turn() throws IOException
    {
	if (isEngineOn) 
    {
        System.out.print("Enter turn direction (1 - east, 2 - west, 3 - north, 4 - south): ");
        int direction = scanner.nextInt();
        scanner.nextLine();  // Очищаем сканер после nextInt()
        if (direction == 1)
        {
            E.turnEast();
            logAction("Turn east", "Turning according to compass", "Ship is heading to east");
        } 
        else if (direction == 2) 
        {
            E.turnWest();
            logAction("Turn west", "Turning according to compass", "Ship is heading to west");
        }
        else if (direction == 3)
        {
            E.turnNorth();
            logAction("Turn north", "Turning according to compass", "Ship is heading to north");
        } 
    	else if (direction == 4) 
    	{
            E.turnSouth();
            logAction("Turn south", "Turning according to compass", "Ship is heading to south");
        }
    	else
    	{
            logAction("Turn", Integer.toString(direction), "Error: forbidden meaning");
            System.out.println("Error: choose one of four directions.");
        }
      }
	  else 
	  {
          System.out.println("Cannot adjust speed. Engine is off.");
          logAction("Cannot adjust speed","", " Engine is off.");

      }
    }
    /**
     * Checks the durability of the hull and reduces it if the ship is in motion. If the hull's durability reaches 0,
     * the ship is considered damaged and an emergency signal is sent.
     * @throws IOException if there is an error checking the hull's durability or sending the SOS
     */
    private void checkHullIntegrity() throws IOException 
    {
        if (H.getDurability() > 0) 
        {
            H.decreaseDurability();
            logAction("Cheking hull integriry", "", "Integrity got lower");

            if (H.getDurability() == 0) 
            {
                System.out.println("Hull is damaged! Antenna sends SOS signal");
                logAction("Hull is damaged!", "", "Sending SOS signal");
                A.sendSOS();
                closeLog();
                System.exit(0);
            }
        }
    }
    /**
     * Returns the ship to port, ending the journey.
     * @throws IOException if there is an error logging the return action
     */
    public void returnToPort() throws IOException 
    {
        // Получаем текущие координаты
    	String currentLocation = A.send_signal();
        logAction("Return to port", "Need to determine location", "Turning on antenna");
        System.out.println("Antenna activated. Retrieving coordinates...");      
        System.out.println("Current location: " + currentLocation);
        // Запись в лог обновленных координат
        logAction("Send coordinates", "Current location is determined " , currentLocation);
        System.out.println("Coordinates sent ");
        logAction("Return to port", "Turning towards port", "Ship is returning to port");
        System.out.println("Ship returning to port.");
       

        closeLog(); // Завершение лога и закрытие
    }
    /**
     * Closes the log file.
     * @throws IOException if there is an error closing the log file
     */
    private void closeLog() throws IOException
    {
        logWriter.write("End log\n");
        logWriter.close();
        scanner.close();
    }
}