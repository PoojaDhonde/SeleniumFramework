package test;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTests"})
public class TestNGGroupsSemo {

	@Test(groups= {"Sanity"})
	public void test1() {

		System.out.println("I'm inside Test1");

	}

	@Test(groups= {"Sanity","Smoke"})
	public void test2() {

		System.out.println("I'm inside Test2");

	}

	@Test(groups= {"Regression"})
	public void three() {

		System.out.println("I'm inside Test5");

	}

	@Test(groups= {"Sanity","Regression"})
	public void test4() {

		System.out.println("I'm inside Test4");

	}

	@Test
	public void five() {

		System.out.println("I'm inside Test3");
	}
	
	@Test
	public void Test6() {

		System.out.println("I'm inside Test6");
	}


}
