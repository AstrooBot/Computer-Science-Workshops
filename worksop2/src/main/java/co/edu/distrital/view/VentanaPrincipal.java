package co.edu.distrital.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import co.edu.distrital.controller.Mesa;

import java.awt.Color;

public class VentanaPrincipal {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Mesa mesa = new Mesa(1234, 10);
		mesa.inicioJuego();
		String[] nombresPastores = mesa.controladorPastores.getPastoresNombres();
		String[] riquezasPastores = mesa.controladorPastores.getPastoresRiqueza();
		String[] fielesPastores = mesa.controladorPastores.getPastoresFieles();
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea areaDesposeidos = new JTextArea();
	
		areaDesposeidos.setFont(new Font("Arial", Font.PLAIN, 12));
		areaDesposeidos.setBackground(new Color(122,0,0));
		areaDesposeidos.setForeground(new Color(0,0,0));
		areaDesposeidos.setBounds(776, 142 ,244, 350);
		frame.getContentPane().add(areaDesposeidos);
		/* 
		JLabel lblDesposeidos = new JLabel("");
		lblDesposeidos.setForeground(new Color(192, 192, 192));
		lblDesposeidos.setBounds(799, 152 ,222, 350);
		lblDesposeidos.setHorizontalAlignment(JLabel.LEFT);
		lblDesposeidos.setVerticalAlignment(JLabel.TOP);
		frame.getContentPane().add(lblDesposeidos);
		*/
		JButton btnEjecutar = new JButton("");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	mesa.loop();
				JOptionPane.showMessageDialog(null, mesa.getWinner().getNombre() + " es el ganador con " + mesa.getWinner().getDoblones() + " doblones y " + mesa.getWinner().getFieles() + " fieles.");
				areaDesposeidos.setText(mesa.controladorPastores.getDesposeidos());

			}
		});
		btnEjecutar.setBounds(799, 11, 207, 23);
		frame.getContentPane().add(btnEjecutar);
		btnEjecutar.setOpaque(false);
		btnEjecutar.setContentAreaFilled(false);
		btnEjecutar.setFocusPainted(false);
			
		
		JLabel lblNombreJ1 = new JLabel(nombresPastores[0]);
		lblNombreJ1.setBounds(400, 81, 100, 10);
		frame.getContentPane().add(lblNombreJ1);
		
		JLabel lblFielesJ1 = new JLabel("Fieles: " + fielesPastores[0]);
		lblFielesJ1.setBounds(400, 100, 100, 10);
		frame.getContentPane().add(lblFielesJ1);
		
		JLabel lblRiquezaJ1 = new JLabel("Riqueza: " + riquezasPastores[0]);
		lblRiquezaJ1.setBounds(400, 120, 100, 10);
		frame.getContentPane().add(lblRiquezaJ1);
		
		JLabel lblNombreJ2 = new JLabel(nombresPastores[1]);
		lblNombreJ2.setBounds(540, 100, 100, 10);
		frame.getContentPane().add(lblNombreJ2);
		
		JLabel lblFielesJ2 = new JLabel("Fieles: " + fielesPastores[1]);
		lblFielesJ2.setBounds(540, 120, 100, 10);
		frame.getContentPane().add(lblFielesJ2);
		
		JLabel lblRiquezaJ2 = new JLabel("Riqueza: " + riquezasPastores[1]);
		lblRiquezaJ2.setBounds(540, 140, 100, 10);
		frame.getContentPane().add(lblRiquezaJ2);
		
		JLabel lblNombreJ3 = new JLabel(nombresPastores[2]);
		lblNombreJ3.setBounds(580, 180, 100, 10);
		frame.getContentPane().add(lblNombreJ3);
		
		JLabel lblFielesJ3 = new JLabel("Fieles: " + fielesPastores[2]);
		lblFielesJ3.setBounds(580, 200, 100, 10);
		frame.getContentPane().add(lblFielesJ3);
		
		JLabel lblRiquezaJ3 = new JLabel("Riqueza: " + riquezasPastores[2]);
		lblRiquezaJ3.setBounds(580, 220, 100, 10);
		frame.getContentPane().add(lblRiquezaJ3);
		
		JLabel lblNombreJ4 = new JLabel(nombresPastores[3]);
		lblNombreJ4.setBounds(592, 280, 100, 10);
		frame.getContentPane().add(lblNombreJ4);
		JLabel lblFielesJ4 = new JLabel("Fieles: " + fielesPastores[3]);
		lblFielesJ4.setBounds(592, 300, 100, 10);
		frame.getContentPane().add(lblFielesJ4);
		JLabel lblRiquezaJ4 = new JLabel("Riqueza: " + riquezasPastores[3]);
		lblRiquezaJ4.setBounds(592, 320, 100, 10);
		frame.getContentPane().add(lblRiquezaJ4);
		
		JLabel lblNombreJ5 = new JLabel(nombresPastores[4]);
		lblNombreJ5.setBounds(560, 390, 100, 10);
		frame.getContentPane().add(lblNombreJ5);
		JLabel lblFielesJ5 = new JLabel("Fieles: " + fielesPastores[4]);
		lblFielesJ5.setBounds(560, 410, 100, 10);
		frame.getContentPane().add(lblFielesJ5);
		JLabel lblRiquezaJ5 = new JLabel("Riqueza: " + riquezasPastores[4]);
		lblRiquezaJ5.setBounds(560, 430, 100, 10);
		frame.getContentPane().add(lblRiquezaJ5);

		JLabel lblNombreJ6 = new JLabel(nombresPastores[5]);
		lblNombreJ6.setBounds(400, 455, 100, 10);
		frame.getContentPane().add(lblNombreJ6);
		JLabel lblFielesJ6 = new JLabel("Fieles: " + fielesPastores[5]);
		lblFielesJ6.setBounds(400, 465, 100, 10);
		frame.getContentPane().add(lblFielesJ6);
		JLabel lblRiquezaJ6 = new JLabel("Riqueza: " + riquezasPastores[5]);
		lblRiquezaJ6.setBounds(400, 475, 100, 10);
		frame.getContentPane().add(lblRiquezaJ6);

		JLabel lblNombreJ7 = new JLabel(nombresPastores[6]);
		lblNombreJ7.setBounds(100, 390, 100, 10);
		frame.getContentPane().add(lblNombreJ7);
		JLabel lblFielesJ7 = new JLabel("Fieles: " + fielesPastores[6]);
		lblFielesJ7.setBounds(100, 410, 100, 10);
		frame.getContentPane().add(lblFielesJ7);
		JLabel lblRiquezaJ7 = new JLabel("Riqueza: " + riquezasPastores[6]);
		lblRiquezaJ7.setBounds(100, 430, 100, 10);
		frame.getContentPane().add(lblRiquezaJ7);

		JLabel lblNombreJ8 = new JLabel(nombresPastores[7]);
		lblNombreJ8.setBounds(60, 280, 100, 10);
		frame.getContentPane().add(lblNombreJ8);
		JLabel lblFielesJ8 = new JLabel("Fieles: " + fielesPastores[7]);
		lblFielesJ8.setBounds(60, 300, 100, 10);
		frame.getContentPane().add(lblFielesJ8);
		JLabel lblRiquezaJ8 = new JLabel("Riqueza: " + riquezasPastores[7]);
		lblRiquezaJ8.setBounds(60, 320, 100, 10);
		frame.getContentPane().add(lblRiquezaJ8);

		JLabel lblNombreJ9 = new JLabel(nombresPastores[8]);
		lblNombreJ9.setBounds(70, 180, 100, 10);
		frame.getContentPane().add(lblNombreJ9);
		JLabel lblFielesJ9 = new JLabel("Fieles: " + fielesPastores[8]);
		lblFielesJ9.setBounds(70, 200, 100, 10);
		frame.getContentPane().add(lblFielesJ9);
		JLabel lblRiquezaJ9 = new JLabel("Riqueza: " + riquezasPastores[8]);
		lblRiquezaJ9.setBounds(70, 220, 100, 10);
		frame.getContentPane().add(lblRiquezaJ9);

		JLabel lblNombreJ10 = new JLabel(nombresPastores[9]);
		lblNombreJ10.setBounds(140, 100, 100, 10);
		frame.getContentPane().add(lblNombreJ10);
		JLabel lblFielesJ10 = new JLabel("Fieles: " + fielesPastores[9]);
		lblFielesJ10.setBounds(140, 120, 100, 10);
		frame.getContentPane().add(lblFielesJ10);
		JLabel lblRiquezaJ10 = new JLabel("Riqueza: " + riquezasPastores[9]);
		lblRiquezaJ10.setBounds(140, 140, 100, 10);
		frame.getContentPane().add(lblRiquezaJ10);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/fondoMesa.jpg")));
		lblFondo.setBounds(0, 0, 1034, 503);
		frame.getContentPane().add(lblFondo);
	}
}
