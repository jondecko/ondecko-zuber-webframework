package actionPackage;

import Business.BusinessCommands;
import edu.franklin.db.sql.MapMakerProcessor;

public class ListEmployeesByPayrollAction implements Action 
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
			results = busHelper.ListByIDs((String[]) data.getParam("selections"));
			data.addOutput("results", results.getResults());
			break;
		
		case NOTFOUND:
			break;
		}
	}
}
