package com.example.cep.concertea;

import java.io.Serializable;

public class Actuacio implements Serializable
{
	private String lloc;
	private String dataHora;
	private String sala;

	public Actuacio(String lloc, String dataHora, String sala) {
		this.lloc = lloc;
		this.dataHora = dataHora;
		this.sala = sala;
	}

	public String getLloc()
	{
		return lloc;
	}

	public String getDataHora()
	{
		return dataHora;
	}

	public String getSala()
	{
		return sala;
	}
}
