import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    // Holds our tour of cities
    private ArrayList<Cidade> caminho = new ArrayList<Cidade>();
    // Cache
    private int distance = 0;
    
    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TourManager.numeroCidades(); i++) {
            caminho.add(null);
        }
    }
    
    // Constructs a tour from another tour
    public Tour(ArrayList caminho){
        this.caminho = (ArrayList) caminho.clone();
    }
    
    // Returns tour information
    public ArrayList getTour(){
        return caminho;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TourManager.numeroCidades(); cityIndex++) {
          setCity(cityIndex, TourManager.getCidade(cityIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(caminho);
    }

    // Gets a city from the tour
    public Cidade getCidade(int tourPosition) {
        return (Cidade)caminho.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, Cidade city) {
        caminho.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    // Gets the total distance of the tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Get city we're traveling from
                Cidade fromCity = getCidade(cityIndex);
                // City we're traveling to
                Cidade destinationCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCidade(cityIndex+1);
                }
                else{
                    destinationCity = getCidade(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.calculaDistancia(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return caminho.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCidade(i)+"|";
        }
        return geneString;
    }
}