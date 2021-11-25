import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {
	
	private List<Vertice> vertices;
	
	private int[][] matriz;
	
	private int qtdeVertices;
	
	public MatrizAdjacencia(List<Vertice> vertices) {
		this.vertices = vertices;
		this.qtdeVertices = vertices.size();
		
		this.matriz = new int[qtdeVertices][qtdeVertices];
	}
	
	public void adicionarAresta(int indiceVerticeInicial, 
			int indiceVerticeFinal) {
		
		Vertice verticeInicial = 
				this.vertices.get(indiceVerticeInicial);
		Vertice verticeFinal = 
				this.vertices.get(indiceVerticeFinal);
		
		if(indiceVerticeInicial == indiceVerticeFinal) {
			this.matriz[indiceVerticeInicial][indiceVerticeFinal] = 1;
			verticeInicial.addGrau();
			verticeInicial.addGrau();
		}else {
			this.matriz[indiceVerticeInicial][indiceVerticeFinal] += 1;
			verticeInicial.addGrau();
			this.matriz[indiceVerticeFinal][indiceVerticeInicial] += 1;
			verticeFinal.addGrau();
		}
	}
	
	public List<Vertice> getAdjacentes(int indiceVertice){
		int linha = indiceVertice;
		List<Vertice> vizinhos = new ArrayList<Vertice>();
		
		for(int j = 0; j < qtdeVertices; j++) {
			if(this.matriz[linha][j] >= 1) {
				Vertice v = this.vertices.get(j);
				vizinhos.add(v);
			}
		}
		
		return vizinhos;
	}

}
