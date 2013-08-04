package br.com.router.registry;

import java.util.ArrayList;
import java.util.List;

import br.com.router.registry.strategy.SimpleRouterRegistryStrategy;
import br.com.router.routes.Route;

public class RouterRegistry {
	
	private final RouterRegistryStrategy strategy;
	private final List<Route> routes;

	private RouterRegistry(RouterRegistryStrategy strategy) {
		super();
		this.strategy = strategy;
		this.routes = new ArrayList<Route>();
		this.routes.addAll(strategy.loadRoutes());
	}
	
	public static RouterRegistry getInstance(){
		//TODO: IMPLEMENTAR SINGLETON
		return new RouterRegistry(new SimpleRouterRegistryStrategy());
	}
	
	public void load(){
		routes.addAll(strategy.loadRoutes());
	}
	
	public void reload(){
		load();
	}
	
	public List<Route> getRoutes(){
		return routes;
	}
	
	public void addRoute(Route route){
		this.routes.add(route);
	}
}
