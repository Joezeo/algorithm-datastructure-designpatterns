package com.joezeo.algorithm.question.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    private static ServerSocket socket;

    static {
        try {
            socket = new ServerSocket(9512);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while (true){
            try {
                Socket client = socket.accept();

                new LatchServlet(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
