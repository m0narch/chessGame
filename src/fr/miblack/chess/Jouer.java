
package fr.miblack.chess;

/**
 * Une interface qui défini comment on joue un coup
 * @author mi-black
 */
public interface Jouer
{
	/**
	 * @param g une partie
	 * @return le coup Joué
	 */
	public Coup jouerCoup( Partie g );

}
