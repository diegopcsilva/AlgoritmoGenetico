package operadoresGeneticos;
import java.util.Random;

import campoDeTestes.Individuo;

public class Crossover {
	Random gerador = new Random();
	//private double crossover;
	private Individuo Indi1;
	private Individuo Indi2;
	
	public Individuo getIndi1() {
		return Indi1;
	}
	public void setIndi1(Individuo indi1) {
		Indi1 = indi1;
	}
	public Individuo getIndi2() {
		return Indi2;
	}
	public void setIndi2(Individuo indi2) {
		Indi2 = indi2;
	}
	public Crossover(double Crossover,Individuo selecaoRoleta, Individuo selecaoRoleta2) {
		Indi1 = selecaoRoleta;
		Indi2 = selecaoRoleta2;
		double random = gerador.nextDouble();
		//System.out.println("Randon se vai cruzar"+random);
		if(random<Crossover){
			cruzamento();
		}

		
		//System.out.println(gerador.nextDouble());
	}
	public void cruzamento(){
		double random = gerador.nextDouble();
		//System.out.println("Randon do cruzamento"+random);
		if(random<0.33){
			//System.out.println("Hit cruza A");
			double aux = Indi1.getValorA();
			Indi1.setValorA(Indi2.getValorA());
			Indi2.setValorA(aux);
		}
		if(random>=0.33&&random<0.66){
			//System.out.println("Hit cruza B");
			double aux = Indi1.getValorB();
			Indi1.setValorB(Indi2.getValorB());
			Indi2.setValorB(aux);
		}
		if(random>=0.66){
			//System.out.println("Hit cruza C");
			double aux = Indi1.getValorC();
			Indi1.setValorC(Indi2.getValorC());
			Indi2.setValorC(aux);
		}
	}
}
