package fr.miblack.chess.com.jtuto.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings( "synthetic-access" )
public class PanneauJeu extends JPanel implements KeyListener, MouseListener , MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FenetreJeu frame = null;

	public PanneauJeu( FenetreJeu frame ) {
		this.frame = frame;
		setBackground( Color.WHITE );
		setLayout( null );
		initComponents( );
	}

	
	@Override
   public void mouseDragged( MouseEvent e ) {
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			/**int ev = 0;
			if (e.getButton( ) == MouseEvent.BUTTON1)
				ev = Constantes.BOUTON_GAUCHE_SOURIS_RELACHE;
			else if (e.getButton( ) == MouseEvent.BUTTON2)
				ev = Constantes.BOUTON_MOLETTE_SOURIS_RELACHE;
			else if (e.getButton( ) == MouseEvent.BUTTON3)
				ev = Constantes.BOUTON_DROIT_SOURIS_RELACHE;**/
			ge.gereEvenement( frame.getName( ) , Constantes.SOURIS_EN_GLISSER_DEPOSER , null , e.getPoint( ).x ,
			      e.getPoint( ).y );
		}
   }

	@Override
   public void mouseMoved( MouseEvent e ) {
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			/**int ev = 0;
			if (e.getButton( ) == MouseEvent.BUTTON1)
				ev = Constantes.BOUTON_GAUCHE_SOURIS_RELACHE;
			else if (e.getButton( ) == MouseEvent.BUTTON2)
				ev = Constantes.BOUTON_MOLETTE_SOURIS_RELACHE;
			else if (e.getButton( ) == MouseEvent.BUTTON3)
				ev = Constantes.BOUTON_DROIT_SOURIS_RELACHE;**/
			ge.gereEvenement( frame.getName( ) , Constantes.SOURIS_EN_MOUVEMENT , null , e.getPoint( ).x ,
			      e.getPoint( ).y );
		}
		
   }
	
	
	public void mouseReleased( MouseEvent evt ) {
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			int ev = 0;
			if (evt.getButton( ) == MouseEvent.BUTTON1)
				ev = Constantes.BOUTON_GAUCHE_SOURIS_RELACHE;
			else if (evt.getButton( ) == MouseEvent.BUTTON2)
				ev = Constantes.BOUTON_MOLETTE_SOURIS_RELACHE;
			else if (evt.getButton( ) == MouseEvent.BUTTON3)
				ev = Constantes.BOUTON_DROIT_SOURIS_RELACHE;
			ge.gereEvenement( frame.getName( ) , ev , null , evt.getPoint( ).x ,
			      evt.getPoint( ).y );
		}
	}

	public void mouseExited( MouseEvent evt ) {
	}

	public void mouseEntered( MouseEvent evt ) {
	}

	public void mouseClicked( MouseEvent evt ) {
		
		
		frame.requestFocus( );
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			int ev = 0;
			int nbClick = evt.getClickCount( );
			if (evt.getButton( ) == MouseEvent.BUTTON1) {
				if (nbClick == 1)
					ev = Constantes.CLICK_GAUCHE_SOURIS;
				else
					ev = Constantes.DOUBLE_CLICK_GAUCHE_SOURIS;
			} else if (evt.getButton( ) == MouseEvent.BUTTON2) {
				if (nbClick == 1)
					ev = Constantes.CLICK_MOLETTE_SOURIS;
				else
					ev = Constantes.DOUBLE_CLICK_MOLETTE_SOURIS;
			} else if (evt.getButton( ) == MouseEvent.BUTTON3) {
				if (nbClick == 1)
					ev = Constantes.CLICK_DROIT_SOURIS;
				else
					ev = Constantes.DOUBLE_CLICK_DROIT_SOURIS;
			}
			ge.gereEvenement( frame.getName( ) , ev , null , evt.getPoint( ).x ,
			      evt.getPoint( ).y );
		}
	}

	public void mousePressed( MouseEvent evt ) {
		frame.requestFocus( );
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			int ev = 0;
			if (evt.getButton( ) == MouseEvent.BUTTON1)
				ev = Constantes.BOUTON_GAUCHE_SOURIS_ENFONCE;
			else if (evt.getButton( ) == MouseEvent.BUTTON2)
				ev = Constantes.BOUTON_MOLETTE_SOURIS_ENFONCE;
			else if (evt.getButton( ) == MouseEvent.BUTTON3)
				ev = Constantes.BOUTON_DROIT_SOURIS_ENFONCE;
			ge.gereEvenement( frame.getName( ) , ev , null , evt.getPoint( ).x ,
			      evt.getPoint( ).y );
		}
	}

	private void initComponents() {
		this.setFocusable( false );
		this.addMouseListener( this );
		this.addMouseMotionListener( this );
		this.setRequestFocusEnabled( true );
		// Initialisation des 5 couches en Z order
		// la couche 0 est la couche du dessus
		// i.e la couche 0 est au dessus la couche 1
		
		for (int i = 0; i < 5; i++)
			lesCouches[i] = new HashMapList( );
	}

	public void raffraichirEcran() {
		repaint( );
	}

	@Override
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 4; i >= 0; i--) {
			HashMapList uneCouche = lesCouches[i];
			for (Dessinable d : uneCouche.lesDessinables( ))
			{
				try
				{
					d.dessine( g2 );
				}
				catch(ConcurrentModificationException e)
				{
				}
			}
		}
		invalidate( );
	}

	public void fixerCouleurElementDeDessin( String elementId , Couleur c ) {
		if (existeIdElementDeDessin( elementId )) {
			Dessinable d = elementsDeDessin.get( elementId );
			d.colorie( c );
		}
	}

	public void remplirElementDeDessin( String elementId , boolean plein ) {
		if (existeIdElementDeDessin( elementId )) {
			Dessinable d = elementsDeDessin.get( elementId );
			if (d instanceof Remplissable)
				((Remplissable) d).plein( plein );
		}
	}

	public void translaterElementDeDessin( String elementId , int dx , int dy ) {
		if (existeIdElementDeDessin( elementId )) {
			Dessinable d = elementsDeDessin.get( elementId );
			if (d instanceof Translatable)
				((Translatable) d).translate( dx , dy );
		}
	}

	public String lireIdObjetSelectionne( int x , int y )
	{
		String id;
		for( int numCouche = 0; numCouche<5; numCouche++)
		{
		  id = lireIdObjectSelectionneSurCouche( numCouche , x , y );
		  if ( id !=  null ) return id;
		}
		return null;
	}
	
	private String lireIdObjectSelectionneSurCouche( int numCouche , int x , int y )
	{
		HashMap<?,?> lesObjets = lesCouches[ numCouche ];
		for( Object o : lesObjets.values( ) )
		{
			if ( o instanceof Selectionnable )
			{
			  if (((Selectionnable) o).contientCoordonnees( x , y ))
			        return ((Nommable)o).getId( );
			}
		}
		return null;
	}
	
	public void enregistreLigne( String id , int x1 , int y1 , int x2 , int y2 ,
	      Color c ) {
		Line l = new Line( );
		l.id = id;
		l.x1 = x1;
		l.x2 = x2;
		l.y1 = y1;
		l.y2 = y2;
		l.c = c;
		elementsDeDessin.put( id , l );
		lesCouches[0].put( id , l );
		raffraichirEcran( );
	}

	public void enregistreLigne( String id , int x1 , int y1 , int x2 , int y2 ,
	      Color c , int couche ) {
		Line l = new Line( );
		l.id = id;
		l.x1 = x1;
		l.x2 = x2;
		l.y1 = y1;
		l.y2 = y2;
		l.c = c;
		elementsDeDessin.put( id , l );
		if (couche > 4)
			couche = 4;
		if (couche < 0)
			couche = 0;
		lesCouches[couche].put( id , l );
		raffraichirEcran( );
	}

	public void enregistreTexte( String id , Font font , int x , int y ,
	      String text , Color c ) {
		Text t = new Text( );
		t.c = c;
		t.x = x;
		t.y = y;
		t.text = text;
		t.font = font;
		t.id = id;
		elementsDeDessin.put( id , t );
		lesCouches[0].put( id , t );
		raffraichirEcran( );
	}

	public void enregistreTexte( String id , Font font , int x , int y ,
	      String text , Color c , int couche ) {
		Text t = new Text( );
		t.c = c;
		t.x = x;
		t.y = y;
		t.text = text;
		t.font = font;
		t.id = id;
		elementsDeDessin.put( id , t );
		if (couche > 4)
			couche = 4;
		if (couche < 0)
			couche = 0;
		lesCouches[couche].put( id , t );
		raffraichirEcran( );
	}

	public void enregistreRectangle( String id , int x , int y , int largeur ,
	      int hauteur , Color c , boolean plein ) {
		Rectangle r = new Rectangle( );
		r.x = x;
		r.y = y;
		r.id = id;
		r.largeur = largeur;
		r.hauteur = hauteur;
		r.c = c;
		r.plein = plein;
		elementsDeDessin.put( id , r );
		lesCouches[0].put( id , r );
		raffraichirEcran( );
	}

	public void enregistreRectangle( String id , int x , int y , int largeur ,
	      int hauteur , Color c , boolean plein , int couche ) {
		Rectangle r = new Rectangle( );
		r.x = x;
		r.y = y;
		r.id = id;
		r.largeur = largeur;
		r.hauteur = hauteur;
		r.c = c;
		r.plein = plein;
		elementsDeDessin.put( id , r );
		if (couche > 4)
			couche = 4;
		if (couche < 0)
			couche = 0;
		lesCouches[couche].put( id , r );
		raffraichirEcran( );
	}

	public void enregistreOval( String id , int x , int y , int largeur ,
	      int hauteur , Color c , boolean plein ) {
		Oval r = new Oval( );
		r.x = x - largeur / 2;
		r.y = y - hauteur / 2;
		r.id = id;
		r.largeur = largeur;
		r.hauteur = hauteur;
		r.c = c;
		r.plein = plein;
		elementsDeDessin.put( id , r );
		lesCouches[0].put( id , r );
		raffraichirEcran( );
	}

	public void enregistreOval( String id , int x , int y , int largeur ,
	      int hauteur , Color c , boolean plein , int couche ) {
		Oval r = new Oval( );
		r.x = x - largeur / 2;
		r.y = y - hauteur / 2;
		r.id = id;
		r.largeur = largeur;
		r.hauteur = hauteur;
		r.c = c;
		r.plein = plein;
		elementsDeDessin.put( id , r );
		if (couche > 4)
			couche = 4;
		if (couche < 0)
			couche = 0;
		lesCouches[couche].put( id , r );
		raffraichirEcran( );
	}

	public void enregistreTriangle( String id , int x1 , int y1 , int x2 ,
	      int y2 , int x3 , int y3 , Color c , boolean plein ) {
		Triangle t = new Triangle( );
		t.x1 = x1;
		t.x2 = x2;
		t.x3 = x3;
		t.y1 = y1;
		t.y2 = y2;
		t.y3 = y3;
		t.init( );
		t.c = c;
		t.plein = plein;
		elementsDeDessin.put( id , t );
		lesCouches[0].put( id , t );
		raffraichirEcran( );
	}

	public void enregistreTriangle( String id , int x1 , int y1 , int x2 ,
	      int y2 , int x3 , int y3 , Color c , boolean plein , int couche ) {
		Triangle t = new Triangle( );
		t.x1 = x1;
		t.x2 = x2;
		t.x3 = x3;
		t.y1 = y1;
		t.y2 = y2;
		t.y3 = y3;
		t.c = c;
		t.init( );
		t.plein = plein;
		elementsDeDessin.put( id , t );
		lesCouches[couche].put( id , t );
		raffraichirEcran( );
	}
	
	
	public void enregistreImage( String id , int x , int y, int largeur, int hauteur, String fichierImage , int numCouche )
	{
		Image img = new Image( id , x ,y , largeur , hauteur ,fichierImage , numCouche );
		elementsDeDessin.put(  id , img );
		lesCouches[  numCouche ].put( id , img  );
		raffraichirEcran();
	}
	
	
	public void fixerImageDeFond( String fichierImage )
	{
	   enregistreImage("#fondEcran",0,0,this.getWidth( ), this.getHeight( ),fichierImage,4);  	
	}
	
	

	public String lireTexteComposant( String nom ) {
		boolean ok = composantsSwing.containsKey( nom );
		String result = null;
		if (ok) {
			JComponent jc = composantsSwing.get( nom );
			if (jc instanceof JTextField)
				result = ((JTextField) jc).getText( );
			if (jc instanceof JLabel)
				result = ((JLabel) jc).getText( );
			if (jc instanceof JButton)
				result = ((JButton) jc).getText( );
		}
		return result;
	}

	public boolean ecrireTexteComposant( String nom , String texte ) {
		boolean ok = composantsSwing.containsKey( nom );
		if (ok) {
			JComponent jc = composantsSwing.get( nom );
			if (jc instanceof JTextField)
				((JTextField) jc).setText( texte );
			if (jc instanceof JLabel)
				((JLabel) jc).setText( texte );
			if (jc instanceof JButton)
				((JButton) jc).setText( texte );
			jc.repaint( );
		}
		return ok;
	}

	public void effacer() {
		composantsSwing.clear( );
		this.removeAll( );
		elementsDeDessin.clear( );
		for (int i = 0; i < 5; i++)
			lesCouches[i].clear( );
		raffraichirEcran( );
	}

	public boolean existeIdElementDeDessin( String id ) {
		return elementsDeDessin.containsKey( id );
	}

	public boolean existeIdComposant( String id ) {
		return composantsSwing.containsKey( id );
	}

	public boolean retirerElement( String id ) {
		boolean ok = elementsDeDessin.containsKey( id );
		if (ok) {
			// On doit le retirer de sa couche egalement;
			Dessinable d = elementsDeDessin.get( id );
			lesCouches[d.numCouche( )].remove( id );
			elementsDeDessin.remove( id );
			raffraichirEcran( );
		}
		return ok;
	}

	public void retirerElementsParCouche( int numCouche )
	{
		for( Object id : lesCouches[ numCouche ].keySet( ) )
		{
			elementsDeDessin.remove( (String)id );
		}
		lesCouches[ numCouche ].clear( );
		raffraichirEcran( );
	}
	
	public void retirerElementParPattern( String regex ) {
		int taille = elementsDeDessin.size( );
		String[] ids = new String[taille];
		elementsDeDessin.keySet( ).toArray( ids );
		for (int i = 0; i < taille; i++)
			if (ids[i].matches( regex ))
				elementsDeDessin.remove( ids[i] );
		raffraichirEcran( );
	}

	public boolean fixerDisponibilite( String nomComposant , boolean dispo ) {
		boolean ok = composantsSwing.containsKey( nomComposant );
		if (ok) {
			JComponent jc =  composantsSwing.get( nomComposant );
			jc.setEnabled( dispo );
		}
		return ok;
	}

	public boolean lireDisponibilite( String nomComposant ) {
		boolean ok = composantsSwing.containsKey( nomComposant );
		if (ok) {
			JComponent jc =  composantsSwing.get( nomComposant );
			return jc.isEnabled( );
		}
		return false;
	}

	public JComponent lireComposantSwing( String nom )
	{
		boolean ok = composantsSwing.containsKey( nom );
		if (ok) {
			JComponent jc = composantsSwing.get( nom );
			return jc;
		}
		return null;
	}
	
	public boolean retirerComposant( String nom ) {
		boolean ok = composantsSwing.containsKey( nom );
		if (ok) {
			JComponent jc = composantsSwing.get( nom );
			this.remove( jc );
			composantsSwing.remove( nom );
			raffraichirEcran( );
		}
		return ok;
	}

	public boolean enregistrerComposant( String nom , JComponent jc ) {
		boolean ok = !composantsSwing.containsKey( nom );
		if (ok) {
			composantsSwing.put( nom , jc );
		}
		return ok;
	}
	private HashMap<String, Dessinable> elementsDeDessin = new HashMap<String, Dessinable>();
	private HashMap<String, JComponent> composantsSwing = new HashMap<String, JComponent>( );
	private HashMapList lesCouches[] = new HashMapList[5];
	private Couleur couleurDeSelection = Couleur.ROUGE;
	
	
	

	private class Line implements Dessinable, Nommable, Translatable {
		public String id;
		public int couche = 0;
		public int x1, y1, x2, y2;
		public Color c;

		public int numCouche() {
			return couche;
		}
		
		@Override
      public int getX() {
	      return x1;
      }

		@Override
      public int getY() {
	      return y1;
      }

		public void dessine( Graphics2D g2 ) {
			Color cb = g2.getColor( );
			g2.setColor( c );
			g2.drawLine( x1 , y1 , x2 , y2 );
			g2.setColor( cb );
		}

		public String getId() {
			return id;
		}

		public void colorie( Couleur c ) {
			this.c = c;
		}

		public void translate( int dx , int dy ) {
			x1 += dx;
			y1 += dy;
			x2 += dx;
			y2 += dy;
		}

		@Override
      public void translateTo( int x , int y ) {
	      int dx = x - x1;
	      int dy = y - y1;
	      translate( dx , dy );
      }
	}
	private class Text implements Dessinable, Nommable, Translatable {
		public String id;
		public int couche = 0;
		public int x, y;
		public String text;
		public Color c;
		public Font font;

		public int numCouche() {
			return couche;
		}
		
		@Override
      public void translateTo( int x , int y ) {
	      int dx = x - this.x;
	      int dy = y - this.y;
	      translate( dx , dy );
      }
		@Override
      public int getX() {
	      return x;
      }

		@Override
      public int getY() {
	      return y;
      }
		public void dessine( Graphics2D g2 ) {
			Color cb = g2.getColor( );
			g2.setColor( c );
			g2.setFont( font );
			g2.drawString( text , x , y );
			g2.setColor( cb );
		}

		public void colorie( Couleur c ) {
			this.c = c;
		}

		public void translate( int dx , int dy ) {
			x += dx;
			y += dy;
		}

		public String getId() {
			return id;
		}
	}
	private class Oval implements Dessinable, Remplissable, Nommable,
	      Translatable, Selectionnable {
		public String id;
		public int couche = 0;
		public boolean plein;
		public int x, y;
		public int hauteur;
		public int largeur;
		public Color c;
      public boolean selectionne = false;
		
		public int numCouche() {
			return couche;
		}

		 public void translateTo( int x , int y ) {
		      int dx = x - this.x;
		      int dy = y - this.y;
		      translate( dx , dy );
	      }
			
		@Override
      public int getX() {
	      return x;
      }

		@Override
      public int getY() {
	      return y;
      }
		public void dessine( Graphics2D g2 ) {
			Color cb = g2.getColor( );
			if (!plein) {
				if ( ! selectionne ) g2.setColor( c );else g2.setColor( getCouleurDeSelection());
				g2.drawOval( x , y , largeur , hauteur );
			} else {
				g2.setColor( c );
				g2.fillOval( x , y , largeur , hauteur );
				if ( selectionne )
				{
					g2.setColor( getCouleurDeSelection() );
					g2.drawOval( x , y , largeur , hauteur );			
				}
			}
			g2.setColor( cb );
		}

		public void colorie( Couleur c ) {
			this.plein = true;
			this.c = c;
		}

		public void plein( boolean b ) {
			plein = b;
		}

		public void translate( int dx , int dy ) {
			x += dx;
			y += dy;
		}

		public String getId() {
			return id;
		}

		@Override
      public boolean contientCoordonnees( int sx , int sy ) {
	      return ( (sx*sx)/(largeur*largeur/4) + (sy*sy)/(hauteur*hauteur/4)<1);
      }

		@Override
      public void fixerSelection( boolean selection ) {
	      selectionne = selection;
      }

		@Override
      public boolean lireSelection() {
	      return selectionne;
      }
	}
	private class Rectangle implements Dessinable, Remplissable, Nommable,
	      Translatable, Selectionnable {
		public String id;
		public int couche = 0;
		public boolean plein;
		public int x, y;
		public int hauteur;
		public int largeur;
		public Color c;
		public boolean selectionne;

		public int numCouche() {
			return couche;
		}

		 public void translateTo( int x , int y ) {
		      int dx = x - this.x;
		      int dy = y - this.y;
		      translate( dx , dy );
	      }
			
		@Override
      public int getX() {
	      return x;
      }

		@Override
      public int getY() {
	      return y;
      }
		public void dessine( Graphics2D g2 ) {
			Color cb = g2.getColor( );
			if (!plein) {
				if ( ! selectionne ) g2.setColor( c ); else g2.setColor( getCouleurDeSelection());
				g2.drawRect( x , y , largeur , hauteur );
			} else {
				g2.setColor( c );
				g2.fillRect( x , y , largeur , hauteur );
				if ( selectionne )
				{
					g2.setColor(  getCouleurDeSelection() );
					g2.drawRect( x , y , largeur , hauteur );
				}
			}
			g2.setColor( cb );
		}

		public void colorie( Couleur c ) {
			this.plein = true;
			this.c = c;
		}

		public void plein( boolean b ) {
			plein = b;
		}

		public void translate( int dx , int dy ) {
			x += dx;
			y += dy;
		}

		public String getId() {
			return id;
		}

		@Override
      public boolean contientCoordonnees( int x , int y ) {
	      return ( (this.x < x) && (this.y < y) && (x < this.x+largeur) && ( y < this.y + hauteur) );
	   }

		@Override
      public void fixerSelection( boolean selection ) {
	      selectionne = selection;
      }

		@Override
      public boolean lireSelection() {
	      return selectionne;
      }
	}
	private class Triangle implements Dessinable, Remplissable, Nommable,
	      Translatable , Selectionnable  {
		public String id;
		public int couche = 0;
		public boolean plein;
		public int x1, y1, x2, y2, x3, y3;
		public Color c;
		private Polygon t = new Polygon( );

		public void init() {
			t.addPoint( x1 , y1 );
			t.addPoint( x2 , y2 );
			t.addPoint( x3 , y3 );
			
		}

		public int numCouche() {
			return couche;
		}

		
		 public void translateTo( int x , int y ) {
		      int dx = x - x1;
		      int dy = y - y1;
		      translate( dx , dy );
	   }
			
		public void dessine( Graphics2D g2 ) {
			Color cb = g2.getColor( );
			if (!plein) {
				if ( ! selectionne ) g2.setColor( c ); else g2.setColor( getCouleurDeSelection() );
				g2.draw( t );
			} else {
		 
				g2.setColor( c );
				g2.fillPolygon( t );
				if ( selectionne )
				{
					g2.setColor( getCouleurDeSelection() );
					g2.draw( t );
				}
			}
			g2.setColor( cb );
		}

		public void colorie( Couleur c ) {
			this.plein = true;
			this.c = c;
		}

		public void plein( boolean b ) {
			plein = b;
		}

		public void translate( int dx , int dy ) {
			x1 += dx;
			y1 += dy;
			x2 += dx;
			y2 += dy;
			x3 += dx;
			y3 += dy;
		}

		public String getId() {
			return id;
		}

		@Override
      public int getX() {
	      return x1;
      }

		@Override
      public int getY() {
	      return y1;
      }

		@Override
      public boolean contientCoordonnees( int x , int y ) {
	      return t.contains(  new Point( x , y ) );
      }

		public boolean selectionne;
		@Override
      public void fixerSelection( boolean selection ) {
	      selectionne = selection;
      }

		@Override
      public boolean lireSelection() {
	      return selectionne;
      }
	}
	
	/**
	 * 
	 * @author Olivier
	 *
	 */
	class Image implements Dessinable , Nommable, Translatable , Selectionnable {

		public int x,y;
		public int largeur, hauteur;
		public BufferedImage image = null;
		public String id;
		public int numCouche;
		public Couleur c;
		public boolean selectionne = false;
		
		public Image( String id , int x , int y, int largeur, int hauteur, String fichierImage , int numCouche ) {
    		
		   try {
		   	   this.id = id;
		   	   this.x = x;
		   	   this.y = y;
		   	   this.largeur = largeur;
		   	   this.hauteur = hauteur;
		   	   this.numCouche = numCouche;
		         image = ImageIO.read(new File(fichierImage));
		         /** int imgLargeur = img.getWidth( );
		         int imgHauteur = img.getHeight( );
		         double factX = largeur / imgLargeur;
		         double factY = hauteur / imgHauteur;
		         AffineTransformOp ato = new AffineTransformOp( 
		         		new AffineTransform( factX , 0 , 0 , factY , 0 , 0 ) , AffineTransformOp.TYPE_BICUBIC);
		         image = ato.createCompatibleDestImage( img , img.getColorModel( ) );
		         **/
		   } catch (IOException e) {
		   	e.printStackTrace( );
		   }
		}
	
		@Override
      public void colorie( Couleur c ) {
         this.c = c;
      }

		@Override
      public void dessine( Graphics2D g2 ) {
			if ( image != null )
			{ g2.drawImage( image , x ,y , largeur, hauteur, (PanneauJeu.this) );
			  if ( selectionne )
				{
				  g2.setColor( getCouleurDeSelection() );
				  g2.drawRect( x , y , largeur , hauteur );
				}
			}
			else
			{
				g2.setColor( c );
				g2.drawRect( x , y , largeur , hauteur );
				g2.drawLine( x , y , x+largeur-1 , y+hauteur-1 );
				g2.drawLine( x , y + hauteur-1 , x+largeur-1 , y );
				
			}
	      
      }

		@Override
      public int numCouche() {
	      return this.numCouche;
      }

		@Override
      public String getId() {
	      return id;
      }

		@Override
      public int getX() {
	      return x;
      }

		@Override
      public int getY() {
	      return y;
      }

		@Override
      public void translate( int dx , int dy ) {
	      x = x+dx;
	      y = y+dy;
      }

		@Override
      public void translateTo( int x , int y ) {
	      this.x = x;
	      this.y = y;
      }

		@Override
      public boolean contientCoordonnees( int x , int y ) {
	      return ( (this.x < x) && (this.y < y) && (x < this.x+largeur) && ( y < this.y + hauteur) );
      }

		@Override
      public void fixerSelection( boolean selection ) {
	      this.selectionne = selection;
      }

		@Override
      public boolean lireSelection() {
	      return selectionne;
      }
		
	}
	
	
	
	
	public interface Dessinable {
		public void dessine( Graphics2D g2 );

		public void colorie( Couleur c );

		public int numCouche();
	}
	private interface Remplissable {
		public void plein( boolean b );
	}
	private interface Nommable {
		public String getId();
	}
	private interface Translatable {
		public void translate( int dx , int dy );
		public int getX();
		public int getY();
		public void translateTo( int x, int y );
	}
	
	private interface Selectionnable {
		public boolean contientCoordonnees( int x , int y );
		public void fixerSelection( boolean selection );
		public boolean lireSelection();
	}

	@Override
	public void keyPressed( KeyEvent e ) {
		gereTouche( e , Constantes.TOUCHE_APPUYEE );
	}

	@Override
	public void keyReleased( KeyEvent e ) {
		gereTouche( e , Constantes.TOUCHE_RELACHEE );
	}

	@Override
	public void keyTyped( KeyEvent e ) {
		gereTouche( e , Constantes.TOUCHE_ENFONCEE );
	}

	private void gereTouche( KeyEvent ev , int typeEvt ) {
		
		GestionnaireEvenements ge = frame.lireGestionnaireEvenements( );
		if (ge != null) {
			String touche = "" +ev.getKeyCode( )+";"+ev.getKeyChar( );
			String modificateur = getModificateur( ev ).trim( );
			if ( modificateur.equals("")) modificateur = "null";
			ge.gereEvenement( frame.getName( ) , typeEvt , modificateur +";"+ touche ,
			      0 , 0 );
		}
	}

	private String getModificateur( KeyEvent ev ) {
		int modif = ev.getModifiers( );
		switch (modif) {
			case InputEvent.CTRL_MASK:
				return "CTRL ";
			case InputEvent.ALT_MASK:
				return "ALT ";
			case InputEvent.SHIFT_MASK:
				return "MAJ ";
		}
		return "";
	}
	
	private ArrayList<ThreadTranslateur> lesThreads = new ArrayList<ThreadTranslateur>();
	
	public void animerFormeJusqua( String idForme , int x , int y , int nbAnimations , int delai , boolean bloquant)
	{
      Object forme = elementsDeDessin.get(  idForme );
      ThreadTranslateur tt = null;
      if ( forme != null )
		if ( forme instanceof Translatable )
		{
		 
			tt = new ThreadTranslateur((Translatable)forme , x , y , nbAnimations , delai , bloquant );
		     
			if ( bloquant )
			{
				synchronized( lesThreads)
		     {
			    lesThreads.add( tt );
		     }
			
		   }
			tt.start( );
		}
	}
	
	
	

	
   class ThreadTranslateur extends Thread  {
       
   	 private Translatable forme;
       private int xDestination, yDestination;
       private int nbAnimations;
       private int delai;
   	 private boolean bloquant;
       
   	 public ThreadTranslateur( Translatable forme , int xDestination ,
            int yDestination , int nbAnimations , int delai , boolean bloquant ) {
	      super( );
	      this.forme = forme;
	      this.xDestination = xDestination;
	      this.yDestination = yDestination;
	      this.nbAnimations = nbAnimations;
	      this.delai = delai;
	      this.bloquant = bloquant;
      }


		public void run()
   	{

			
			double dXDepart = forme.getX();
			double dYDepart = forme.getY( );
			double dXDest = xDestination;
			double dYDest = yDestination;
			double deltaX = ( dXDest - dXDepart ) / nbAnimations;
			double deltaY = ( dYDest - dYDepart ) / nbAnimations;
			
			if ( bloquant )
			{
			   // on attends que ce thread soit le premier dans la liste
				// c'est a dire que le precedent ait termine
				synchronized( lesThreads )
				{
				 int index = -1;
				 while( index != 0 )
				 {
					 index = lesThreads.indexOf( this );
				    try {
				   	 Thread.sleep( 10 );
				   	 lesThreads.wait( 10 );
				    }
				    catch( Exception e ) {}
				 }
				}
			}
			
			for( int i = 0; i < nbAnimations ; i++)
			{
			   dXDepart += deltaX;
			   dYDepart += deltaY;
			   forme.translateTo( (int)Math.round( dXDepart ) , (int)Math.round( dYDepart ) );  
			   (PanneauJeu.this).raffraichirEcran( );
			   try {
			      Thread.sleep( delai );
			   } catch ( Exception e )
			   { e.printStackTrace( );  };
			}
			
			if ( bloquant )
			// on retire le thread de la liste : il est forcement en position 0
			synchronized( lesThreads )
			{
				lesThreads.remove(0);
			}
   		 	 
   	}
   	
   }


   // Gestion de la selection
   
   public void selectionnerObjet( String id )
   {
   	if (existeIdElementDeDessin( id )) {
			Dessinable d = elementsDeDessin.get( id );
			if ( d instanceof Selectionnable )
			{
				((Selectionnable) d).fixerSelection( true );
			}
   	}
   	raffraichirEcran( );
   }
   
   
   public void deselectionnerObjet( String id )
   {
   	if (existeIdElementDeDessin( id )) {
			Dessinable d = elementsDeDessin.get( id );
			if ( d instanceof Selectionnable )
			{
				((Selectionnable) d).fixerSelection( false );
			}
   	}
   	raffraichirEcran( );
   }
   
   public void fixerCouleurDeSelection( Couleur c )
   {
   	this.couleurDeSelection = c;
   }
   
   public Couleur lireCouleurDeSelection()
   {
     return couleurDeSelection ;	
   }
   
   public Couleur getCouleurDeSelection()
	{
		return couleurDeSelection;
	}


	public void setCouleurDeSelection( Couleur couleurDeSelection )
	{
		this.couleurDeSelection = couleurDeSelection;
	}




   
}