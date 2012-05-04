package fr.miblack.chess;

import fr.miblack.chess.GUI.Textuelle;

public class Main
{
	public static void main(String[] args)
	{
			if(args.length==0)
			{
				Textuelle guiTxt=new Textuelle();
				guiTxt.jouerPartie();
			}
			
		
	}



}
