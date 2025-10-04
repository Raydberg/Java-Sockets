package com.server;

import com.server.operador.OperadorServer;
import com.server.operador.OperadorServerHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        OperadorServerHandler.start(OperadorServer.PUERTO);

    }
}

