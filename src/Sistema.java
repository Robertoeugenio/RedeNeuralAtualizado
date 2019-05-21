import java.util.Scanner;

 

public class Sistema {
	 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		 int  fyent=0, control =0, epocaContador=0,entradaX1,entradaX2, entradX3;
		 double wEntradaPesos[]= {0,0,0,0},yentCalculo;
		 int entrada[][]= {
				           {1,1,1,1},
				 		   {1,1,0,1},
				 		   {1,0,1,1},
				 		   {1,0,0,1},
				 		   {0,1,1,1},
				 		   {0,1,0,1},
				 		   {0,0,1,1},
				 		   {0,0,0,1}};
		 int t[]={1,0 ,0 , 0, 0, 0, 0,0};
		 boolean   parada=true;
		 
		System.out.println("Digite linear ");
		 double teta= sc.nextDouble();
		 System.out.println("Digite a taxa de aprendizado (0<n<=1)");
		 double n=sc.nextDouble();
		 
		 
		 do
		 {
		parada=true;  
		 for(int i=0; i<8;i++){
			  
			 yentCalculo=0;
			  for(int j=0; j<4;j++){	 
			 yentCalculo+= (entrada[i][j]*wEntradaPesos[j]);
				 }
			 if(yentCalculo>teta)
				 fyent=1;
			 else if(yentCalculo<-teta)
				 fyent= -1;
			 else{
				 fyent=0;
			 } 
			 if(fyent!=t[i]){
				 wEntradaPesos[0]+=n*(t[i]-fyent)* entrada[i][0];
				 wEntradaPesos[1]+=n*(t[i]-fyent)* entrada[i][1];
				 wEntradaPesos[2]+=n*(t[i]-fyent)* entrada[i][2];
				 wEntradaPesos[3]+=n*(t[i]-fyent)* entrada[i][3];
				 
				 parada=false;
			}
		 }
		 epocaContador++;
		 }while(parada==false);
		 
		 System.out.println(control +" p1= "+wEntradaPesos[0]+" p2= "+wEntradaPesos[1]+" p3= "+wEntradaPesos[2]+" p4= "+wEntradaPesos[3]+" epoca= "+epocaContador);
		 
		 System.out.println("Digite Entradax1, Entradax2, Entradax3");
		 entradaX1= sc.nextInt();
		 entradaX2= sc.nextInt();
		 entradX3= sc.nextInt();
		 yentCalculo=((entradaX1*wEntradaPesos[0])+(entradaX2*wEntradaPesos[1])+(entradX3*wEntradaPesos[2]+(1*wEntradaPesos[3])));
		 if(yentCalculo>teta)
			 fyent=1;
		 else if(yentCalculo<-teta)
			 fyent= -1;
		 else{
			 fyent=0;
		 } 
		 
		  System.out.println("Resultado = "+fyent);
		 sc.close();
		 }
		 
		 
	}