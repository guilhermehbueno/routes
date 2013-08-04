package br.com.router.context;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import br.com.router.resolver.RouterResolver;
import br.com.router.routes.Route;
import br.com.router.routes.RouteContext;

/**
 * 
 * @author gbueno1_dsv
 *
 */

//TODO: Gerenciar multiplos contextos internamente para permitir o gerenciamento de routes e steps em tempo de execucão
public class RouterContext {
	
	private final RouterResolver resolver;
	
	private RouterContext(RouterResolver resolver) {
		super();
		this.resolver = resolver;
	}

	public Response process(HttpServletRequest request){
		RouteContext routeContext = new RouteContext();
		routeContext.addProperties("path", request.getPathInfo());
		routeContext.setRequest(request);
		return process(routeContext);
	}
	
	/**
	 * Atraves da instancia do objeto passado identifica para qual Route enviar
	 * @param request
	 * @return
	 */
	public Response process(Object request){
		RouteContext routeContext = new RouteContext();
		//TODO: Implementar algo como RouteContextConverter que irá converter a instancia recebida em um RouteContext
		return process(routeContext);
	}
	
	//TODO: Definir um tipo de objeto que ira trafegar entre todos os steps, 
	//TODO: este objeto deverá também conter o HttpServletRequest com seus parâmetros
	public Response process(RouteContext routeContext){
		Route route = this.resolver.resolve(routeContext);
		System.out.println("#### Starting route: "+route.getId()+", name: "+route.getName()+" ####");
		return route.start(routeContext);
	}

	public static RouterContext getInstance() {
		//TODO: Transformar em singleton
		return new RouterContext(RouterResolver.getInstance());
	}
}
