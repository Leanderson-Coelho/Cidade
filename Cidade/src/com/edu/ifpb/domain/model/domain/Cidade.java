package com.edu.ifpb.domain.model.domain;

import com.vividsolutions.jts.geom.Geometry;

public class Cidade {
	private String nome;
	private String estado;
	private int populacao;
	private Float densidade_demo;
	private Float area;
//	private Geometry geom;
	
	public Cidade() {}
	
	public Cidade(String nome, String estado, int populacao, Float densidade_demo, Float area) {
		this.nome = nome;
		this.estado = estado;
		this.populacao = populacao;
		this.densidade_demo = densidade_demo;
		this.area = area;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public Float getDensidade_demo() {
		return densidade_demo;
	}

	public void setDensidade_demo(Float densidade_demo) {
		this.densidade_demo = densidade_demo;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + ", estado=" + estado + ", populacao=" + populacao + ", densidade_demo="
				+ densidade_demo + ", area=" + area + "]";
	}
	
	


}
