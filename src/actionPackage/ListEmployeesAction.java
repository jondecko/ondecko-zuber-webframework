package actionPackage;

import edu.franklin.db.sql.MapMakerProcessor;
import Business.BusinessCommands;


public class ListEmployeesAction implements Action 
{
	@Override
	public void process(ActionContainer data) 
	{
		BusinessCommands busHelper = new BusinessCommands();
		MapMakerProcessor results;
		
		switch (data.getActionResult())
		{
		case INPUT:
			results = busHelper.ListAllEmployees();
			data.addOutput("results", results.getResults());
			break;
			
		case SUCESS:
			break;
			
		case NOTFOUND:
			break;
		}
	}
}
