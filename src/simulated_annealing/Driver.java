import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Driver {

	
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(new JFrame());
        File inputFile = fileChooser.getSelectedFile();
        System.out.println("Selected file : "+inputFile.getAbsolutePath());
        ArrayList<Cidade> cities = new ArrayList<Cidade>();
        try{
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] line_array = line.split(" ");
                cities.add(new Cidade(Integer.parseInt(line_array[1]),Integer.parseInt(line_array[2])));
            }
            input.close();
        }catch (Exception e)
        {
            System.out.println("Error : "+e.getMessage() +" !");
        }
        /*
        * Até o momento está lendo o arquivo e preenchendo a lista de cidades
        * */
        Caminho tour = new Caminho(cities);
        // Inicialização da primeira solução
        //SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        SimulatedAnnealing.simmulatedAnnealing(tour);
        // Lance o algoritmo com a solução inicial
    }
	
}
