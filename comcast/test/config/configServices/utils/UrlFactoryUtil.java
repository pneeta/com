package comcast.test.config.configServices.utils;

public class UrlFactoryUtil 
{
	private static UrlFactoryUtil instance;
	
	private UrlFactoryUtil(){}
	
	public static synchronized UrlFactoryUtil getInstance()
	{
		if(instance == null)
			instance =  new UrlFactoryUtil();
		
		return instance;
	}
	
	public String getFeaturedURL()
	{
		return "http://api.stage2.xidio.com/api/iptv/contentpanel/100_featured?expand=content";
	}
	
	public String getPopularURL()
	{
		return "http://api.stage2.xidio.com/api/iptv/contentpanel/100_popular?expand=content";
	}

	public String getSubShowURL(String id,int size)
	{
		return "http://api.stage2.xidio.com/api/iptv/search/categories/100?start=0&query=%28%28parentCategoryId%3A"+id+"%29%29%20AND%20levelName%3ASUB_SHOW&size="+size+"";
	}
	
	public String getEpisodeCountURL(String id)
	{
		return "http://api.stage2.xidio.com/api/iptv/search/categories/"+id+"/assets";
	}
	
	public String getVideoDetailsURL(String id, int size)
	{
		return "http://api.stage2.xidio.com/api/iptv/search/"+id+"?start=0&size="+size+"";
	}
	
	public String getPopularShowsURL()
	{
		return "http://api.stage2.xidio.com/api/iptv/contentpanel/100_popular_shows?expand=content";
	}
	
	public String getUpNextURL()
	{
		return "http://www.projecthelen.net:3000/api/user/upnext?userId=1792274&sessionId=Q3HYcuwzCoesnaRXjsk6lnKfc%5C/f9t1MW1nzBS&platform=web&page=1&size=15";
	}
	
	public String getSubscriptionsURL()
	{
		return "http://api.stage2.xidio.com/api/iptv/contentpanel/100_featured?expand=content";
	}
	
	public String getBundleShowsURL(String id,int size)
	{
		return "http://api.stage2.xidio.com/api/iptv/search/categories/100?start=0&query=prodGroupId%3A"+id+"&size="+size+"";
	}
	
}
