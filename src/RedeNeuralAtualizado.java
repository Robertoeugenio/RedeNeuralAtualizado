import java.util.Scanner;

public class RedeNeuralAtualizado {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int fyent = 0,  // variavel de calculo 
	    control = 0, //variavel para contador 
	    epocaContador = 0, //contador zerado 
	    entradaX1, // entrada  
	    entradaX2, // entrada 
	    entradX3; // entrada
		double wEntradaPesos[] = { 0, 0, 0, 0 },    // entrada peso zerado
				yentCalculo; // variavel calculo
		int entradaTabela[][] = {         // tabela            
								 { 1, 1, 1, 1 }, 
								 { 1, 1, 0, 1 }, 
								 { 1, 0, 1, 1 }, 
								 { 1, 0, 0, 1 }, 
								 { 0, 1, 1, 1 },
								 { 0, 1, 0, 1 }, 
								 { 0, 0, 1, 1 }, 
								 { 0, 0, 0, 1 } 
								};
		int tResultado[] = { 1, 0, 0, 0, 0, 0, 0, 0 };
		boolean parada = true;

		System.out.println("Digite Téta ");
		double teta = sc.nextDouble();
		System.out.println("Digite a taxa de aprendizado (0<n<=1)");
		double nAprendizado = sc.nextDouble();

		do {
			parada = true;
			for (int i = 0; i < 8; i++) {

				yentCalculo = 0;
				for (int j = 0; j < 4; j++) {
					yentCalculo += (entradaTabela[i][j] * wEntradaPesos[j]);
				}
				if (yentCalculo > teta)
					fyent = 1;
				else if (yentCalculo < -teta)
					fyent = -1;
				else {
					fyent = 0;
				}
				if (fyent != tResultado[i]) {
					wEntradaPesos[0] += nAprendizado * (tResultado[i] - fyent) * entradaTabela[i][0];
					wEntradaPesos[1] += nAprendizado * (tResultado[i] - fyent) * entradaTabela[i][1];
					wEntradaPesos[2] += nAprendizado * (tResultado[i] - fyent) * entradaTabela[i][2];
					wEntradaPesos[3] += nAprendizado * (tResultado[i] - fyent) * entradaTabela[i][3];

					parada = false;
				}
			}
			epocaContador++;
		} 
		while (parada == false);

		System.out.println("Pesos Atualizados\n");
		System.out.println(control + "\n peso1= " + wEntradaPesos[0] + "\n peso2= " + wEntradaPesos[1] + "\n peso3= "
		+ wEntradaPesos[2] + "\n peso4= " + wEntradaPesos[3] + "\n\n Épocas rodadas para atualizar os pesos= " + epocaContador);
		
		
		
		System.out.println("");

			

		System.out.println("#####################    Testando Resultado   #################################################");
		System.out.println("#############################   teste   #######################################################");
		System.out.println("#############################    AND     #######################################################");
		System.out.println("Entrada para Teste Digite 0 ou 1:");

		System.out.println("Digite a Primeira  Entrada: ");
		entradaX1 = sc.nextInt();
		System.out.println("Digite a Segunda  Entrada: ");
		entradaX2 = sc.nextInt();
		System.out.println("Digite a Terceira  Entrada: ");
		entradX3 = sc.nextInt();
		yentCalculo = ((entradaX1 * wEntradaPesos[0]) + (entradaX2 * wEntradaPesos[1])
				+ (entradX3 * wEntradaPesos[2] + (1 * wEntradaPesos[3])));
		if (yentCalculo > teta)
			fyent = 1;
		else if (yentCalculo < -teta)
			fyent = -1;
		else {
			fyent = 0;
		}

		System.out.println("Resultado para operação => AND  = " + fyent);
		sc.close();
	}

}