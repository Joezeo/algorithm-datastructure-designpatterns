package com.joezeo.algorithm.question.socket;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 9512);
            OutputStream outputStream = clientSocket.getOutputStream();
            InputStream inputStream = clientSocket.getInputStream();

            byte[] buf = new byte[1024];
            outputStream.write("Hello World".getBytes());

            int len = inputStream.read(buf);
            String data = new String(buf, 0, len);
            System.out.println(data);
            inputStream.close();
            outputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
