
public class Cidade1 {
	private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
	private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI/1800;
	private static final double CONVERT_KM_TO_MILES = 0.621371;
	private double longitude;
	private double latitude;
	private String name;
	
	public Cidade1(String name,double latitude, double longitude) {
		this.name =name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	public String getName() {
		return name;
	}
	public double getLongitude() {
		return this.longitude;
	}
	public double mensuredistance(Cidade1 cidade) { //medir a distancia
		double deltaLongitude = cidade.getLongitude() - this.getLongitude();
		double deltaLatitude = cidade.getLatitude() - this.getLatitude();
		
		double potencia1 = Math.pow(deltaLongitude, 2);
		double potencia2 = Math.pow(deltaLatitude, 2);
		double somaPotencia = potencia1 + potencia2;
		return Math.sqrt(somaPotencia);
	}
	public double getLatitude() {
		return this.latitude;
	}
	public String toString() {
		return this.name;
	}
}
