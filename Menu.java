import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Wendy Esquivel A01633483 100% 
//Jose Antonio A01351215 0%

public class Menu extends JPanel{
	private JLabel lblPuntuaciones,
				   lblTurno;
	
	private Tablero tab;
	private Jugador[] jugadores;
	
	
	public Menu(Tablero tab, Jugador[] jugadores) {
		super();
		this.tab = tab;
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(150, 600));
		this.lblTurno=new JLabel("- Jugador en turno -");
		this.lblPuntuaciones=new JLabel("- Puntuaciones -");
		this.jugadores= tab.Getjug();
		
		this.add(lblTurno);	
		this.add(lblPuntuaciones);		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.pintaLabelsJugadores(g);
		this.pintaLabelsTurno(g);	
	}
	
	public void pintaLabelsTurno(Graphics g){
		JLabel labelT = new JLabel(this.jugadores[tab.getTurno()].getNombre());
	}
	
	public void pintaLabelsJugadores(Graphics g) {
		if(tab.getNumJ() == 1) {
			this.jugadores[0] = new Jugador(tab.getNomJ1());
			JLabel label1= new JLabel(" < "+this.jugadores[0].getNombre()+": "+this.jugadores[0].getScore()+" > ");
			this.add(label1);
		}else if(tab.getNumJ() == 2) {
			this.jugadores[0] = new Jugador(tab.getNomJ1());
			this.jugadores[1] = new Jugador(tab.getNomJ2());
			JLabel label1= new JLabel(" < "+this.jugadores[0].getNombre()+": "+this.jugadores[0].getScore()+" > ");
			JLabel label2= new JLabel(" < "+this.jugadores[1].getNombre()+": "+this.jugadores[1].getScore()+" > ");
			this.add(label1);
			this.add(label2);
		}else if(tab.getNumJ() == 3)  {
			this.jugadores[0] = new Jugador(tab.getNomJ1());
			this.jugadores[1] = new Jugador(tab.getNomJ2());
			this.jugadores[2] = new Jugador(tab.getNomJ3());
			JLabel label1= new JLabel(" < "+this.jugadores[0].getNombre()+": "+this.jugadores[0].getScore()+" > ");
			JLabel label2= new JLabel(" < "+this.jugadores[1].getNombre()+": "+this.jugadores[1].getScore()+" > ");
			JLabel label3= new JLabel(" < "+this.jugadores[2].getNombre()+": "+this.jugadores[2].getScore()+" > ");
			this.add(label1);
			this.add(label2);
			this.add(label3);
		}
	}
	
	public void pintaGanador(Graphics g) {
		tab.winner();
	}
}
