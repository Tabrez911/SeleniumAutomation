package packng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class testng_prac {
	
	  @Test
	  public void fun3() { System.out.println("fun3"); }
	  
	  @Test
	  public void fun1() { System.out.println("fun1"); }
	  
	  @Test(priority=1)
	  public void fun2() { System.out.println("fun2"); }
	  
	  @Test
	  public void fun4() { System.out.println("fun4"); } 
	   
}
