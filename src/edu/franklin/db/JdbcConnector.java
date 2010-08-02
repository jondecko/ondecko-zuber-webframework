package edu.franklin.db;

import java.sql.Connection;

/**
 * An interface for getting and closing connections. A simple implementation
 * would just invoke DriverManager methods. However, this can also be used as an
 * abstraction for connection pooling.
 * 
 * @author WhittakT
 * @version 1.0
 */
public interface JdbcConnector {

    /**
     * Get a new connection to the database. A simple implementation may just
     * call DriverManager.getConnection(), however it could also keep a pool of
     * active connections.
     * 
     * @return A database connection object.
     */
    Connection getConnection() throws Exception;

    /**
     * Close the database connection. A simple implementation may just call
     * conn.close(), but it could also return the connection to a pool of
     * connections.
     * 
     * @param connection
     *            The connection to close.
     */
    void closeConnection(Connection connection) throws Exception;

}