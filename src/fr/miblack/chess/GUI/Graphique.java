package fr.miblack.chess.GUI;

import fr.miblack.chess.Partie;
import fr.miblack.chess.joueurs.JoueurAbstract;

public class Graphique 
{
	private Partie maPartie;

	public Graphique(JoueurAbstract player1,JoueurAbstract player2)
	{
		this.setMaPartie( new Partie(player1,player2) );
	}

	public Partie getMaPartie()
	{
		return maPartie;
	}

	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}
}
