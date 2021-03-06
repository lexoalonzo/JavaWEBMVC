/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ConsultasBodega;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.ConsultasProducto;

/**
 *
 * @author lexo
 */
@WebServlet(name = "nuevoProducto", urlPatterns = {"/nuevoProducto"})
public class nuevoProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String codigo = request.getParameter("codigo_producto");
        String nombre = request.getParameter("nombre_producto");
        String precio_venta= request.getParameter("precio_venta");
        String precio_compra = request.getParameter("precio_compra");
        String id_proveedor = request.getParameter("id_proveedor");
        String cantidad = request.getParameter("cantidad");
        String id_bodega = request.getParameter("id_bodega");
        if(!codigo.isEmpty() && !nombre.isEmpty() && !precio_venta.isEmpty() && !precio_compra.isEmpty() && !id_proveedor.isEmpty() && !cantidad.isEmpty() && !id_bodega.isEmpty()){
            
                ConsultasProducto Conn = new ConsultasProducto();
                Conn.nuevo(codigo, nombre, precio_venta, precio_compra, id_proveedor, cantidad,id_bodega);
                response.sendRedirect("listadoProductos.jsp");
            
        }
        else {
            response.sendRedirect("nuevoproducto.jsp?error=Llene todos los campos");
        }
        
        //------------------------------------------------------------
           /*ConsultasBodega Conn = new ConsultasBodega();
            ResultSet resultados = Conn.listado();
            request.setAttribute("resultados", resultados);
            request.getRequestDispatcher("nuevoproducto.jsp").forward(request, response);*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
