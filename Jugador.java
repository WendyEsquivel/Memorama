//Wendy Esquivel A01633483 100% 
//Jose Antonio A01351215 0%

public class Jugador {
	private String nombre;
	private int score;
	
	// SETTERS
	public Jugador(String nombre) {
		this.nombre=nombre;
		this.score=0;
	}
	
	public void setScore(int score) {
		this.score+=score;
	}
	
	//GETTERS	
	public String getNombre() {
		return this.nombre;
	}
	public int getScore() {
		return this.score;
	}
	
}
