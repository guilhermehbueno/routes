package br.com.router.resolver;

import java.util.List;
import br.com.router.registry.RouterRegistry;
import br.com.router.routes.Route;
import br.com.router.routes.RouteContext;

/**
 * Classe responsável por identificar o route correto para determinado request
 * @author gbueno1_dsv
 *
 */
//TODO: pode ser transformado em uma interface, e ter diferentes critérios para a identificação de um route
public class RouterResolver {
	
	private final List<Route> routes;
	
	private RouterResolver() {
		super();
		this.routes = RouterRegistry.getInstance().getRoutes();
	}
	
	public static RouterResolver getInstance(){
		return new RouterResolver();
	}

	public Route resolve(RouteContext routeContext){
		String path = routeContext.getProperties("path");
		Route result = null;
		for (Route route : this.routes) {
			if(path.equalsIgnoreCase(route.getPath())){
				result = route;
			}
		}
		return result;
	}
}
