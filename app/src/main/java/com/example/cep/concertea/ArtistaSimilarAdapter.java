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

public class ArtistaSimilarAdapter extends ArrayAdapter<Artista>
{
	//Els comentaris d'aquest adapter estan a la classe ArtistaAdapter.java
	private ArrayList<Artista> llistaArtistesSimilars;

	public ArtistaSimilarAdapter(Context context, ArrayList<Artista> llista) {
		super(context, R.layout.artista_similar, llista);
		this.llistaArtistesSimilars = llista;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View item = inflater.inflate(R.layout.artista_similar, null);

		Artista artistaVisualitzar = llistaArtistesSimilars.get(position);

		ImageView imatge = item.findViewById(R.id.imatgeArtistaSimilar);
		imatge.setImageResource(artistaVisualitzar.getImatge());

		TextView nomGrup = item.findViewById(R.id.nomArtistaSimilar);
		nomGrup.setText(artistaVisualitzar.getNom());

		return item;
	}
}
