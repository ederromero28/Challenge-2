package FormInit;

import Converter.DivisasGUI;
import Converter.LongitudGUI;
import Converter.PesoGUI;
import Converter.TemperaturaGUI;
import ApiModule.ApiClass;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public abstract class FormFunction {
    /**
     * Metodo para que el valor ingresado en el Input sea solo numero, cualquier otra valor no se escribirá
     * @param textField -> Input a configurar
     */
    public void NumbersOnly(JTextField textField){
        AbstractDocument document = (AbstractDocument) textField.getDocument();
        DocumentFilter documentFilter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
                    throws BadLocationException {
                if (text.matches("[0-9.]+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("[0-9.]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
        document.setDocumentFilter(documentFilter);
    }

    /**
     *
     * @param text
     * @param conver
     * @param entrada
     * @param salida
     * @param tipo
     * @param symbol
     * @param changeValue
     */
    public void sendData(JLabel text, JTextField conver, JComboBox entrada, JComboBox salida, int tipo, Map<String ,String> symbol, Map<String, Double> changeValue) {
        String resultant = null;
        //Obtener los valoces selccionados
        String unidadOne = (String) entrada.getSelectedItem();
        String unidadTwo = (String) salida.getSelectedItem();
        String unitConver = conver.getText();

        //obtener el simbolo
        String valSymbol1 = symbol.get(unidadOne);
        String valSymbol = symbol.get(unidadTwo);

        //Convertir los valores a minusculas
        String unitOne = unidadOne.toLowerCase();
        String unitTwo = unidadTwo.toLowerCase();

        //unir valores
        String union = unitOne + "_" + unitTwo;

        if (unitConver.isEmpty()) {
            System.out.println("Cantidad a convertir vacía");
        } else {
            switch (tipo) {
                case 0:
                    resultant = converterDivisa(valSymbol1, valSymbol, unitConver);
                    break;
                case 1:
                    resultant = converterTemperatura(union, unitConver, valSymbol, changeValue);
                    break;
                default:
                    resultant = converterOther(union, unitConver, valSymbol, changeValue);
            }
            text.setText(resultant);
        }
    }

    /**
     * Metodo que delvoverá el valor de la conversion utilizando la API de divisas con el metodo Requestapi.
     * @param firstDivisa   -> Primer simbolo de divisas para la API.
     * @param secondDivisa  -> Segundo simbolo de divisas para la API.
     * @param valor         -> Valor que se multipicada con lo que retorne la API
     * @return Valor de la Divisa
     */
    public String converterDivisa(String firstDivisa, String secondDivisa, String valor) {
        DecimalFormat df = new DecimalFormat("###.##");
        double rptaApi = ApiClass.Requestapi("55f172bc40dd3f6d642cbfc7", firstDivisa, secondDivisa);
        double rpta = rptaApi * Double.parseDouble(valor);

        return "Aprox.: " + String.valueOf(df.format(rpta)) + " " + secondDivisa;
    }

    /**
     * Metodo para la conversión de las unidades de temperaturas
     * @param union     -> String a comprobar en el Map, obtendra un valor para la formula
     * @param valor     -> Valor del input.
     * @param valSymbol -> Simbolo de la unidad de temperatura
     * @param valChange -> Valores del Map
     * @return Valor de la unidad de temperatura
     */
    public String converterTemperatura (String union, String valor, String valSymbol, Map<String, Double> valChange) {
        double rpta = 0;
        Map<String, Double> valueTwo = new HashMap<>();
        DecimalFormat df = new DecimalFormat("###.##");

        valueTwo.put("celsius_fahrenheit", 32.0);
        valueTwo.put("fahrenheit_celsius", -17.7778);
        valueTwo.put("celsius_kelvin", 273.15);
        valueTwo.put("kelvin_celsius", -273.15);
        valueTwo.put("fahrenheit_kelvin", 255.372);
        valueTwo.put("kelvin_fahrenheit", -459.67);
        valueTwo.put("celsius_rankine", 491.67);
        valueTwo.put("rankine_celsius", -273.15);
        valueTwo.put("fahrenheit_rankine", 459.67);
        valueTwo.put("rankine_fahrenheit", -459.67);
        valueTwo.put("kelvin_rankine", 0.0);
        valueTwo.put("rankine_kelvin", 0.0);

        if(valChange.containsKey(union)) {
            rpta = (Double.parseDouble(valor) * valChange.get(union) + valueTwo.get(union));
        } else {
            rpta = Double.parseDouble(valor);
        }

        return String.valueOf(df.format(rpta)) + " " + valSymbol;
    }

    /**
     * Metodo para la conversion de unidades de Peso y Longitud
     * @param union     -> String a comprobar en el Map, obtendra un valor para la formula
     * @param valor     -> Valor del input.
     * @param valSymbol -> Simbolo de la unidad a convertir
     * @param valChange -> Valores del Map
     * @return Valor de la unidad
     */
    public String converterOther (String union, String valor, String valSymbol, Map<String, Double> valChange) {
        double rpta = 0;
        DecimalFormat df = new DecimalFormat("###.####");

        if(valChange.containsKey(union)) {
            rpta = Double.parseDouble(valor) * valChange.get(union);
        } else {
            rpta = Double.parseDouble(valor);
        }

        return String.valueOf(df.format(rpta)) + " " + valSymbol;
    }

    /**
     * Metodo para hacer el cambio de componentes que tendra JFrame.
     * @param frame -> JFrame donde almacenara el panel.
     * @param panel -> JPanel donde estaran todos los componentes.
     * @param opt   -> Opción de cambion de componentes del JFrame
     */
    public void changeButtom(JFrame frame, JPanel panel, int opt) {
        frame.remove(panel);
        switch (opt) {
            case 0:
                new DivisasGUI(frame);
                break;
            case 1:
                new TemperaturaGUI(frame);
                break;
            case 2:
                new PesoGUI(frame);
                break;
            case 3:
                new LongitudGUI(frame);
                break;
        }
    }
}
