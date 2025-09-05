package view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ordenamiento.Burbuja;
import controller.ordenamiento.Merge;
import controller.ordenamiento.Quick;
import controller.ordenamiento.Selection;
import model.Banco;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frame;
	private JTextField textFieldCantidadCandidatos;
	private ButtonGroup opcionesOrdenamiento;
	private ButtonGroup opcionesParametros;
	private JLabel lblOrdenarDeManera;
	
	private int cantCandidatos;
	
	private Banco banco;
	
	private Burbuja burbuja;
	private Selection selection;
	private Quick quick;
	private Merge merge;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 942, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldCantidadCandidatos = new JTextField();
		textFieldCantidadCandidatos.setBounds(133, 40, 86, 20);
		frame.getContentPane().add(textFieldCantidadCandidatos);
		textFieldCantidadCandidatos.setColumns(10);
		
		JLabel lblGeneradorCandidatos = new JLabel("Generar Candidatos: ");
		lblGeneradorCandidatos.setBounds(24, 32, 112, 37);
		frame.getContentPane().add(lblGeneradorCandidatos);
		
		lblOrdenarDeManera = new JLabel("Ordenar de manera:");
		lblOrdenarDeManera.setBounds(605, 11, 145, 37);
		frame.getContentPane().add(lblOrdenarDeManera);
		
		JRadioButton rdbtnOpcionAleatoriaUniforme = new JRadioButton("Aleatoria uniforme");
		rdbtnOpcionAleatoriaUniforme.setBounds(756, 18, 139, 23);
		frame.getContentPane().add(rdbtnOpcionAleatoriaUniforme);
		
		JRadioButton rdbtnOpcionCasiOrdenada = new JRadioButton("Casi ordenada");
		rdbtnOpcionCasiOrdenada.setBounds(756, 46, 109, 23);
		frame.getContentPane().add(rdbtnOpcionCasiOrdenada);
		
		JRadioButton rdbtnOpcionOrdenInverso = new JRadioButton("Orden Inverso");
		rdbtnOpcionOrdenInverso.setBounds(756, 74, 109, 23);
		frame.getContentPane().add(rdbtnOpcionOrdenInverso);
		
		opcionesOrdenamiento = new ButtonGroup();
		opcionesOrdenamiento.add(rdbtnOpcionAleatoriaUniforme);
		opcionesOrdenamiento.add(rdbtnOpcionCasiOrdenada);
		opcionesOrdenamiento.add(rdbtnOpcionOrdenInverso);
		
		JLabel lblOrdenarAtributos = new JLabel("Ordenar segun el atributo:");
		lblOrdenarAtributos.setBounds(24, 101, 195, 37);
		frame.getContentPane().add(lblOrdenarAtributos);
		
		JRadioButton rdbtnDistMarchas = new JRadioButton("(1) Distancia recorrida en marchas");
		rdbtnDistMarchas.setBounds(34, 145, 223, 23);
		frame.getContentPane().add(rdbtnDistMarchas);
		
		JRadioButton rdbtnHorasClase = new JRadioButton("(2) Horas de clase perdidas por bloqueos");
		rdbtnHorasClase.setBounds(34, 182, 265, 23);
		frame.getContentPane().add(rdbtnHorasClase);
		
		JRadioButton rdbtnPrebSindicales = new JRadioButton("(3) Valor total de prebendas sindicales recibidas");
		rdbtnPrebSindicales.setBounds(34, 210, 308, 23);
		frame.getContentPane().add(rdbtnPrebSindicales);
		
		JRadioButton rdbtnSobornos = new JRadioButton("(4) Número de políticos de los que han recibido sobornos");
		rdbtnSobornos.setBounds(259, 145, 423, 23);
		frame.getContentPane().add(rdbtnSobornos);
		
		JRadioButton rdbtnActosCorrup = new JRadioButton("(5) Valor total atribuido a actos de corrupción en los que han participado. ");
		rdbtnActosCorrup.setBounds(309, 182, 461, 23);
		frame.getContentPane().add(rdbtnActosCorrup);
		
		opcionesParametros = new ButtonGroup();
		opcionesParametros.add(rdbtnDistMarchas);
		opcionesParametros.add(rdbtnHorasClase);
		opcionesParametros.add(rdbtnPrebSindicales);
		opcionesParametros.add(rdbtnSobornos);
		opcionesParametros.add(rdbtnActosCorrup);
		
		JLabel lblDesempenioAlgoritmos = new JLabel("Desempeño algoritmos: ");
		lblDesempenioAlgoritmos.setBounds(27, 271, 195, 37);
		frame.getContentPane().add(lblDesempenioAlgoritmos);
		
		JLabel lblTituloInsercion = new JLabel("Inserción");
		lblTituloInsercion.setBounds(322, 271, 59, 37);
		frame.getContentPane().add(lblTituloInsercion);
		
		JLabel lblTituloSeleccion = new JLabel("Selección");
		lblTituloSeleccion.setBounds(443, 271, 59, 37);
		frame.getContentPane().add(lblTituloSeleccion);
		
		JLabel lblTituloBurbuja = new JLabel("Burbuja");
		lblTituloBurbuja.setBounds(564, 271, 59, 37);
		frame.getContentPane().add(lblTituloBurbuja);
		
		JLabel lblTituloQuick = new JLabel("Quick");
		lblTituloQuick.setBounds(685, 271, 59, 37);
		frame.getContentPane().add(lblTituloQuick);
		
		JLabel lblTituloMerge = new JLabel("Merge");
		lblTituloMerge.setBounds(806, 271, 59, 37);
		frame.getContentPane().add(lblTituloMerge);
		
		JLabel lblTiempoEjecucion = new JLabel("Tiempo de ejecución: ");
		lblTiempoEjecucion.setBounds(65, 319, 195, 37);
		frame.getContentPane().add(lblTiempoEjecucion);
		
		JLabel lblTiempoEjecInsercion = new JLabel("");
		lblTiempoEjecInsercion.setBounds(322, 319, 59, 37);
		frame.getContentPane().add(lblTiempoEjecInsercion);
		
		JLabel lblTiempoEjecSeleccion = new JLabel("");
		lblTiempoEjecSeleccion.setBounds(443, 319, 59, 37);
		frame.getContentPane().add(lblTiempoEjecSeleccion);
		
		JLabel lblTiempoEjecBurbuja = new JLabel("");
		lblTiempoEjecBurbuja.setBounds(553, 319, 59, 37);
		frame.getContentPane().add(lblTiempoEjecBurbuja);
		
		JLabel lblTiempoEjecQuick = new JLabel("");
		lblTiempoEjecQuick.setBounds(673, 319, 59, 37);
		frame.getContentPane().add(lblTiempoEjecQuick);
		
		JLabel lblTiempoEjecMerge = new JLabel("");
		lblTiempoEjecMerge.setBounds(806, 319, 59, 37);
		frame.getContentPane().add(lblTiempoEjecMerge);
		
		JLabel lblNumComparaciones = new JLabel("Numero de comparaciones: ");
		lblNumComparaciones.setBounds(65, 367, 195, 37);
		frame.getContentPane().add(lblNumComparaciones);
		
		JLabel lblNumComparacionesIsercion = new JLabel("");
		lblNumComparacionesIsercion.setBounds(323, 367, 59, 37);
		frame.getContentPane().add(lblNumComparacionesIsercion);
		
		JLabel lblNumComparacionesSeleccion = new JLabel("");
		lblNumComparacionesSeleccion.setBounds(443, 367, 59, 37);
		frame.getContentPane().add(lblNumComparacionesSeleccion);
		
		JLabel lblNumComparacionesBurbuja = new JLabel("");
		lblNumComparacionesBurbuja.setBounds(553, 367, 59, 37);
		frame.getContentPane().add(lblNumComparacionesBurbuja);
		
		JLabel lblNumComparacionesQuick = new JLabel("");
		lblNumComparacionesQuick.setBounds(673, 367, 59, 37);
		frame.getContentPane().add(lblNumComparacionesQuick);
		
		JLabel lblNumComparacionesMerge = new JLabel("");
		lblNumComparacionesMerge.setBounds(806, 367, 59, 37);
		frame.getContentPane().add(lblNumComparacionesMerge);
		
		JLabel lblNumIntercambios = new JLabel("Numero de intercambios: ");
		lblNumIntercambios.setBounds(65, 415, 195, 37);
		frame.getContentPane().add(lblNumIntercambios);
		
		JLabel lblNumIntercambiosInsercion = new JLabel("");
		lblNumIntercambiosInsercion.setBounds(323, 415, 59, 37);
		frame.getContentPane().add(lblNumIntercambiosInsercion);
		
		JLabel lblNumIntercambiosSeleccion = new JLabel("");
		lblNumIntercambiosSeleccion.setBounds(443, 415, 59, 37);
		frame.getContentPane().add(lblNumIntercambiosSeleccion);
		
		JLabel lblNumIntercambiosBurbuja = new JLabel("");
		lblNumIntercambiosBurbuja.setBounds(553, 415, 59, 37);
		frame.getContentPane().add(lblNumIntercambiosBurbuja);
		
		JLabel lblNumIntercambiosQuick = new JLabel("");
		lblNumIntercambiosQuick.setBounds(673, 415, 59, 37);
		frame.getContentPane().add(lblNumIntercambiosQuick);
		
		JLabel lblNumIntercambiosMerge = new JLabel("");
		lblNumIntercambiosMerge.setBounds(806, 415, 59, 37);
		frame.getContentPane().add(lblNumIntercambiosMerge);
		
		JLabel lblTiempoPared = new JLabel("Tiempo pared: ");
		lblTiempoPared.setBounds(65, 468, 195, 37);
		frame.getContentPane().add(lblTiempoPared);
		
		JLabel lblTiempoParedInsercion = new JLabel("");
		lblTiempoParedInsercion.setBounds(323, 468, 59, 37);
		frame.getContentPane().add(lblTiempoParedInsercion);
		
		JLabel lblTiempoParedSeleccion = new JLabel("");
		lblTiempoParedSeleccion.setBounds(443, 468, 59, 37);
		frame.getContentPane().add(lblTiempoParedSeleccion);
		
		JLabel lblTiempoParedBurbuja = new JLabel("");
		lblTiempoParedBurbuja.setBounds(553, 468, 59, 37);
		frame.getContentPane().add(lblTiempoParedBurbuja);
		
		JLabel lblTiempoParedQuick = new JLabel("");
		lblTiempoParedQuick.setBounds(673, 468, 59, 37);
		frame.getContentPane().add(lblTiempoParedQuick);
		
		JLabel lblTiempoParedMerge = new JLabel("");
		lblTiempoParedMerge.setBounds(806, 468, 59, 37);
		frame.getContentPane().add(lblTiempoParedMerge);
		
		JLabel lblCandidatoElecto = new JLabel("Candidato electo: ");
		lblCandidatoElecto.setBounds(24, 516, 139, 37);
		frame.getContentPane().add(lblCandidatoElecto);
		
		JLabel lblMostrarCandidatoElecto = new JLabel("");
		lblMostrarCandidatoElecto.setBounds(173, 516, 620, 37);
		frame.getContentPane().add(lblMostrarCandidatoElecto);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textFieldCantidadCandidatos.setText("");
				
				opcionesOrdenamiento.clearSelection();
				opcionesParametros.clearSelection();
				
				lblTiempoEjecInsercion.setText("");
				lblTiempoEjecSeleccion.setText("");
				lblTiempoEjecBurbuja.setText("");
				lblTiempoEjecQuick.setText("");
				lblTiempoEjecMerge.setText("");
				
				lblNumComparacionesIsercion.setText("");
				lblNumComparacionesSeleccion.setText("");
				lblNumComparacionesBurbuja.setText("");
				lblNumComparacionesQuick.setText("");
				lblNumComparacionesMerge.setText("");
				
				lblNumIntercambiosInsercion.setText("");
				lblNumIntercambiosSeleccion.setText("");
				lblNumIntercambiosBurbuja.setText("");
				lblNumIntercambiosQuick.setText("");
				lblNumIntercambiosMerge.setText("");
				
				lblTiempoParedInsercion.setText("");
				lblTiempoParedSeleccion.setText("");
				lblTiempoParedBurbuja.setText("");
				lblTiempoParedQuick.setText("");
				lblTiempoParedMerge.setText("");
				
				lblMostrarCandidatoElecto.setText("");
			}
		});
		btnBorrar.setBounds(827, 530, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cantCandidatos = Integer.parseInt(textFieldCantidadCandidatos.getText());
					String opcionOrdenamiento = "";
					String opcionParametro = "";
					
					if(cantCandidatos < 10000000)
					{
						JOptionPane.showMessageDialog(null, "El numero de candidatos debe ser mayor a 10000000");
						cantCandidatos = Integer.parseInt(textFieldCantidadCandidatos.getText());
					}
					
					
					ButtonModel seleccionadoOrden = opcionesOrdenamiento.getSelection();
					if(seleccionadoOrden == rdbtnOpcionAleatoriaUniforme.getModel())
					{
						opcionOrdenamiento = "aleatoria uniforme";
					}
					else if(seleccionadoOrden == rdbtnOpcionCasiOrdenada.getModel())
					{
						opcionOrdenamiento = "Casi ordenada";
					}
					else if(seleccionadoOrden == rdbtnOpcionOrdenInverso.getModel())
					{
						opcionOrdenamiento = "orden inverso";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Esocoja una opcion valida para el ordenamiento");
					}
					
					ButtonModel seleccionadoParametro = opcionesParametros.getSelection();
					if(seleccionadoParametro == rdbtnDistMarchas.getModel())
					{
						opcionParametro = "distancia marchas";
					}
					else if(seleccionadoParametro == rdbtnHorasClase.getModel())
					{
						opcionParametro = "horas perdidas";
					}
					else if(seleccionadoParametro == rdbtnPrebSindicales.getModel())
					{
						opcionParametro = "prebendas sindicales";
					}
					else if(seleccionadoParametro == rdbtnSobornos.getModel())
					{
						opcionParametro = "sobornos";
					}
					else if(seleccionadoParametro == rdbtnActosCorrup.getModel())
					{
						opcionParametro = "actos corruptos";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Esocoja una opcion valida para el parametro");
					}
					
					System.out.println(cantCandidatos);
					System.out.println(opcionOrdenamiento);
					System.out.println(opcionParametro);
					
					banco = new Banco(cantCandidatos);
					
					burbuja = new Burbuja(banco);
					selection = new Selection(banco);
					quick = new Quick(banco);
					merge = new Merge(banco);
					
					burbuja.ordenar(opcionParametro);
					selection.ordenar(opcionParametro);
					quick.ordenar(opcionParametro);
					merge.ordenar(opcionParametro);
					
					System.out.println("Banco ordenado exitosamente con todos los algoritmos!");
				}
				catch(Exception exception)
				{
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
		btnGenerar.setBounds(776, 163, 89, 60);
		frame.getContentPane().add(btnGenerar);
	}
}
