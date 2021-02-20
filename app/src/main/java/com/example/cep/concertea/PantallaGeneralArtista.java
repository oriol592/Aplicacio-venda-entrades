package com.example.cep.concertea;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PantallaGeneralArtista extends AppCompatActivity
{
	private boolean corBuit = true;
	//La variable que fa referència al cor no està inicialitzada. S'inicialitza un cop s'ha carregat el layout
	//amb el setContentView() del mètode OnCreate(). Em donava error, un nullPointerException, perquè ho inicialitzava
	//aquí, quan el layout no estava carregat. Solució de StackOverFlow:
	// https://stackoverflow.com/questions/3264610/findviewbyid-returns-null
	ImageView imatgeCor;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		//Compte! Aquest @Nullable no hi surt en les pràctiques que he fet, pot ser font d'errors
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_general_artista);

		imatgeCor = findViewById(R.id.botoCorPantallaGeneralArtista);

		//Recupero l'objecte enviat i assigno les dades al layout:
		Intent intent = getIntent();
		final Artista objecteRebut = (Artista)intent.getSerializableExtra(MainActivity.PAQUET);

		TextView nomArtista = findViewById(R.id.nomArtista);
		nomArtista.setText(objecteRebut.getNom());

		ImageView imatgeGrup = findViewById(R.id.imatgeArtista);
		imatgeGrup.setImageResource(objecteRebut.getImatge());


		//Assigno l'adapter a la listView de properes actuacions:
		final ListView listViewProperesActuacions = findViewById(R.id.listViewProperesActuacions);
		ProperesActuacionsAdapter adapter = new ProperesActuacionsAdapter(this, ObtenirDades.dadesActuacions());
		listViewProperesActuacions.setAdapter(adapter);

		//Programo l'event onClick:
		listViewProperesActuacions.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				//Recupero l'objecte Actuacio clicat:
				Actuacio actuacioClicada = (Actuacio)listViewProperesActuacions.getItemAtPosition(i);

				Intent intent = new Intent(PantallaGeneralArtista.this, PantallaComprarEntrades.class);

				//Explicació fàcil de com funciona el putExtra: http://jonsegador.com/2012/02/paso-de-datos-variables-entre-actividades-android/
				intent.putExtra("objecte actuacio", actuacioClicada);
				intent.putExtra("objecte artista", objecteRebut);
				startActivity(intent);
			}
		});


		final RecyclerView recyclerViewArtistaSimilar = (RecyclerView)findViewById(R.id.recyclerViewArtistesSimilars);

		//Posar que la grid és de tamany fix no és obligatori però sí recomanable, per optimitzar el funcionament
		recyclerViewArtistaSimilar.setHasFixedSize(true);

		//Assigno l'adapter al recyclerView horitzontal d'artistes similars
		AdaptadorArtistaSimilarRecyclerView adaptador = new AdaptadorArtistaSimilarRecyclerView(ObtenirDades.dadesArtistes());
		recyclerViewArtistaSimilar.setAdapter(adaptador);

		//Extret d'internet: https://www.designstring.com/android-using-layoutmanagers-with-recyclerview/
		//initialize linear layout manager horizontally
		LinearLayoutManager linearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

		//attach linear layout to recyclerview
		recyclerViewArtistaSimilar.setLayoutManager(linearHorizontal);


		//Afegeixo l'itemDecoration, i utilitzo el que ve per defecte amb l'AndroidStudio
		recyclerViewArtistaSimilar.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

		//Afegeixo l'item animator, que serveix per definir les animacions que farà el recyclerVieu al fer les
		//accions més comunes (afegir, modificar, eliminar i moure). Utilitzo el que ve per defecte:
		recyclerViewArtistaSimilar.setItemAnimator(new DefaultItemAnimator());


		//Programo que quan l'usuari cliqui el cor, aquesta imatge es canviï per la del cor ple, i viceversa:
		//He hagut de posar-ho a una funció a part perquè dins de l'OnClick no podia utilitzar la variable booleana,
		//em demanava que fos final
		imatgeCor.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				cambiarImatge();
			}
		});
	}



	public void cambiarImatge() {
		if (corBuit) {
			imatgeCor.setImageResource(R.drawable.corvermell);
			corBuit = false;
		} else {
			imatgeCor.setImageResource(R.drawable.corbuit);
			corBuit = true;
		}
	}
}
