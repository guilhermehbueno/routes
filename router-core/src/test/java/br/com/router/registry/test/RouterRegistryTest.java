package br.com.router.registry.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import br.com.router.registry.RouterRegistry;

public class RouterRegistryTest {
	
	@Test
	public void test(){
		RouterRegistry registry = RouterRegistry.getInstance();
		Assert.assertNotNull(registry);
	}
}
