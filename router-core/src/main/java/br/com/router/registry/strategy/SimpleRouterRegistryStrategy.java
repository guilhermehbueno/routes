package br.com.router.registry.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.router.registry.RouterRegistryStrategy;
import br.com.router.routes.Route;

public class SimpleRouterRegistryStrategy implements RouterRegistryStrategy{
	
	private static final List<Route> routes = new ArrayList<Route>();
	

	public List<Route> loadRoutes() {
		return routes;
	}

	public boolean add(Route e) {
		return routes.add(e);
	}
	
	/**
	 * Para inserir routes estaticamente
	 * @param e
	 * @return
	 */
	public static boolean addRoute(Route e) {
		return routes.add(e);
	}

	public boolean remove(Object o) {
		return routes.remove(o);
	}

	public void clear() {
		routes.clear();
	}

	public Route get(int index) {
		return routes.get(index);
	}
	
	
	

}
