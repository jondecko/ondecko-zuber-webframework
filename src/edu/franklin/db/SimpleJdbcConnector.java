package edu.franklin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

public class SimpleJdbcConnector implements JdbcConnector 
{
	/** Connection to the database **/
	private List<Connection> conn;
	/** Properties of the database **/
	private DatabaseProperties properties;
	
	
    public SimpleJdbcConnector(DatabaseProperties dbProps) throws Exception
    {
    	Class.forName("org.hsqldb.jdbcDriver");
    	properties = dbProps;
    	conn = new LinkedList<Connection>();
    }

    public Connection getConnection() throws Exception
    {    	
    	if (conn.add(DriverManager.getConnection(properties.getUrl(), 
    			properties.getUserName(),
    			properties.getPassword())))
    	{
    		return conn.get(conn.size() - 1);
    	}
    	return null;
    }

    public void closeConnection(Connection connection) throws Exception
    {
    	for (int i = 0; i < conn.size(); i++)
    	{
    		if (conn.get(i).equals(connection))
    		{
    			conn.get(i).close();
    			conn.remove(i);
    			return;
    		}
    	}
    }
}
