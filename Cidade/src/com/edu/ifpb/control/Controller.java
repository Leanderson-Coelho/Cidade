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

@WebServlet("/controller")
public class Controller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cidadeNome = request.getParameter("cidade");
		CidadeDAOImpl daoCidade = new CidadeDAOImpl();
		Cidade cidade = null;
		try {
			 cidade = daoCidade.buscar(cidadeNome);
			 System.out.println(cidade);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cidade", cidade);
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
