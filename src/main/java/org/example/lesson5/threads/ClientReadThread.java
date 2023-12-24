package org.example.lesson5.threads;

import java.net.Socket;
import java.util.Scanner;

public class ClientReadThread extends Thread{
    private final Socket client;

    public ClientReadThread(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try (Scanner input = new Scanner(client.getInputStream())) {
            while (true) {
                System.out.println(input.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Клиент отключен");
        }
    }
}
