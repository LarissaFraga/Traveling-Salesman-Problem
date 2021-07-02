public class SimulatedAnnealing {

    public static double probabilidade(int energia, int novaEnergia, double temperatura) {
        if (novaEnergia < energia) {
            return 1.0;
        }
        return Math.exp((energia - novaEnergia) / temperatura);
    }

    public static Caminho simmulatedAnnealing(Caminho caminhoAtual){
        
        // temperatura inicial
        double temp = 10000;

        // taxa de esfriamento
        double coolingRate = 0.003;

        Caminho solucaoAtual = caminhoAtual;

        Caminho melhorCaminho = new Caminho(solucaoAtual.getCaminho());
        
        while (temp > 1) {
            // Cria o caminho do vizinho
            Caminho solucaoNova = new Caminho(solucaoAtual.getCaminho());

            // Seleciona posicoes aleatorias no caminho
            int caminhoPos1 = (int) (solucaoNova.tamanhoCaminho() * Math.random());
            int caminhoPos2 = (int) (solucaoNova.tamanhoCaminho() * Math.random());

            // Coleta as posicoes das cidades selecionadas no caminho
            Cidade trocaCidade1 = solucaoNova.getCidade(caminhoPos1);
            Cidade trocaCidade2 = solucaoNova.getCidade(caminhoPos2);

            // Troca as cidades
            solucaoNova.setCidade(caminhoPos2, trocaCidade1);
            solucaoNova.setCidade(caminhoPos1, trocaCidade2);
            
            // Calcula a energia
            int energiaAtual = solucaoAtual.getDistancia();
            int energiaVizinho = solucaoNova.getDistancia();

            // Decide se deve aceitar o vizinho
            if (probabilidade(energiaAtual, energiaVizinho, temp) > Math.random()) {
                solucaoAtual = new Caminho(solucaoNova.getCaminho());
            }

            // Rastreia a melhor solucao
            if (solucaoAtual.getDistancia() < melhorCaminho.getDistancia()) {
                melhorCaminho = new Caminho(solucaoAtual.getCaminho());
            }
            
            // Esfria a temperatura
            temp *= 1-coolingRate;
        }

        System.out.println("Distancia da solucao final: " + melhorCaminho.getDistancia());
        System.out.println("Caminho: " + melhorCaminho);

        return caminhoAtual;
    }
}