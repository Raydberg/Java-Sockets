package com.client.operador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class OperadorClient {

    public static String IP_SERVIDOR = "192.168.18.111";
    public static int PUERTO = 1234;

    public static double operar(double num1, double num2, char op) throws Exception {
        Socket socket = new Socket(IP_SERVIDOR, PUERTO);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        //Envio de datos al servidor
        DataOutputStream dataOutput = new DataOutputStream(output);

        dataOutput.writeDouble(num1);
        dataOutput.writeDouble(num2);
        dataOutput.writeChar(op);
        //Leer la respuesta
        DataInputStream dataInput = new DataInputStream(input);

        double response = dataInput.readDouble();
        socket.close();

        return response;
    }
}
