package edu.escuelaing.arep.returns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Response {

    public static void response(Socket clienteSocket,String entrada) {
        String url;
        if (entrada.contains("GET")) {
            url = entrada.split(" ")[1].substring(1);
            try {
                if(url.contains("/clima")){
                    Clima.getInstance(clienteSocket);
                }
                else if(url.contains("7consulta")){

                }
                else{

                }
            } catch (IOException e) {
                
            }
        }
    }

    public static void getentry(Socket clienteSocket) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clienteSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response(clienteSocket, inputLine);
            if (!in.ready()) {
                break;
            }
        }
    }

}
