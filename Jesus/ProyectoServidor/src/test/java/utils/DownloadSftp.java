package utils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class DownloadSftp {
    private String host;
    private int port;
    private String user;
    private String pass;

    public DownloadSftp(String host, int port, String user, String pass) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public void download(String directorioRemoto, String archivoRemoto, String rutaArchivoLocal) {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channel = null;

        try {
            session = jsch.getSession(user, host, port);
            session.setPassword(pass);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect();

            if (channel.isConnected()) {
                System.out.println("Conexión establecida.");
            }

            OutputStream out = new FileOutputStream(rutaArchivoLocal);
            String src = directorioRemoto + archivoRemoto;
            channel.get(src, out);

            out.close();
            channel.disconnect();
            session.disconnect();
            System.out.println("Archivo descargado con exito");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
}
