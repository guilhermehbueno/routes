package br.com.router.routes.steps;

import br.com.router.routes.RouteContext;

//TODO: Para se registrar a execuçõ de cada step pode utilizar o pattern template_method
// e transformar esta interface em uma classe abstrata
public interface Step {
	
	public void executeStep(RouteContext context);

}
