package br.com.router.routes.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.router.routes.Route;
import br.com.router.routes.steps.Step;

public class SimpleRouterLoaderStrategy implements RouteLoaderStrategy {
	
	private static final Map<String, List<Step>> stepsByRoute = new HashMap<String, List<Step>>();
	
	public static void addStepByRoute(String route, List<Step> steps){
		stepsByRoute.put(route, steps);
	}
	
	public List<Step> loadSteps4Route(Route route) {
		String path = route.getPath();
		return stepsByRoute.get(path);
	}
}
