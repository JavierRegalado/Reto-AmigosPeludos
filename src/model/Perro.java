package model;

public class Perro extends Animal {
	
	private String tamano;
	private boolean entrenado = false;
	
	public Perro() {
		
	}
	
	public Perro(String nombre, String raza, int edad, boolean disponibilidad, String centro, boolean sano, String tamano, boolean entrenado) {
		
		super(nombre, raza, edad, disponibilidad, centro, sano);
		this.tamano = tamano;
		this.entrenado = entrenado;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public boolean isEntrenado() {
		return entrenado;
	}

	public void setEntrenado(boolean entrenado) {
		this.entrenado = entrenado;
	}
	
	public void realizarEntrenamiento() {
		String mensaje;
		
		if(!entrenado) {
			this.entrenado = true;
			mensaje = this.getNombre()+" ha aprendido ordenes basicas";
		}else {
			mensaje = this.getNombre()+" ya esta entrenado";
		}
	}

	@Override
	public String toString() {
		return super.toString()+"Perro [tamano=" + tamano + ", entrenado=" + entrenado + "]";
	}
}