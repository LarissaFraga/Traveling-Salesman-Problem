public class Hill_Climbing {
	public static final int ITERATIONS_BEFORE_MAXIMA = 100000; // numero de interaçoes que verificaremos o caminho adjacente
															  //se eles tem um caminho maior que o caminho atual
															 // antes de considerar o caminho atual.
	
	
	
	public Caminho encontrarMenorCaminho(Caminho caminhoAtual) { //encontrar o menor caminho
		Caminho caminhoAdjacente;
		int iteraçãoContadorMax = 0; 
		String compareCaminhos = null;
		while(iteraçãoContadorMax < ITERATIONS_BEFORE_MAXIMA) {
			caminhoAdjacente = obterCaminhoAdjacente( new Caminho(caminhoAtual)); 
			if(caminhoAdjacente.getDistanciaTotal() <= caminhoAtual.getDistanciaTotal()) { //se a distancia total do caminho 
				compareCaminhos = "<-(prossiga)";                         //adjacente for menor ou igual a rota atual
				iteraçãoContadorMax = 0;                              //movemos para a rota adjacente e ajustamos para zero
				caminhoAtual = new Caminho(caminhoAdjacente);	
			}else compareCaminhos = "> (permanece) - iteration#"+ iteraçãoContadorMax++; //senão ficamos na rota atual
																				//e aumentamos o contator
			System.out.println(" | "+compareCaminhos);
			System.out.println(caminhoAtual + " | "+caminhoAtual.getDistanciaTotalString());
		}
		if(iteraçãoContadorMax == ITERATIONS_BEFORE_MAXIMA) System.out.println(" | Caminho mais Curto");
		else System.out.println(" | "+compareCaminhos);
		return caminhoAtual;
		
	}
	
	// caminho adjacente
	public Caminho obterCaminhoAdjacente(Caminho caminho) { //obteremos dois indices distintos de duas cidades no caminho
		int x1 =0, x2=0;
		while(x1 == x2) {
			x1= (int) (caminho.getCidades().size()*Math.random());
			x2= (int) (caminho.getCidades().size()*Math.random());
		}
		
		Cidade cidade1 = caminho.getCidades().get(x1);
		Cidade cidade2 = caminho.getCidades().get(x2);
		caminho.getCidades().set(x2, cidade1);   //invertemos os indices 
		caminho.getCidades().set(x1, cidade2);
		
		return caminho;
		
	}

}
