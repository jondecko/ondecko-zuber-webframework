package actionPackage;

public class ListEmployeesByTitleAction implements Action 
{
		@Override
		public ActionResult process(ActionContainer data) 
		{
			System.out.println("ListEmployeesByTitleAction: MADE IT!");
			
			return null;
		}
}
