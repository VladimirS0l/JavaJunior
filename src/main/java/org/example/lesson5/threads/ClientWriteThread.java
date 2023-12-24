package org.example.lesson5.threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class ClientWriteThread extends Thread{
    private final Socket client;

    public ClientWriteThread(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(client.getOutputStream(), true)) {
            Scanner consoleScanner = new Scanner(System.in);
            while (true) {
                String consoleInput = consoleScanner.nextLine();
                output.println(consoleInput);
                if (Objects.equals("q", consoleInput)) {
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
