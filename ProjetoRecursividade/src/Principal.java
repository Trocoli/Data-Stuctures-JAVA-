
public class Principal {
	
	public static void main(String[] args) {	
		funcao_recursiva(1);
		
		
		
	}
	
	//1,2,3,4,5,6,7,8,9,10
	static void funcao() {
		for(int i = 1; i <= 10; i++) {
			System.out.print(i+", ");
		}
	}
	
	//1,2,3,4,5,6,7,8,9,10
	static void funcao_recursiva(int num) {
		//solução trivial
		if(num > 3) {
			return;
		}
		System.out.print(num + ", ");
		//solução recursiva
		funcao_recursiva(num+1);
	}

}
