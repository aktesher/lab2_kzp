
/**
 * Represents an engine of a ship or vehicle, with properties like type, power, and current speed.
 * Provides methods to control the engine and adjust its speed.
 */
public class Engine
{
    private String type;
    private int power;
    private int speed; // текущая скорость
    //private int direction = 1;
    /**
     * Constructor to initialize the engine with a specific type and power.
     * Sets the initial speed to 3.
     * 
     * @param type The type of the engine (e.g., "Diesel", "Electric").
     * @param power The power of the engine in horsepower (hp).
     */
    public Engine(String type, int power) 
    {
        this.type = type;
        this.power = power;
        this.speed = 3; // начальная скорость
    }
    /**
     * Checks if the engine is currently running by evaluating its speed.
     * 
     * @return True if the engine is running (speed > 0), false otherwise.
     */
    public boolean isRunning() 
    {
        return speed > 0; // Двигатель работает, если скорость больше 0
    }
    /**
     * Sets a new speed for the engine.
     * If the new speed is greater than 9, the speed is not changed and an error message is displayed.
     * 
     * @param newSpeed The new speed to set (maximum allowed is 9).
     */
    public void setSpeed(int newSpeed)
    {
        if (newSpeed <= 9)
        {
            this.speed = newSpeed;
            System.out.println("Скорость установлена: " + newSpeed);
        } 
        else 
        {
            System.out.println("Ошибка: скорость не может превышать 9 узлов.");
        }
    }
    /**
     * Increases the engine speed by 1, up to a maximum speed of 9.
     * Displays the current speed after each increase.
     */
    public void increase_speed() 
    {
        for (int i = speed; i < 9; i++) 
        {
            speed++;
            System.out.println("Скорость увеличена: " + speed);
            if (speed >= 9)
            {
                System.out.println("Достигнута максимальная скорость: " + speed);
                break;
            }
        }
    }
    /**
     * Decreases the engine speed by 1, down to a minimum speed of 0.
     * Displays the current speed after each decrease.
     */
    public void decrease_speed() 
    {
        for (int i = speed; i > 0; i--)
        {
            speed--;
            System.out.println("Скорость уменьшена: " + speed);
            if (speed <= 0)
            {
                System.out.println("Достигнута минимальная скорость: " + speed);
                break;
            }
        }
    }
    /**
     * Retrieves the type of the engine.
     * 
     * @return The type of the engine (e.g., "Diesel").
     */
    public String getType() 
    {
        return type;
    }
    /**
     * Retrieves the power of the engine in horsepower.
     * 
     * @return The power of the engine in horsepower.
     */
    public int getPower() 
    {
        return power;
    }
    /**
     * Starts the engine and prints a message indicating the engine is on.
     */
    public void start() 
    {
        System.out.println("Engine turned on.");
    }
    /**
     * Stops the engine and prints a message indicating the engine is off.
     */
    public void stop()
    {
        System.out.println("Engine stopped.");
    }
    /**
     * Turns the ship to the east and prints a message indicating the direction.
     */
    public void turnEast() 
    {
        System.out.println("Ship turns east.");
    }
    /**
     * Turns the ship to the west and prints a message indicating the direction.
     */
    public void turnWest() 
    {
        System.out.println("Ship turns west.");
    }
    /**
     * Turns the ship to the north and prints a message indicating the direction.
     */
    public void turnNorth()
    {
        System.out.println("Ship turns north.");
    }
    /**
     * Turns the ship to the south and prints a message indicating the direction.
     */
    public void turnSouth() 
    {
        System.out.println("Ship turns south.");
    }
    /**
     * Returns a string representation of the engine, including its type and power.
     * 
     * @return A string describing the engine's type and power.
     */
    @Override
    public String toString() 
    {
        return "Engine type is " + type + ", power is " + power + " hp.";
    }
}
