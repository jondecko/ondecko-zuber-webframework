package edu.franklin.db.sql;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExecuteUpdate extends AbstractSqlOperation 
{
	private String update; 
	private List<Object> paramList;
	
    public ExecuteUpdate(String query, Object... params) 
    {
    	paramList = new ArrayList<Object>();
    	update = query;
    	for (Object p : params)
    	{
    		paramList.add(p);
    	}
    }

    public Object execute(Connection c) throws SQLException 
    {
    	Statement st = null;
    	st = c.createStatement();
       
    	/** Create the expression **/
    	Pattern pat = Pattern.compile("\\?");
    	String[] expressionArr = pat.split(update);
    	update = "";
    	int i = 0;
    	for (Object p : expressionArr)
    	{
    		if (i < paramList.size())
    		{
    			update = update + p.toString() + "'" + paramList.get(i).toString() + "'";
    		}
    		else
    		{
    			update = update + p.toString();
    		}
    		i++;
    	}
    	int runQuery = st.executeUpdate(update);
    	if (-1 == runQuery) 
    	{
    		System.out.println("db error : " + update);
    	}
    	else
    	{
    		//System.out.println("UPDATE MADE");
    		//System.out.println(update);
    	}
    	st.close();
    	return null;
    }
}
