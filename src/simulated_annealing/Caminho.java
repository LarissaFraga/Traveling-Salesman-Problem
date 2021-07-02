import java.util.ArrayList;
import java.util.Collections;

public class Caminho{

    private ArrayList<Cidade> caminho = new ArrayList<Cidade>();
    private int distancia = 0;
    
    public Caminho(){
        for (int i = 0; i < CaminhoManager.numeroCidades(); i++) {
            caminho.add(null);
        }
    }
    
    public Caminho(ArrayList caminho){
        this.caminho = (ArrayList) caminho.clone();
    }
    
    public ArrayList getCaminho(){
        return caminho;
    }

    // Cria um ponto aleatorio
    public void generateIndividual() {
        for (int cidadeIndex = 0; cidadeIndex < CaminhoManager.numeroCidades(); cidadeIndex++) {
          setCidade(cidadeIndex, CaminhoManager.getCidade(cidadeIndex));
        }
        // Rordena o caminho
        Collections.shuffle(caminho);
    }

    public Cidade getCidade(int caminhoPosicao) {
        return (Cidade)caminho.get(caminhoPosicao);
    }

    // Coloca uma cidade numa posição dentro do caminho
    public void setCidade(int caminhoPosicao, Cidade city) {
        caminho.set(caminhoPosicao, city);
        distancia = 0;
    }
    
    public int getDistancia(){
        if (distancia == 0) {
            int caminhoDistancia = 0;
            
            for (int cityIndex=0; cityIndex < tamanhoCaminho(); cityIndex++) {
                Cidade cidadeOrigem = getCidade(cityIndex);
                Cidade cidadeDestino;
                // Checa se nao e a cidade final
                if(cityIndex+1 < tamanhoCaminho()){
                    cidadeDestino = getCidade(cityIndex+1);
                }
                else{
                    cidadeDestino = getCidade(0);
                }
                // calcula a distancia entre as cidades
                caminhoDistancia += cidadeOrigem.calculaDistancia(cidadeDestino);
            }
            distancia = caminhoDistancia;
        }
        return distancia;
    }

    public int tamanhoCaminho() {
        return caminho.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tamanhoCaminho(); i++) {
            geneString += getCidade(i)+"|";
        }
        return geneString;
    }
}