
public class Vertice {

	private String rotulo;
	private int grau;

	public Vertice(String rotulo) {
		// condicao "" || null
		this.rotulo = rotulo;
	}

	public String getRotulo() {
		return rotulo;
	}
	
	public void addGrau() {
		this.grau++;
	}

	public int getGrau() {
		return grau;
	}
}
