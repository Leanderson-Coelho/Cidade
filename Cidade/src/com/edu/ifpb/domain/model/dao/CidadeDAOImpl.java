package com.edu.ifpb.domain.model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ifpb.domain.model.domain.Cidade;
import com.edu.ifpb.domain.model.jdbc.ConnectionFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class CidadeDAOImpl implements CidadeDAO {
	public ConnectionFactory factory;
	public WKTReader reader;

	public CidadeDAOImpl() {
		factory = new ConnectionFactory();
		reader = new WKTReader();
	}

	@Override
	public List<String> buscarNomeEstados() throws ClassNotFoundException, SQLException {
		List<String> estados = new ArrayList<>();
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement(
					"select nome from estados order by nome");
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
	public Cidade buscarCidadeEstado(String nomeCidade, String nomeEstado) throws ClassNotFoundException, SQLException, ParseException {
		try (Connection connection = factory.getConnection()) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT c.nome, c.populacao_2010, c.area, ST_AsText(ST_AsEWKT(c.geom)),ST_AsSVG(geom) FROM cidade c, estados e WHERE c.nome ilike ? and e.nome ilike ?");
			statement.setString(1, nomeCidade);
			statement.setString(2, nomeEstado);
			ResultSet resultado = statement.executeQuery();
			Cidade cidade = new Cidade();
			if(resultado.next()) {
				cidade.setNome(resultado.getString(1));
				cidade.setPopulacao(resultado.getInt(2));
				cidade.setArea(resultado.getFloat(3));
//				TRANSFORMA O TEXTO EM UMA GEOMETRIA COM A CLASSE WKTReader
				cidade.setGeom(reader.read(resultado.getString(4)));
				cidade.setSvg(resultado.getString(5));
				return cidade;
			}
		}
		return null;
	}

	@Override
	public List<String> buscarNomeCidadesEstado(String estado) throws ClassNotFoundException, SQLException {
		List<String> cidades = new ArrayList<>();
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement(
					"select c.nome " + 
					"from cidade c, estados e " + 
					"where c.estado_id = e.id and e.nome ilike ? "+
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

	@Override
	public String getViewBox(String cidade1, String cidade2) throws ClassNotFoundException, SQLException {
		try(Connection connection = factory.getConnection()){
			PreparedStatement statement = connection.prepareStatement("select getviewbox(?,?)");
			statement.setString(1, cidade1);
			statement.setString(2, cidade2);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				return resultado.getString(1);
			}
		}
		return null;
	}
	


}
