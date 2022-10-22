
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "contadorServlet", urlPatterns = {"/contadorServlet"})
public class contadorServlet extends HttpServlet {

   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        //obtener el arreglo de cookies del cliente 
        Cookie[] cukis = request.getCookies();
        
        if(cukis != null){
            for(Cookie c : cukis){
                if(c.getName().equals("visitas")){
                    // antes de la asignacion  se convierte un valor en cadena
                    contador = Integer.parseInt( c.getValue());
                }    
            }
        }
        
        contador++;
        //convertir de un entero a una cadena 
        Cookie c = new Cookie("visitas",Integer.toString(contador));
        
        c.setMaxAge(120);
        //lamvenado al arreglo 
        response.addCookie(c);
        //generar contenido a partir del serlet
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        if(contador == 1){
        out.println("Bienvenido a nuestro sitio web  " + contador);
        }
        if(contador > 1){
        out.println("gracias por visitarnos nuevamente  " + contador);
        }
        
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
}
