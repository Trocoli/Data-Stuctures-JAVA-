
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
		if(this.raiz == null) {//solu��o trivial
			this.raiz = no;
		}else if(no.getPessoa().getIdade() < this.raiz.getPessoa().getIdade()) {
			if(this.noEsquerda == null) {
				this.noEsquerda = new ArvoreBinaria();
			}
			this.noEsquerda.inserir(no);//solu��o recursiva
		}else if(no.getPessoa().getIdade() > this.raiz.getPessoa().getIdade()) {
			if(this.noDireita == null) {
				this.noDireita = new ArvoreBinaria();
			}
			this.noDireita.inserir(no);//solu��o recursiva
		}else {
			System.out.println("Uma pessoa com essa idade j� foi adicionado");
		}
	}
	
	public void buscaEmOrdem() {
		if(this.raiz == null){
			return;
		}//solu��o trivial
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaEmOrdem();
		}//solu��o recursiva
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
		
		if(this.noDireita != null) {
			this.noDireita.buscaEmOrdem();
		}//solu��o recursiva
	}
	
	public void buscaPreOrdem() {
		if(this.raiz == null){
			return;
		}//solu��o trivial
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaPreOrdem();
		}//solu��o recursiva
		
		if(this.noDireita != null) {
			this.noDireita.buscaPreOrdem();
		}//solu��o recursiva
	}
	
	public void buscaPosOrdem() {
		if(this.raiz == null){
			return;
		}//solu��o trivial
		
		if(this.noEsquerda != null) {
			this.noEsquerda.buscaPosOrdem();
		}//solu��o recursiva
		
		if(this.noDireita != null) {
			this.noDireita.buscaPosOrdem();
		}//solu��o recursiva
		
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		System.out.println("Idade: " + this.raiz.getPessoa().getIdade());
	}

}
