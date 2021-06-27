
public class HillClimbing {
	
	public static final int ITERATIONS_BEFORE_MAXIMA = 100000;
	
	public Route1 findShortestRoute( Route1 currentRoute) {
		Route1 adjacentRoute;
		int iterToMaximaCounter = 0;
		String compareRoutes = null;
		while(iterToMaximaCounter < ITERATIONS_BEFORE_MAXIMA) {
			adjacentRoute = obtainAdjacentRoute( new Route1(currentRoute));
			if(adjacentRoute.getTotalDistance() <= currentRoute.getTotalDistance()) {
				compareRoutes = "<-(proceed)";
				iterToMaximaCounter = 0;
				currentRoute = new Route1(adjacentRoute);	
			}else compareRoutes = "> (stay) - iteration#"+ iterToMaximaCounter++;
				
			System.out.println(" | "+compareRoutes);
			System.out.println(currentRoute + " | "+currentRoute.getTotalStringDistance());
		}
		if(iterToMaximaCounter == ITERATIONS_BEFORE_MAXIMA) System.out.println(" | potential Maxima");
		else System.out.println(" | "+compareRoutes);
		return currentRoute;
		
	}
	public Route1 obtainAdjacentRoute( Route1 route) {
		int x1 =0, x2=0;
		while(x1 == x2) {
			x1= (int) (route.getCidades().size()*Math.random());
			x2= (int) (route.getCidades().size()*Math.random());
		}
		
		Cidade1 cidade1 = route.getCidades().get(x1);
		Cidade1 cidade2 = route.getCidades().get(x2);
		route.getCidades().set(x2, cidade1);
		route.getCidades().set(x1, cidade2);
		
		return route;
		
	}
}
