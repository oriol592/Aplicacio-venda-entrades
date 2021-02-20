package com.example.cep.concertea;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistaAdapter extends ArrayAdapter<Artista>
{
	private ArrayList<Artista> llistaArtistes;

	public ArtistaAdapter(Context context, ArrayList<Artista> llistaArtistes) {
		super(context, R.layout.artista, llistaArtistes);
		this.llistaArtistes = llistaArtistes;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		//Creo l'inflater i la view:
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View item = inflater.inflate(R.layout.artista, null);

		//Recupero l'element a la posició corresponent:
		Artista artistaVisualitzar = llistaArtistes.get(position);

		//Poso la imatge a cada element:
		ImageView imatge = item.findViewById(R.id.imatgeArtista);
		imatge.setImageResource(artistaVisualitzar.getImatge());

		//Poso el nom a cada element:
		TextView nomArtista = item.findViewById(R.id.nomArtista);
		nomArtista.setText(artistaVisualitzar.getNom());

		//Poso el lloc d'actuació:
		TextView llocActuacio = item.findViewById(R.id.llocActuacioArtista);
		llocActuacio.setText(artistaVisualitzar.getLlocOnActua());

		return item;
	}
}
