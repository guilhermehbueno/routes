package br.com.router.routes.strategy;

import java.util.List;

import br.com.router.routes.Route;
import br.com.router.routes.steps.Step;

public interface RouteLoaderStrategy {
	
	public List<Step> loadSteps4Route(Route route);

}
