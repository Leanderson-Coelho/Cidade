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
import com.vividsolutions.jts.io.ParseException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("comando");
		try {
			Command command = (Command) Class.forName("com.edu.ifpb.control."+comando).newInstance();
			command.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
