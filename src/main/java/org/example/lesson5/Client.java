package org.example.lesson5;

import org.example.lesson5.threads.ClientReadThread;
import org.example.lesson5.threads.ClientWriteThread;

import java.io.IOException;
import java.net.Socket;

public class Client {
  private static ClientWriteThread clientWriteThread;
  private static ClientReadThread clientReadThread;

  public static void main(String[] args) throws IOException {
    final Socket client = new Socket("localhost", Server.PORT);
    // чтение
    clientReadThread = new ClientReadThread(client);
    clientReadThread.start();

    // запись
    clientWriteThread = new ClientWriteThread(client);
    clientWriteThread.start();
  }
}


