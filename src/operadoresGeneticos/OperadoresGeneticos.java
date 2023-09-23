package operadoresGeneticos;

import campoDeTestes.Populacao;

public class OperadoresGeneticos {
	double TamanhoPopulacao = 0;
	double TaxaCrossover = 0;
	double TaxaMutacao = 0;
	double LimiteInferior = 0;
	double LimiteSuperior = 0;
	Populacao PopAntiga,PopNova;
	
	public OperadoresGeneticos(Populacao popAntiga, Populacao popNova, double tamanhoPopulacao, double taxaCrossover,
			double taxaMutacao, double limiteSuperior, double limiteInferior) {
		PopAntiga = popAntiga;
		PopNova = popNova;
		TamanhoPopulacao = tamanhoPopulacao;
		TaxaCrossover = taxaCrossover;
		TaxaMutacao = taxaMutacao;
		LimiteSuperior = limiteSuperior;
		LimiteInferior = limiteInferior;
		
	}

	public Populacao CrossoverMutation(){
		boolean populando = true;
		while(populando){
			Crossover cross = new Crossover(TaxaCrossover, PopAntiga.selecaoRoleta(), PopAntiga.selecaoRoleta());
			Mutation mut = new Mutation(TaxaMutacao,LimiteSuperior,LimiteInferior);
			if(TamanhoPopulacao == PopNova.Lista.size()) populando = false;
			PopNova.Lista.add(mut.mutation(cross.getIndi1()));
			if(TamanhoPopulacao == PopNova.Lista.size()) populando = false;
			PopNova.Lista.add(mut.mutation(cross.getIndi2()));
		}
		return PopNova;
	}
}
