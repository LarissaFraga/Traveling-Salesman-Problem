public class Cidade {
	
	private double coordenada_x;//longitude
	private double coordenada_y; //latitude
	private String identificador_do_nó; //nome da cidade
	
	
	public Cidade(String identificador_do_nó,double coordenada_y, double coordenada_x) {
		this.identificador_do_nó =identificador_do_nó;
		this.coordenada_x = coordenada_x;
		this.coordenada_y = coordenada_y;
	}
	
	public String getIdentificador_do_nó() {
		return identificador_do_nó;
	}
	public double getCoordenada_x() {
		return this.coordenada_x;
	}
	public double calcularDistancia(Cidade cidade) { //calcular a distancia euclidiana
		double deltaLongitude = cidade.getCoordenada_x() - this.getCoordenada_x();
		double deltaLatitude = cidade.getCoordenada_y() - this.getCoordenada_y();
		
		double potencia1 = Math.pow(deltaLongitude, 2);
		double potencia2 = Math.pow(deltaLatitude, 2);
		double somaPotencia = potencia1 + potencia2;
		return Math.sqrt(somaPotencia);
	}
	public double getCoordenada_y() {
		return this.coordenada_y;
	}
	public String toString() {
		return this.identificador_do_nó;
	}
}


