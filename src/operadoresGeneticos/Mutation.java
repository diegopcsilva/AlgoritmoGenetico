package operadoresGeneticos;
import java.util.Random;

import campoDeTestes.Individuo;

public class Mutation {
	double taxa;
	Random gerador = new Random();
	double limSup;
	double limInf;
	
	public Mutation(double taxaMutacao, double limiteSuperior, double limiteInferior) {
		taxa = taxaMutacao;
		limSup = limiteSuperior;
		limInf = limiteInferior;
	}
	public Individuo mutation(Individuo Indi){
		if (gerador.nextDouble()<taxa){
			//System.out.println("Hit!!! Mutation");
			double random = gerador.nextDouble();
			if(random<0.33){
				//System.out.println("Hit!!! Mutation A");
				Indi.setValorA(gerador.nextInt((int)limSup)-gerador.nextInt((int) limInf));
			}
			if(random>=0.33&&random<0.66){
				//System.out.println("Hit!!! Mutation B");
				Indi.setValorB(gerador.nextInt((int)limSup)-gerador.nextInt((int) limInf));
			}
			if(random>=0.66){
				//System.out.println("Hit!!! Mutation C");
				Indi.setValorC(gerador.nextInt((int)limSup)-gerador.nextInt((int) limInf));
			}
			return Indi;
		}
		return Indi;
	}
}
