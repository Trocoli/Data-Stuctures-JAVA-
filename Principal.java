import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		
		Grafo grafo = new Grafo(10);
		
		try {
			grafo.addVertice("A");
			grafo.addVertice("B");
			grafo.addVertice("C");
			grafo.addVertice("D");
			grafo.addVertice("E");
			grafo.addVertice("F");
			grafo.addVertice("G");
			grafo.addVertice("H");
			grafo.addVertice("I");
			grafo.addVertice("J");

			grafo.conectarVertices("C", "B");
			grafo.conectarVertices("C", "E");
			grafo.conectarVertices("C", "G");
			grafo.conectarVertices("A", "C");
			grafo.conectarVertices("A", "B");
			grafo.conectarVertices("A", "D");
			grafo.conectarVertices("D", "A");
			grafo.conectarVertices("D", "E");
			grafo.conectarVertices("F", "B");
			grafo.conectarVertices("G", "F");
			grafo.conectarVertices("G", "H");
			grafo.conectarVertices("G", "D");
			grafo.conectarVertices("E", "H");


		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<String> caminho = BuscaEmLargura.getInstance().buscar(grafo, "C", "H");
		System.out.println(caminho);
	}

}
