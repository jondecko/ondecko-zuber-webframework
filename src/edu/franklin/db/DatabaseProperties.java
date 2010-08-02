package edu.franklin.db;

/**
 * Simple "parameter object" (see
 * http://www.refactoring.com/catalog/introduceParameterObject.html) for
 * configuring database connections.
 * 
 * @author WhittakT
 * @version 1.0
 */
public class DatabaseProperties {
    /** The user name for connecting to the database. */
    private String userName;
    /** The password for connecting to the database. */
    private String password;
    /** The database URL. */
    private String url;
    /** The fully qualified driver class name. */
    private String driverName;

    /**
     * Constructs a parameter object containing all relevant connection
     * information needed by the DriverManager.
     * 
     * @param driverName
     *            The database driver class name.
     * @param url
     *            The connection URL.
     * @param userName
     *            The user for connecting.
     * @param password
     *            The password for the user.
     */
    public DatabaseProperties(String driverName, String url, String userName,
            String password) {
        this.driverName = driverName;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Getter for userName property.
     * 
     * @return The user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for userName property.
     * 
     * @param userName
     *            The user name.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for password property.
     * 
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password property.
     * 
     * @param password
     *            The users's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for URL property.
     * 
     * @return The database connection URL.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for URL property.
     * 
     * @param url
     *            The database connection URL.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for driverName property.
     * 
     * @return The driver class name.
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * Setter for driverName property.
     * 
     * @param driverName
     *            The driver class name.
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
