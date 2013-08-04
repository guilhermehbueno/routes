package br.com.router.registry;

import java.util.List;

import br.com.router.routes.Route;

public interface RouterRegistryStrategy {
	
	public List<Route> loadRoutes();

}
