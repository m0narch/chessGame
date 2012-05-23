package fr.miblack.chess.com.jtuto.gui;

import java.awt.Color;

public class Couleur extends Color {
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
	public static Couleur BLEU = new Couleur( Color.BLUE.getRed( ) , Color.BLUE
	      .getGreen( ) , Color.BLUE.getBlue( ) );
	public static Couleur ROUGE = new Couleur( Color.RED.getRed( ) , Color.RED
	      .getGreen( ) , Color.RED.getBlue( ) );
	public static Couleur VERT = new Couleur( Color.GREEN.getRed( ) ,
	      Color.GREEN.getGreen( ) , Color.GREEN.getBlue( ) );
	public static Couleur VERT_FONCE = new Couleur( 0 , 180 , 0 );
	public static Couleur JAUNE = new Couleur( Color.YELLOW.getRed( ) ,
	      Color.YELLOW.getGreen( ) , Color.YELLOW.getBlue( ) );
	public static Couleur ORANGE = new Couleur( Color.ORANGE.getRed( ) ,
	      Color.ORANGE.getGreen( ) , Color.ORANGE.getBlue( ) );
	public static Couleur NOIR = new Couleur( Color.BLACK.getRed( ) ,
	      Color.BLACK.getGreen( ) , Color.BLACK.getBlue( ) );
	public static Couleur BLANC = new Couleur( Color.WHITE.getRed( ) ,
	      Color.WHITE.getGreen( ) , Color.WHITE.getBlue( ) );
	public static Couleur ROSE = new Couleur( Color.PINK.getRed( ) , Color.PINK
	      .getGreen( ) , Color.PINK.getBlue( ) );
	public static Couleur MAGENTA = new Couleur( Color.MAGENTA.getRed( ) ,
	      Color.MAGENTA.getGreen( ) , Color.MAGENTA.getBlue( ) );
	public static Couleur CYAN = new Couleur( Color.CYAN.getRed( ) , Color.CYAN
	      .getGreen( ) , Color.CYAN.getBlue( ) );
	public static Couleur GRIS = new Couleur( Color.GRAY.getRed( ) , Color.GRAY
	      .getGreen( ) , Color.GRAY.getBlue( ) );
	public static Couleur GRIS_CLAIR = new Couleur( Color.LIGHT_GRAY.getRed( ) ,
	      Color.LIGHT_GRAY.getGreen( ) , Color.LIGHT_GRAY.getBlue( ) );

	public Couleur( int rouge , int vert , int bleu ) {
		super( rouge , vert , bleu );
	}

	public Couleur( int niveauDeGris ) {
		super( niveauDeGris , niveauDeGris , niveauDeGris );
	}
}
