package edu.franklin.db.sql;

import java.sql.Connection;
import java.sql.SQLException;

import edu.franklin.db.JdbcConnector;

/**
 * Execute some database call given the connection.
 * @author WhittakT
 * @version 1.0
 */
public interface SqlOperation extends Command {
    Object execute(Connection connection) throws SQLException;
    void setJdbcConnector(JdbcConnector connector);
}
