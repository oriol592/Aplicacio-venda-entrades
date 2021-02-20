package com.example.cep.concertea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
	public static final String PAQUET = "com.example.cep.concertea";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Assigno l'adapter a la listView del menú principal:
		final ListView listViewMenuPrincipal = findViewById(R.id.listViewArtistes);
		ArtistaAdapter adapter = new ArtistaAdapter(this, ObtenirDades.dadesArtistes());
		listViewMenuPrincipal.setAdapter(adapter);

		listViewMenuPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
			{
				//Recupero l'element clicat per l'usuari
				Artista artistaClicat = (Artista)listViewMenuPrincipal.getItemAtPosition(i);

				//Creo l'intent, li poso les dades i inicio una nova activity:
				Intent intent = new Intent(MainActivity.this, PantallaGeneralArtista.class);
				intent.putExtra(PAQUET, artistaClicat);
				startActivity(intent);
			}
		});


	}
}
