import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		
		Scanner teclado = new Scanner(System.in);
		Scanner tecladoString = new Scanner(System.in);
		
		ArvoreBinaria avr = new ArvoreBinaria();
		int op;
		
		do {
			System.out.println("Menu");
			System.out.println("1 - Inserir uma Pessoa");
			System.out.println("2 - Buscar em Ordem");
			System.out.println("3 - Buscar pré Ordem");
			System.out.println("4 - Buscar pós Ordem");
			System.out.println("Informe uma opção: ");
			op = teclado.nextInt();
			
			switch(op) {
			case 1:
				Pessoa pessoa = new Pessoa();
				System.out.println("Informe o nome da Pessoa: ");
				pessoa.setNome(tecladoString.nextLine());
				System.out.println("Informe a idade da Pessoa");
				pessoa.setIdade(teclado.nextInt());
				
				avr.criarNo(pessoa);
				break;
			case 2:
				avr.buscaEmOrdem();
				break;
			case 3:
				avr.buscaPreOrdem();
				break;
			case 4:
				avr.buscaPosOrdem();
				break;
			}
		}while(op != 8);
		
	}

}
