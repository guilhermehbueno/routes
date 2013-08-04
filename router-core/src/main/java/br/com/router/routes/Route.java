package br.com.router.routes;

import javax.ws.rs.core.Response;

public interface Route {
	
	public String getId();
	public String getName();
	public String getPath();
	public Response start(RouteContext context);

}
