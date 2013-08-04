package br.com.router.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.router.registry.strategy.SimpleRouterRegistryStrategy;
import br.com.router.routes.Route;
import br.com.router.routes.SimpleRouteA;
import br.com.router.routes.SimpleRouteB;
import br.com.router.routes.steps.Step;
import br.com.router.routes.strategy.SimpleRouterLoaderStrategy;
import br.com.router.steps.StepA;
import br.com.router.steps.StepB;

public class ServiceATest {
	
	private static final String PATH_A = "/service/a";
	private static final String PATH_B = "/service/b";
	
	@BeforeClass
	public void init(){
		prepareRouteA();
		prepareRouteB();
	}
	
	private static void prepareRouteA(){
		/**
		 * Adicionando step
		 */
		List<Step> steps = new ArrayList<Step>();
		steps.add(new StepA());
		steps.add(new StepB());
		SimpleRouterLoaderStrategy.addStepByRoute(PATH_A, steps);
		
		/**
		 * Instanciando uma rota de exemplo
		 */
		Route routeA = new SimpleRouteA("Route A", "[1]", PATH_A);
		
		/**
		 * Adicionando a rota no registro
		 */
		SimpleRouterRegistryStrategy.addRoute(routeA);
	}
	
	private static void prepareRouteB(){
		/**
		 * Adicionando step
		 */
		List<Step> steps = new ArrayList<Step>();
		steps.add(new StepA());
		SimpleRouterLoaderStrategy.addStepByRoute(PATH_B, steps);
		
		/**
		 * Instanciando uma rota de exemplo
		 */
		Route routeB = new SimpleRouteB("Route B", "[2]", PATH_B);
		
		/**
		 * Adicionando a rota no registro
		 */
		SimpleRouterRegistryStrategy.addRoute(routeB);
	}

	@Test
	public void testRouteA() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");
		request.addParameter("query", "testing");
		request.setPathInfo(PATH_A);

		ServiceA serviceA = new ServiceA();
		Response response = serviceA.doSomething(null, request);
		Assert.assertNotNull(response);
		System.out.println("Retornado: "+response.getEntity());
	}
	
	@Test
	public void testRouteB() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setMethod("GET");
		request.addParameter("query", "testing");
		request.setPathInfo(PATH_B);

		ServiceA serviceA = new ServiceA();
		Response response = serviceA.doSomething(null, request);
		Assert.assertNotNull(response);
		System.out.println("Retornado: "+response.getEntity());
	}

}
