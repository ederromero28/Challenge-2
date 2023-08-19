package Converter;

import FormInit.FormMain;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PesoGUI {
    private JPanel panelInit = new JPanel();
    private String[] peso = {"Kilogramo", "Gramo", "Libra", "Onza"};
    private int tipo = 2;
    private Map<String, String> symbol = new HashMap<>();
    private Map<String, Double> changeValue = new HashMap<>();

    /**
     * Contructor de la clase, la cual creara el formulario udando el método FromMain.
     * @param frame -> JFrame sobre el se creara el formulario.
     */
    public PesoGUI(JFrame frame){
        symbol.put("Kilogramo", "Kg");
        symbol.put("Gramo", "g");
        symbol.put("Libra", "lb");
        symbol.put("Onza", "oz");

        changeValue.put("kilogramo_gramo", 1000.0);
        changeValue.put("gramo_kilogramo", 0.001);
        changeValue.put("kilogramo_libra", 2.20462);
        changeValue.put("libra_kilogramo", 0.453592);
        changeValue.put("kilogramo_onza", 35.274);
        changeValue.put("onza_kilogramo", 0.0283495);
        changeValue.put("gramo_libra", 0.00220462);
        changeValue.put("libra_gramo", 453.592);
        changeValue.put("gramo_onza", 0.035274);
        changeValue.put("onza_gramo", 28.3495);
        changeValue.put("libra_onza", 16.0);
        changeValue.put("onza_libra", 0.0625);

        new FormMain(frame, panelInit, peso, tipo, symbol, changeValue);
    }
}
