package actionPackage;

import Business.BusinessCommands;
import edu.franklin.db.sql.MapMakerProcessor;

public class ListEmployeesByIdAction implements Action 
{
	@Override
	public void process(ActionContainer data) 
	{
		BusinessCommands busHelper = new BusinessCommands();
		MapMakerProcessor results;
		
		switch (data.getActionResult())
		{
		case INPUT:
			results = busHelper.ListIds();
			data.addOutput("results", results.getResults());			
			break;
			
		case SUCESS:
			int id = Integer.parseInt((String) data.getParam("id"));
			results = busHelper.SearchByEmployeeID(id);
			data.addOutput("results", results.getResults());
			break;
			
		case NOTFOUND:
			break;
		}
	}
}
