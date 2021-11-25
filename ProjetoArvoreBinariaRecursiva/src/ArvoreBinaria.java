
public class ArvoreBinaria {

	private No raiz;
	private ArvoreBinaria noEsquerda;
	private ArvoreBinaria noDireita;

	public ArvoreBinaria() {

	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public ArvoreBinaria getNoEsquerda() {
		return noEsquerda;
	}

	public void setNoEsquerda(ArvoreBinaria noEsquerda) {
		this.noEsquerda = noEsquerda;
	}

	public ArvoreBinaria getNoDireita() {
		return noDireita;
	}

	public void setNoDireita(ArvoreBinaria noDireita) {
		this.noDireita = noDireita;
	}
	
	public void criarNo(Pessoa pessoa) {
		No no = new No(pessoa);
		inserir(no);
	}
	
	private void inserir(No no) {
		if(this.raiz == null) {//solução trivial
			this.raiz = no;
		}else if(no.getPessoa().getIdade() < this.raiz.getPessoa().getIdade()) {
			if(this.noEsquerda == null) {
				this.noEsquerda = new ArvoreBinaria();
			}
			this.noEsquerda.inserir(no);//solução recursiva
		}else if(no.getPessoa().getIdade() > this.raiz.getPessoa().getIdade()) {
			if(this.noDireita == null) {
				this.noDireita = new ArvoreBinaria();
			}
			this.noDireita.inserir(no);//solução recursiva
		}else {
			System.out.println("Uma pessoa com essa idade já foi adicionado");
		}
	}
	
	public void buscaEmOrdem() {
		if(this.raiz == null){
			return;
		}//solução trivial
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaEmOrdem();
		}//solução recursiva
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
		
		if(this.noDireita != null) {
			this.noDireita.buscaEmOrdem();
		}//solução recursiva
	}
	
	public void buscaPreOrdem() {
		if(this.raiz == null){
			return;
		}//solução trivial
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaPreOrdem();
		}//solução recursiva
		
		if(this.noDireita != null) {
			this.noDireita.buscaPreOrdem();
		}//solução recursiva
	}
	
	public void buscaPosOrdem() {
		if(this.raiz == null){
			return;
		}//solução trivial
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaPosOrdem();
		}//solução recursiva
		
		if(this.noDireita != null) {
			this.noDireita.buscaPosOrdem();
		}//solução recursiva
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
	}

}
