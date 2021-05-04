package test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters({"myName"})
	public void test(@Optional("Priti") String name) {

		System.out.println("My Name is:"+name);
	}

}
