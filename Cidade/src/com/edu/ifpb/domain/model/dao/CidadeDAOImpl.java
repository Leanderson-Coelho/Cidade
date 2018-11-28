package com.edu.ifpb.domain.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;
import com.edu.ifpb.domain.model.jdbc.ConnectionFactory;

public class CidadeDAOImpl implements CidadeDAO {
	private ConnectionFactory factory;

	public CidadeDAOImpl() {
		factory = new ConnectionFactory();
	}

	@Override
	public List<String> buscarNomeEstados() throws ClassNotFoundException, SQLException {
		List<String> estados = new ArrayList<>();
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement(
					"select nome from estados");
			ResultSet resultado = statement.executeQuery();
			if(resultado!= null) {
				while(resultado.next()) {
					estados.add(resultado.getString(1));
				}
				return estados;
			}
		}
		
		return null;
	}

	@Override
	public Cidade buscarCidadeEstado(String cidade, String estado) throws ClassNotFoundException, SQLException {
//		try (Connection connection = factory.getConnection()) {
//			PreparedStatement statement = connection
//					.prepareStatement("SELECT nome,populacao_2010,densidade_demo,area FROM cidades WHERE nome ilike ?");
//			statement.setString(1, nomeCidade);
//			ResultSet resultado = statement.executeQuery();
//			if (resultado.next()) {
//				Cidade cidade = new Cidade();
//				cidade.setNome(resultado.getString(1));
//				cidade.setPopulacao(resultado.getInt(2));
//				cidade.setDensidade_demo(resultado.getFloat(3));
//				cidade.setArea(resultado.getFloat(4));
//				return cidade;
//			}
//		}
		return null;
	}

	@Override
	public List<String> buscarNomeCidadesEstado(String estado) throws ClassNotFoundException, SQLException {
		List<String> cidades = new ArrayList<>();
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement(
					"select c.nome\n" + 
					"from cidade c, estados e \n" + 
					"where c.estado_id = e.id and e.nome ilike ?\n"+
					"order by c.nome");
			statement.setString(1, estado);
			ResultSet resultado = statement.executeQuery();
			if(resultado!= null) {
				while(resultado.next()) {
					cidades.add(resultado.getString(1));
				}
				return cidades;
			}
		}
		return null;
	}

}
