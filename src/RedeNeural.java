import java.util.Locale;
import java.util.Scanner;

public class RedeNeural {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		double entradaX[][], //entrada x 
		WentradaPesos[],  //entrada pesos  
		Nusuario,   // entrada digitada pelo usuario  
		yentCalculo, //variaveis para calculo
		limiarTeta; // Tèta
		int fyent, // variaveis calculo
		control, // variavel para contador 
		epocaContador = 0,  // contador zerado 
		vetorFyent[]; //variavel para usar o calculo
		double[] Tresultado; //resultado esperado da operação
		boolean operacao = true; // usando o bollean 

		
		System.out.print("Digite o N usuário entre 0 e 1 : \n"); //entrada usuario
		Nusuario = sc.nextDouble();
		System.out.print("Digite o TéTa que é o limiar:	 \n"); //entrada usuario
		limiarTeta = sc.nextDouble();

		
		WentradaPesos = new double[] { 0, 0, 0, 0 };// pesos zerados 
		
		entradaX = new double[][] { // tabela 
			{ 1, 1, 1, 1 }, 
			{ 1, 1, 0, 1 }, 
			{ 1, 0, 1, 1 }, 
			{ 1, 0, 0, 1 }, 
			{ 0, 1, 1, 1 },
			{ 0, 1, 0, 1 }, 
			{ 0, 0, 1, 1 }, 
			{ 0, 0, 0, 1 } 
		};
		Tresultado = AND(); //chamada metodo
		vetorFyent = new int[8]; //vetor função

		while (operacao) {  //while para operação 
			control = 0;

			for (int i = 0; i < entradaX.length; i++) {
				yentCalculo = 0;

				for (int k = 0; k < 4; k++) {
					yentCalculo = entradaX[i][k] + yentCalculo * WentradaPesos[k];  //calculo da funçao 
				}

				if (yentCalculo > limiarTeta) {
					fyent = 1;
					vetorFyent[i] = fyent;
				} else if ((-1 * limiarTeta) <= yentCalculo && yentCalculo <= limiarTeta) {
					fyent = 0;
					vetorFyent[i] = fyent;
				} else {
					fyent = -1;
					vetorFyent[i] = fyent;
				}

				if (fyent != Tresultado[i]) {     //calculo fyente for diferente resultado fazer equação
					for (int a = 0; a < WentradaPesos.length; a++) {
						WentradaPesos[a] = WentradaPesos[a] +  Nusuario * (Tresultado[i] - fyent) * entradaX[i][a];
					}
				} else {
					control++;
				}
			}

			if (control == 8) {
				operacao = false;

				System.out.print("Pesos Atualizados: \n");   //resultado dos pesos 
				for (double contadorAuxPesos : WentradaPesos) {
					System.out.print(contadorAuxPesos + " \n");
				}
				
				System.out.println("");
				for (int contadorAux : vetorFyent) {
					System.out.print(contadorAux + " ");
				}
			}
			epocaContador++;
		}
		System.out.println("");
		System.out.println("Épocas rodadas para atualizar os pesos \n" + epocaContador); // época rodadas pela entradas do usuario

		
		//variaveis para teste
		int XtesteResultado[];
		double testeYent = 0;

	
		System.out.println("#####################    Testando Resultado AND  #################################################");
		System.out.println("#############################   teste   #######################################################");
		System.out.println("#############################   Abaixo  #######################################################");
		System.out.println("Entrada para Teste Digite 0 ou 1");

		//teste and 
		XtesteResultado = new int[4];

		// for para rodar o teste com a entrada do usuario
		for (int i = 0; i < XtesteResultado.length; i++) {
			if (i == 3) {
				XtesteResultado[i] = 1;
			} else {
				System.out.print("Digite a entrada " + (i + 1) + ":");
				XtesteResultado[i] = sc.nextInt();
			}
		}
		//equação 
		for (int i = 0; i < WentradaPesos.length; i++) {
			testeYent = XtesteResultado[i] + testeYent * WentradaPesos[i];
		}
		//condiçoes 
		if (testeYent > limiarTeta) {
			System.out.println("Resposta eh  " + 1);
		} else if (testeYent <= limiarTeta && testeYent <= limiarTeta) {
			System.out.println("Resposta eh  " + 0);
		} else {
			System.out.println("Resposta eh  " + -1);
		}

		sc.close();
	}
	//metodo vetor AND
	public static double[] AND() {

		double Tvetor[] = new double[] { 1, 0, 0, 0, 0, 0, 0, 0 };
		return Tvetor;
	}
	
}
	