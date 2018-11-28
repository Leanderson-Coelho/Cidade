package com.edu.ifpb.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.ifpb.domain.model.dao.CidadeDAOImpl;
import com.edu.ifpb.domain.model.domain.Cidade;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cidadeNome = request.getParameter("cidade");
		CidadeDAOImpl daoCidade = new CidadeDAOImpl();
		Cidade cidade = null;
		try {
			 cidade = daoCidade.buscar(cidadeNome);
			 System.out.println(cidade);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cidade", cidade);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
