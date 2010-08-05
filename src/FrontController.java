import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
    }
    
	@Override
	public void init() throws ServletException 
	{
		// Hard-code mapping solution for the action map
		// this can be put into an XML document later and parsed if needed
		// The ActionMap class should still be used for the mapping
		
		actionMap = new ActionMap();
		// ListEmployeesAction
		Map<ActionResult, String> resMap = new HashMap<ActionResult, String>();
		resMap.put(ActionResult.SUCESS, "/ListEmployees.jsp");
		resMap.put(ActionResult.INPUT, "/ListEmployees.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmp.do", 
				"actionPackage.ListEmployeesAction", resMap);
		// ListEmployeesByIdAction
		Map<ActionResult, String> resMap2 = new HashMap<ActionResult, String>();
		resMap2.put(ActionResult.SUCESS, "/ListEmployees.jsp");
		resMap2.put(ActionResult.INPUT, "/FormById.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpById.do", 
				"actionPackage.ListEmployeesByIdAction", resMap2);
		// ListEmployeesByTitleAction
		Map<ActionResult, String> resMap3 = new HashMap<ActionResult, String>();
		resMap3.put(ActionResult.SUCESS, "/ListEmployees.jsp");
		resMap3.put(ActionResult.INPUT, "/FormByTitle.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpByTitle.do", 
				"actionPackage.ListEmployeesByTitleAction", resMap3);
		// ListEmployeesByTitleAction
		Map<ActionResult, String> resMap4 = new HashMap<ActionResult, String>();
		resMap4.put(ActionResult.SUCESS, "/ListEmployeePayroll.jsp");
		resMap4.put(ActionResult.INPUT, "/ListEmployeesSelect.jsp");
		actionMap.addAction("/ondecko-zuber-webframework/listEmpByPayroll.do", 
				"actionPackage.ListEmployeesByPayrollAction", resMap4);
		// End of map creation
		
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			// Get everything ready and sent to the proper action
			String reqURI = request.getRequestURI();
			Class theAction = Class.forName(actionMap.getActionclass(reqURI));
			Object theActionObject = theAction.newInstance();
			Method foundProcessMethod = findProcessMethod(theAction);
			ActionContainer actionContainer = new ActionContainer(ActionResult.INPUT);
			foundProcessMethod.invoke(theActionObject, actionContainer);
						
			// Get everything ready and sent to the proper view
			String mappedResult = actionMap.getResult(reqURI, ActionResult.INPUT);
			request.setAttribute("results", actionContainer.getOutputs().get("results"));
			RequestDispatcher view = request.getRequestDispatcher(mappedResult);
			view.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println("doGet CAUGHT!!!");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String reqURI = request.getRequestURI();
			Class theAction = Class.forName(actionMap.getActionclass(reqURI));
			Object theActionObject = theAction.newInstance();
			Method foundProcessMethod = findProcessMethod(theAction);
			ActionContainer actionContainer = new ActionContainer(ActionResult.SUCESS);
			
			String param;
			Enumeration temp = request.getParameterNames();
			while(temp.hasMoreElements())
			{
				param = temp.nextElement().toString();
				actionContainer.addParam(param, request.getParameterValues(param));
			}
			foundProcessMethod.invoke(theActionObject, actionContainer);
			
			// Get everything ready and sent to the proper view
			String mappedResult = actionMap.getResult(reqURI, ActionResult.SUCESS);
			request.setAttribute("results", actionContainer.getOutputs().get("results"));
			RequestDispatcher view = request.getRequestDispatcher(mappedResult);
			view.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println("doPost CAUGHT!!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * findProcessMethod function.
	 * 
	 * This helper function will scan though the class passed in and look for a method by the name of
	 * "process".  The "process" method should be apart of any class that was implemented off of the
	 * Action base class.fs
	 * 
	 * @param classParam
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
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
