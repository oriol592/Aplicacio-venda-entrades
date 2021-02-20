package com.example.cep.concertea;

import java.util.ArrayList;

public class ObtenirDades
{

	public static ArrayList<Artista> dadesArtistes() {
		//Aquest mètode estàtic retorna les dades dels artistes:
		ArrayList<Artista> llistaArtistes = new ArrayList<Artista>();

		//Creo un objecte per cada artista i els afegeixo a l'arraylist:
		llistaArtistes.add(new Artista("Carolina Durante", "Palau Sant Jordi", R.drawable.carolinadurante,
				"Carolina Durante es una banda madrileña formada en 2017, cuya música puede catalogarse dentro de géneros como el Punk, el Pop o el Rock. La agrupación musical está compuesta por Diego Ibáñez (voz), Martín Vallhonrat (bajo), Juan Pedrayes (batería) y Mario del Valle (guitarra). Su primer EP, titulado Necromántico, salió a la venta en diciembre de 2017, seguido de su segundo lanzamiento, Examiga, el 4 de mayo de 2018.6"));
		llistaArtistes.add(new Artista("La Gossa Sorda", "Acampada Jove", R.drawable.gossasorda,
				"La Gossa Sorda va ser un grup musical de Pego (Marina Alta, País Valencià). La seua música té ritmes de Ska, Rock, Reggae i Punk amb la utilització de molts ritmes mediterranis i altres influències. Fan servir instruments com la dolçaina. Les seves lletres en català ataquen els fonaments del sistema, la injustícia de l'ordre social i mundial actual, la lluita per salvar el País Valencià, el consumisme, la corrupció política, la crisi econòmica i l'integrisme religiós."));
		llistaArtistes.add(new Artista("Lendakaris muertos", "Sala Razzmatazz", R.drawable.lendakaris,
				"Lendakaris Muertos és un grup musical de punk i rock radical basc en clau irònica, en llengua castellana, fundat el març de 2004 a Pamplona (Navarra). Es caracteritza per un punk ortodox, gran velocitat, temes molt curts, cors continus.[4] Utilitzen lletres iròniques, amb acidesa que resulta de combinar humor i crítica social i política d'Euskal Herria i Espanya. El nom de la banda està inspirat en el grup de hardcore punk estatunidenc Dead Kennedys."));
		llistaArtistes.add(new Artista("Manel", "Sala Apolo", R.drawable.manel, "Manel és un grup de música de Barcelona que canta en català. Les seves cançons barregen el pop amb música folklòrica. Van llançar el seu primer disc al mercat l'any 2008, titulat Els millors professors europeus; el segon, 10 milles per veure una bona armadura," +
				" el 2011; el tercer, Atletes, baixin de l'escenari, el 2013 i el quart, Jo competeixo, el 2016. Segons alguns crítics tenen elements en comú amb altres artistes catalans com Jaume Sisa, Pau Riba o Antònia Font, i amb altres d'internacionals com Beirut o Sufjan Stevens."));
		llistaArtistes.add(new Artista("Txarango", "Sala Bikini", R.drawable.txarango, "Txarango és un grup de música català format a Barcelona el 2010 per components originaris del Ripollès, de Sant Joan de les Abadesses."));
		llistaArtistes.add(new Artista("La Pegatina", "Luz de gas", R.drawable.pegatina, "La Pegatina és un grup de música de rumba catalana i ska fundat el 2003 a Montcada i Reixac. El grup inicia la seva carrera l'any 2003 amb el nom de Pegatina Sound System, amb més de vint actuacions a l'esquena i un parell de temes recollits en un EP, van començar a recórrer la península i a tocar en festivals i concerts. "));

		return llistaArtistes;
	}


	public static ArrayList<Actuacio> dadesActuacions() {
		//Em remeto a les explicacions del mètode anterior
		ArrayList<Actuacio> llistaActuacions = new ArrayList<Actuacio>();

		llistaActuacions.add(new Actuacio("Barcelona", "12-3-2019 23h", "Razzmatazz"));
		llistaActuacions.add(new Actuacio("Barcelona", "19-4-2019 22h", "Bikini"));
		llistaActuacions.add(new Actuacio("Barcelona", "25-4-2019 21h", "Apolo"));

		return llistaActuacions;
	}


	/*public static ArrayList<ArtistaSimilar> dadesArtistesSimilars() {
		ArrayList<ArtistaSimilar> llistaArtistesSimilars = new ArrayList<>();

		llistaArtistesSimilars.add(new ArtistaSimilar(R.drawable.carolinadurante, ))
	}*/
}
