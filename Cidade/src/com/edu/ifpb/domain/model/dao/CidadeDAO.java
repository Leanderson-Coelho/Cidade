package com.edu.ifpb.domain.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;

public interface CidadeDAO {
	Cidade buscarCidadeEstado(String cidade, String estado) throws ClassNotFoundException, SQLException;
	List<String> buscarNomeCidadesEstado(String estado) throws ClassNotFoundException, SQLException;
	List<String> buscarNomeEstados() throws ClassNotFoundException, SQLException;
}
