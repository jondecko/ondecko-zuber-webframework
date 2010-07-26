package testCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import actionPackage.*;
import junit.framework.TestCase;

public class ActionContainerTest extends TestCase 
{
	ActionContainer container1;
	ActionContainer container2;
	
	public ActionContainerTest()
	{
		container1 = new ActionContainer();
		container2 = new ActionContainer("/SearchByMLS.do", 
				"lab131.mlsapp.ListMlsAction");
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
	
	public void testConstructorInput()
	{
		assertEquals(0, container2.paramCount());
		assertEquals("/SearchByMLS.do", container2.getUrlPattern());
		assertEquals("lab131.mlsapp.ListMlsAction", container2.getActionClass());	
	}
	
	public void testResultHandlers()
	{
		assertEquals(0, container2.paramCount());
		container2.addResultHandler("SUCCESS", "/ShowListings.jsp");
		container2.addResultHandler("INPUT", "/SearchByMLS.html");
		container2.addResultHandler("NOTFOUND", "/NotFound.jsp");
		assertEquals("/ShowListings.jsp", container2.getResultHandler("SUCCESS"));
		assertEquals("/SearchByMLS.html", container2.getResultHandler("INPUT"));
		assertEquals("/NotFound.jsp", container2.getResultHandler("NOTFOUND"));
	}
	
	public void testOutput()
	{
		List<String> output = new ArrayList<String>();
		output.add("max");
		output.add("lady");
		output.add("spike");
		container2.addOutput("dogs", output);
		List<String> testList = (List<String>)container2.getOutputs().get("dogs");
		assertEquals("max", testList.get(0));
		assertEquals("lady", testList.get(1));
		assertEquals("spike", testList.get(2));
	}
}
