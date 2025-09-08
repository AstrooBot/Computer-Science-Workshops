package controller;


import java.awt.EventQueue;

import view.VentanaPrincipal;

/**
 * The {@code Controller} class is responsible for initializing and launching the main application window
 * in a thread-safe manner using the Event Dispatch Thread (EDT).
 * <p>
 * It provides a {@link #run()} method that schedules the creation and display of the {@code VentanaPrincipal}
 * window, ensuring that all GUI-related operations are performed on the EDT.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Controller controller = new Controller();
 *     controller.run();
 * </pre>
 * </p>
 *
 * @author Nicolas Diaz Salamanca <jndiazs@udistrital.edu.co>
 */
public class Controller {
	public Controller() {}
	
	public void run()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
