import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;


import actionPackage.*;


/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet 
{
	ActionMap actionMap;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException 
	{
		// Hard-code mapping solution for the action map
		// this can be put into an XML document later and parsed if needed
		// The ActionMap class should still be used for the mapping
		Map<String, String> resMap = new HashMap<String, String>();
		actionMap = new ActionMap();
		// ListEmployeesAction
		resMap.put("SUCCES", "/ListEmployees.jsp");
		resMap.put("INPUT", "/ListEmployees.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmp.do", 
				"actionPackage.ListEmployeesAction", resMap);
		// ListEmployeesByIdAction
		resMap = new HashMap<String, String>();
		resMap.put("SUCCES", "/ListEmployees.jsp");
		resMap.put("INPUT", "/FormById.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpById.do", 
				"actionPackage.ListEmployeesByIdAction", resMap);
		// ListEmployeesByTitleAction
		resMap.put("SUCCES", "/ListEmployees.jsp");
		resMap.put("INPUT", "/FormByTitle.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpByTitle.do", 
				"actionPackage.ListEmployeesByTitleAction", resMap);
		// ListEmployeesByTitleAction
		resMap.put("SUCCES", "/ListEmployeePayroll.jsp");
		resMap.put("INPUT", "/ListEmployeesSelect.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpByPayroll.do", 
				"actionPackage.ListEmployeesByPayrollAction", resMap);
		// End of map creation
		
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//BusinessCommands helper = new BusinessCommands();
		try
		{
			String reqURI = request.getRequestURI();
			ActionContainer actionContainerParam = new ActionContainer();
			Class theAction = Class.forName(actionMap.getActionclass(reqURI));
			Object theActionObject = theAction.newInstance();
			Method foundProcessMethod = findProcessMethod(theAction);	
			foundProcessMethod.invoke(theActionObject, actionContainerParam);
		}
		catch (Exception e)
		{
			System.out.println("CAUGHT!!!");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// WILL HAVE TO ADD MORE... JUST A COPY AND PASTE FROM THE doGet for now
		try
		{
			String reqURI = request.getRequestURI();
			ActionContainer actionContainerParam = new ActionContainer();
			Class theAction = Class.forName(actionMap.getActionclass(reqURI));
			Object theActionObject = theAction.newInstance();
			Method foundProcessMethod = findProcessMethod(theAction);	
			foundProcessMethod.invoke(theActionObject, actionContainerParam);
		}
		catch (Exception e)
		{
			System.out.println("CAUGHT!!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * findProcessMethod function.
	 * 
	 * This helper function will scan though the class passed in and look for a method by the name of
	 * "process".  The "process" method should be apart of any class that was implimented off of the
	 * Action base class.fs
	 * 
	 * @param classParam
	 * @return
	 * @throws Exception
	 */
	private static Method findProcessMethod(Class classParam) throws Exception
	{
		Method[] methods = classParam.getMethods();
		for(int i = 0; i < methods.length; i++)
		{
			if (methods[i].getName().equals("process"));
			{
				//System.out.println(methods[i].toString());
				return methods[i];
			}
		}
		// process method not found
		return null;
	}
}
