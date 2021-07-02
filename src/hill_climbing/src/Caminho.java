import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Caminho {
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>(); // arrayList de cidades
	
	public Caminho(ArrayList<Cidade>cidades) { //constrututor para inicializar o arrayList e depois embaralha-las
		this.cidades.addAll(cidades);
		Collections.shuffle(this.cidades);
	}
	
	public Caminho(Caminho caminho) { // inicializa as cidades usando uma instancia de rota pré-existententes
		caminho.cidades.stream().forEach(x -> cidades.add(x));
	}
	
	public ArrayList<Cidade> getCidades(){ //retorna o arrayList de cidades
		return cidades;
	}
	
	public double getDistanciaTotal() { // metodo que calcula a distancia entre as cidades 1 e 2 e entre 2 e 3
		int cidadeSize = this.cidades.size();
		return this.cidades.stream().mapToDouble(x -> {
			int cidadeIndex = this.cidades.indexOf(x);
			double returnValor =0;
			if(cidadeIndex < cidadeSize -1) returnValor = x.calcularDistancia(this.cidades.get(cidadeIndex + 1));
			return  returnValor;
		}).sum()+this.cidades.get(cidadeSize - 1).calcularDistancia(this.cidades.get(0)); // soma a distancia entre a ultima cidade e cidade de origem 
																						//e cidade de origem 
	}
	
	public String getDistanciaTotalString() {
		String returnValor = String.format("%.2f", this.getDistanciaTotal());
		if(returnValor.length()== 7) returnValor = " "+returnValor;
		return returnValor;
	}
	
	public String toString() { //método para imprimir as cidades
		return Arrays.toString(cidades.toArray());
	}

}
