import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		
		Scanner entrada = new Scanner(System.in);
		
		No raiz = null;
		No aux = null;
		
		Pilha topo, pilha_aux;
		
		int op, idade, find = 0;
		
		do {
			
			System.out.println("Menu");
			System.out.println("1 - Inserir Idade");
			System.out.println("2 - Buscar Idade");
			System.out.println("3 - Busca em Ordem");
			System.out.println("Escolha uma opção: ");
			op = entrada.nextInt();
			
			switch(op) {
				case 1:
					System.out.println("Informe uma idade: ");
					No novo_no = new No();
					novo_no.idade = entrada.nextInt();
					if(raiz == null) {
						raiz = novo_no;
					}else {
						aux = raiz;
						find = 0;
						while(find == 0) {
							if(novo_no.idade < aux.idade) {
								if(aux.esq == null) {
									aux.esq = novo_no;
									find = 1;
								}else {
									aux = aux.esq;
								}
							}else if(novo_no.idade >= aux.idade) {
								if(aux.dir == null) {
									aux.dir = novo_no;
									find = 1;
								}else {
									aux = aux.dir;
								}
							}
						}
					}
					break;
					case 2:
						if(raiz == null) {
							System.out.println("Árvore Vazia");
						}else {
							System.out.println("Digite uma idade: ");
							idade = entrada.nextInt();
							aux = raiz;
							find = 0;
							while(aux != null && find == 0) {
								if(aux.idade == idade) {
									System.out.println("Idade: " + idade + ", Encontrada");
									find = 1;
								}else if(idade < aux.idade) {
									aux = aux.esq;
								}else {
									aux = aux.dir;
								}
							}
							if(find == 0) {
								System.out.println("O Idade não existe!");
							}
						}
						break;
					case 3:
						if(raiz == null) {
							System.out.println("Árvore não existe");
						}else {
							aux = raiz;
							topo = null;
							do {
								while(aux != null) {
									pilha_aux = new Pilha();
									pilha_aux.no = aux;
									pilha_aux.prox = topo;
									topo = pilha_aux;
									aux = aux.esq;
								}
								if(topo != null) {
									pilha_aux = topo;
									System.out.println(pilha_aux.no.idade + " ");
									aux =topo.no.dir;
									topo = topo.prox;
								}
							}while(topo != null || aux != null);
						}
						break;
				default:
					System.out.println("Informe uma operação válida!");
					break;
			}
			
		}while(op != 8);
		
		
		
	}

}
