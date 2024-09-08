package pe.edu.upeu.calcfx.control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class CalcControl {

    @FXML
    TextField txtResultado;



    @FXML
    public void accionButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        switch (button.getId()) {
            case "btn7", "btn8", "btn9", "btn6", "btn5", "btn4", "btn3", "btn2", "btn1", "btn0"
                    -> escribirNumeros(button.getText());
            case "btnSum", "btnMul", "btnRest", "btnDiv", "btnPotencia", "btnRaiz", "btnUnoSobreX", "btnBin", "btnPorcentaje"
                    -> operador(button.getText());
            case "btnPI" -> escribirNumeros(String.valueOf(Math.PI)); // Usa el valor de Pi
            case "btnIgual" -> calcularResultado();
            case "btnBorrarTodo" -> txtResultado.clear();
            case "btnBorrar" -> borrarUltimoCaracter();
        }
    }

    public void borrarUltimoCaracter() {
        String textoActual = txtResultado.getText();
        if (textoActual != null && textoActual.length() > 0) {
            txtResultado.setText(textoActual.substring(0, textoActual.length() - 1));
        }
    }

    public void escribirNumeros(String valor){
        txtResultado.appendText(valor);
    }

    public void operador(String valor){
        txtResultado.appendText(" "+valor+" ");}

    public void calcularResultado() {
        try {
            String input = txtResultado.getText().trim(); // Eliminamos espacios innecesarios
            String[] valores = input.split("\\s+"); // Dividimos por uno o más espacios

            if (valores.length == 1) { // Si solo hay un número, lo mostramos
                txtResultado.setText(valores[0]);
                return;
            }
            double val1 = Double.parseDouble(valores[0]);

            if (valores.length == 2) {
                String operador = valores[1];
                switch (operador) {
                    case "√" -> txtResultado.setText(String.valueOf(Math.sqrt(val1)));
                    case "1/x" -> txtResultado.setText(String.valueOf(1 / val1));
                    case "Bin" -> txtResultado.setText(Integer.toBinaryString((int) val1));
                    case "%" -> txtResultado.setText(String.valueOf(val1 / 100)); // Porcentaje del número
                    default -> txtResultado.setText("Error");
                }
            } else if (valores.length == 3) {
                double val2 = Double.parseDouble(valores[2]);
                switch (valores[1]) {
                    case "+" -> txtResultado.setText(String.valueOf(val1 + val2));
                    case "-" -> txtResultado.setText(String.valueOf(val1 - val2));
                    case "/" -> txtResultado.setText(String.valueOf(val1 / val2));
                    case "*" -> txtResultado.setText(String.valueOf(val1 * val2));
                    case "^" -> txtResultado.setText(String.valueOf(Math.pow(val1, val2)));
                    case "%" -> txtResultado.setText(String.valueOf((val1 * val2) / 100)); // Porcentaje del primer número con respecto al segundo
                    default -> txtResultado.setText("Error");
                }
            } else {
                txtResultado.setText("Formato inválido");
            }
        } catch (Exception e) {
            txtResultado.setText("Error en la operación");
        }
    }
}
