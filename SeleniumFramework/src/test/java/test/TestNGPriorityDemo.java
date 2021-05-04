package test;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {

	@Test(priority = 1)
	public void test1() {

		System.out.println("I'm inside Test1");

	}

	@Test(priority = -1)
	public void test2() {

		System.out.println("I'm inside Test2");

	}

	@Test(priority = 2)
	public void three() {

		System.out.println("I'm inside Test3");

	}

	@Test(priority = 0)
	public void test4() {

		System.out.println("I'm inside Test4");

	}

	@Test(priority = 2)
	public void five() {

		System.out.println("I'm inside Test5");
	}
	
	@Test
	public void Test6() {

		System.out.println("I'm inside Test6");
	}


}
