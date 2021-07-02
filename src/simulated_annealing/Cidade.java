public class Cidade {
    int x;
    int y;
    
    // escolhe uma cidade aleatoria
    public Cidade(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // constroi uma cidade com as coordenadas
    public Cidade(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    // calcula a distancia
    public double calculaDistancia(Cidade cidade){
        int xDistancia = Math.abs(getX() - cidade.getX());
        int yDistancia = Math.abs(getY() - cidade.getY());
        double distancia = Math.sqrt( (xDistancia*xDistancia) + (yDistancia*yDistancia) );
        
        return distancia;
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}