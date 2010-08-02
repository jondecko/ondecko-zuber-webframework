package edu.franklin.db.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ExecuteQuery extends AbstractSqlOperation 
{
	private String update; 
	private List<Object> paramList;
	ResultSetProcessor resultProcessor;
		
    public ExecuteQuery(ResultSetProcessor processor, String query,
            Object... params) 
    {
    	paramList = new ArrayList<Object>();
    	update = query;
    	resultProcessor = processor;
    	for (Object p : params)
    	{
    		paramList.add(p);
    	}
    }

    @Override
    public Object execute(Connection connection) throws SQLException 
    {
    	Statement st = null;
        st = connection.createStatement();
        
        /** Create the expression **/
        Pattern pat = Pattern.compile("\\?");
        String[] expressionArr = pat.split(update);
        
        update = "";
        int i = 0;
        for (Object p : expressionArr)
        {
     	   	if (i < paramList.size()) 
     	   	{
     	   		if (paramList.get(i).getClass().equals(Integer.class))
     	   			update = update + p.toString() + paramList.get(i).toString();
     	   		else
     	   			update = update + p.toString() + "'" + paramList.get(i).toString() + "'";
			}
     	   	else
     	   	{
     	   		update = update + p.toString();
     	   	}
			i++;
        }
        super.rs = st.executeQuery(update);
        resultProcessor.process(super.rs);
        st.close();
       
        //System.out.println(update);
        //System.out.println("---------------------------");
        return null;
    }
}
