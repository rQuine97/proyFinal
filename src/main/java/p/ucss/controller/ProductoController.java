/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.ucss.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import p.ucss.dao.PostDao;
import p.ucss.daomlp.PostDaoImpl;
import p.ucss.entity.Post;

/**
 *
 * @author DESEHADAS 3
 */
public class ProductoController extends HttpServlet {
    private PostDao dao = new PostDaoImpl();
    private Gson gson = new Gson();
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
           PrintWriter out = response.getWriter();

        int opc = Integer.parseInt(request.getParameter("opc"));
        switch (opc) {
            case 1:
                out.println(gson.toJson(dao.readAll()));
                break;
            case 2:
                dao.create(new Post(0, request.getParameter("producto"), request.getParameter("marca"), Integer.parseInt(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock"))));
                break;
            case 3:
                dao.delete(Integer.parseInt(request.getParameter("idproducto")));
                break;
            case 4:
                out.println(gson.toJson(dao.read(Integer.parseInt(request.getParameter("idproducto")))));
                break;
            case 5:
                dao.update(new Post(Integer.parseInt(request.getParameter("idproducto")), request.getParameter("producto"), request.getParameter("marca"), Integer.parseInt(request.getParameter("precio")), Integer.parseInt(request.getParameter("stock"))));
                break;
        }
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
