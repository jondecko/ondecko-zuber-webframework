package actionPackage;

import Business.BusinessCommands;
import edu.franklin.db.sql.MapMakerProcessor;

public class ListEmployeesByTitleAction implements Action 
{
		@Override
		public void process(ActionContainer data) 
		{
			BusinessCommands busHelper = new BusinessCommands();
			MapMakerProcessor results;
			
			switch (data.getActionResult())
			{
			case INPUT:
				results = busHelper.ListTitles();
				data.addOutput("results", results.getResults());	
				break;
				
			case SUCESS:
				String[] temp = (String[]) data.getParam("title");
				String title = temp[0];
				results = busHelper.ListByTitle(title);
				data.addOutput("results", results.getResults());
				break;
				
			case NOTFOUND:
				break;
			}
		}
}
