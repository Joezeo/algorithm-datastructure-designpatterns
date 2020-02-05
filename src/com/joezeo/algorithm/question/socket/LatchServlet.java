package com.joezeo.algorithm.question.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LatchServlet extends Thread {

    private Socket socket;

    public LatchServlet(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();
            OutputStream clientOut = socket.getOutputStream();
            byte[] buf = new byte[1024];
            int len = inputStream.read(buf);
            String data = new String(buf, 0, len);
            System.out.println(data);
            clientOut.write(String.valueOf(data.length()).getBytes());

            clientOut.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
