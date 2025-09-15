import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CalculadoraIMC extends Application {

    @Override
    public void start(Stage palco) {

        // Etiquetas para os campos de entrada
        Label etiquetaPeso = new Label("Peso");
        Label etiquetaAltura = new Label("Altura");

        // Cmpos de texto para entrada de dados        
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        // Label para mostrar o resultado do IMC
        Label etiquetaResultado = new Label();
        Label etiquetaClassificacao = new Label();

        // Botão para calcular o IMC
        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.setOnAction( e -> {
            try {
                double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
                double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));

                double imc = peso / (altura * altura);

                if (imc < 17.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Muito abaixo do peso");
                } else if (imc >= 17.0 && imc < 18.5) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Abaixo do peso");
                } else if (imc >= 18.5 && imc < 25.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Peso normal");
                } else if (imc >= 25.0 && imc < 30.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Acima do peso");
                } else if (imc >= 30.0 && imc < 35.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Obesidade I");
                } else if (imc >= 35.0 && imc < 40.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Obesidade II");
                } else if (imc > 40.0) {
                    etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
                    etiquetaClassificacao.setText("Obesidade III");
                }
            } catch (NumberFormatException ex) {
                etiquetaResultado.setText("Por favor, insira números válidos para peso e altura.");
            }
        });

        // Layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado, etiquetaClassificacao);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        // Cena e palco
        Scene cena = new Scene(layout, 350, 250);
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}