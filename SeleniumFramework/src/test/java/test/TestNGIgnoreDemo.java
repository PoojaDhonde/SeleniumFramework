package test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGIgnoreDemo {
	
	@Ignore//can put at class level also or package level by creating package with same name and adding Ignore 
	@Test
	public void test1() {
		
		System.out.println("I'm inside test1");
	}
	
	@Test
	public void test2() {
		
		System.out.println("I'm inside test2");
	}

}
