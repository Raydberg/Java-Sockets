package com.client.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConsole {
    private Logger log = LoggerFactory.getLogger(ClientConsole.class);
    private int puerto;
    private boolean isStart;
    private ServerSocket serverSocket;


    public ClientConsole(int puerto) throws IOException {
        this.puerto = puerto;
        this.serverSocket = new ServerSocket(this.puerto);
        log.info("El servidor ha sido inicado en el puerto {}", this.puerto);
    }

    public void startServer() {
        this.isStart = true;

        while (this.isStart) {
            try {
                Socket conexion = this.serverSocket.accept();
                String hostClient = conexion.getInetAddress().getHostName();
                log.info("Conexion desde : {}", hostClient);
                InputStream inputStream = conexion.getInputStream();

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String message = bufferedReader.readLine();

                log.info("");


            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
