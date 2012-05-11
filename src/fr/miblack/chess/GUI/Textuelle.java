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

public class Textuelle   extends Interface
{

	
	public Textuelle()
	{
		menuPrincipal();
	}
	
	public Textuelle(String p1,String p2)
	{
		menuLocal(p1,p2);
	}

	private void menuPrincipal()
	{
		int i=affichageMenuPrincipal();
		int ret=saisieMenu(i);
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
				//TODO	menuOption();
				break;
			case 4 :
				System.exit( 0 );
				break;
			default :
				break;
		}

	}

	private void menuLocal()
	{
		int i=affichageMenuLocale();
		int ret=saisieMenu(i);
		if(ret >=i)
		{
			menuPrincipal();
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Entrez le nom du joueur 1:");
		String p1=sc.nextLine();
		System.out.println("Entrez le nom du joueur 2:");
		String p2=sc.nextLine();
		switch(ret)
		{
			case 1 :
				player1=new JoueurHumain( p1, new Couleur( 1 ));
				player2=new JoueurOrdinateur( p2, new Couleur( 0 ));
				this.maPartie=new Partie(player1,player2,this);
				break;	

			case 2 :
				player1=new JoueurHumain( p1, new Couleur( 1 ));
				player2=new JoueurHumain( p2, new Couleur( 0 ));
				this.maPartie=new Partie(player1,player2,this);
				break;	
				
			case 3 :
				player1=new JoueurOrdinateur( p1, new Couleur( 1 ));
				player2=new JoueurOrdinateur( p2, new Couleur( 0 ));
				this.maPartie=new Partie(player1,player2,this);
				break;
				
			case 4 :
				menuPrincipal();
				break;

			default :
				break;
		}
	}
	
	private void menuLocal(String p1,String p2)
	{
		int i=affichageMenuLocale();
		int ret=saisieMenu(i);
		if(ret >=i)
		{
			menuPrincipal();
		}
		switch(ret)
		{
			case 1 :
				player1=new JoueurHumain( p1, new Couleur( 0 ));
				player2=new JoueurOrdinateur( p2, new Couleur( 1 ));
				this.maPartie=new Partie(player1,player2,this);
				break;	

			case 2 :
				player1=new JoueurHumain( p1, new Couleur( 0 ));
				player2=new JoueurHumain( p2, new Couleur( 1 ));
				this.maPartie=new Partie(player1,player2,this);
				break;	
				
			case 3 :
				player1=new JoueurOrdinateur( p1, new Couleur( 0 ));
				player2=new JoueurOrdinateur( p2, new Couleur( 1 ));
				this.maPartie=new Partie(player1,player2,this);
				break;
				
			case 4 :
				menuPrincipal();
				break;

			default :
				break;
		}
	}
	
	//TODO si jamais le temps y est !
	private void menuReseau()
	{
		int ret=saisieMenu(affichageMenuReseau());
		switch(ret)
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
		System.out.print("Bienvenue !\n");
		System.out.print("Faites votre choix :\n");
		System.out.print("1 . Partie locale\n");
		System.out.print("2 . Partie réseau\n");//TODO Partie réseau
		System.out.print("3 . Options\n");
		System.out.print("4 . Quitter\n");
		return 4;

	}

	public int affichageMenuLocale()
	{
		System.out.print("Faites votre choix :\n");
		System.out.print("1 . Partie un joueur\n");
		System.out.print("2 . Partie deux joueurs\n");
		System.out.print("3 . Partie Machine VS Machine\n");
		System.out.print("4 . Retour\n");

		return 4;
	}

	public int affichageMenuReseau()
	{
		System.out.print("Faites votre choix :\n");
		System.out.print("1 . Partie deux joueurs\n");
		System.out.print("2 . Partie Machine VS Machine\n");
		System.out.print("3 . Retour\n");
		return 3;
	}

	public Coup saisirCoup(JoueurAbstract p,Echiquier chess)  
	{
		Scanner sc=new Scanner(System.in );
		String strCoup;
		Coup monCoup = null;
		boolean trouve=false;

		while(trouve==false)
		{
			System.out.println("Saissisez le coup à jouer avec la notation complete");
			strCoup=sc.nextLine();
			try
			{
				monCoup=Coup.parseStringToCoupCompl( strCoup, maPartie );
			}
			catch(RuntimeException e)
			{
				System.out.println(e.getMessage());
				continue;
			}		
			for(Coup c:maPartie.listOfAvailableMove( p ))
			{
				if(monCoup.equals( c ))
				{
					trouve=true;
					break;
				}
			}
		}
		return monCoup;
	}

	public int saisieMenu(int taille)
	{
		int i=taille+1;
		Scanner sc=new Scanner(System.in);

		while(i<0 || i>taille)
		{
			i=sc.nextInt();
			if(i<0 || i>taille)
				System.out.println("Mauvaise valeur !");
		}
		return i;
	}
	public void jouerPartie()
	{
		Coup monCoup;
		//while(!getMaPartie().estEchecEtMat( getMaPartie().getPlayerEnCours() )) //FIXME Changer la cond pour gestion pat echec etc
		while(true)
		{
			for	(JoueurAbstract p: this.getMaPartie().getListOfPlayer())
			{
				this.AfficherEchiquier();
				System.out.println(this.getMaPartie().listOfAvailableMove( p ) );
				if(getMaPartie().estEnEchec(p))
				{
					System.out.println("Le roi de "+getMaPartie().getPlayerEnCours()+" est en echecs !");
				}
				if(p instanceof JoueurHumain)
				{
						System.out.println("C'est au joueur humain "+p.toString()+" de jouer !");
						monCoup=((JoueurHumain) p).jouerCoup( this.getMaPartie());
				}
				else
				{
						System.out.println("C'est au joueur machine "+p.toString()+" de jouer !");
						monCoup=((JoueurOrdinateur) p).jouerCoup( this.getMaPartie());
				}
				this.getMyChessboard().realiserCoup( monCoup );
				this.getMaPartie().setPlayerEnCours();
				
			}
		}
	}
	
	public String AfficherEchiquier()
	{
		Echiquier myChessboard=maPartie.getMyChessboard();
		String a="";
		for(int y=7;y>=0;y--)
		{
			for(int x=0;x<=7;x++)
			{
				System.out.print(Couleur.ANSI_RESET);
				if(myChessboard.getPiecePosition(Position.getPosition(x,y) )!=null)
					System.out.print(myChessboard.getPiecePosition(Position.getPosition(x, y)).toString());
				else
				{
					System.out.print(Position.getPosition(x,y));
				}
			}
			System.out.print(Couleur.ANSI_RESET);

			System.out.print(" " +(y+1)+"\n");
		}
		System.out.println("");

		for(int i=0;i<=7;i++)
		{
			System.out.print((char)(i+97));
		}

		System.out.println("");
		return a;
	}


}
