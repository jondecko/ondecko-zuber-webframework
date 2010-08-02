package actionPackage;

public class ListEmployeesByPayrollAction implements Action 
{
	@Override
	public ActionResult process(ActionContainer data) 
	{
		System.out.println("ListEmployeesByPayrollAction: MADE IT!");
		
		return null;
	}
}
