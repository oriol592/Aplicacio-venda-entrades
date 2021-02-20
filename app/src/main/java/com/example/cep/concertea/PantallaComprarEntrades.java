package com.example.cep.concertea;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class PantallaComprarEntrades extends AppCompatActivity
{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_comprar_entrades);

		//Recupero l'intent i les dades enviades:
		Intent intent = getIntent();
		Actuacio actuacioEscollida = (Actuacio)intent.getSerializableExtra("objecte actuacio");
		Artista artistaEscollit = (Artista)intent.getSerializableExtra("objecte artista");


		//Creo les variables del layout en Java:
		TextView textNomArtista = findViewById(R.id.titolArtistaComprarEntrades);
		ImageView imatgeArtista = findViewById(R.id.imatgeArtistaComprarEntrades);

		TextView llocActuacio = findViewById(R.id.llocComprarEntrades);
		TextView dataActuacio = findViewById(R.id.dataComprarEntrades);
		TextView horaActuacio = findViewById(R.id.horaComprarEntrades);
		TextView salaActuacio = findViewById(R.id.salaComprarEntrades);
		TextView descripcioArtista = findViewById(R.id.descripcioArtistaComprarEntrades);

		final RadioButton radioButtonEntradaNormal = findViewById(R.id.radioButtonEntradaNormal);
		final RadioButton radioButtonEntradaAnticipada = findViewById(R.id.radioButtonEntradaAnticipada);
		final TextView numEntradesNormals = findViewById(R.id.numEntradesNormals);
		final TextView numEntradesAnticipades = findViewById(R.id.numEntradesAnticipades);
		final Button botoComprarEntrades = findViewById(R.id.botoComprarEntrades);

		//Botons de + i -
		Button botoMesEntradaNormal = findViewById(R.id.botoMesEntradaNormal);
		Button botoMenysEntradaNormal = findViewById(R.id.botoMenysEntradaNormal);
		Button botoMesEntradaAnticipada = findViewById(R.id.botoMesEntradaAnticipada);
		Button botoMenysEntradaAnticipada = findViewById(R.id.botoMenysEntradaAnticipada);


		//Assigno les dades rebudes als elements del layout:
		textNomArtista.setText(artistaEscollit.getNom());
		imatgeArtista.setImageResource(artistaEscollit.getImatge());
		llocActuacio.setText(actuacioEscollida.getLloc());

		String[] dataHora = actuacioEscollida.getDataHora().split(" ");
		dataActuacio.setText(dataHora[0]);
		horaActuacio.setText(dataHora[1]);

		salaActuacio.setText(actuacioEscollida.getSala());
		descripcioArtista.setText(artistaEscollit.getDescripcio());

		//descripcioArtista.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);


		//APARTAT REFERENT ALS RADIOBUTTONS I ELS BOTONS PER AFEGIR I TREURE ENTRADES:

		//A l'inici, vull que l'entrada normal estigui seleccionada i que hi hagi un 1 al número d'entrades:
		radioButtonEntradaNormal.setChecked(true);
		numEntradesNormals.setText("1");

		radioButtonEntradaNormal.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				numEntradesNormals.setText("1");
				numEntradesAnticipades.setText("0");
			}
		});

		radioButtonEntradaAnticipada.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				numEntradesNormals.setText("0");
				numEntradesAnticipades.setText("1");
			}
		});


		//Programo la resposta al click al botó de comprar entrades:
		botoComprarEntrades.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				//Creo un nou intent, esborro la resta d'activitats que hi ha obertes (pq al donar al botó enrenre
				//no hi torni, i després inicio la nova activity:
				Intent activityMenuPrincipal = new Intent(getApplicationContext(), MainActivity.class);
				activityMenuPrincipal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(activityMenuPrincipal);

				//Mostro un toast informatiu:
				Toast.makeText(getApplicationContext(), "Compra realitzada correctament!", Toast.LENGTH_LONG).show();
			}
		});



		//Programo els botons per sumar o restar el número d'entrades normals:
		if (radioButtonEntradaNormal.isChecked()) {
			botoMesEntradaNormal.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					int numEntrades = Integer.parseInt((String)numEntradesNormals.getText());
					numEntrades++;
					numEntradesNormals.setText(String.valueOf(numEntrades));
				}
			});

			botoMenysEntradaNormal.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					int numEntrades = Integer.parseInt((String)numEntradesNormals.getText());
					if (numEntrades >= 2)
					{
						numEntrades--;
						numEntradesNormals.setText(String.valueOf(numEntrades));
					}
				}
			});
		}

		//Programo els botons per sumar o restar entrades anticipades:
		if (radioButtonEntradaAnticipada.isChecked()) {
			botoMesEntradaAnticipada.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					int numEntrades = Integer.parseInt((String)numEntradesAnticipades.getText());
					numEntrades++;
					numEntradesAnticipades.setText(String.valueOf(numEntrades));
				}
			});

			botoMenysEntradaAnticipada.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					int numEntrades = Integer.parseInt((String)numEntradesAnticipades.getText());
					if (numEntrades >= 2)
					{
						numEntrades--;
						numEntradesAnticipades.setText(String.valueOf(numEntrades));
					}
				}
			});
		}

	}
}
