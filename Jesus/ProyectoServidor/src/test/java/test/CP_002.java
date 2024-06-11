package test;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import utils.DownloadSftp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CP_002 {
    public static void main(String[] args) {
        String archivoJson = "/var.json";
        InputStream inputStream = CP_002.class.getResourceAsStream(archivoJson);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
            StringBuilder jsonTexto = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null){
                jsonTexto.append(linea);
            }
            JSONObject json = new JSONObject(jsonTexto.toString());

            String host = json.getString("host");
            int port = json.getInt("port");
            String user = json.getString("user");
            String pass = json.getString("pass");
            String directoryRemote = json.getString("directoryRemote");
            String fileRemote = json.getString("fileRemote");
            String directoryLocal = json.getString("directoryLocal");

            DownloadSftp downloadSftp = new DownloadSftp(host, port, user, pass);
            downloadSftp.download(directoryRemote,fileRemote,directoryLocal);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
