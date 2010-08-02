package edu.franklin.db.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMakerProcessor implements ResultSetProcessor {

	//Map<String, ArrayList<Object>>  theMap;
	List<Map<String, Object>> listMap;
	
    public MapMakerProcessor() 
    {
    	//theMap = new HashMap<String, ArrayList<Object>>();
    	listMap = new ArrayList<Map<String, Object>>();
    }

    @Override
    public void process(ResultSet rs) throws SQLException 
    {
    	// Some code used from previous lab
    	//
    	// the order of the rows in a cursor
        // are implementation dependent unless you use the SQL ORDER statement
    	ResultSetMetaData meta   = rs.getMetaData();
        int              	colmax = meta.getColumnCount();
        //int              	i;
        int					j;
        
        /*for(i = 1; i <= colmax; i++)
        {
        	theMap.put(meta.getColumnName(i), new ArrayList<Object>());
        }   
        for (i = 1; rs.next(); i++) 
        {
            for (j = 1; j <= colmax; j++) 
            {
            	theMap.get(meta.getColumnName(i)).add(rs.getObject(j));
            	System.out.println(rs.getObject(j).toString());
            }
        }*/
        Map<String, Object> temp;
        for (; rs.next();)
        {
        	temp = new HashMap<String, Object>();
        	for (j = 1; j <= colmax; j++)
        	{
        		temp.put(meta.getColumnName(j), rs.getObject(j));
        	}
        	listMap.add(temp);
        }
    }

    public List<Map<String, Object>> getResults() 
    {
        return listMap;
    }
}
