package edu.franklin.db.sql;

/**
 * An form of the "command" pattern or the "unit of work" pattern. The execute
 * method encapsulates some work that is done.
 * 
 * @author WhittakT
 * 
 */
public interface Command {
    /**
     * Do some work that returns a result object.
     * @return A result.
     */
    Object execute();
}
