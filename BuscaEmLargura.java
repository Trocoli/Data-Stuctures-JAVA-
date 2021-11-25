import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuscaEmLargura {
	
	private static BuscaEmLargura instance;
	
	public static BuscaEmLargura getInstance() {
		if(instance == null) {
			instance = new BuscaEmLargura();
			return instance;
		}
		return instance;
	}
	
	public List<String> buscar(Grafo grafo, String origem, String destino){
		Queue<String> pontosNavegacao = new LinkedList<String>();
		LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
		
		Caminho caminho = new Caminho();
		
		pontosNavegacao.add(origem);
		verticesVisitados.add(origem);
		
		while(!pontosNavegacao.isEmpty()) {
			String v = pontosNavegacao.poll();
			System.out.println(v);
			if(v.equals(destino)) {
				break;
			}
			
			for(Vertice vertice : grafo.getAdjacentes(v)) {
				String rotulo = vertice.getRotulo();
				if(!verticesVisitados.contains(rotulo)) {
					verticesVisitados.add(rotulo);
					caminho.ligar(rotulo, v);
					pontosNavegacao.add(rotulo);
				}
			}
		}
		
		return caminho.gerar(origem, destino);
	}

}
