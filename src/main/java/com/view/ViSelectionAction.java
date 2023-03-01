package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.dataaccess.ViDao;
import com.dataaccess.ViDaoImpl;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViSelectionAction
 */
@WebServlet(name="ViSelectionAction", urlPatterns="/SelectVi.do")
public class ViSelectionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViSelectionAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Requerimos parámetro de color
		String color = request.getParameter("color");
		
		// Instanciamos viDao como DAO y se cargan los vinos en el arraylist
		ViDao viDao = new ViDaoImpl();
		

		// Creamos una lista llamada marquesVi que será la que mostraremos 
		// Invocamos get del DAO de los vinos por su tipo/color pasándole el color
		// este nos devuelve la lista
	
		List<String> marquesVi = viDao.getVinsByTipus(color);
		
		// Part de resposta i Printwriter
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println ("<HTML>");			
		out.println ("<BODY>");		
		out.println ("<H1>Marques de Vi suggerides</H1>");
		out.println ("<H2>Tipus: " + color + "</H2>");
		out.println (marquesVi);
		out.println ("</BODY>");
		out.println ("</HTML>");
	}

}
