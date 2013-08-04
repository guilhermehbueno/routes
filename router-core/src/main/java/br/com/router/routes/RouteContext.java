package br.com.router.routes;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RouteContext {
	
	private HttpServletRequest request;
	private final Map<String,Object> properties;
	//TODO: Definir atributo que irá registrar a execucao de cada step, para que a app saiba quais steps foram executados
	
	public RouteContext() {
		super();
		this.properties = new HashMap<String, Object>();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getProperties(String key){
		return this.properties.get(key)+"";
	}

	public void addProperties(String key, Object value) {
		properties.put(key, value);
	}
}
