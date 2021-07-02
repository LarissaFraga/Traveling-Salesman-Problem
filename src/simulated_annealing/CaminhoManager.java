import java.util.ArrayList;

public class CaminhoManager {

    // Armazena cidades
    private static ArrayList<Cidade> cidadesDestinos = new ArrayList<Cidade>();

    public static void adicionaCidade(Cidade cidade) {
        cidadesDestinos.add(cidade);
    }
    
    public static Cidade getCidade(int index){
        return (Cidade)cidadesDestinos.get(index);
    }
  
    public static int numeroCidades(){
        return cidadesDestinos.size();
    }
    
}
