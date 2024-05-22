package Calculadora;
|
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    // Crear componentes
    private JTextField pantalla;
    private JPanel panelBotones;
    private JButton[] botones;
    private JButton btnAvanzadas;
    private String[] etiquetasBotones = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+", 
            "√", "^"
    };

    // Variables para el cálculo
    private String operador;
    private double num1, num2, resultado;
    private boolean nuevoNumero;

    public Calculadora() {
        // Configurar el JFrame
        setTitle("Calculadora");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear pantalla
        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.PLAIN, 24));

        // Crear panel de botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 10, 10));

        // Crear y agregar botones
        botones = new JButton[18];
        for (int i = 0; i < 18; i++) {
            botones[i] = new JButton(etiquetasBotones[i]);
            botones[i].setFont(new Font("Arial", Font.PLAIN, 20));
            botones[i].addActionListener(this);
            panelBotones.add(botones[i]);
        }

        // Botón de opciones avanzadas
        btnAvanzadas = new JButton("Avanzadas");
        btnAvanzadas.setFont(new Font("Arial", Font.PLAIN, 20));
        btnAvanzadas.addActionListener(e -> mostrarOpcionesAvanzadas());
        panelBotones.add(btnAvanzadas);

        // Agregar componentes al JFrame
        setLayout(new BorderLayout());
        add(pantalla, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.charAt(0) >= '0' && comando.charAt(0) <= '9' || comando.equals(".")) {
            if (nuevoNumero) {
                pantalla.setText(comando);
                nuevoNumero = false;
            } else {
                pantalla.setText(pantalla.getText() + comando);
            }
        } else if (comando.equals("=")) {
            num2 = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/": resultado = num1 / num2; break;
                case "^": resultado = Math.pow(num1, num2); break;
            }
            pantalla.setText(String.valueOf(resultado));
            nuevoNumero = true;
        } else if (comando.equals("√")) {
            num1 = Double.parseDouble(pantalla.getText());
            resultado = Math.sqrt(num1);
            pantalla.setText(String.valueOf(resultado));
            nuevoNumero = true;
        } else {
            operador = comando;
            num1 = Double.parseDouble(pantalla.getText());
            nuevoNumero = true;
        }
    }

    private void mostrarOpcionesAvanzadas() {
        JDialog dialogoAvanzado = new JDialog(this, "Opciones Avanzadas", true);
        dialogoAvanzado.setSize(300, 200);
        dialogoAvanzado.setLayout(new GridLayout(3, 2, 10, 10));

        JButton btnSeno = new JButton("sin");
        JButton btnCoseno = new JButton("cos");
        JButton btnTangente = new JButton("tan");

        btnSeno.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCoseno.setFont(new Font("Arial", Font.PLAIN, 20));
        btnTangente.setFont(new Font("Arial", Font.PLAIN, 20));

        btnSeno.addActionListener(e -> realizarOperacionAvanzada("sin"));
        btnCoseno.addActionListener(e -> realizarOperacionAvanzada("cos"));
        btnTangente.addActionListener(e -> realizarOperacionAvanzada("tan"));

        dialogoAvanzado.add(btnSeno);
        dialogoAvanzado.add(btnCoseno);
        dialogoAvanzado.add(btnTangente);

        dialogoAvanzado.setLocationRelativeTo(this);
        dialogoAvanzado.setVisible(true);
    }

    private void realizarOperacionAvanzada(String operacion) {
        double numero = Double.parseDouble(pantalla.getText());
        switch (operacion) {
            case "sin": resultado = Math.sin(Math.toRadians(numero)); break;
            case "cos": resultado = Math.cos(Math.toRadians(numero)); break;
            case "tan": resultado = Math.tan(Math.toRadians(numero)); break;
        }
        pantalla.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadora = new Calculadora();
            calculadora.setVisible(true);
        });
    }
}
