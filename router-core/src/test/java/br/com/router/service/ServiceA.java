package br.com.router.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import br.com.router.context.RouterContext;

public class ServiceA {
	
	public Response doSomething(@Context HttpServletResponse response, @Context HttpServletRequest request){
		/**
		 * Recupera instância do RouterContext, podendo também ser injetado
		 */
		RouterContext context = RouterContext.getInstance();
		
		/**
		 * Objeto que irá trafegar em todas as fases da execução
		 */
		//RouteContext routeContext = new RouteContext();
		//routeContext.addProperties("path", request.getPathInfo());
		//routeContext.setRequest(request);
		//Response result = context.process(routeContext);
		
		/**
		 * O método process recebe um HttpServletRequest como parâmetro.
		 * Ele é responsável por identificar os parâmetros recebidos e direcionar para o Route correto
		 */
		Response result = context.process(request);
		return result;
	}
}
