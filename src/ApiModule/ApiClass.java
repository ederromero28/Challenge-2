package ApiModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiClass {

    /**
     * Esta función hace una peticion a la API, utiliza una key pública y 2 parámetros que sirven para la conversión.
     * Utiliza la función ResponseCodeAndGetRate para extraer del JSON el valor a convertir.
     * @param key           -> Llave pública de acceso.
     * @param firstDivisa   -> Primera Divisa.
     * @param secondDivisa  -> Segunda Divisa.
     * @return Valor de conversión.
     */
    public static double Requestapi(String key, String firstDivisa, String secondDivisa) {
        String Request = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", key, firstDivisa, secondDivisa);
        try {
            URL URL_API = new URL(Request);
            HttpURLConnection connection = (HttpURLConnection) URL_API.openConnection();
            connection.setRequestMethod("GET");

            int RESPONSE_CODE = connection.getResponseCode();

            double rate = ResponseCodeAndGetRate(RESPONSE_CODE, connection);
            return rate;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Este método recibe un parámetro para obtener el JSON de la API y devolver el valor requerido
     * @param code      -> Codigo generado por la API.
     * @param connection-> Objeto HttpURLConnection.
     * @return -> Valor de conversión.
     * @throws IOException
     */
    public static double ResponseCodeAndGetRate(int code, HttpURLConnection connection) throws IOException {
        if(code == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            JSONObject JSON_RESPONSE = new JSONObject(response.toString());

            double CONVERSION_RATE = JSON_RESPONSE.getDouble("conversion_rate");
            return CONVERSION_RATE;
        }else {
            System.out.println("A ocurrido un error");
            return -1;
        }
    }
}
