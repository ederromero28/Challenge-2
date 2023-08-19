package Converter;

import FormInit.FormMain;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class LongitudGUI {
    private JPanel panelInit = new JPanel();
    private String[] longitud = {"Kilómetro", "Metro", "Milla", "Yarda", "Pie"};
    private int tipo = 3;
    private Map<String, String>  symbol = new HashMap<>();
    private Map<String, Double> changeValue = new HashMap<>();

    /**
     * Contructor de la clase, la cual creara el formulario udando el método FromMain.
     * @param frame -> JFrame sobre el se creara el formulario.
     */
    public LongitudGUI(JFrame frame) {
        symbol.put("Kilómetro", "Km");
        symbol.put("Metro", "m");
        symbol.put("Milla", "Mi");
        symbol.put("Yarda", "Yd");
        symbol.put("Pie", "ft");

        changeValue.put("kilómetro_metro", 1000.0);
        changeValue.put("metro_kilómetro", 0.001);
        changeValue.put("kilómetro_milla", 0.621371);
        changeValue.put("milla_kilómetro", 1.60934);
        changeValue.put("kilómetro_yarda", 1093.61);
        changeValue.put("yarda_kilómetro", 0.0009144);
        changeValue.put("kilómetro_pie", 1000.0);
        changeValue.put("pie_kilómetro", 3280.84);
        changeValue.put("metro_milla", 0.000621371);
        changeValue.put("milla_metro", 1609.34);
        changeValue.put("metro_yarda", 1.09361);
        changeValue.put("yarda_metro", 0.9144);
        changeValue.put("metro_pie", 3.28084);
        changeValue.put("pie_metro", 0.3048);
        changeValue.put("milla_yarda", 1760.0);
        changeValue.put("yarda_milla", 0.000568182);
        changeValue.put("milla_pie", 5280.0);
        changeValue.put("pie_milla", 0.000189394);
        changeValue.put("yarda_pie", 3.0);
        changeValue.put("pie_yarda", 0.33);

        new FormMain(frame, panelInit, longitud, tipo, symbol, changeValue);
    }

}
