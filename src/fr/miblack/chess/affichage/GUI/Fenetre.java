package fr.miblack.chess.affichage.GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.miblack.chess.Coup;
import fr.miblack.chess.Partie;





public class Fenetre extends JFrame
{
	private static final long	serialVersionUID	= 2097605447320723308L;
	private JTextArea zoneSaisie=new JTextArea();
	Partie maPartie;
	
	private JPanel monPanel=new JPanel( new BorderLayout() );
	private JPanel sud=new JPanel(new BorderLayout());
	private JButton boutonSend; 
	private EchiquierGraphique monEchiquier;
	

	public Fenetre(Partie maPartie)
	{
		this.maPartie=maPartie;
		monEchiquier=new EchiquierGraphique(maPartie);
		initialiserFenetre();
	}
	
	public void	initialiserFenetre()
	{
		setTitle("chessGame");
		setSize(800, 600);
		boutonSend= new JButton( "Envoyer"  );
		boutonSend.addActionListener( new BoutonListener() );
		monPanel.setBackground( new Color( 125, 125, 125 ) );

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		zoneSaisie.addKeyListener( new ClavierListener() );
		sud.add(zoneSaisie,BorderLayout.WEST );
		sud.add(boutonSend,BorderLayout.EAST );
		
		monPanel.add(monEchiquier,BorderLayout.CENTER);
		monPanel.add( sud ,BorderLayout.SOUTH);
		setContentPane( monPanel );
		setVisible(true);
	}
	
	

	public EchiquierGraphique getMonEchiquier()
	{
		return monEchiquier;
	}

	public void setMonEchiquier( EchiquierGraphique monEchiquier )
	{
		this.monEchiquier = monEchiquier;
	}
	
	public JTextArea getZoneSaisie()
	{
		return zoneSaisie;
	}

	public void setZoneSaisie( JTextArea zoneSaisie )
	{
		this.zoneSaisie = zoneSaisie;
	}

	public Partie getMaPartie()
	{
		return maPartie;
	}

	public void setMaPartie( Partie maPartie )
	{
		this.maPartie = maPartie;
	}

	public JPanel getMonPanel()
	{
		return monPanel;
	}

	public void setMonPanel( JPanel monPanel )
	{
		this.monPanel = monPanel;
	}

	public JPanel getSud()
	{
		return sud;
	}

	public void setSud( JPanel sud )
	{
		this.sud = sud;
	}

	public JButton getBoutonSend()
	{
		return boutonSend;
	}

	public void setBoutonSend( JButton boutonSend )
	{
		this.boutonSend = boutonSend;
	}


    class BoutonListener implements ActionListener
    { 
        public void actionPerformed(ActionEvent e) 
        {
        	getZoneSaisie().setText ("");
        }  
    }
    
 class ClavierListener implements KeyListener{
    	
		public void keyPressed(KeyEvent event) {
			//System.out.println("Code touche pressée : " + event.getKeyCode() + 
				//				" - caractère touche pressée : " + event.getKeyChar());
		}

		public void keyReleased(KeyEvent event) {
		//	System.out.println("Code touche relâchée : " + event.getKeyCode() + 
		//			" - caractère touche relâchée : " + event.getKeyChar());			
						
		}

		public void keyTyped(KeyEvent event) {
			//System.out.println("Code touche tapée : " + event.getKeyCode() + 
			//		" - caractère touche tapée : " + event.getKeyChar());
		}

		 
    }    
    
}
