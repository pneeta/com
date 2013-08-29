package comcast.test.config.configServices.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import comcast.test.config.dataServices.vo.VideoDetails;

public class restAPIServices
{
	public static String  featuredResponse;
	public static String  popularResponse;
	
	static
	{		
		try {
			featuredResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getFeaturedURL());
			popularResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getPopularURL());
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static List<VideoDetails> featuredBundlesList;
	private static List<VideoDetails> featuredShowsList;
	private static List<VideoDetails> featuredSubShowList;
	private static List<VideoDetails> featuredVideoList;
	
	/* Name: FeaturedAPI
	 * Module: STORE/HOME Page
	 * Description: This method provides Featured API Response Details.
	 */
	public static Map<String, List<VideoDetails>> FeaturedAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		List<VideoDetails> featuredAPIResponseList =JsonParser.parseStoreFeaturedChannelsResponse(featuredResponse);
		
		featuredBundlesList=new ArrayList<VideoDetails>();
		featuredShowsList=new ArrayList<VideoDetails>();
		featuredSubShowList=new ArrayList<VideoDetails>();
		featuredVideoList=new ArrayList<VideoDetails>();
		
		for(VideoDetails videoDetails:featuredAPIResponseList)
		{
			System.out.println("Details:>>>"+videoDetails.getTitle());
		}
		
		if (featuredAPIResponseList!=null && featuredAPIResponseList.size()<=10)
		{
			for(VideoDetails videoDetails:featuredAPIResponseList)
			{
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					featuredBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		int showCount =0;
		    		String  showCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(videoDetails.getId(), 0));
		    		if(showCountResponse!=null && showCountResponse.length()>0)
		    			showCount = Integer.parseInt( JsonParser.parseStoreFeaturedShowCountResponse(showCountResponse));
		    		if(showCount>0)
		    			featuredShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		featuredSubShowList.add(videoDetails);
		    	}
		    	if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("asset"))
		    	{
		    		featuredVideoList.add(videoDetails);
		    	}
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails = featuredAPIResponseList.get(index);
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					featuredBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		int showCount =0;
		    		String  showCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(videoDetails.getId(), 0));
		    		if(showCountResponse!=null && showCountResponse.length()>0)
		    			showCount = Integer.parseInt( JsonParser.parseStoreFeaturedShowCountResponse(showCountResponse));
		    		if(showCount>0)
		    			featuredShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		featuredSubShowList.add(videoDetails);
		    	}
		    	if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("asset"))
		    	{
		    		featuredVideoList.add(videoDetails);
		    	}
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("featuedBundleList", featuredBundlesList);
		finalMap.put("featuedShowsList", featuredShowsList);
		finalMap.put("featuedSubShowsList", featuredSubShowList);
		finalMap.put("featuedVideoList", featuredVideoList);
						
		return finalMap;
	}
	
	private static List<VideoDetails> popularBundlesList;
	private static List<VideoDetails> popularShowsList;
	private static List<VideoDetails> popularSubShowList;
	
	/* Name: FeaturedAPI
	 * Module: STORE/HOME Page
	 * Description: This method provides Featured API Response Details.
	 */
	public static Map<String, List<VideoDetails>> PopularAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		List<VideoDetails> popularAPIResponseList =JsonParser.parseStoreFeaturedChannelsResponse(popularResponse);
		
		popularBundlesList=new ArrayList<VideoDetails>();
		popularShowsList=new ArrayList<VideoDetails>();
		popularSubShowList=new ArrayList<VideoDetails>();
		
		for(VideoDetails videoDetails:popularAPIResponseList)
		{
			System.out.println("Details:>>>"+videoDetails.getTitle());
		}
		
		if (popularAPIResponseList!=null && popularAPIResponseList.size()<=10)
		{
		
			for(VideoDetails videoDetails:popularAPIResponseList)
			{
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					popularBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		popularShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		popularSubShowList.add(videoDetails);
		    	}
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails = popularAPIResponseList.get(index);
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					popularBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		popularShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		popularSubShowList.add(videoDetails);
		    	}
			}
		}
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("popularBundleList", popularBundlesList);
		finalMap.put("popularShowsList", popularShowsList);
		finalMap.put("popularSubShowsList", popularSubShowList);
						
		return finalMap;
	}
	
	private static List<VideoDetails> subscriptionsBundlesList;
	private static List<VideoDetails> subscriptionsShowsList;
	private static List<VideoDetails> subscriptionsSubShowList;
	
	/* Name: SubscriptionsAPI
	 * Module: SUBSCRIPTIONS Page
	 * Description: This method provides Subscriptions API Response Details.
	 */
	public static Map<String, List<VideoDetails>> SubscriptionsAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		String subscriptionsResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubscriptionsURL());
		List<VideoDetails> subscriptionsAPIResponseList =JsonParser.parseStoreFeaturedChannelsResponse(subscriptionsResponse);
		
		subscriptionsBundlesList=new ArrayList<VideoDetails>();
		subscriptionsShowsList=new ArrayList<VideoDetails>();
		subscriptionsSubShowList=new ArrayList<VideoDetails>();
		
		for(VideoDetails videoDetails:subscriptionsAPIResponseList)
		{
			System.out.println("Details:>>>"+videoDetails.getTitle());
		}
		
		if (subscriptionsAPIResponseList!=null && subscriptionsAPIResponseList.size()<=10)
		{
			for(VideoDetails videoDetails:subscriptionsAPIResponseList)
			{
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					subscriptionsBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		int showCount =0;
		    		String  showCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(videoDetails.getId(), 0));
		    		if(showCountResponse!=null && showCountResponse.length()>0)
		    			showCount = Integer.parseInt( JsonParser.parseStoreFeaturedShowCountResponse(showCountResponse));
		    		if(showCount>0)
	    			subscriptionsShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		subscriptionsSubShowList.add(videoDetails);
		    	}
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails = subscriptionsAPIResponseList.get(index);
				if(videoDetails.getContentType()!=null && videoDetails.getContentType().equalsIgnoreCase("bundle"))
		    	{
					subscriptionsBundlesList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SHOW"))
		    	{
		    		int showCount =0;
		    		String  showCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(videoDetails.getId(), 0));
		    		if(showCountResponse!=null && showCountResponse.length()>0)
		    			showCount = Integer.parseInt( JsonParser.parseStoreFeaturedShowCountResponse(showCountResponse));
		    		if(showCount>0)
		    		subscriptionsShowsList.add(videoDetails);
		    	}
		    	if(videoDetails.getLevel()!=null && videoDetails.getLevel().equalsIgnoreCase("SUB_SHOW"))
		    	{
		    		subscriptionsSubShowList.add(videoDetails);
		    	}
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("subscriptionsBundleList", subscriptionsBundlesList);
		finalMap.put("subscriptionsShowsList", subscriptionsShowsList);
		finalMap.put("subscriptionsSubShowsList", subscriptionsSubShowList);
						
		return finalMap;
	}
	
	
	
	/* Name: StorePageAPIs
	 * Module: STORE Page
	 * Description: This method provides Featured and Popular API's Details.
	 */
	public static Map <String,List<VideoDetails>> StorePageAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		//Calling Popular API.
		PopularAPI();
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("Featuredshow", featuredShowsList);
		finalMap.put("Popularshow", popularShowsList);
						
		return finalMap;
	}
	
	/* Name: StoreFeaturedAPI
	 * Module: STORE Page
	 * Description: This method provides Stored Featured, Show list and Video list Details.
	 */
	public static Map <String,List<VideoDetails>> StoreFeaturedAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();		
		
		VideoDetails featuredChannelDetails =featuredShowsList.get(0);		
		String  subShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 12));
		List<VideoDetails> storeFeaturedSubShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		
		List<VideoDetails> storeFeaturedShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedSubShowsList!=null && storeFeaturedSubShowsList.size()<10)
		{
			for(VideoDetails videoDetails:storeFeaturedSubShowsList)
			{
				storeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedSubShowsList.get(index);
				storeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails featuredSubShowDetails =storeFeaturedShowsListUnderChannel.get(0);
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredSubShowDetails.getId(), 12));
		List<VideoDetails> storeFeaturedVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> storeFeaturedVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedVideoList!=null && storeFeaturedVideoList.size()<10)
		{
			for(VideoDetails videoDetails:storeFeaturedVideoList)
			{
				storeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedVideoList.get(index);
				storeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("BundlesList", featuredBundlesList);
		finalMap.put("show", featuredShowsList);
		finalMap.put("subshow", featuredSubShowList);
		finalMap.put("video", storeFeaturedVideoListUnderChannel);
		finalMap.put("showsUnderChannel", storeFeaturedShowsListUnderChannel);
		return finalMap;		
	}
	
	/* Name: storeShowCountUnderChannel
	 * Module: STORE Page
	 * Description: This method provides Show count under Channel details page.
	 */
	public static String storeShowCountUnderChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredChannelDetails =featuredShowsList.get(0);
		String  subShowCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 0));
		return JsonParser.parseStoreFeaturedShowCountResponse(subShowCountResponse);
	}
	
	/* Name: episodeListUnderChannel
	 * Module: STORE/HOME Page
	 * Description: This method provides Episode count for a Channel.
	 */
	public static List<VideoDetails> episodeListUnderChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredChannelDetails =featuredShowsList.get(0);
		String  episodeCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getEpisodeCountURL(featuredChannelDetails.getId()));
		String noOfHits =JsonParser.parseEpisodeCountForChannelResponse(episodeCountResponse);
		featuredChannelDetails.setNoOfHits(noOfHits);
		
		List<VideoDetails> episodeCountUnderChanne=new ArrayList<VideoDetails>();		
		episodeCountUnderChanne.add(featuredChannelDetails);		

		return episodeCountUnderChanne;		
	}
	
	/* Name: featuredEpisodeListUnderShows
	 * Module: STORE/HOME Page
	 * Description: This method provides Episode count for a Channel.
	 */
	public static List<VideoDetails> featuredEpisodeListUnderShows() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();

		VideoDetails featuredChannelDetails =featuredShowsList.get(0);
		
		String  subShowResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 12));
		List<VideoDetails> storeFeaturedShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		VideoDetails featuredShowDetails =storeFeaturedShowsList.get(0);
		
		String  episodeCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getEpisodeCountURL(featuredShowDetails.getId()));
		String noOfHits =JsonParser.parseEpisodeCountForChannelResponse(episodeCountResponse);
		featuredShowDetails.setNoOfHits(noOfHits);
		
		List<VideoDetails> episodeCountUnderChanne=new ArrayList<VideoDetails>();	
		
		episodeCountUnderChanne.add(featuredChannelDetails);
		episodeCountUnderChanne.add(featuredShowDetails);
		
		return episodeCountUnderChanne;
		
	}
	
	/* Name: featuredEpisodeListUnderShows
	 * Module: STORE/HOME Page
	 * Description: This method provides Episode count for a Channel.
	 */
	public static Map <String,List<VideoDetails>> videoCountUnderShows() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredChannelDetails =featuredSubShowList.get(0);
		String  episodeCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredChannelDetails.getId(), 0));
		String noOfHits =JsonParser.parseEpisodeCountForChannelResponse(episodeCountResponse);
		featuredChannelDetails.setNoOfHits(noOfHits);
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("show", featuredShowsList);
		finalMap.put("subshow", featuredSubShowList);
	
		return finalMap;
	}
	
	/* Name: storeShowListUnderChannel
	 * Module: STORE Page
	 * Description: This method provides Shows list under Channel details page.
	 */
	public static Map <String,List<VideoDetails>> storeShowListUnderChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		String ShowCategoryID=featuredShowsList.get(0).getId();
		String  subShowListResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(ShowCategoryID, 12));
		List<VideoDetails> storeFeaturedShowList =JsonParser.parseStoreFeaturedShowsResponse(subShowListResponse);
					
		List<VideoDetails> homeFeaturedShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedShowList!=null && storeFeaturedShowList.size()<10)
		{
			for(VideoDetails videoDetails:storeFeaturedShowList)
			{
				homeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedShowList.get(index);
				homeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails featuredShowDetails =storeFeaturedShowList.get(0);	
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredShowDetails.getId(), 12));
		List<VideoDetails> storeFeaturedVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> homeFeaturedVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedVideoList!=null && storeFeaturedVideoList.size()<10)
		{
			for(VideoDetails videoDetails:storeFeaturedVideoList)
			{
				homeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedVideoList.get(index);
				homeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundle", featuredBundlesList);
		finalMap.put("show", featuredShowsList);
		finalMap.put("subshow", featuredSubShowList);
		finalMap.put("showsUnderChannel", homeFeaturedShowsListUnderChannel);
		finalMap.put("video", homeFeaturedVideoListUnderChannel);
		
		return finalMap;
	}
	
	/* Name: StorePopularAPI
	 * Module: STORE Page > Popular Channel
	 * Description: This method provides Channel List, Shows list and Video List for Popular Channel Category.
	 */
	public static Map <String,List<VideoDetails>> StorePopularAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(0);
		String  subShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 12));
		List<VideoDetails> storePopularSubShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		
		List<VideoDetails> storePopularShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularSubShowsList!=null && storePopularSubShowsList.size()<=10)
		{
			for(VideoDetails videoDetails:storePopularSubShowsList)
			{
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularSubShowsList.get(index);
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails PopularShowDetails =storePopularShowsListUnderChannel.get(0);
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(PopularShowDetails.getId(), 12));
		List<VideoDetails> storePopularVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> storePopularVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularVideoList!=null && storePopularVideoList.size()<=10)
		{
			for(VideoDetails videoDetails:storePopularVideoList)
			{
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularVideoList.get(index);
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}	
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundle", popularBundlesList);
		finalMap.put("show", popularShowsList);
		finalMap.put("subshow", popularSubShowList);
		finalMap.put("showsUnderChannel", storePopularShowsListUnderChannel);
		finalMap.put("video", storePopularVideoListUnderChannel);
						
		return finalMap;
	}
	
	/* Name: showCountUnderPopularChannel
	 * Module: STORE Page > Popular Channel
	 * Description: This method provides Store Popular Channel list and Shows count.
	 */
	public static String showCountUnderPopularChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(0);		
		String  subShowCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 0));
		return JsonParser.parseStorePopularShowCountResponse(subShowCountResponse);
	}
	
	/* Name: popularEpisodeListUnderShows
	 * Module: STORE/HOME Page
	 * Description: This method provides Episode count for a Channel.
	 */
	public static List<VideoDetails> popularEpisodeListUnderShows() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails featuredChannelDetails =popularShowsList.get(0);
		String  subShowResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 12));
		List<VideoDetails> storeFeaturedShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		VideoDetails featuredShowDetails =storeFeaturedShowsList.get(0);
		
		String  episodeCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getEpisodeCountURL(featuredShowDetails.getId()));
		String noOfHits =JsonParser.parseEpisodeCountForChannelResponse(episodeCountResponse);
		featuredChannelDetails.setNoOfHits(noOfHits);
		
		List<VideoDetails> episodeCountUnderChanne=new ArrayList<VideoDetails>();	
		episodeCountUnderChanne.add(featuredChannelDetails);
		episodeCountUnderChanne.add(featuredShowDetails);

		return episodeCountUnderChanne;
	}
	
	
	/* Name: storePopularShowListUnderChannel
	 * Module: STORE Page > Popular Channel
	 * Description: This method provides Store Popular Show list under Channel.
	 */
	public static Map <String,List<VideoDetails>> storePopularShowListUnderChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(0);
		
		String  subShowListResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 12));
		List<VideoDetails> storePopularShowList =JsonParser.parseStoreFeaturedShowsResponse(subShowListResponse);
		
		List<VideoDetails> storePopularShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularShowList!=null && storePopularShowList.size()<=10)
		{
			for(VideoDetails videoDetails:storePopularShowList)
			{
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularShowList.get(index);
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails popularSubShowDetails =storePopularShowsListUnderChannel.get(0);		
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(popularSubShowDetails.getId(), 12));
		List<VideoDetails> storePopularVideoList =JsonParser.parseStorePopularVideosResponse(videoResponse);
		
		List<VideoDetails> storePopularVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularVideoList!=null && storePopularVideoList.size()<=10)
		{
			for(VideoDetails videoDetails:storePopularVideoList)
			{
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularVideoList.get(index);
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundle", popularBundlesList);
		finalMap.put("show", popularShowsList);
		finalMap.put("subshow", popularSubShowList);
		finalMap.put("showsUnderChannel", storePopularShowsListUnderChannel);
		finalMap.put("video", storePopularVideoListUnderChannel);
						
		return finalMap;
	}
	
	/*HOME Page API's*/
	public static List<VideoDetails> homePageAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{		
		String  featuredResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getFeaturedURL());
		List<VideoDetails> homeFeaturedChannelList =JsonParser.parseStoreFeaturedChannelsResponse(featuredResponse);
		VideoDetails homefeaturedChannelDetails =homeFeaturedChannelList.get(0);
		
		String  popularShowResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getPopularShowsURL());
		List<VideoDetails> homePopularShowslList =JsonParser.parseHomePopularShowResponse(popularShowResponse);
		VideoDetails homePopularShowDetails =homePopularShowslList.get(0);
		
		String  featuredResponse1 =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getFeaturedURL());
		List<VideoDetails> homePopularChannelList =JsonParser.parseHomeFeaturedChannelsResponse(featuredResponse1);
		VideoDetails homePopularChannelDetails =homePopularChannelList.get(0);
				
		List<VideoDetails> homePageVideoDetailsList=new ArrayList<VideoDetails>();
		
		homePageVideoDetailsList.add(homefeaturedChannelDetails);
		homePageVideoDetailsList.add(homePopularShowDetails);
		homePageVideoDetailsList.add(homePopularChannelDetails);	
		
		return homePageVideoDetailsList;
	}
	
	/*
	 * HOME Featured API's
	 */
	public static Map <String,List<VideoDetails>> HomeFeaturedAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredChannelDetails =featuredShowsList.get(0);		
		String  subShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 12));
		List<VideoDetails> storeFeaturedSubShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
				
		List<VideoDetails> homeFeaturedShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedSubShowsList!=null && storeFeaturedSubShowsList.size()<=10)
		{
			for(VideoDetails videoDetails:storeFeaturedSubShowsList)
			{
				homeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedSubShowsList.get(index);
				homeFeaturedShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails featuredSubShowDetails =homeFeaturedShowsListUnderChannel.get(0);
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredSubShowDetails.getId(), 12));
		List<VideoDetails> storeFeaturedVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> homeFeaturedVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedVideoList!=null && storeFeaturedVideoList.size()<=10)
		{
			for(VideoDetails videoDetails:storeFeaturedVideoList)
			{
				homeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedVideoList.get(index);
				homeFeaturedVideoListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails VideoUnderSubShowOfHomePage =featuredSubShowList.get(0);
		String  homePageSubShowVideoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(VideoUnderSubShowOfHomePage.getId(), 12));
		List<VideoDetails> homePageSubShowVideos =JsonParser.parseStoreFeaturedVideosResponse(homePageSubShowVideoResponse);
		
		List<VideoDetails> homePageSubShowVideoList=new ArrayList<VideoDetails>();
		if(homePageSubShowVideos!=null && homePageSubShowVideos.size()<=10)
		{
			for(VideoDetails videoDetails:homePageSubShowVideos)
			{
				homePageSubShowVideoList.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=homePageSubShowVideos.get(index);
				homePageSubShowVideoList.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("show", featuredShowsList);
		finalMap.put("subshow", featuredSubShowList);
		finalMap.put("subShowVideos", homePageSubShowVideoList);
		finalMap.put("video", homeFeaturedVideoListUnderChannel);
		finalMap.put("showsUnderChannel", homeFeaturedShowsListUnderChannel);
		
		return finalMap;
	}
	
	/*
	 * UPNEXT API's
	 */
	public static List<VideoDetails> upNextAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		String  upNextResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getUpNextURL());
		List<VideoDetails> HomeUpNextVideolList =JsonParser.parseUpNextVideosResponse(upNextResponse);
		
		List<VideoDetails> homeUpNextDetailsList=new ArrayList<VideoDetails>();
		if(HomeUpNextVideolList!=null && HomeUpNextVideolList.size()<10)
		{
			for(VideoDetails videoDetails:HomeUpNextVideolList)
			{
				homeUpNextDetailsList.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=HomeUpNextVideolList.get(index);
				homeUpNextDetailsList.add(videoDetails);
			}
		}
		
		return homeUpNextDetailsList;
	}
		
	
	/*
	 * HOME Popular Channel API's
	 */
	public static Map<String, List<VideoDetails>> HomePopularChannelAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(0);		
		String  subShowResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 12));
		List<VideoDetails> popularSubShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		
		List<VideoDetails> popularSubShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(popularSubShowsList!=null && popularSubShowsList.size()<10)
		{
			for(VideoDetails videoDetails:popularSubShowsList)
			{
				popularSubShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=popularSubShowsList.get(index);
				popularSubShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails featuredShowDetails =popularSubShowsListUnderChannel.get(0);		
		String  videoResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredShowDetails.getId(), 12));
		List<VideoDetails> popularVideoList =JsonParser.parseStorePopularVideosResponse(videoResponse);
		
		List<VideoDetails> popularVideosList=new ArrayList<VideoDetails>();
		if(popularVideoList!=null && popularVideoList.size()<10)
		{
			for(VideoDetails videoDetails:popularVideoList)
			{
				popularVideosList.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=popularVideoList.get(index);
				popularVideosList.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundle", popularBundlesList);
		finalMap.put("show", popularShowsList);
		finalMap.put("subshow", popularSubShowList);
		finalMap.put("showsUnderChannel", popularSubShowsListUnderChannel);
		finalMap.put("video", popularVideosList);
						
		return finalMap;
	}
	
	/*
	 * HOME Popular Channel API's
	 */
	public static Map<String, List<VideoDetails>> HomePopularChannelDetailsAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(2);
		String  subShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 12));
		List<VideoDetails> storePopularShowsList =JsonParser.parseStoreFeaturedShowsResponse(subShowResponse);
		
		List<VideoDetails> storePopularShowsListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularShowsList!=null && storePopularShowsList.size()<10)
		{
			for(VideoDetails videoDetails:storePopularShowsList)
			{
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularShowsList.get(index);
				storePopularShowsListUnderChannel.add(videoDetails);
			}
		}
		
		VideoDetails PopularShowDetails =storePopularShowsListUnderChannel.get(0);
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(PopularShowDetails.getId(), 12));
		List<VideoDetails> storePopularVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> storePopularVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storePopularVideoList!=null && storePopularVideoList.size()<10)
		{
			for(VideoDetails videoDetails:storePopularVideoList)
			{
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storePopularVideoList.get(index);
				storePopularVideoListUnderChannel.add(videoDetails);
			}
		}
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundle", popularBundlesList);
		finalMap.put("show", popularShowsList);
		finalMap.put("subshow", popularSubShowList);
		finalMap.put("showsUnderChannel", storePopularShowsListUnderChannel);
		finalMap.put("video", storePopularVideoListUnderChannel);
						
		return finalMap;
	}
	
	/*
	 * HOME Popular Show API's
	 */
	public static Map<String, List<VideoDetails>> HomePopularShowsAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		String  popularShowResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getPopularShowsURL());
		List<VideoDetails> HomePopularShowsList =JsonParser.parseHomePopularShowResponse(popularShowResponse);
		VideoDetails popularShowDetails =HomePopularShowsList.get(0);
		
		String  videoResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(popularShowDetails.getId(), 12));
		List<VideoDetails> homePopularShowsVideoList =JsonParser.parsePopularShowsVideosResponse(videoResponse);
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("popularShows", HomePopularShowsList);
		finalMap.put("popularvideos", homePopularShowsVideoList);
		return finalMap;
	}
	
	/*
	 * HOME
	 * 
	 */
	public static String showCountForHomeFeaturedChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredChannelDetails =featuredShowsList.get(0);		
		String  showCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 0));
		return JsonParser.parseHomeFeaturedShowCountResponse(showCountResponse);
	}
	
	/*This method parse Home Popular channel */
	public static String showCountForHomePopularChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Popular API.
		PopularAPI();
		
		VideoDetails popularChannelDetails =popularShowsList.get(0);		
		String  subShowCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(popularChannelDetails.getId(), 0));
		return JsonParser.parseHomeFeaturedShowCountResponse(subShowCountResponse);
	}
	
	/*
	 * SUBSCRIPION Page API's
	 */
	public static Map<String, List<VideoDetails>> subscriptionChannelAPIs() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Subscriptions API.
		SubscriptionsAPI();
		
		VideoDetails subscriptionsChannelDetails =subscriptionsShowsList.get(0);		
		String  subShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(subscriptionsChannelDetails.getId(), 12));
		List<VideoDetails> subscriptionsSubShowsList =JsonParser.parseSubscriptionsShowsResponse(subShowResponse);
		
		VideoDetails subscriptionsShowDetails =subscriptionsSubShowsList.get(0);
		String  videoResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(subscriptionsShowDetails.getId(), 12));
		List<VideoDetails> subscriptionsVideoList =JsonParser.parseSubscriptionsVideosResponse(videoResponse);
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("subscribedBundle", subscriptionsBundlesList);
		finalMap.put("subscribedShows", subscriptionsShowsList);
		finalMap.put("subscribedSubShow", subscriptionsSubShowList);
		finalMap.put("subscribedShowsUnderChannel", subscriptionsSubShowsList);
		finalMap.put("subscribedVideo", subscriptionsVideoList);
						
		return finalMap;
	}
	
	/*
	 * SUBSCRIPIONS Page API's
	 */
	public static String showCountForSubscriptionsChannel() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Subscriptions API.
		SubscriptionsAPI();
		
		VideoDetails subscriptionsChannelDetails =subscriptionsShowsList.get(0);	
		String  subShowCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(subscriptionsChannelDetails.getId(), 0));
		return JsonParser.parseHomeFeaturedShowCountResponse(subShowCountResponse);
	}
	
	/* Name: FeaturedBundleAPI
	 * Module: STORE Page
	 * Description: This method provides Stored Featured, Bundle,Channel,Shows and Video list Details.
	 */
	public static Map <String,List<VideoDetails>> FeaturedBundleAPI() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();		
		
		VideoDetails featuredBundleDetails =featuredBundlesList.get(1);		
		String  BundleShowsResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getBundleShowsURL(featuredBundleDetails.getId(), 12));
		List<VideoDetails> FeaturedShowsListUnderBundle =JsonParser.parseStoreFeaturedShowsResponse(BundleShowsResponse);
		
		List<VideoDetails> featuredShowsListUnderBundle=new ArrayList<VideoDetails>();
		if(FeaturedShowsListUnderBundle!=null && FeaturedShowsListUnderBundle.size()<10)
		{
			for(VideoDetails videoDetails:FeaturedShowsListUnderBundle)
			{
				featuredShowsListUnderBundle.add(videoDetails);
				System.out.println("Bundle Shows List:>>"+videoDetails.getTitle());
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=FeaturedShowsListUnderBundle.get(index);
				featuredShowsListUnderBundle.add(videoDetails);
				System.out.println("Bundle Shows List:>>"+videoDetails.getTitle());
			}
		}
		
		VideoDetails featuredChannelDetails =featuredShowsListUnderBundle.get(1);		
		String  bundleChannelsSubShowResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(featuredChannelDetails.getId(), 12));
		List<VideoDetails> featuredBundleChannelSubShowsList =JsonParser.parseStoreFeaturedShowsResponse(bundleChannelsSubShowResponse);
		
		List<VideoDetails> featuredBundleChannelsSubShowsList=new ArrayList<VideoDetails>();
		if(featuredBundleChannelSubShowsList!=null && featuredBundleChannelSubShowsList.size()<10)
		{
			for(VideoDetails videoDetails:featuredBundleChannelSubShowsList)
			{
				featuredBundleChannelsSubShowsList.add(videoDetails);
				System.out.println("Bundle Sub Shows List:>>"+videoDetails.getTitle());
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=featuredBundleChannelSubShowsList.get(index);
				featuredBundleChannelsSubShowsList.add(videoDetails);
				System.out.println("Bundle Sub Shows List:>>"+videoDetails.getTitle());
			}
		}
		
		VideoDetails featuredSubShowDetails =featuredBundleChannelsSubShowsList.get(0);
		String  videoResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getVideoDetailsURL(featuredSubShowDetails.getId(), 12));
		List<VideoDetails> storeFeaturedVideoList =JsonParser.parseStoreFeaturedVideosResponse(videoResponse);
		
		List<VideoDetails> storeFeaturedVideoListUnderChannel=new ArrayList<VideoDetails>();
		if(storeFeaturedVideoList!=null && storeFeaturedVideoList.size()<10)
		{
			for(VideoDetails videoDetails:storeFeaturedVideoList)
			{
				storeFeaturedVideoListUnderChannel.add(videoDetails);
				System.out.println("Bundle Sub Shows Video List:>>"+videoDetails.getTitle());
			}
		}
		else
		{
			for(int index=0; index<10; index++)
			{
				VideoDetails videoDetails=storeFeaturedVideoList.get(index);
				storeFeaturedVideoListUnderChannel.add(videoDetails);
				System.out.println("Bundle Sub Shows Video List:>>"+videoDetails.getTitle());
			}
		}		
		
		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundlesList", featuredBundlesList);
		finalMap.put("showsInBundle", featuredShowsListUnderBundle);
		finalMap.put("subShowInBundleChannel", featuredBundleChannelsSubShowsList);
		finalMap.put("videosInBundleChannel", storeFeaturedVideoListUnderChannel);
		return finalMap;
	}
	
	/* Name: ChannelCountUnderBundle
	 * Module: STORE Page
	 * Description: This method provides Channel count under Bundle details page.
	 */
	public static String ChannelCountUnderBundle() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		VideoDetails featuredChannelDetails =featuredBundlesList.get(1);
		String  ChannelCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getBundleShowsURL(featuredChannelDetails.getId(), 0));
		return JsonParser.parseStoreFeaturedShowCountResponse(ChannelCountResponse);
	}
	
	/* Name: episodeListUnderBundle
	 * Module: STORE/HOME Page
	 * Description: This method provides Episode count for a Bundle.
	 */
	public static Map<String,List<VideoDetails>> episodeListUnderBundle() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();	
		
		VideoDetails featuredBundleDetails =featuredBundlesList.get(1);		
		String  BundleShowsResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getBundleShowsURL(featuredBundleDetails.getId(), 12));
		List<VideoDetails> FeaturedShowsListUnderBundle =JsonParser.parseStoreFeaturedShowsResponse(BundleShowsResponse);
				
		VideoDetails featuredBundleEpisodeDetails =FeaturedShowsListUnderBundle.get(1);
		String  episodeCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getEpisodeCountURL(featuredBundleEpisodeDetails.getId()));
		String noOfHits =JsonParser.parseEpisodeCountForChannelResponse(episodeCountResponse);
		featuredBundleEpisodeDetails.setNoOfHits(noOfHits);
		
		List<VideoDetails> episodeCountUnderBundle=new ArrayList<VideoDetails>();		
		episodeCountUnderBundle.add(featuredBundleEpisodeDetails);		

		Map <String,List<VideoDetails>> finalMap= new HashMap <String,List<VideoDetails>>();
		finalMap.put("bundlesList", featuredBundlesList);
		finalMap.put("episodeCountInBundle", episodeCountUnderBundle);
		return finalMap;		
	}
	
	/* Name: ShowsCountFeaturedBundle
	 * Module: STORE/HOME Page
	 * Description: This method provides Shows count for a Bundle.
	 */
	public static String ShowsCountFeaturedBundle() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		//Calling Featured API.
		FeaturedAPI();
		
		VideoDetails featuredBundleDetails =featuredBundlesList.get(1);		
		String  BundleShowsResponse = DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getBundleShowsURL(featuredBundleDetails.getId(), 12));
		List<VideoDetails> FeaturedShowsListUnderBundle =JsonParser.parseStoreFeaturedShowsResponse(BundleShowsResponse);
				
		VideoDetails subShowsInBundle =FeaturedShowsListUnderBundle.get(0);		
		String  subShowCountResponse =DomParserXPATH.getCategories(UrlFactoryUtil.getInstance().getSubShowURL(subShowsInBundle.getId(), 0));
		return JsonParser.parseHomeFeaturedShowCountResponse(subShowCountResponse);
	}
	
}
