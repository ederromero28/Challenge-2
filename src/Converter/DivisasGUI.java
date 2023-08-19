package Converter;

import FormInit.FormMain;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DivisasGUI {
    private JPanel panelInit = new JPanel();
    private String[] divisas = {"Dolar", "Euro", "Sol peruano", "Peso argentino", "Real brasileño", "Peso chileno",
                "Peso colombiano", "Peso mexicano"};
    private int tipo = 0;
    private Map<String, String> symbol = new HashMap<>();
    private Map<String, Double> changeValue = new HashMap<>();

    /**
     * Contructor de la clase, la cual creara el formulario udando el método FromMain.
     * @param frame -> JFrame sobre el se creara el formulario.
     */
    public DivisasGUI(JFrame frame) {
        symbol.put("Peso argentino", "ARS");
        symbol.put("Real brasileño", "BRL");
        symbol.put("Peso chileno", "CLP");
        symbol.put("Peso colombiano", "COP");
        symbol.put("Euro", "EUR");
        symbol.put("Peso mexicano", "MXN");
        symbol.put("Sol peruano", "PEN");
        symbol.put("Dolar", "USD");

        new FormMain(frame, panelInit, divisas, tipo, symbol, changeValue);
    }
}