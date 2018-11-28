package com.edu.ifpb.domain.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;

public interface CidadeDAO {
	public Cidade buscar(String nome) throws ClassNotFoundException, SQLException;
	public List<Cidade> listar();
}
