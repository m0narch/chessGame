package fr.miblack.chess;
import java.util.LinkedList;

import fr.miblack.chess.color.Couleur;

public class Position
{

	private static LinkedList<Position> listPos=new LinkedList<Position>();

	private int x;
	private int y;

	public Position(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	public int getColor()
	{
		if(((x+y)%2)==1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public  int getX()
	{
		return this.x;
	}

	public  int getY()
	{
		return this.y;
	}

	

	public void setX(int x)
	{
		this.x=x;
	}

	public void setY(int y)
	{
		this.y=y;
	}

	public boolean equals(Position pos)
	{
		return 	( ( this.getX()==pos.getX() ) && ( this.getY()==pos.getY() ) );
	}

	public String toString()
	{
		if(getColor()==1)
		{
			//return ".";
			return  Couleur.ANSI_WHITE+".";
		}
		else
		{
			//return ".";
			return  Couleur.ANSI_RED+".";
		}
	}

	public static Position getPosition(int x,int y)
	{
			Position a;
			if(valValide(x) && valValide(y))
			{
				for(Position myPos :listPos)
				{
					if((myPos.getX()==x)&& (myPos.getY()==y))
						return myPos;
				}
				a=new Position(x,y);
				listPos.add(a);
				return a;
			}
			throw new RuntimeException(x + ", " + y + " : coordonnées  invalide");
	}

	public static boolean valValide(int a) 
	{
		if((a>=0)&&(a<8))
		{
			return true;
		}
		return false;
	}

	public static int instanceOfPos()
	{
		return listPos.size();
	}

	public String toStringPos()
	{
		return  ""+(char)(this.x+97)+ (this.y+1);
	}
	
	public static Position stringToPos(String pos)
	{
		int x = 0;
		int y = 0;
		if(pos.charAt( 0 )>= 'a' && pos.charAt( 0 )<= 'h'  )
		{
			x=pos.charAt( 0 )-97;
			if(pos.charAt( 1 )>= '1' && pos.charAt( 1 )<= '8'  )
			{
				y=(int)pos.charAt( 1 )-'1';
				return Position.getPosition( x, y );
			}
		}
		throw new RuntimeException(pos+" Position invalide");
	}

	public static LinkedList<Position> listPosit()
	{
		return listPos;
	}

}
