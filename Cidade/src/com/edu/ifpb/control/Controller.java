package com.edu.ifpb.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.ifpb.domain.model.dao.CidadeDAOImpl;
import com.edu.ifpb.domain.model.domain.Cidade;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	public static String estadoAnterior1 = null;
	public static String estadoAnterior2 = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comando = request.getParameter("comando");
		try {
			Command command = (Command) Class.forName("com.edu.ifpb.control."+comando).newInstance();
			command.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CidadeDAOImpl dao = new CidadeDAOImpl();
		String estadoAtual1 = request.getParameter("estado1");
		String estadoAtual2 = request.getParameter("estado2");
		String cidadeNome1 = request.getParameter("cidade1");
		String cidadeNome2 = request.getParameter("cidade2");
		request.setAttribute("estado1", estadoAtual1);
		request.setAttribute("estado2", estadoAtual2);
		request.setAttribute("cidadeNome1", cidadeNome1);
		request.setAttribute("cidadeNome2", cidadeNome2);
		Cidade cidade1 = null, cidade2 = null;
//--------------------------------------------------------------------------------------//		
		if(!estadoAtual1.equals("___NENHUM___") && estadoAnterior1 != estadoAtual1) {
			estadoAnterior1 = estadoAtual1;
			try {
				List<String> cidades1 = dao.buscarNomeCidadesEstado(estadoAtual1);
				request.setAttribute("nomeCidades1", cidades1);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(!estadoAtual2.equals("___NENHUM___") && estadoAnterior2 != estadoAtual2) {
			estadoAnterior2 = estadoAtual2;
			try {
				List<String> cidades2 = dao.buscarNomeCidadesEstado(estadoAtual2);
				request.setAttribute("nomeCidades2", cidades2);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(!cidadeNome1.equals("___NENHUM___")) {
			try {
				cidade1 = dao.buscarCidadeEstado(cidadeNome1, estadoAtual1);
				request.setAttribute("cidade1", cidade1);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("cidade1", null);
		}
		
		if(!cidadeNome2.equals("___NENHUM___")) {
			try {
				cidade2 = dao.buscarCidadeEstado(cidadeNome2, estadoAtual2);
				request.setAttribute("cidade2", cidade2);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("cidade2", null);
		}
		
		if(!estadoAtual2.equals("___NENHUM___") && !estadoAtual1.equals("___NENHUM___") && !cidadeNome1.equals("___NENHUM___") && !cidadeNome2.equals("___NENHUM___")) {
			Float dist = (float) (cidade1.getGeom().getCentroid().distance(cidade2.getGeom().getCentroid()) * (40075/360));
			request.setAttribute("distancia", dist);
		}
		else {
			request.setAttribute("distancia", null);
		}
//------------------------------------------------------------------------------------//		
		try {
			List<String> estados = dao.buscarNomeEstados();
			request.setAttribute("estados", estados);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//------------------------------------------------------------------------------------//		
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}

}
