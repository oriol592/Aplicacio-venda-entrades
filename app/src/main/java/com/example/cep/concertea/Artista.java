package com.example.cep.concertea;

import java.io.Serializable;

public class Artista implements Serializable
{
	private String nom;
	private String llocOnActua;
	private int imatge;
	private String descripcio;

	public Artista(String nom, String lloc, int imatge, String descripcio) {
		this.nom = nom;
		this.llocOnActua = lloc;
		this.imatge = imatge;
		this.descripcio = descripcio;
	}

	public String getNom()
	{
		return nom;
	}

	public String getLlocOnActua()
	{
		return llocOnActua;
	}

	public int getImatge()
	{
		return imatge;
	}

	public String getDescripcio() { return descripcio; }
}
