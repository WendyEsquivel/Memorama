import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Wendy Esquivel A01633483 100% 
//Jose Antonio A01351215 0%

public class Memorama extends JFrame{
	
	public Memorama() {
		this.setTitle("Memorama");
	    // Memorama
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension screenSize = miPantalla.getScreenSize();
		int altura = screenSize.height;
		int ancho = screenSize.width;
		this.setBounds(ancho/4, altura/8, ancho/2, (altura/4)*3);
		setResizable(false);
		
		//this.add(new Tablero());	
		//Jugador jugadores = new Jugador();
				
		Tablero tablero = new Tablero(null);
		this.add(tablero);
		this.add(new Menu(tablero, null),BorderLayout.WEST);

			
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		Memorama ventana = new Memorama();
	}

}
