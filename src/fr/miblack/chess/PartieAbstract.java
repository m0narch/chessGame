package fr.miblack.chess;
import fr.miblack.chess.Echiquier;
import fr.miblack.chess.color.Couleur;
import fr.miblack.chess.joueurs.JoueurAbstract;
import fr.miblack.chess.joueurs.JoueurHumain;
import fr.miblack.chess.piece.*;
import java.util.*;
public abstract class PartieAbstract
{
	private LinkedList<Coup> listOfMove=new LinkedList<Coup>();
	private LinkedList<Coup> listOfMoveCancelled=new LinkedList<Coup>();
	private LinkedList<JoueurAbstract> listOfPlayer =new LinkedList<JoueurAbstract>();

	private LinkedList<Coup> listOfMovep1=new LinkedList<Coup>();
	private LinkedList<Coup> listOfMovep2=new LinkedList<Coup>();

	private Echiquier myChessboard = new Echiquier();

	

	public PartieAbstract(String p1,String p2)
	{
		listOfPlayer.add(new JoueurHumain(p1));
		listOfPlayer.add(new JoueurHumain(p2));
		initPositions();
	}

	public Echiquier getMyChessboard() 
	{
		return myChessboard;
	}
	
	public Coup cancelLastMove(JoueurAbstract p)
	{
		listOfMoveCancelled.add(listOfMove.getLast());
		return listOfMove.removeLast();
	}

	public Coup replayLastCanceledMove()
	{
		listOfMove.add( listOfMoveCancelled.getLast() );
		return listOfMoveCancelled.removeLast();
	}
	public boolean isStalemate()
	{
		boolean stalemate=false;

		return stalemate;
	}

	public boolean isCheck()
	{
		boolean check=false;
		Position kingPos=null;
		for(Position onePos :Position.listPosit()  )
		{
			if(getMyChessboard().getPiecePosition(onePos) instanceof Roi)
			{
				kingPos=onePos;
				for(Position otherPos :myChessboard.getPiecePosition(onePos).positionAccessibleChessboard(this.myChessboard) )
				{
					if(otherPos.equals(kingPos))
					{
						check=true;
					}
				}
			}
		}
		return check;
	}

	public boolean isCheckmate()
	{
		boolean mate=false;
		return mate;
	}

	public boolean isDraw()
	{
		boolean draw=false;
		return draw;
	}

	public void saveGame(String pathOfFile)
	{

	}

	public void loadGame(String pathOfFile)
	{

	}

	public LinkedList<Coup> listOfAvailableMove(JoueurAbstract p)
	{
		LinkedList<Coup> pos=new LinkedList<Coup>();
		return pos;
	}

	public void initPositions()
	{
		/***************************     White piece       ***********************************/

		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(0,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(1,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(2,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(3,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(4,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(5,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(6,1),1));
		this.myChessboard.addPawn(new Pion(new Couleur(1),Position.getPosition(7,1),1));

		this.myChessboard.addRook(new Tour(new Couleur(1),Position.getPosition(0,0),5));
		this.myChessboard.addRook(new Tour(new Couleur(1),Position.getPosition(7,0),5));

		this.myChessboard.addBishop(new Fou(new Couleur(1),Position.getPosition(2,0),3));
		this.myChessboard.addBishop(new Fou(new Couleur(1),Position.getPosition(5,0),3));

		this.myChessboard.addKing(new Roi(new Couleur(1),Position.getPosition(4,0),0));

		this.myChessboard.addQueen(new Dame(new Couleur(1),Position.getPosition(3,0),10));

		this.myChessboard.addKnight(new Cavalier(new Couleur(1),Position.getPosition(1,0),3));
		this.myChessboard.addKnight(new Cavalier(new Couleur(1),Position.getPosition(6,0),3));

		/***************************     Black piece       ***********************************/

		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(0,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(1,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(2,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(3,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(4,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(5,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(6,6),1));
		this.myChessboard.addPawn(new Pion(new Couleur(0),Position.getPosition(7,6),1));

		this.myChessboard.addRook(new Tour(new Couleur(0),Position.getPosition(0,7),5));
		this.myChessboard.addRook(new Tour(new Couleur(0),Position.getPosition(7,7),5));

		this.myChessboard.addBishop(new Fou(new Couleur(0),Position.getPosition(2,7),3));
		this.myChessboard.addBishop(new Fou(new Couleur(0),Position.getPosition(5,7),3));

		this.myChessboard.addKing(new Roi(new Couleur(0),Position.getPosition(4,7),0));

		this.myChessboard.addQueen(new Dame(new Couleur(0),Position.getPosition(3,7),10));

		this.myChessboard.addKnight(new Cavalier(new Couleur(0),Position.getPosition(1,7),3));
		this.myChessboard.addKnight(new Cavalier(new Couleur(0),Position.getPosition(6,7),3));
	}

	public void letsPlay()
	{

	}

	public boolean  coupValide(Piece pieceD,Position posD,Piece pieceA,Position posA,int coupSpecial)
	{
		
		return false;
	}
	
	public boolean addMove(Coup e) 
	{
		return listOfMove.add(e);
	}

	public void setListOfMovep1(LinkedList<Coup> listOfMovep1) 
	{
		this.listOfMovep1 = listOfMovep1;
	}

	public LinkedList<Coup> getListOfMovep1() 
	{
		return listOfMovep1;
	}

	public void setListOfMovep2(LinkedList<Coup> listOfMovep2)
	{
		this.listOfMovep2 = listOfMovep2;
	}

	public LinkedList<Coup> getListOfMovep2() 
	{
		return listOfMovep2;
	}
	
	/**
	 * @return the listOfMoveCancelled
	 */
	public LinkedList<Coup> getListOfMoveCancelled()
	{
		return listOfMoveCancelled;
	}
	
	public JoueurAbstract getJoueur(int i)
	{
		return this.listOfPlayer.get( i );
	}
	
	/**
	 * @param listOfMoveCancelled the listOfMoveCancelled to set
	 */
	public void setListOfMoveCancelled( LinkedList<Coup> listOfMoveCancelled )
	{
		this.listOfMoveCancelled = listOfMoveCancelled;
	}
}
