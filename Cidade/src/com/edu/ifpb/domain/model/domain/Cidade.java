package com.edu.ifpb.domain.model.domain;

import com.vividsolutions.jts.geom.Geometry;

//import com.vividsolutions.jts.geom.Geometry;

public class Cidade {
	private String nome;
	private Integer populacao;
	private Float area;
	private Geometry geom;
	private String svg;
	private Integer estado_id;
	
	public Cidade() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}

	public Float getDensidade_demo() {
		return ((float)populacao)/area;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Geometry getGeom() {
		return geom;
	}

	public void setGeom(Geometry geom) {
		this.geom = geom;
	}

	public Float getPerimetro() {
		return (float) (geom.getLength() * (40075/360));
	}

	public String getSvg() {
		return svg;
	}

	public void setSvg(String svg) {
		this.svg = svg;
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}

	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}
	

	
}
