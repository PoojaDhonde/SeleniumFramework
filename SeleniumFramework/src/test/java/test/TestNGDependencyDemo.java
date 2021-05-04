package test;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test(dependsOnMethods = {"test2","test3"})
	public void test1() {
		
		System.out.println("I'm inside Test1");
	}
	
	@Test(dependsOnGroups = {"Functional.*"})
	public void test2() {
		
		System.out.println("I'm inside Test2");
	}
	
	@Test(groups = {"Functional"})
	public void test3() {
		
		System.out.println("I'm inside Test3");
	}
	
	@Test(groups = {"Functional1"})
	public void test4() {
		
		System.out.println("I'm inside Test4");
	}

}
