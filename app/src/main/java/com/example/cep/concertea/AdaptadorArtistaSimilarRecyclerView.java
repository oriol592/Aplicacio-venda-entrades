package com.example.cep.concertea;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorArtistaSimilarRecyclerView extends RecyclerView.Adapter<AdaptadorArtistaSimilarRecyclerView.ImatgesViewHolder> implements View.OnClickListener
{
	private ArrayList<Artista> dadesArtistes;

	//Variable per fer el onClickListener:
	private View.OnClickListener listener;

	//El constructor, que rep un arrayList de Place:
	public AdaptadorArtistaSimilarRecyclerView(ArrayList<Artista> dades) {
		this.dadesArtistes = dades;
	}

	public static class ImatgesViewHolder extends RecyclerView.ViewHolder {
		private ImageView imatge;
		private TextView nomArtista;

		public ImatgesViewHolder(View itemView) {
			super(itemView);

			imatge = (ImageView)itemView.findViewById(R.id.imatgeArtistaSimilar);
			nomArtista = (TextView)itemView.findViewById(R.id.nomArtistaSimilar);
		}

		public void bindImatge(Artista artista) {
			//Converteixo l'int de la imatge a la imatge. Font: https://stackoverflow.com/questions/37439560/how-to-convert-int-to-drawable#
			imatge.setImageResource(artista.getImatge());

			nomArtista.setText(artista.getNom());
		}
	}

	//Aquest és el primer mètode a sobreescriure
	@Override
	public ImatgesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		//Inflo la vista
		View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artista_similar, viewGroup, false);

		//Per fer l'onClickListener:
		itemView.setOnClickListener(this);

		//Creo un objecte, que serà el que retornaré:
		ImatgesViewHolder ivh = new ImatgesViewHolder(itemView);

		return ivh;
	}


	//El segon mètode a sobreescriure:
	@Override
	public void onBindViewHolder(ImatgesViewHolder viewHolder, int pos) {
		Artista item = dadesArtistes.get(pos);
		viewHolder.bindImatge(item);
	}

	//El tercer mètode a sobreescriure:
	@Override
	public int getItemCount() {
		return dadesArtistes.size();
	}


	//Aquests dos mètodes són per fer l'onClickListener:
	public void setOnClickListener(View.OnClickListener listener) {
		this.listener = listener;
	}

	@Override
	public void onClick(View view) {
		if(listener != null) {
			listener.onClick(view);
		}
	}
}
