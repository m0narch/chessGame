
package fr.miblack.chess.color;

public class Couleur
{
	public static final String	ANSI_RESET	= "\u001B[0m";
	public static final String	ANSI_BLACK	= "\u001B[30m";
	public static final String	ANSI_RED	= "\u001B[31m";
	public static final String	ANSI_GREEN	= "\u001B[32m";
	public static final String	ANSI_YELLOW	= "\u001B[33m";
	public static final String	ANSI_BLUE	= "\u001B[34m";
	public static final String	ANSI_PURPLE	= "\u001B[35m";
	public static final String	ANSI_CYAN	= "\u001B[36m";
	public static final String	ANSI_WHITE	= "\u001B[37m";
	/*
	 * If sum of line/collon =impaire => white else black
	 */
	protected int				color;						// Si jamais on veux
															// mettre plus que 2
															// couleurs

	public Couleur( int color ) {
		this.color = color;
	}

	public void setColor( int color )
	{
		this.color = color;
	}

	public int getColor()
	{
		return this.color;
	}

	public boolean equals( Couleur color )
	{
		return (this.color == color.color);
	}

}
