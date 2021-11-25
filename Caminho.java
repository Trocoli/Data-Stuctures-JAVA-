import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caminho {
	
	private Map<String, String> caminho;
	
	public Caminho() {
		this.caminho = new HashMap<String, String>();
	}

	public void ligar(String noAnterior, String noProximo) {
		this.caminho.put(noAnterior, noProximo);
	}
	
	public List<String> gerar(String origem, String destino){
		List<String> resultado = new ArrayList<String>();
		
		String noAux = destino;
		
		while(noAux != origem && this.caminho.containsKey(noAux)) {
			resultado.add(noAux);
			noAux = this.caminho.get(noAux);
		}
		
		resultado.add(noAux);
		Collections.reverse(resultado);
		return resultado;
	}
}
