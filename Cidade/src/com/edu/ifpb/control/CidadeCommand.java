package com.edu.ifpb.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.edu.ifpb.domain.model.dao.CidadeDAOImpl;

public class CidadeCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
		CidadeDAOImpl dao = new CidadeDAOImpl();
		try {
			List<String> estados = dao.buscarNomeEstados();
			request.setAttribute("estados", estados);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("View.jsp").forward(request, response);
		
	}

}
