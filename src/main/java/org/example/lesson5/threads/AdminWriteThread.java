package org.example.lesson5.threads;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class AdminWriteThread extends Thread{
    private final Socket admin;

    public AdminWriteThread(Socket admin) {
        this.admin = admin;
    }

    @Override
    public void run() {
        try (PrintWriter output = new PrintWriter(admin.getOutputStream(), true)) {
            output.println("Admin connect");
            Scanner consoleScanner = new Scanner(System.in);
            while (true) {
                String consoleInput = consoleScanner.nextLine();
                output.println(consoleInput);
                if (Objects.equals("q", consoleInput)) {
                    admin.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
