package edu.franklin.db.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompositeSqlOperation extends AbstractSqlOperation 
{
	List<SqlOperation> operations;
	
    public CompositeSqlOperation() 
    {
        operations = new ArrayList<SqlOperation>();
    }
    
    public void addSqlOperation(SqlOperation operation) 
    {
        operations.add(operation);
    }

    @Override
    public Object execute(Connection c) throws SQLException 
    {
    	// I never use the connection in this method.  Right now, it is assuming that
    	// each SqlOperation is going to have a concrete class with an execute method 
    	// already built.  In this assignment, it will be using ExecuteUpdate &
    	// ExecuteQuery "execute()" methods
        for(SqlOperation o : operations)
        {
        	o.execute();
        }
        return null;
    }
}
