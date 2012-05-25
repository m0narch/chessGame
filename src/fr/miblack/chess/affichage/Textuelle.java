
package fr.miblack.chess.affichage;

import java.util.Scanner;
import fr.miblack.chess.Coup;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.Partie;
import fr.miblack.chess.Position;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;

public class Textuelle extends Interface
{

	public Textuelle() {
		menuPrincipal();
	}

	public Textuelle( String p1, String p2 ) {
		menuLocal( p1, p2 );
	}



	public void jouerPartie()
	{
		Coup monCoup;
		while (!getMaPartie().isDraw()) 
		{
			for ( JoueurAbstract p : this.getMaPartie().getListOfPlayer() )
			{
				this.afficherEchiquier();

				if ( getMaPartie().estEnEchec( p ) )
				{
					if ( getMaPartie().estEchecEtMat( p ) )
					{
						System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est echecs et mat !" );
						proposerSave(maPartie);
						System.exit( 0);
					}
					System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est en echecs !" );
				}
				else
				{
					if ( getMaPartie().estPat( p ) )
					{
						System.out.println( "Le roi de "+ getMaPartie().getPlayerEnCours()+ " est pat !" );
						proposerSave(maPartie);
						System.exit( 0);
					}
				}
				System.out.println( this.getMaPartie().listOfAvailableMove( p ) );
				System.out.println( "C'est au joueur " + p.getType() + " "+ p.toString() + " de jouer !" );
				monCoup = p.jouerCoup( this.getMaPartie() );

				this.getMaPartie().realiserCoup( monCoup );
				if ( getMaPartie().promotionPossible( ) )
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
		proposerSave(maPartie);

	}

	/**
	 * propose si l'on veux une sauvegarde
	 * 
	 * @param maPartie
	 */
	public void proposerSave(Partie maPartie)
	{		
	Scanner sc =new Scanner( System.in );
	String m="";
		System.out.println("save <nom fichier> pour sauvegarder");
		m=sc.nextLine();
		if(m.equals( "save" ))
		{
			System.out.println("Saissisez le nom de save du fichier");
			m = sc.nextLine();
			maPartie.saveGame( m );
		}
		if(m.startsWith( "save " ))
		{
			String out=m.substring( 5 );
			maPartie.saveGame( out );
		}
	}
	/**
	 * 
	 * @return
	 */
	public void afficherEchiquier()
	{
		Echiquier myChessboard = maPartie.getMyChessboard();
		for ( int y = 7 ; y >= 0 ; y-- )
		{
			for ( int x = 0 ; x <= 7 ; x++ )
			{
				System.out.print( Couleur.ANSI_RESET );
				if ( myChessboard
						.getPiecePosition( Position.getPosition( x, y ) ) != null )
					System.out.print( myChessboard.getPiecePosition(Position.getPosition( x, y ) ).toString() );
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
			if(m.getRoque()==true)
			{
				break;
			}
			if ( g.seraEnEchec( m.getPosDepart().clone(), m.getPosArrivee().clone() ) )
			{
				mauvaisChoix = true;
			}
			else
				mauvaisChoix = false;
		} while (mauvaisChoix);

		return m;
	}
	
	public Coup saisirCoup( JoueurAbstract p, Echiquier chess )
	{
		Scanner sc = new Scanner( System.in );
		String strCoup;
		Coup monCoup = null;
		boolean trouve = false;

		while (trouve == false)
		{
			
			System.out.println( "Saissisez le coup a jouer avec la notation complete" );
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

}
