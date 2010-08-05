package actionPackage;

import java.util.Map;
import java.util.HashMap;

public class ActionContainer 
{
	private Map<String, Object> m_paramMap;
	private Map<String, Object> m_outputtMap;
	private ActionResult m_actionResult;
	
	/**
	 * ActionContainer constructor.
	 * 
	 * Default constructor is overloaded to ensure that it can't be used.
	 */
	@SuppressWarnings("unused")
	private ActionContainer()
	{
		// Do nothing.
		// Constructor is overloaded to avoid it being used.
	}
	
	/**
	 * ActionContainer constructor.
	 * 
	 * Constructor for the ActionContainer class that takes in a single
	 * string for the action result.
	 * 
	 * @param actionResult
	 */
	public ActionContainer(ActionResult actionResult)
	{
		m_paramMap = new HashMap<String, Object>();
		m_outputtMap = new HashMap<String, Object>();
		
		//TODO: check to make sure the input is clean.
		m_actionResult = actionResult;
	}
	
	/**
	 * addParam method.
	 * 
	 * Add a paired set to the param map.
	 * 
	 * @param key
	 * @param item
	 */
	public void addParam(String key, Object item)
	{
		m_paramMap.put(key, item);
	}
	
	/**
	 * getParam method.
	 * 
	 * Get a value from the param map with the key.
	 * 
	 * @param key
	 * @return
	 */
	public Object getParam(String key)
	{
		return m_paramMap.get(key);
	}
	
	/**
	 * removeParam method.
	 * 
	 * Remove an entry from the param map with the key.
	 * 
	 * @param key
	 */
	public void removeParam(String key)
	{
		m_paramMap.remove(key);
	}
	
	/**
	 * clearParams method.
	 * 
	 * Clears everything out of the param map.
	 */
	public void clearParams()
	{
		m_paramMap.clear();
	}
	
	/**
	 * paramCount method.
	 * 
	 * Returns the number of entries in the param map.
	 * 
	 * @return
	 */
	public int paramCount()
	{
		return m_paramMap.size();
	}
	
	/**
	 * addOutput method.
	 * 
	 * Adds a key-value pair to the output map.
	 * 
	 * @param key
	 * @param item
	 */
	public void addOutput(String key, Object item)
	{
		m_outputtMap.put(key, item);
	}
	
	/**
	 * getOutputs method.
	 * 
	 * Gets the entire output map.
	 * 
	 * @return
	 */
	public Map<String, Object> getOutputs()	{
		return m_outputtMap;
	}

	/**
	 * setActionResult method.
	 * 
	 * Sets the action result.
	 * 
	 * @param m_actionResult
	 */
	public void setActionResult(ActionResult m_actionResult) {
		//TODO: check to make sure the input is clean.
		this.m_actionResult = m_actionResult;
	}
	
	/**
	 * setParamMap method.
	 * 
	 * Sets the param map.
	 * 
	 * @param paramMap
	 */
	@SuppressWarnings("unchecked")
	public void setParamMap(Map paramMap)
	{
		m_paramMap = paramMap;
	}

	/**
	 * getActionResult method.
	 * 
	 * Gets the value of the action result.
	 * 
	 * @return
	 */
	public ActionResult getActionResult() {
		//TODO: check to make sure the input is clean.
		return m_actionResult;
	}
}
