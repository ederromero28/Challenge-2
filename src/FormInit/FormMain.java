package FormInit;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

public class FormMain extends FormFunction {
    private final ImageIcon icoAlura = new ImageIcon("./Resources/alura.jpg");
    private final ImageIcon icoOracle = new ImageIcon("./Resources/oracle.jpg");
    private final ImageIcon icoDivisa = new ImageIcon("./Resources/divisas.png");
    private final ImageIcon icoTemperatura = new ImageIcon("./Resources/temperatura.png");
    private final ImageIcon icoPeso = new ImageIcon("./Resources/peso.png");
    private final ImageIcon icoLongitud = new ImageIcon("./Resources/longitud.png");
    private final Color backBlue = new Color(5, 25, 51);
    private final Color backCele = new Color(41, 122, 227);
    private final int widthX = 800;
    private final int heightY = 600;

    /**
     * Constructor para la creación del formulario del Conversor.
     * @param frame         -> JFrame ventana donde se almcena el panel.
     * @param panel         -> JPanel donde estará almacenado los componentes del formulario.
     * @param unidades      -> unidades a convertir.
     * @param tipo          -> tipo de las 4 opciones a convertir.
     * @param symbol        -> simbolo de los unidades.
     * @param changeValue   -> Cambio de valor de las unidades.
     */
    public FormMain(JFrame frame, JPanel panel, String[] unidades, int tipo, Map symbol, Map changeValue){
        frame.setTitle("Conversor Alura");
        headerForm(panel);

        JButton btnDivisa = new JButton();
        styleBtnConversor(btnDivisa, icoDivisa, backCele, 0, 140, 200, 100, panel, 0);
        JButton btnTemperatura = new JButton();
        styleBtnConversor(btnTemperatura, icoTemperatura, backCele, 200, 140, 200, 100, panel, 0);
        JButton btnPeso = new JButton();
        styleBtnConversor(btnPeso, icoPeso, backCele, 400, 140, 200, 100, panel, 0);
        JButton btnLongitud = new JButton();
        styleBtnConversor(btnLongitud, icoLongitud, backCele, 600, 140, 200, 100, panel, 0);

        JComboBox<String> comboEntrada = new JComboBox<>(unidades);
        JComboBox<String> comboSalida = new JComboBox<>(unidades);
        JTextField textConverter = new JTextField();

        createCmbTxt(panel, comboEntrada, comboSalida, textConverter, 150, 30);

        JButton btnConvertir = new JButton("Convertir");
        styleBtnConversor(btnConvertir, new ImageIcon(), backBlue, 300, 370, 200, 50, panel, 1);

        JLabel result = new JLabel();
        styleResult(panel, result, 200, 450, 400, 80);

        btnConvertir.addActionListener(e -> sendData(result, textConverter, comboEntrada, comboSalida, tipo, symbol, changeValue));

        btnDivisa.addActionListener(e -> changeButtom(frame, panel, 0));
        btnTemperatura.addActionListener(e -> changeButtom(frame, panel, 1));
        btnPeso.addActionListener(e -> changeButtom(frame, panel, 2));
        btnLongitud.addActionListener(e -> changeButtom(frame, panel, 3));

        footerForm(panel);
        configFinal(frame, panel, widthX, heightY);
    }

    /**
     * Metodo para crear el header del formulario donde estara logos y Título
     * @param panel
     */
    private void headerForm(JPanel panel){
        JLabel logoAlura = new JLabel();
        styleLogo(logoAlura, icoAlura, 70, 10, 125, 85, panel);

        JLabel logoOracle = new JLabel();
        styleLogo(logoOracle, icoOracle, 470, 35, 260, 35, panel);

        JLabel backHeader = new JLabel();
        backOrTitle(backHeader, 0, backBlue, 0, 0, widthX, 105, panel);

        JLabel titleGeneral = new JLabel("Conversor de:", SwingConstants.CENTER);
        backOrTitle(titleGeneral, 1, backBlue, 0, 105, widthX, 35, panel);
    }

    /**
     * Metodo para crear el footer del formulario donde estara logos y Título
     * @param panel
     */
    private void footerForm(JPanel panel){
        JLabel textFooter = new JLabel("Realizado por: Eder R.M.", SwingConstants.CENTER);
        backOrTitle(textFooter, 0, backBlue, 0, 570, widthX, 30, panel);
    }

    /**
     * metodo para darle estilo al logo del formulario
     * @param logo  -> JLabel, espacio reservado para almacenar el icono del logo
     * @param icono -> Imagen.
     * @param x     -> Posicionamiento en el eje X
     * @param y     -> Posicionamiento en el eje Y
     * @param width -> Ancho del espacio para el logo
     * @param height-> Alto del espacio para el logo
     * @param panel -> Panel donde de almacena todos los componentes
     */
    public void styleLogo(JLabel logo, ImageIcon icono, int x, int y, int width, int height, JPanel panel){
        logo.setIcon(icono);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(SwingConstants.CENTER);
        panel.add(logo);
        logo.setBounds(x, y, width, height);
    }

    /**
     * Método para darle estilo fondo con o sin texto.
     * @param texto -> JLabel espacio para el texto.
     * @param tipo  -> Valores 0 y 1, para verificar si es con texto o no
     * @param color -> Color de fondo
     * @param x     -> Posicionamiento en el eje X
     * @param y     -> Posicionamiento en el eje Y
     * @param width -> Ancho del espacio del componente
     * @param height-> Alto del espacio del componente
     * @param panel -> Panel donde de almacena todos los componentes
     */
    public void backOrTitle(JLabel texto, int tipo, Color color, int x, int y, int width, int height, JPanel panel) {
        texto.setOpaque(true);
        if (tipo == 1) {
            texto.setForeground(Color.WHITE);
            texto.setBackground(color);
            texto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        } else {
            texto.setBackground(Color.WHITE);
        }

        panel.add(texto);
        texto.setBounds(x, y, width, height);
    }

    /**
     * Método para darle estilo a los botones del formulario
     * @param boton -> JButton para darle el estilo
     * @param icono -> Imagen para los botones
     * @param color -> Color del boton
     * @param x     -> Posicionamiento en el eje X
     * @param y     -> Posicionamiento en el eje Y
     * @param width -> Ancho del espacio del componente
     * @param height-> Alto del espacio del componente
     * @param panel -> Panel donde de almacena todos los componentes
     * @param tipo  -> Tipo de boton del formulario
     */
    public void styleBtnConversor(JButton boton, ImageIcon icono, Color color, int x, int y, int width, int height, JPanel panel, int tipo){
        boton.setFocusable(false);

        if (tipo == 0) {
            Border line = new LineBorder(Color.BLACK);
            Border margin = new EmptyBorder(5, 15, 5, 15);
            Border compound = new CompoundBorder(line, margin);

            boton.setIcon(icono);
            boton.setBackground(color);
            boton.setBorder(compound);
        } else {
            boton.setForeground(Color.WHITE);
            boton.setBackground(color);
        }

        panel.add(boton);
        boton.setBounds(x, y, width, height);
    }

    /**
     * Método para crear los Combos y el input del formulario.
     * @param panel         -> Panel donde de almacena todos los componentes.
     * @param comboEntrada  -> Primer combo para almacenar datos.
     * @param comboSalida   -> Segundo combo para almacenar datos.
     * @param textConverter -> input para escrbir el valor a convertir.
     * @param width         -> Ancho del espacio del componente
     * @param height        -> Alto del espacio del componente
     */
    public void createCmbTxt(JPanel panel, JComboBox comboEntrada, JComboBox comboSalida, JTextField textConverter, int width, int height) {
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);

        comboSalida.setSelectedIndex(1);
        NumbersOnly(textConverter);
        panel.add(comboEntrada);
        panel.add(comboSalida);
        panel.add(textConverter);
        comboEntrada.setBounds(150, 270, width, height);
        comboSalida.setBounds(500, 270, width, height);
        textConverter.setBorder(compound);
        textConverter.setBounds(300, 320, 200, height + 5);
    }

    /**
     * Metodo para darle estilo al cuadro del resultado para el valor convertido.
     * @param panel -> Panel donde de almacena todos los componentes.
     * @param text  -> JLabel para almacenar el valor.
     * @param x     -> Posicionamiento en el eje X
     * @param y     -> Posicionamiento en el eje Y
     * @param width -> Ancho del espacio del componente
     * @param height-> Alto del espacio del componente
     */
    public void styleResult(JPanel panel, JLabel text, int x, int y, int width, int height){
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        text.setOpaque(true);
        text.setBorder(compound);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBackground(Color.WHITE);
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

        panel.add(text);
        text.setBounds(x, y, width, height);
    }

    /**
     * Metodo para configurar la parte final del JFrame.
     * @param frame -> JFrame donde se almacenara el Panel
     * @param panel -> JPanel donde estaran todos los componentes
     * @param width -> Ancho del JFrame
     * @param height-. Alto del JFrame
     */
    public void configFinal(JFrame frame, JPanel panel, int width, int height) {
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(width, height));

        frame.add(panel);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
