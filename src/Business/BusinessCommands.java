package Business;
import java.util.List;
import java.util.Map;

import edu.franklin.db.sql.AbstractSqlOperation;
import edu.franklin.db.sql.ExecuteQuery;
import edu.franklin.db.sql.ExecuteUpdate;
import edu.franklin.db.sql.MapMakerProcessor;


public class BusinessCommands 
{
	int id;
	
	public BusinessCommands()
	{
		id = 1;
	}
	
    public void CreateEmployee(String name, String position, double salary, String address, double vacation)
    {
    	AbstractSqlOperation input;
    	String command = "INSERT INTO EMPLOYEES(EMPID, NAME, TITLE, SALARY, ADDRESS, VACATION)" +
    		"VALUES (?, ?, ?, ?, ?, ?)";
    	input =  new ExecuteUpdate(command, id, name, position, salary, address, vacation);
    	id++;
    	input.execute();
    }
    
    public MapMakerProcessor SearchByEmployeeID(int employeeID)
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	String command = "SELECT * FROM EMPLOYEES WHERE EMPID=?";
    	AbstractSqlOperation query = new ExecuteQuery(queryResults, command, employeeID);
    	query.execute();
    	//printRows(queryResults.getResults());
    	return queryResults;
    }
    
    public MapMakerProcessor ListAllEmployees()
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	String command = "SELECT * FROM EMPLOYEES";
    	AbstractSqlOperation query = new ExecuteQuery(queryResults, command);
    	query.execute();
    	return queryResults;
    }
    
    public MapMakerProcessor ListByTitle(String title)
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	String command = "SELECT * FROM EMPLOYEES WHERE TITLE=?";
    	AbstractSqlOperation query = new ExecuteQuery(queryResults, command, title);
    	query.execute();
    	//printRows(queryResults.getResults());
    	return queryResults;
    }
    
    public MapMakerProcessor ListTitles()
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	String command = "SELECT DISTINCT TITLE FROM EMPLOYEES";
    	AbstractSqlOperation query = new ExecuteQuery(queryResults, command);
    	query.execute();
    	return queryResults;
    }
    
    public MapMakerProcessor ListIds()
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	String command = "SELECT DISTINCT EMPID FROM EMPLOYEES";
    	AbstractSqlOperation query = new ExecuteQuery(queryResults, command);
    	query.execute();
    	return queryResults;
    }
    
    public MapMakerProcessor ListByIDs(String[] numberList)
    {
    	MapMakerProcessor queryResults = new MapMakerProcessor();
    	if (null == numberList)
    	{
    		System.out.println("0 selections");
    		return queryResults;
    	}
    	else
    	{
        	int length = numberList.length;
        	
    		// Create the proper command string
    		String command = "SELECT * FROM EMPLOYEES WHERE EMPID=";
    		for(int i = 0; i < length; i++)
    		{
    			command = command + numberList[i];
    			if (i+1 < length)
    			{
    				command = command + " OR EMPID=";
    			}
    		} 		
    		AbstractSqlOperation query = new ExecuteQuery(queryResults, command);
    		query.execute();
    		return queryResults;
    	}
    }
    
    public void ChangeSalary(int employeeID, double newSalary)
    {
    	AbstractSqlOperation input;
    	String command = "UPDATE EMPLOYEES " +
    			"SET SALARY=" + newSalary + ' ' +
    			"WHERE EMPID=" + employeeID;

    	input =  new ExecuteUpdate(command);
    	input.execute();
    }
    
    public void DeleteEmployee(int employeeID)
    {
     	AbstractSqlOperation input;
    	String command = "DELETE FROM EMPLOYEES " +
    			"WHERE EMPID=" + employeeID;

    	input =  new ExecuteUpdate(command);
    	input.execute();
    }
    
    @SuppressWarnings("unused")
	private void printRows(List<Map<String, Object>> rows)
    {
    	String out;
    	for (Map<String, Object> resMap : rows)
        {
    		out = "";
    		if (null != resMap.get("EMPID"))
    			out = out + resMap.get("EMPID").toString() + '\t';
    		if (null != resMap.get("NAME"))
    			out = out + resMap.get("NAME").toString() + '\t';
    		if (null != resMap.get("TITLE"))
    			out = out + resMap.get("TITLE").toString() + '\t';
    		if (null != resMap.get("SALARY"))
    			out = out + resMap.get("SALARY").toString() + '\t';
    		if (null != resMap.get("ADDRESS"))
    			out = out + resMap.get("ADDRESS").toString() + '\t';
    		if (null != resMap.get("VACATION"))
    			out = out + resMap.get("VACATION").toString() + '\t';
    			
    		System.out.println(out);
    	}
    	System.out.println("---------------------------");
    }
}
