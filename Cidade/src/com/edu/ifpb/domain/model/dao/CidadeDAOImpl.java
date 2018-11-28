package com.edu.ifpb.domain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;
import com.edu.ifpb.domain.model.jdbc.ConnectionFactory;

public class CidadeDAOImpl implements CidadeDAO{
	private ConnectionFactory factory;
	
	public CidadeDAOImpl() {
		factory = new ConnectionFactory();
	}

	@Override
	public Cidade buscar(String nomeCidade) throws ClassNotFoundException, SQLException {
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement("SELECT nome,populacao_2010,densidade_demo,area FROM cidades WHERE nome ilike ?");
			statement.setString(1, nomeCidade);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				Cidade cidade = new Cidade();
				cidade.setNome(resultado.getString(1));
				cidade.setPopulacao(resultado.getInt(2));
				cidade.setDensidade_demo(resultado.getFloat(3));
				cidade.setArea(resultado.getFloat(4));
				return cidade;
			}
		}
		return null;
	}

	@Override
	public List<Cidade> listar() {
		return null;
	}

}
