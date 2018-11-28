package com.edu.ifpb.domain.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;
import com.vividsolutions.jts.io.ParseException;

public interface CidadeDAO {
	Cidade buscarCidadeEstado(String cidade, String estado) throws ClassNotFoundException, SQLException, ParseException;
	List<String> buscarNomeCidadesEstado(String estado) throws ClassNotFoundException, SQLException;
	List<String> buscarNomeEstados() throws ClassNotFoundException, SQLException;
}
