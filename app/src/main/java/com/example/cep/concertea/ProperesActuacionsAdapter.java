package com.example.cep.concertea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProperesActuacionsAdapter extends ArrayAdapter<Actuacio>
{
	private ArrayList<Actuacio> llistaActuacions;

	public ProperesActuacionsAdapter(Context context, ArrayList<Actuacio> arrayActuacions) {
		super(context, R.layout.actuacio, arrayActuacions);
		this.llistaActuacions = arrayActuacions;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View item = inflater.inflate(R.layout.actuacio, null);

		Actuacio actuacioVisualitzar = llistaActuacions.get(position);

		//A partir de l'objecte clicat que he recuperat, poso les dades d'aquest objecte al layout:
		TextView textViewLlocActuacio = item.findViewById(R.id.llocActuacio);
		TextView textViewDataHora = item.findViewById(R.id.dataHoraActuacio);
		TextView textViewSala = item.findViewById(R.id.salaActuacio);

		textViewLlocActuacio.setText(actuacioVisualitzar.getLloc());
		textViewDataHora.setText(actuacioVisualitzar.getDataHora());
		textViewSala.setText(actuacioVisualitzar.getSala());

		return item;
	}
}


