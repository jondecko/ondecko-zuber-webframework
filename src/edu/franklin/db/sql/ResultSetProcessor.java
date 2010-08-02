package edu.franklin.db.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetProcessor 
{
    void process(ResultSet rs) throws SQLException;
}
 