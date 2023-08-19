package Converter;

import FormInit.FormMain;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class TemperaturaGUI {
    private JPanel panelInit = new JPanel();
    private String[] temperaturas = {"Celsius", "Fahrenheit", "Kelvin", "Rankine"};
    private int tipo = 1;
    private Map<String, String> symbol = new HashMap<>();
    private Map<String, Double> changeValue = new HashMap<>();

    /**
     * Contructor de la clase, la cual creara el formulario udando el método FromMain.
     * @param frame -> JFrame sobre el se creara el formulario.
     */
    public TemperaturaGUI(JFrame frame) {
        symbol.put("Celsius", "°C");
        symbol.put("Fahrenheit", "°F");
        symbol.put("Kelvin", "°K");
        symbol.put("Rankine", "°R");

        changeValue.put("celsius_fahrenheit", 9.0/5.0);
        changeValue.put("fahrenheit_celsius", 5.0/9.0);
        changeValue.put("celsius_kelvin", 1.0);
        changeValue.put("kelvin_celsius", 1.0);
        changeValue.put("fahrenheit_kelvin", 5.0/9.0);
        changeValue.put("kelvin_fahrenheit", 9.0/5.0);
        changeValue.put("celsius_rankine", 9.0/5.0);
        changeValue.put("rankine_celsius", 5.0/9.0);
        changeValue.put("fahrenheit_rankine", 1.0);
        changeValue.put("rankine_fahrenheit", 1.0);
        changeValue.put("kelvin_rankine", 9.0/5.0);
        changeValue.put("rankine_kelvin", 5.0/9.0);

        new FormMain(frame, panelInit, temperaturas, tipo, symbol, changeValue);
    }
}
