package actionPackage;


public class ListEmployeesAction implements Action 
{
	@Override
	public ActionResult process(ActionContainer data) 
	{
		System.out.println("ListEmployeesAction: MADE IT!");
		
		return null;
	}
}
