package org.example.lesson5.threads;

import org.example.lesson5.SocketWrapper;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ServerThread extends Thread{
    private final SocketWrapper wrapper;
    private final Map<Long, SocketWrapper> clients;
    private final long clientId;

    public ServerThread(SocketWrapper wrapper, Map<Long, SocketWrapper> clients, long clientId) {
        this.wrapper = wrapper;
        this.clients = clients;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try (Scanner input = wrapper.getInput(); PrintWriter output = wrapper.getOutput()) {
            output.println("Подключение успешно. Список всех клиентов: " + clients);

            while (true) {
                String clientInput = input.nextLine();
                if (Objects.equals("q", clientInput)) {
                    // todo разослать это сообщение всем остальным клиентам
                    clients.remove(clientId);
                    clients.values().forEach(it -> it.getOutput().println("Клиент[" + clientId + "] отключился"));
                    break;
                }

                if (clientInput.matches("@\\d+ \\w.*")) {
                    long destinationId = Long.parseLong(clientInput.substring(1, 2));
                    SocketWrapper destination = clients.get(destinationId);
                    destination.getOutput().println(clientInput);
                }

                if (clientInput.matches("\\w.*")) {
                    clients.values().forEach(it -> it.getOutput().println(clientInput));
                }

                if (clientInput.matches("Пользователь админ подключился")) {
                    clients.values().forEach(it -> it.getOutput().println(clientInput));
                }

                if (clientInput.matches("kick \\d+")) {
                    String[] clientDelete = clientInput.split(" ");
                    long clientIdDelete = Long.parseLong(clientDelete[1]);
                    clients.remove(clientIdDelete);
                    clients.values().forEach(it -> it.getOutput().println("Админ отключил [" + clientIdDelete + "]"));
                    break;
                }
            }
        }
    }
}
