
package fr.miblack.chess.GUI;

import java.util.Scanner;
import fr.miblack.chess.Coup;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.Partie;
import fr.miblack.chess.Position;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.joueurs.JoueurHumain;
import fr.miblack.chess.joueurs.JoueurOrdinateur;

public class Textuelle extends Interface
{

	public Textuelle() {
		menuPrincipal();
	}

	public Textuelle( String p1, String p2 ) {
		menuLocal( p1, p2 );
	}

	private void menuPrincipal()
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

	private int menuLocal()
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

	private int menuLocal( String p1, String p2 )
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
	private void menuReseau()
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
		System.out.print( "2 . Partie réseau\n" );// TODO Partie réseau
		System.out.print( "3 . Options\n" );
		System.out.print( "4 . Quitter\n" );
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
				monCoup = Coup.parseStringToCoupCompl( strCoup, maPartie );
			} catch (RuntimeException e)
			{
				System.out.println( "Le coup est invalide" );
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

	public void jouerPartie()
	{
		Coup monCoup;
		while (!getMaPartie().isDraw()) 
		{
			for ( JoueurAbstract p : this.getMaPartie().getListOfPlayer() )
			{
				this.AfficherEchiquier();

				if ( getMaPartie().estEnEchec( p ) )
				{
					if ( getMaPartie().estEchecEtMat( p ) )
					{
						System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est echecs et mat !" );
						System.exit( 0 );
					}
					System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est en echecs !" );
				}
				else
				{
					if ( getMaPartie().estPat( p ) )
					{
						System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est pat !" );
						System.exit( 0 );
					}
				}
				System.out.println( this.getMaPartie().listOfAvailableMove( p ) );
				System.out.println( "C'est au joueur " + p.getType() + " "+ p.toString() + " de jouer !" );
				monCoup = p.jouerCoup( this.getMaPartie() );

				this.getMaPartie().realiserCoup( monCoup );
				if ( getMaPartie().promotionPossible( getMyChessboard() ) )
				{
					getMyChessboard().realiserPromotion( monCoup );
				}
				this.getMaPartie().setPlayerEnCours();
			}
		}
		if ( getMaPartie().isDraw() )
		{
			System.out.println( "Fin de partie , partie nulle" );
		}
	}

	public String AfficherEchiquier()
	{
		Echiquier myChessboard = maPartie.getMyChessboard();
		String a = "";
		for ( int y = 7 ; y >= 0 ; y-- )
		{
			for ( int x = 0 ; x <= 7 ; x++ )
			{
				System.out.print( Couleur.ANSI_RESET );
				if ( myChessboard
						.getPiecePosition( Position.getPosition( x, y ) ) != null )
					System.out.print( myChessboard.getPiecePosition(
							Position.getPosition( x, y ) ).toString() );
				else
				{
					System.out.print( Position.getPosition( x, y ) );
				}
			}
			System.out.print( Couleur.ANSI_RESET );
			System.out.print( " " + (y + 1) + "\n" );
		}
		System.out.println( "" );

		for ( int i = 0 ; i <= 7 ; i++ )
		{
			System.out.print( (char) (i + 97) );
		}
		System.out.println( "" );
		return a;
	}

	@Override
	public Coup jouerCoup( Partie g )
	{
		JoueurAbstract p = g.getPlayerEnCours();
		Coup m;
		boolean mauvaisChoix = false;
		do
		{
			if ( mauvaisChoix )
			{
				System.out.println( "Mauvais choix de coup" );
			}
			m = saisirCoup( p, this.getMyChessboard() );
			if ( g.seraEnEchec( m.getPosDepart().clone(), m.getPosArrivee().clone() ) )
			{
				mauvaisChoix = true;
			}
			else
				mauvaisChoix = false;
		} while (mauvaisChoix);

		return m;
	}

}
