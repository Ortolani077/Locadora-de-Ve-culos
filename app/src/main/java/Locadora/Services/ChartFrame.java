package Locadora.Services;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import Locadora.Model.Carro;
import Locadora.Repository.CarroRepository;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartFrame extends JFrame {

    public ChartFrame(DefaultPieDataset dataset) {
        super("Gráfico de Pizza");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        JFreeChart chart = ChartFactory.createPieChart(
                "Carros Mais Alugados",
                dataset,
                true, // legend?
                true, // tooltips?
                false // URLs?
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                CarroRepository carroRepository = new CarroRepository();
                List<Carro> carros = carroRepository.listarTodos();
                DefaultPieDataset dataset = criarDataset(carros);
                
                ChartFrame frame = new ChartFrame(dataset);
                frame.setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static DefaultPieDataset criarDataset(List<Carro> carros) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        CarroRepository carroRepository = new CarroRepository();
        Map<String, Integer> contadorModelos = new HashMap<>();

        // Conta quantas vezes cada modelo aparece
        for (Carro carro : carros) {
            String nomeModelo = carroRepository.buscarNomeModeloPorId(carro.getModeloId());
            contadorModelos.put(nomeModelo, contadorModelos.getOrDefault(nomeModelo, 0) + 1);
        }

        // Calcula o total de carros alugados
        int totalCarrosAlugados = carros.size();

        // Adiciona os valores ao conjunto de dados como porcentagem
        for (Map.Entry<String, Integer> entry : contadorModelos.entrySet()) {
            String nomeModelo = entry.getKey();
            int quantidade = entry.getValue();
            double percentual = (double) quantidade / totalCarrosAlugados * 100;
            String label = nomeModelo + " (" + new DecimalFormat("0.##").format(percentual) + "%)";
            dataset.setValue(label, quantidade);
        }

        return dataset;
    }
}
