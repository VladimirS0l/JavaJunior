package org.example.lesson5;

import org.example.lesson5.threads.AdminWriteThread;
import org.example.lesson5.threads.ClientReadThread;

import java.io.IOException;
import java.net.Socket;

public class Admin {
    private static ClientReadThread clientReadThread;
    private static AdminWriteThread adminWriteThread;
    public static void main(String[] args) throws IOException {
        final Socket admin = new Socket("localhost", Server.PORT);
        // чтение
        clientReadThread = new ClientReadThread(admin);
        clientReadThread.start();

        // запись
        adminWriteThread = new AdminWriteThread(admin);
        adminWriteThread.start();
    }
}
