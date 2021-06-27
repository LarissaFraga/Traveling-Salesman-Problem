import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Route1 {
	private ArrayList<Cidade1> cidades = new ArrayList<Cidade1>();
	
	public Route1(ArrayList<Cidade1>cidades) {
		this.cidades.addAll(cidades);
		Collections.shuffle(this.cidades);
	}
	
	public Route1(Route1 route) {
		route.cidades.stream().forEach(x -> cidades.add(x));
	}
	public ArrayList<Cidade1> getCidades(){
		return cidades;
	}
	public double getTotalDistance() { // metodo que calcula a distancia entre as cidades
		int cidadeSize = this.cidades.size();
		return this.cidades.stream().mapToDouble(x -> {
			int cidadeIndex = this.cidades.indexOf(x);
			double returnValue =0;
			if(cidadeIndex < cidadeSize -1) returnValue = x.mensuredistance(this.cidades.get(cidadeIndex + 1));
			return  returnValue;
		}).sum()+this.cidades.get(cidadeSize - 1).mensuredistance(this.cidades.get(0));
		
	}
	public String getTotalStringDistance() {
		String returnValue = String.format("%.2f", this.getTotalDistance());
		if(returnValue.length()== 7) returnValue = " "+returnValue;
		return returnValue;
	}
	public String toString() {
		return Arrays.toString(cidades.toArray());
	}
	
}
