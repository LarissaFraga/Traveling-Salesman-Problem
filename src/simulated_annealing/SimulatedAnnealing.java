public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static Tour simmulatedAnnealing(Tour currentRoute){
        // Create and add our cities
        Cidade city = new Cidade(60, 200);
        TourManager.adicionaCidade(city);
        

        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        
        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // Set as current best
        Tour best = new Tour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            Cidade citySwap1 = newSolution.getCidade(tourPos1);
            Cidade citySwap2 = newSolution.getCidade(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            // Get energy of solutions
            int currentEnergy = currentSolution.getDistance();
            int neighbourEnergy = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }
            
            // Cool system
            temp *= 1-coolingRate;
        }

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);

        return currentRoute;
    }
}