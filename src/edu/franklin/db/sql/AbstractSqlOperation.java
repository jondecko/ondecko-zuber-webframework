package edu.franklin.db.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.franklin.db.DatabaseProperties;
import edu.franklin.db.JdbcConnector;
import edu.franklin.db.SimpleJdbcConnector;

/**
 * A class that manages the lifecycle of connections, prepared statements, and
 * result sets. Subclasses should override the execute(Connection) method to
 * perform the query using the provided open connection. This class's execute()
 * method will ensure that any resources used by the subclass are returned
 * (provided that the subclasses use the protected members here).
 * 
 * @author WhittakT
 * @version 1.0
 */
public abstract class AbstractSqlOperation implements Command, SqlOperation {

    /** Used in sub-classes. Closed automatically here. */
    protected PreparedStatement ps;
    /** Used in sub-classes. Closed automatically here. */
    protected ResultSet rs;
    /** Used to provide a database connection. */
    protected JdbcConnector connector;

    /**
     * Constructor to initialize protected fields.
     */
    public AbstractSqlOperation() {
        ps = null;
        rs = null;
    }

    /**
     * Must be implemented by the concrete subclass. If the operation is a query
     * or other operation, it should return the return data in some object,
     * otherwise return null.
     */
    public abstract Object execute(Connection connection) throws SQLException;

    /**
     * The only public method in this class. It is used to execute the SQL
     * operation by calling the execute(Connection) method. Note that acquiring
     * a connection for every query is not a problem if the connections are
     * pooled by the JdbcConnection implementation. This is also why it is
     * closed after every query. This simply places the connection back in the
     * pool.
     */
    public Object execute() 
    {
        try 
        {
			/** Database properties for an in-memory HSQLDB database */
			//DatabaseProperties dbProps = new DatabaseProperties(
			//        "org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "sa", "");
			DatabaseProperties dbProps = new DatabaseProperties(
			        "org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost:9001//xdb", "sa", "");
			/** A JdbcConnector using the above properties. */
			JdbcConnector connector = new SimpleJdbcConnector(dbProps);
			
			Connection conn = connector.getConnection();
			execute(conn);
			connector.closeConnection(conn);
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        return null;
    }

    /**
     * Set a new JDBCConnector. Allows the Connection mechanism to be varied
     * independent from the AbstractSqlOperation Hierarchy.
     */
    public void setJdbcConnector(JdbcConnector connector) {
        this.connector = connector;
    }

    /**
     * Get a JDBC connection.
     */
    protected Connection getJdbcConnection() 
    {
        try 
        {
			return connector.getConnection();
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
			return null;
		}
    }
}
