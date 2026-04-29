package model;

public class Perro extends Animal {
	
	private String raza;
	private String tamano;
	private boolean entrenado;
	
	public Perro() {
		super();
		this.entrenado = false;
	}
	

	public Perro(String idAnimal, String idCentro, String nombreAnim, int edadMeses, String caracteristicas, String necesidadesEspeciales,String raza, String tamano, boolean entrenado) {
		super(idAnimal, idCentro, nombreAnim, edadMeses, Especie.Perro, caracteristicas, necesidadesEspeciales, true);
		this.raza = raza;
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
	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String realizarEntrenamiento() {
		String mensaje;
		
		if(!entrenado) {
			this.entrenado = true;
			mensaje = this.getNombreAnim() + " ha aprendido órdenes básicas.";
		} else {
			mensaje = this.getNombreAnim() + " ya está entrenado.";
		}
		
		return mensaje;
	}

	


	@Override
	public String toString() {
		return super.toString()+" raza=" + raza + ", tamano=" + tamano + ", entrenado=" + entrenado + "]";
	}



}