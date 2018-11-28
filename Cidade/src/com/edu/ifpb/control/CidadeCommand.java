package com.edu.ifpb.control;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.edu.ifpb.domain.model.dao.CidadeDAOImpl;

public class CidadeCommand implements Command {

	public CidadeCommand() {
		CidadeDAOImpl daoCidade = new CidadeDAOImpl();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

}
