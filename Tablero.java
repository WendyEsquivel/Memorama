import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//Wendy Esquivel A01633483 100% 
//Jose Antonio A01351215 0%

public class Tablero extends JPanel{
	private Carta[] cartas = new Carta[12];
	private Carta carta1,
				  carta2,
				  cartav1,
				  cartav2;
	private Jugador[] jugadores;
	

	private int paresEncontrados,
				numJ,
				turno;
	
	private Timer timer;
	private Menu menu;
	
	Tablero(Jugador[] jugadores){
		super();
		this.menu = menu;
		this.setBackground(Color.WHITE);
		this.paresEncontrados = 0;
		this.turno = 0;
		this.menu = menu;
		JFrame frame = new JFrame();
	    Icon frtP = new ImageIcon("1p.png");
	    Icon sndP = new ImageIcon("2p.png");
	    Icon trdP = new ImageIcon("3p.png");
	    Object imgP[] = {frtP, sndP,trdP};
	    int noP=JOptionPane.showOptionDialog(frame, "¿Cuantos jugadores?", "Seleccion de jugadores",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, imgP, imgP[0]);
	    this.numJ = noP+1;
	    this.jugadores = new Jugador[numJ];
	    for(int i=0;i<numJ;i++) {
	    	this.jugadores[i] = new Jugador(JOptionPane.showInputDialog(null, "Jugador "+(i+1)));
	    }
	    
	    		
		// Crea cartas
		setLayout(new GridLayout(3,4,10,10));
		this.cartas[0] = new Carta("estrella",new ImageIcon("estrella.jpg").getImage(),this);
		this.cartas[1] = new Carta("estrella",new ImageIcon("estrella.jpg").getImage(),this);
		this.cartas[2] = new Carta("triangulo",new ImageIcon("triangulo.png").getImage(),this);
		this.cartas[3] = new Carta("triangulo",new ImageIcon("triangulo.png").getImage(),this);
		this.cartas[4] = new Carta("circulo",new ImageIcon("circulo.png").getImage(),this);
		this.cartas[5] = new Carta("circulo",new ImageIcon("circulo.png").getImage(),this);
		this.cartas[6] = new Carta("corazon",new ImageIcon("corazon.jpg").getImage(),this);
		this.cartas[7] = new Carta("corazon",new ImageIcon("corazon.jpg").getImage(),this);
		this.cartas[8] = new Carta("cruz",new ImageIcon("cruz.png").getImage(),this);
		this.cartas[9] = new Carta("cruz",new ImageIcon("cruz.png").getImage(),this);
		this.cartas[10] = new Carta("exagono",new ImageIcon("exagono.jpg").getImage(),this);
		this.cartas[11] = new Carta("exagono",new ImageIcon("exagono.jpg").getImage(),this);
		
		// Mezcla y agrega cartas al tablero
		mezclar(cartas);	
		for(int i=0; i<this.cartas.length; i++){
			this.add(cartas[i]);
			}

		// Timer para voltear cartas
		timer = new Timer(250, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	cartav1.cerrar();
				cartav2.cerrar();
	        }
	    });				
		timer.setRepeats(false);
		
	}	
	/*
	public void repaintMenu(){
		this.menu.repaint();
	}*/
	
	//GETTERS
	public int getNumJ() {
		return this.numJ;
	}
	
	public String getNomJ1() {
		return jugadores[0].getNombre();
	}
	
	public String getNomJ2() {
		return jugadores[1].getNombre();
	}
	
	public String getNomJ3() {
		return jugadores[2].getNombre();
	}
		
	public int getScoreJ1() {
		return jugadores[0].getScore();
	}
	
	public int getScoreJ2() {
		return jugadores[1].getScore();
	}
	
	public int getScoreJ3() {
		return jugadores[2].getScore();
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public void mezclar(Carta[] cartas) {
		Random ran = new Random();
		int pos;
		Carta tmp;
		for(int i=0; i<this.cartas.length; i++){
			pos = ran.nextInt(12);
			tmp=this.cartas[i];
			this.cartas[i]=this.cartas[pos];
			this.cartas[pos]=tmp;
		}
	}
	public void Setjug(Jugador[] a) {
		this.jugadores= a;
	}
	
	public Jugador[] Getjug() {
		return this.jugadores;
	}

	public void setCarta1(Carta carta1) {
		this.carta1=carta1;
	}
	public void setCarta2(Carta carta2) {
		this.carta2=carta2;
	}
	
	public void settearCarta(Carta carta){
		if(this.carta1==null) {
			setCarta1(carta);
			System.out.println("Elegiste: " + carta1);
		}else{
			setCarta2(carta);
			System.out.println("Elegiste: " + carta2);
			voltearCartas();
			validarFinJuego();
			
		}
		if(this.carta2==carta) {			
			this.carta1=null;
			this.carta2=null;
		}
	}

	public void voltearCartas(){	
		if(carta2.equals(carta1)) {
				carta2.parEncontrado();
				carta1.parEncontrado();
				paresEncontrados++;
				jugadores[this.turno].setScore(1);
				System.out.println("Turno de: " + jugadores[this.turno].getNombre());
				System.out.println("Score: " + jugadores[this.turno].getScore());
			}else{
				this.cartav1 = this.carta1;
				this.cartav2 = this.carta2;
				this.timer.start();
				System.out.println("Turno de: " + jugadores[this.turno].getNombre()); 
				this.turno++;
				if(this.turno >= this.numJ) {
					this.turno = 0;	
				}
			}	
	}
	
	public String winner() {
		int scorej1,scorej2,scorej3;
		String winner;
		scorej1=0;
		scorej2=0;
		scorej3=0;
		winner ="...";
		if(jugadores.length==1) {
			scorej1=jugadores[0].getScore();
		}else if(jugadores.length==2) {
			scorej1=jugadores[0].getScore();
			scorej2=jugadores[1].getScore();
		}else{
			scorej1=jugadores[0].getScore();
			scorej2=jugadores[1].getScore();
			scorej3=jugadores[2].getScore();
		}
		
		if(scorej1>scorej2 && scorej1>scorej3) {
			winner=jugadores[0].getNombre();
		}else if(scorej2>scorej1 && scorej2>scorej3) {
			winner=jugadores[1].getNombre();
		}else if(scorej3>scorej1 && scorej3>scorej2) {
			winner=jugadores[2].getNombre();
		}else {
			winner="¡Es un empate!";
		}
		System.out.println("Jugador 1: "+scorej1+" Jugador 2: "+scorej2+" Jugador 3: "+scorej3);
		return winner;
	}
	
	public void validarFinJuego() {
		if(paresEncontrados==6) {
			JOptionPane.showMessageDialog(null,"gano: "+ winner());
			
		}
	}
}
