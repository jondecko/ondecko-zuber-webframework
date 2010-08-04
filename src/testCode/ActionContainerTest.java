package testCode;

import actionPackage.*;
import junit.framework.TestCase;

public class ActionContainerTest extends TestCase 
{
	ActionContainer container1;
	
	public ActionContainerTest()
	{
		container1 = new ActionContainer(ActionResult.SUCESS);
	}
	
	public void testBasic()
	{
		assertEquals(0, container1.paramCount());
		container1.addParam("dog", "woof");
		assertEquals(1, container1.paramCount());
		container1.removeParam("dog");
		assertEquals(0, container1.paramCount());
	}
	
	public void testClear()
	{
		assertEquals(0, container1.paramCount());
		container1.addParam("dog", "woof");
		container1.addParam("cat", "meow");
		assertEquals(2, container1.paramCount());
		container1.clearParams();
		assertEquals(0, container1.paramCount());
	}
	
	public void testGet()
	{
		assertEquals(0, container1.paramCount());
		container1.addParam("dog", "woof");
		container1.addParam("cat", "meow");
		container1.addParam("leet", 1337);
		container1.addParam("snake", "hiss");
		assertEquals(4, container1.paramCount());
		assertEquals("woof", container1.getParam("dog"));
		assertEquals("meow", container1.getParam("cat"));
		assertEquals(1337, container1.getParam("leet"));
		assertEquals("hiss", container1.getParam("snake"));	
		container1.clearParams();
		assertEquals(0, container1.paramCount());
		assertEquals(null, container1.getParam("dog"));
		assertEquals(null, container1.getParam("cat"));
		assertEquals(null, container1.getParam("leet"));
		assertEquals(null, container1.getParam("snake"));	
	}
}
