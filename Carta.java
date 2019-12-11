import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//Wendy Esquivel A01633483 100% 
//Jose Antonio A01351215 0%

public class Carta extends JPanel implements MouseListener{

	private String nombre;
	private boolean encontrada; // encontrada o no encontrada
	private boolean estado; // cerrada(false) o abierta(true)
	private Image imagen,
				  oculta;
	private Tablero tab;
	
	Carta(String nombre, Image imagen, Tablero tab) {
		super();
		this.setBackground(new Color(255, 220, 200));
		this.nombre = nombre;
		this.imagen=imagen;
		this.oculta=new ImageIcon("oculta.png").getImage();
		this.encontrada = false;
		this.estado = false;
		this.tab =tab;
		
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.pintaCarta(g);	
	}
	

	public boolean abrir() {
		if (this.estado == false) { 	//si está cerrada
			this.estado = true;		//abrela
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cerrar() { //se implementa en la par
		if(this.estado == true && this.encontrada == false) { //
			this.estado = false;
			this.repaint();
			return true;
		}else {
			return false;
		}
	}
	
	public void parEncontrado() {
		this.encontrada=true;
	}
	
	public void pintaCarta(Graphics g) {
		if(this.estado == true) {
			g.drawImage(this.imagen, 0, 0, this.getWidth(),this.getHeight(), this); 		
		}else {
			g.drawImage(this.oculta, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	public boolean equals(Carta carta) {
		if(this.nombre == carta.toString()) {
			return true;
		}else {
			return false;
		}		
	}
	
	public String toString() {
		return this.nombre;
	} 
	
	@Override
	public void mouseClicked(MouseEvent evt) {	
		if(evt.getSource() == this) {
			this.estado = true;
			repaint();	
			this.tab.settearCarta(this);
		}else {
			
		}
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
