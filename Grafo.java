import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

	private List<Vertice> vertices = new ArrayList<Vertice>();
	private int qtdeMaximaVertices = 0;
	private int qtdeAtualVertices = 0;
	
	private Map<String, Integer> rotuloEmIndices = new HashMap<String, Integer>();
	
	private MatrizAdjacencia matrizAdjacencia;

	public Grafo(int qtdeMaximaVertices) {
		this.qtdeMaximaVertices = qtdeMaximaVertices;
	}

	public void addVertice(String rotulo) throws Exception {
		if (qtdeAtualVertices <= qtdeMaximaVertices - 1) {
			if(isVerticeExists(rotulo)) {
				throw new Exception("O vértice de rótulo: " + rotulo + ", já existe");
			}
			Vertice vertice = new Vertice(rotulo);
			rotuloEmIndices.put(rotulo, qtdeAtualVertices);
			this.vertices.add(vertice);
			qtdeAtualVertices++;
		} else {
			throw new Exception("A quantidade máxima de vértices eh: " + qtdeMaximaVertices);
		}
	}

	public List<Vertice> getVertices() {
		return Collections.unmodifiableList(vertices);
	}
	
	public Vertice getVertice(String rotuloVertice) {
		this.isVerticeExistsOrThrow(rotuloVertice);
		int indice = this.rotuloEmIndices.get(rotuloVertice);
		return this.vertices.get(indice);
	}
	
	public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception {
		if(!isVerticeExists(rotuloVerticeInicial) || !isVerticeExists(rotuloVerticeFinal)) {
			throw new Exception("Só é possível conectar os vértices se ambos existirem!");
		}
		criarMatrizAdjacencia();
		
		int indiceVerticeInicial = this.rotuloEmIndices.get(rotuloVerticeInicial);
		int indiceVerticeFinal = this.rotuloEmIndices.get(rotuloVerticeFinal);
		
		this.matrizAdjacencia.adicionarAresta(indiceVerticeInicial, indiceVerticeFinal);
	}
	
	public List<Vertice> getAdjacentes(String vertice){
		isVerticeExistsOrThrow(vertice);
		int indiceVertice = this.rotuloEmIndices.get(vertice);
		return this.matrizAdjacencia.getAdjacentes(indiceVertice);
	}
	
	private boolean isVerticeExists(String rotulo){
		if(rotuloEmIndices.containsKey(rotulo)) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isVerticeExistsOrThrow(String rotulo) {
		if(!isVerticeExists(rotulo)) {
			throw new IllegalArgumentException("O vértice não existe!");
		}
		
		return true;
	}
	
	private void criarMatrizAdjacencia() {
		if(this.matrizAdjacencia == null) {
			this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<Vertice>(vertices));
		}
	}
	
	/*private boolean isVerticeExists(String rotulo) {
		for(int i = 0; i < vertices.size(); i++) {
			if(vertices.get(i).getRotulo().equalsIgnoreCase(rotulo)) {
				return true;
			}
		}
		
		return false;
	}*/

}
