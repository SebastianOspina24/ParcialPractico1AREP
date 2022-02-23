package edu.escuelaing.arep.returns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class Response {

    public static void response(Socket clienteSocket, String entrada) {
        String url;
        if (entrada.contains("GET")) {
            url = entrada.split(" ")[1].substring(1);
            //System.out.println(url);
            try {
                if (url.contains("clima")) {
                    printing(clienteSocket,Clima.getInstance());
                } else if (url.contains("consulta?lugar=")) {
                    consulta(clienteSocket,url);
                } else {

                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

private static void printing(Socket clienteSocket,String s) throws IOException{
    System.out.println("Se envia respuesta");
    PrintWriter out = new PrintWriter(
        clienteSocket.getOutputStream(), true);
        s = "HTTP/1.1 200 OK\r\n Content-Type: text/html \r\n\r\n"+s;
    out.println(s);
    out.close(); 
}

private static void consulta(Socket clienteSocket,String url) throws IOException{
    String ciudad = url.split("=")[1];
    String apiconection = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad
            + "&appid=d60de446da476e3e141cd457145c6f19";
    URL obj = new URL(apiconection);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    con.getResponseCode();
    PrintWriter out = new PrintWriter(
        clienteSocket.getOutputStream(), true);
    out.print("HTTP/1.1 200 OK\r\n Content-Type: text/json \r\n\r\n");
    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }
                br.close();
    out.print(sb);
    out.close();
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
        in.close();
        clienteSocket.close();
    }

}
