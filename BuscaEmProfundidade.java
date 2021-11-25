import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

public class BuscaEmProfundidade {
	
	private static BuscaEmProfundidade instance;
	
	public BuscaEmProfundidade() {
		
	}
	
	public static BuscaEmProfundidade getInstance() {
		if(instance == null) {
			instance = new BuscaEmProfundidade();
			return instance;
		}
		return instance;
	}
	
	public List<String> buscar(Grafo grafo, String origem, String destino){
		Stack<String> pontosNavegacao = new Stack<String>();
		LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
		
		Caminho caminho = new Caminho();
		
		pontosNavegacao.push(origem);
		
		verticesVisitados.add(origem);
		
		while(!pontosNavegacao.empty()) {
			String v = pontosNavegacao.pop();
			System.out.println(v);
			if(v.equals(destino)) {
				break;
			}
			
			for(Vertice u : grafo.getAdjacentes(v)) {
				String rotulo = u.getRotulo();
				if(!verticesVisitados.contains(rotulo)) {
					verticesVisitados.add(rotulo);
					caminho.ligar(rotulo, v);
					pontosNavegacao.push(rotulo);
				}
			}
		}
		
		return caminho.gerar(origem, destino);
	}
	
	


}
