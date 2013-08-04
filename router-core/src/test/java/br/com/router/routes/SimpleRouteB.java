package br.com.router.routes;

import java.util.List;
import javax.ws.rs.core.Response;
import br.com.router.routes.steps.Step;
import br.com.router.routes.strategy.RouteLoaderStrategy;
import br.com.router.routes.strategy.SimpleRouterLoaderStrategy;

public class SimpleRouteB implements Route{
	
	private final String name;
	private final String id;
	private final String path;
	private final List<Step> steps;
	private final RouteLoaderStrategy strategy;
	
	public SimpleRouteB(String name, String id, String path) {
		super();
		this.name = name;
		this.id = id;
		this.path = path;
		this.strategy = new SimpleRouterLoaderStrategy();
		this.steps = this.strategy.loadSteps4Route(this);
	}

	public Response start(RouteContext context) {
		for (Step step : this.steps) {
			step.executeStep(context);
		}
		return getResponse(context);
	}
	
	private Response getResponse(RouteContext context){
		return Response.status(200).entity("{teste : 'OOO'}").build();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPath() {
		return path;
	}
}
