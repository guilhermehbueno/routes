package br.com.router.steps;

import br.com.router.routes.RouteContext;
import br.com.router.routes.steps.Step;

public class StepB implements Step {

	public void executeStep(RouteContext context) {
		System.out.println("Executando Step B");
	}
}
