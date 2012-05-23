
package fr.miblack.chess;

import fr.miblack.chess.affichage.Graphique;
import fr.miblack.chess.affichage.Textuelle;

public class Main
{
	public static void main( String [] args )
	{
		if ( args.length == 0 )
		{
			Textuelle guiTxt = new Textuelle();
			guiTxt.jouerPartie();
		}
		else
		{
			Graphique maGUI = new Graphique();
			maGUI.jouerPartie();
		}
	}
}
