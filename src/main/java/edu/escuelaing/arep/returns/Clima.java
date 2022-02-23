package edu.escuelaing.arep.returns;
import java.io.IOException;

public class Clima {
    public static String getInstance()throws IOException{

        String outputLine = 
          "<!DOCTYPE html>" + 
          getCoder()+
          "<html>" + 
          "<head>" + 
          "<meta charset=\"UTF-8\">" + 
          "<title>API Clima ECI</title>\n" + 
          "</head>" + 
          "<body>" + 
          "<h1>En esta api se puede consultar el clima de diferentes ciudades con solo usar su nombre</h1>" + 
          "</body>" + 
          "</html>"; 
        return outputLine;
    }

    public static String getCoder(){
        return "<script>let url = \"https://parcialarepno1.herokuapp.com/consulta?lugar=\""+
        "function consumirapi(){"+
        "fetch(url+document.getElementById(\"valor\").value"+
       "  .then(response => response.json())"+
          ".then(data => {"+
            "document.getElementById(\"city\").innerHTML = data.name"+
            "document.getElementById(\"tempe\").innerHTML = data.temp})}</script>";
    }
}
