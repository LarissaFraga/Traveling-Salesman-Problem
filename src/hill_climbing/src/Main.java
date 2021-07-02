import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		JFileChooser arquivos = new JFileChooser();
		arquivos.showOpenDialog(new JFrame());
        File arquivoEntrada = arquivos.getSelectedFile();
        System.out.println("Arquivo Selecionado : "+arquivoEntrada.getAbsolutePath());
        ArrayList<Cidade> cities = new ArrayList<Cidade>();
        try{
            Scanner entrada = new Scanner(arquivoEntrada);
            while (entrada.hasNextLine())
            {
                String linha = entrada.nextLine();
                String[] linha_array = linha.split(" ");
                cities.add(new Cidade(linha_array[0],Double.parseDouble(linha_array[1]),Double.parseDouble(linha_array[2])));
            }
            entrada.close();
        }catch (Exception e)
        {
            System.out.println("Erro : "+e.getMessage() +" !");
        }
        /*
        * Até o momento está lendo o arquivo e preenchendo a lista de cidades
        * */
        Caminho caminho = new Caminho(cities);
        // Inicialização da primeira solução
        Hill_Climbing hill_Climbing = new Hill_Climbing();
        hill_Climbing.encontrarMenorCaminho(caminho);
        // Lance o algoritmo com a solução inicial
    }

}
