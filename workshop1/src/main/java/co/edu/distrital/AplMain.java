

import controller.Controller;

/**
 * The entry point for the application.
 * <p>
 * This class contains the main method which initializes the {@link Controller}
 * and starts the application's execution.
 * </p>
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class AplMain {

	public static void main(String args[])
	{
		Controller control = new Controller();
		control.run();
	}
}
 
