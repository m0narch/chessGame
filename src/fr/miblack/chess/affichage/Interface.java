
package fr.miblack.chess.affichage;

import java.util.Scanner;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.Jouer;
import fr.miblack.chess.Partie;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.joueurs.JoueurHumain;
import fr.miblack.chess.joueurs.JoueurOrdinateur;
import fr.miblack.chess.piece.Piece;

public abstract class Interface implements Jouer
{
	protected Partie			maPartie;
	protected JoueurAbstract	player1;
	protected JoueurAbstract	player2;

	public Partie getMaPartie()
	{
		return maPartie;
	}

	public Piece getPiecePosition( int x, int y )
	{
		return this.getMaPartie().getMyChessboard().getPiecePosition( x, y );
	}

	public Echiquier getMyChessboard()
	{
		return this.getMaPartie().getMyChessboard();
	}

	@Override
	public abstract Coup jouerCoup( Partie g );
	
	protected void menuPrincipal()
	{
		int i = 0;
		i = affichageMenuPrincipal();
		int ret = saisieMenu( i );
		switch (ret)
		{
			case 1 :
				menuLocal();
				break;
			case 2 :
				System.exit( 0 );
				menuReseau();
				break;
			case 3 :
				System.exit( 0 );
				// TODO menuOption();
				break;
			case 4 :
				System.exit( 0 );
				break;
			default :
				break;
		}

	}

	protected int menuLocal()
	{
		int i = 0;
		i = affichageMenuLocale();
		int ret = saisieMenu( i );
		if ( ret > i )
		{
			menuPrincipal();
			return -1;
		}
		Scanner sc = new Scanner( System.in );
		System.out.println( "Entrez le nom du joueur 1:" );
		String p1 = sc.nextLine();
		System.out.println( "Entrez le nom du joueur 2:" );
		String p2 = sc.nextLine();
		switch (ret)
		{
			case 1 :
				player1 = new JoueurHumain( p1, new Couleur( 1 ), this );
				player2 = new JoueurOrdinateur( p2, new Couleur( 0 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 2 :
				player1 = new JoueurHumain( p1, new Couleur( 1 ), this );
				player2 = new JoueurHumain( p2, new Couleur( 0 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 3 :
				player1 = new JoueurOrdinateur( p1, new Couleur( 1 ), this );
				player2 = new JoueurOrdinateur( p2, new Couleur( 0 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 4 :
				menuPrincipal();
				break;

			default :
				break;
		}
		return 0;
	}

	protected int menuLocal( String p1, String p2 )
	{
		int i = 0;
		i = affichageMenuLocale();
		int ret = saisieMenu( i );
		if ( ret > i )
		{
			menuPrincipal();
			return -1;
		}
		switch (ret)
		{
			case 1 :
				player1 = new JoueurHumain( p1, new Couleur( 0 ), this );
				player2 = new JoueurOrdinateur( p2, new Couleur( 1 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 2 :
				player1 = new JoueurHumain( p1, new Couleur( 0 ), this );
				player2 = new JoueurHumain( p2, new Couleur( 1 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 3 :
				player1 = new JoueurOrdinateur( p1, new Couleur( 0 ), this );
				player2 = new JoueurOrdinateur( p2, new Couleur( 1 ), this );
				this.maPartie = new Partie( player1, player2 );
				break;

			case 4 :
				menuPrincipal();
				break;

			default :
				break;
		}
		return 0;
	}

	// TODO si jamais le temps y est !
	protected void menuReseau()
	{
		int ret = saisieMenu( affichageMenuReseau() );
		switch (ret)
		{
			case 1 :

				break;
			case 2 :

				break;
			case 3 :
				menuPrincipal();
				break;

			default :
				menuPrincipal();
				break;
		}
	}

	public int affichageMenuPrincipal()
	{
		System.out.print( "Bienvenue !\n" );
		System.out.print( "Faites votre choix :\n" );
		System.out.print( "1 . Partie locale\n" );
		System.out.print( "2 . Quitter\n" );
		return 4;

	}

	public int affichageMenuLocale()
	{
		System.out.print( "Faites votre choix :\n" );
		System.out.print( "1 . Partie un joueur\n" );
		System.out.print( "2 . Partie deux joueurs\n" );
		System.out.print( "3 . Partie Machine VS Machine\n" );
		System.out.print( "4 . Retour\n" );

		return 4;
	}

	public int affichageMenuReseau()
	{
		System.out.print( "Faites votre choix :\n" );
		System.out.print( "1 . Partie deux joueurs\n" );
		System.out.print( "2 . Partie Machine VS Machine\n" );
		System.out.print( "3 . Retour\n" );
		return 3;
	}	
 

	public Coup saisirCoup( JoueurAbstract p, Echiquier chess )
	{
		Scanner sc = new Scanner( System.in );
		String strCoup;
		Coup monCoup = null;
		boolean trouve = false;

		while (trouve == false)
		{
			System.out.println( "Saissisez le coup à jouer avec la notation complete" );
			strCoup = sc.nextLine();
			if(strCoup.equals( "save" ))
			{
				System.out.println("Saissisez le nom de save du fichier");
				strCoup = sc.nextLine();
				maPartie.saveGame( strCoup );
				continue;
			}
			if(strCoup.startsWith( "save " ))
			{
				String out=strCoup.substring( 5 );
				maPartie.saveGame( out );
				continue;
			}
			if(strCoup.equals( "load" ))
			{
				System.out.println("Saissisez le nom  du fichier a charger");
				strCoup = sc.nextLine();
				maPartie.loadGame( strCoup, this );
				continue;
			}
			if(strCoup.startsWith( "load " ))
			{
				String out=strCoup.substring( 5 );
				maPartie.loadGame( out, this );
				continue;
			}
			 
			try
			{
				monCoup = Coup.parseStringToCoupCompl( strCoup, maPartie,p );
			} catch (RuntimeException e)
			{
				System.out.println( "Le coup est invalide -izai" );
				continue;
			}
			for ( Coup c : maPartie.listOfAvailableMove( p ) )
			{
				if ( monCoup.equals( c ) )
				{
					trouve = true;
					break;
				}
			}
		}
		return monCoup;
	}

	public int saisieMenu( int taille )
	{
		int i = taille + 1;
		Scanner sc = new Scanner( System.in );
		while (i <= 0 || i > taille)
		{

			try
			{
				i = Integer.parseInt( sc.nextLine() );
			} catch (NumberFormatException e)
			{
				i = taille + 1;
				continue;
			}
			if ( i < 0 || i > taille )
			{
				System.out.println( "Mauvaise valeur !" );
				i = taille + 1;
			}
		}
		return i;
	}
	
}
