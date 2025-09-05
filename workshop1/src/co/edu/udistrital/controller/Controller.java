package controller;

import java.awt.EventQueue;

import view.VentanaPrincipal;

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
