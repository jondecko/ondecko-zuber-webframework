package actionPackage;

import java.util.Map;
import java.util.HashMap;

public class ActionContainer 
{
	private Map<String, Object> paramMap;
	private String urlPattern;
	private String actionClass;
	private Map<String, String> actionResults;
	private Map<String, Object> outputtMap;
	
	public ActionContainer()
	{
		paramMap = new HashMap<String, Object>();
		urlPattern = new String();
		actionClass = new String();
		actionResults = new HashMap<String, String>();
		outputtMap = new HashMap<String, Object>();
	}
	
	public ActionContainer(String urlPatternParam, String actionClassParam)
	{
		paramMap = new HashMap<String, Object>();
		urlPattern = urlPatternParam;
		actionClass = actionClassParam;
		actionResults = new HashMap<String, String>();
		outputtMap = new HashMap<String, Object>();
	}
	
	public void addParam(String key, Object item)
	{
		paramMap.put(key, item);
	}
	
	public Object getParam(String key)
	{
		return paramMap.get(key);
	}
	
	public void removeParam(String key)
	{
		paramMap.remove(key);
	}
	
	public void clearParams()
	{
		paramMap.clear();
	}
	
	public int paramCount()
	{
		return paramMap.size();
	}
	
	public String getUrlPattern()
	{
		return urlPattern;
	}
	
	public String getActionClass()
	{
		return actionClass;
	}
	
	public void addResultHandler(String result, String handler)
	{
		actionResults.put(result, handler);
	}
	
	public String getResultHandler(String result)
	{
		return actionResults.get(result);
	}
	
	public void addOutput(String key, Object item)
	{
		outputtMap.put(key, item);
	}
	
	public Map<String, Object> getOutputs()
	{
		return outputtMap;
	}
}
