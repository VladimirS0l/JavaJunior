package org.example.lesson5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketWrapper implements AutoCloseable {

    private final long id;
    private final String name;
    private final Socket socket;
    private final Scanner input;
    private final PrintWriter output;

    SocketWrapper(long id, Socket socket) throws IOException {
        this.id = id;
        this.name = String.valueOf(id);
        this.socket = socket;
        this.input = new Scanner(socket.getInputStream());
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    public long getId() {
        return id;
    }

    public Socket getSocket() {
        return socket;
    }

    public Scanner getInput() {
        return input;
    }

    public PrintWriter getOutput() {
        return output;
    }

    public String getName() {
        return name;
    }


    @Override
    public void close() throws Exception {
        socket.close();
    }

    @Override
    public String toString() {
        return String.format("%s", socket.getInetAddress().toString());
    }
}
