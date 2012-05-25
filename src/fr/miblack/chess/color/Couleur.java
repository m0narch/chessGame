
package fr.miblack.chess.color;
/**
 * @author mi-black
 */
public class Couleur
{
	/**
	 * ANSI_RESET
	 */
	public static final String	ANSI_RESET	= "\u001B[0m";
	/**
	 * ANSI_BLACK
	 */
	public static final String	ANSI_BLACK	= "\u001B[30m";
	/**
	 * ANSI_RED
	 */
	public static final String	ANSI_RED	= "\u001B[31m";
	/**
	 * ANSI_GREEN
	 */
	public static final String	ANSI_GREEN	= "\u001B[32m";
	/**
	 * ANSI_YELLOW
	 */
	public static final String	ANSI_YELLOW	= "\u001B[33m";
	/**
	 * ANSI_BLUE
	 */
	public static final String	ANSI_BLUE	= "\u001B[34m";
	/**
	 * ANSI_PURPLE
	 */
	public static final String	ANSI_PURPLE	= "\u001B[35m";
	/**
	 * ANSI_CYAN
	 */
	public static final String	ANSI_CYAN	= "\u001B[36m";
	/**
	 * ANSI_WHITE
	 */
	public static final String	ANSI_WHITE	= "\u001B[37m";
	/**
	 * If sum of line/collon =impaire => white else black
	 */
	protected int				color;						// Si jamais on veux
															// mettre plus que 2
															// couleurs

	/**
	 * @param color
	 */
	public Couleur( int color ) {
		this.color = color;
	}
	/**
	 * @param color
	 */
	public void setColor( int color )
	{
		this.color = color;
	}
	/**
	 * @return
	 */
	public int getColor()
	{
		return this.color;
	}
	/**
	 * @param color
	 * @return
	 */
	public boolean equals( Couleur color )
	{
		return (this.color == color.color);
	}

}
