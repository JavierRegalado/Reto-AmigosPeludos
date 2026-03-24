package model;

public class Pez extends Animal {

	private boolean aguaDulce;
	private String especiePez;
	private boolean compatibleComunidad;

	public Pez() {
		super();
	}

	public Pez(String idAnimal, String idCentro, String nombreAnim, int edadMeses, String caracteristicas,
			String necesidadesEspeciales, String especiePez, boolean aguaDulce, boolean compatibleComunidad) {
		super(idAnimal, idCentro, nombreAnim, edadMeses, Especie.Pez, caracteristicas, necesidadesEspeciales);
		this.especiePez = especiePez;
		this.aguaDulce = aguaDulce;
		this.compatibleComunidad = compatibleComunidad;
	}

	public boolean isAguaDulce() {
		return aguaDulce;
	}

	public void setAguaDulce(boolean aguaDulce) {
		this.aguaDulce = aguaDulce;
	}
	public String getEspeciePez() {
		return especiePez;
	}

	public void setEspeciePez(String especiePez) {
		this.especiePez = especiePez;
	}

	public boolean isCompatibleComunidad() {
		return compatibleComunidad;
	}

	public void setCompatibleComunidad(boolean compatibleComunidad) {
		this.compatibleComunidad = compatibleComunidad;
	}

	@Override
	public String toString() {
		return "Pez [aguaDulce=" + aguaDulce + ", especiePez=" + especiePez + ", compatibleComunidad="
				+ compatibleComunidad + "]";
	}


}