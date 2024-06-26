package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean flag = false;
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        stringHandler(string, output, server);
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Возникло исключение в работе сервера", e);
        }
    }

    private static void stringHandler(String string, OutputStream output, ServerSocket server) throws IOException {
        if (string.contains("Hello")) {
            output.write("Hello".getBytes());
            return;
        }
        if (string.contains("Exit")) {
            output.write("Выключаю сервер.".getBytes());
            output.flush();
            server.close();
            return;
        }
        if (string.contains("=")) {
            String msg = string.split("=", 2)[1];
            output.write(msg.getBytes());
        } else {
            System.out.println(string);
        }
    }
}
