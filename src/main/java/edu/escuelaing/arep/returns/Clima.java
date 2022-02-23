package edu.escuelaing.arep.returns;

import java.io.IOException;

public class Clima {
    public static String getInstance() throws IOException {

        String outputLine = "<!DOCTYPE html>" +
                getCoder() +
                "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>API Clima ECI</title>\n" +
                "</head>" +
                "<body>" +
                "<h1>En esta api se puede consultar el clima de diferentes ciudades con solo usar su nombre</h1>" +
                "<section id=\"Test\" class=\"test-section\">" +
                "<div class=\"section-header\">" +
                "<h2>Testing</h2>" +
                "</div>" +
                "<div class=\"testing\">" +
                "<center>" +
                "<h2>Selecciona la unidad a convertir:</h2>" +
                "</select>" +
                "</center>" +
                "</div>" +
                "<div class=\"testing\">" +
                "<input class=\"box\" type=\"Text\" id=\"nombre\" placeholder=\"Nombre de la Ciudad \">" +
                "</div>" +
                "<div class=\"testing\">" +
                "<button  class=\"box\" onclick=\"consumirapi()\" class=\"btn\">Consultar</button>" +
                "</div>" +
                "<center>" +
                "<div class=\"testing\">" +
                "<h3>Nombre</h3>" +
                "<p id=\"city\"></p>" +
                "</div>" +
                "</center>" +
                "<center>" +
                "<div class=\"testing\">" +
                "<h3>Temperatura</h3>" +
                "<p id=\"tempe\"></p>" +
                "</div>" +
                "</center>" +
                "</section>" +
                "</body>" +
                "</html>";
        return outputLine;
    }

    public static String getCoder() {
        return "<script type=\"text/javascript\">let url = \"https://parcialarepno1.herokuapp.com/consulta?lugar=\"\n" +
                "function consumirapi(){\n" +
                "fetch(url+document.getElementById(\"nombre\").value)\n" +
                "  .then(response => response.json())\n" +
                ".then(data => {\n" +
                "document.getElementById(\"city\").innerHTML = data.name\n" +
                "document.getElementById(\"tempe\").innerHTML = data.temp\n})\n}\n</script>\n";
    }
}
