package co.edu.distrital;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class App extends JFrame {

    public App() {
        setTitle("Gráfico de Barras");

        // Crear dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(8, "Ventas", "Enero");
        dataset.addValue(12, "Ventas", "Febrero");
        dataset.addValue(5, "Ventas", "Marzo");

        // Crear el gráfico
        JFreeChart grafico = ChartFactory.createBarChart(
                "Ventas por Mes",      // Título
                "Mes",                 // Etiqueta eje X
                "Cantidad",            // Etiqueta eje Y
                dataset                // Datos
        );

        // Mostrar en un panel
        ChartPanel panel = new ChartPanel(grafico);
        setContentPane(panel);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App ventana = new App();
            ventana.setVisible(true);
        });
    }
}


