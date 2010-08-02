import java.util.HashMap;
import java.util.Map;


public class ActionMap 
{
	private Map<String, String> m_urlToActionMap;
	private Map<String, Map<String, String>> m_resultHandlers;
	
	public ActionMap()
	{
		m_urlToActionMap = new HashMap<String, String>();
		m_resultHandlers = new HashMap<String, Map<String, String>>();
	}
	
	public void addAction(String urlPattern, String actionClass, Map<String, String> resultHandlers)
	{
		m_urlToActionMap.put(urlPattern, actionClass);
		m_resultHandlers.put(urlPattern, resultHandlers);
	}
	
	public String getActionclass(String urlParamKey)
	{
		return m_urlToActionMap.get(urlParamKey);
	}
	
	public String getResult(String urlParamKey, String result)
	{
		return m_resultHandlers.get(urlParamKey).get(result);
	}
}
