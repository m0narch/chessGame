
package fr.miblack.chess;

import fr.miblack.chess.affichage.Graphique;
import fr.miblack.chess.affichage.Textuelle;


/**
 * La classe de Launch
 * @author mi-black
 */
public class Main
{
	/**
	 * La classe main
	 * @param args Les parametres : 0 = graphique >1 =  textuelle
	 */
	public static void main( String [] args )
	{
		if ( args.length == 0 )
		{
			Graphique maGUI = new Graphique();
			maGUI.jouerPartie();	
		}
		else
		{
			Textuelle guiTxt = new Textuelle();
			guiTxt.jouerPartie();
		}
	}
}
