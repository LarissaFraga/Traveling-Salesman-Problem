import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Driver1 {

	
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(new JFrame());
        File inputFile = fileChooser.getSelectedFile();
        System.out.println("Selected file : "+inputFile.getAbsolutePath());
        ArrayList<Cidade1> cities = new ArrayList<Cidade1>();
        try{
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] line_array = line.split(" ");
                cities.add(new Cidade1(line_array[0],Double.parseDouble(line_array[1]),Double.parseDouble(line_array[2])));
            }
            input.close();
        }catch (Exception e)
        {
            System.out.println("Error : "+e.getMessage() +" !");
        }
        /*
        * Até o momento está lendo o arquivo e preenchendo a lista de cidades
        * */
        Route1 route = new Route1(cities);
        // Inicialização da primeira solução
        HillClimbing hillClimbing = new HillClimbing();
        hillClimbing.findShortestRoute(route);
        // Lance o algoritmo com a solução inicial
    }
	
}
