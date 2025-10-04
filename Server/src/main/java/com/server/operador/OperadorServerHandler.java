package com.server.operador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OperadorServerHandler {

    private static final Logger log = LoggerFactory.getLogger(OperadorServerHandler.class);

    public static void start(int puerto) throws Exception {
        ServerSocket listener = new ServerSocket(puerto);
        log.info("Servidor ejecutandose");

        while (true) {
            Socket client = listener.accept();
            log.info("Cliente conectado, IP{}", client.getInetAddress().toString());
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            DataInputStream dataInput = new DataInputStream(input);

            double num1 = dataInput.readDouble();
            double num2 = dataInput.readDouble();
            char op = dataInput.readChar();
            if (op == 'x')
                break;

            double result = OperadorServer.processOperation(num1, num2, op);
            log.info("Mensaje recibido {} {} {}", num1, op, num2);

            DataOutputStream dataOutput = new DataOutputStream(output);

            dataOutput.writeDouble(result);
            client.close();
        }
        listener.close();
    }

}
