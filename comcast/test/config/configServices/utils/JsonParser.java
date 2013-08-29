package comcast.test.config.configServices.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import comcast.test.config.dataServices.vo.VideoDetails;

public class JsonParser 
{
	/*This method parse the Store Feature Category Channels, Shows under channel and Videos user Channel*/
	public static List<VideoDetails> parseStoreFeaturedChannelsResponse(String featureResponse)
	{
		List<VideoDetails> featuredChannelList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("contentPanelElements");
			JSONArray jsonArray = jsonObject1.getJSONArray("contentPanelElement");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("contentKey"))
					videoDetails.setId(json.getString("contentKey"));
				if(json.has("contentType"))
					videoDetails.setContentType(json.getString("contentType"));
				if(json.has("category"))
				{
					JSONObject catagory = json.getJSONObject("category");
					if(catagory.has("level"))
						videoDetails.setLevel(catagory.getString("level"));
				}
					
				if(!videoDetails.getContentType().equalsIgnoreCase("productgroup"))
					featuredChannelList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredChannelList;
	}

	/*This method parse the Store Feature Category Show Count under Channel*/
	public static String parseStoreFeaturedShowCountResponse(String featureResponse)
	{
		String noOfHits =null;
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");
			if(jsonObject1.has("numberOfHits"))
				noOfHits= jsonObject1.getString("numberOfHits");	
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return noOfHits;
	}
	
	/*This method parse the Store Popular Category Show Count under Channel*/
	public static String parseStorePopularShowCountResponse(String popularResponse)
	{
		String noOfHits =null;
		
		try {
			JSONObject jsonObject = new JSONObject(popularResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");
			if(jsonObject1.has("numberOfHits"))
				noOfHits= jsonObject1.getString("numberOfHits");	
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return noOfHits;
	}
	
	/*This method parse the episode Count under Channel*/
	public static String parseEpisodeCountForChannelResponse(String popularResponse)
	{
		String noOfHits =null;
		try {
				JSONObject jsonObject = new JSONObject(popularResponse);
				JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
				if(jsonObject1.has("numberOfHits"))
					noOfHits= jsonObject1.getString("numberOfHits");
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return noOfHits;
	}
	
	/*This Method is to parse Featured shows Response from selected Channel*/
	public static List<VideoDetails> parseStoreFeaturedShowsResponse(String featureResponse)
	{
		List<VideoDetails> featuredShowList = new ArrayList<VideoDetails>();
		int noOfShows=0;
		JSONArray jsonArray =null;
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");		
			
				if(jsonObject1.has("numberOfHits"))
				{
					String noOfHits = jsonObject1.getString("numberOfHits");
					if(noOfHits!=null && noOfHits.length()>0)
						noOfShows = Integer.parseInt(noOfHits);
				}
				if(jsonObject1.has("category") && jsonObject1!=null)
				{
					if(noOfShows ==1)
					{
						JSONObject categoryJson  = jsonObject1.getJSONObject("category");	
						jsonArray = new JSONArray(categoryJson);
					}
					else
						jsonArray = jsonObject1.getJSONArray("category");	
				
					for(int i=0;i<jsonArray.length();i++)
					{
						VideoDetails videoDetails = new VideoDetails();
						JSONObject json = (JSONObject) jsonArray.get(i);
						if(json.has("title"))
							videoDetails.setTitle(json.getString("title"));	
						if(json.has("@id"))
							videoDetails.setId(json.getString("@id"));
						if(json.has("level"))
							videoDetails.setLevel(json.getString("level"));
						featuredShowList.add(videoDetails);
					}					
				} 
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return featuredShowList;
	}
	
	/*This Method is to parse Featured Video from selected Shows in a Channel*/
	public static List<VideoDetails> parseStoreFeaturedVideosResponse(String featureResponse)
	{
		List<VideoDetails> featuredVideoList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
			
			if(jsonObject1.has("asset") && jsonObject1!=null)
			{
				JSONArray jsonArray = jsonObject1.getJSONArray("asset");			
				
				for(int i=0;i<jsonArray.length();i++)
				{
					VideoDetails videoDetails = new VideoDetails();
					JSONObject json = (JSONObject) jsonArray.get(i);
					if(json.has("title"))
						videoDetails.setTitle(json.getString("title"));	
					if(json.has("@id"))
						videoDetails.setId(json.getString("@id"));
					
					featuredVideoList.add(videoDetails);
				}
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredVideoList;
	}
	
	/*This Method is to parse Store Featured Video from selected Shows in a Channel*/
	public static List<VideoDetails> parseStorePopularVideosResponse(String popularResponse)
	{
		List<VideoDetails> popularVideoList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(popularResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
			if(jsonObject1.has("asset") && jsonObject1!=null)
			{
				JSONArray jsonArray = jsonObject1.getJSONArray("asset");			
				
				for(int i=0;i<jsonArray.length();i++)
				{
					VideoDetails videoDetails = new VideoDetails();
					JSONObject json = (JSONObject) jsonArray.get(i);
					if(json.has("title"))
						videoDetails.setTitle(json.getString("title"));	
					if(json.has("@id"))
						videoDetails.setId(json.getString("@id"));
					
					popularVideoList.add(videoDetails);
				}
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return popularVideoList;
	}
	
	/*HOME
	 * 
	 */
	
	
	/*This Method is to parse Store Featured Video from selected Shows in a Channel*/
	public static List<VideoDetails> parseUpNextVideosResponse(String upNextResponse)
	{
		List<VideoDetails> upNextVideoList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(upNextResponse);
			//JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
			JSONArray jsonArray = jsonObject.getJSONArray("items");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("@id"))
					videoDetails.setId(json.getString("@id"));
				
				upNextVideoList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return upNextVideoList;
	}
	
	/*This method used to parse the Home Feature Category Channels, Shows under channel and Videos*/
	public static List<VideoDetails> parseHomeFeaturedChannelsResponse(String featureResponse)
	{
		List<VideoDetails> featuredChannelList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("contentPanelElements");
			JSONArray jsonArray = jsonObject1.getJSONArray("contentPanelElement");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("contentKey"))
					videoDetails.setId(json.getString("contentKey"));
				if(json.has("contentType"))
					videoDetails.setContentType(json.getString("contentType"));
				if(json.has("category"))
				{
					JSONObject catagory = json.getJSONObject("category");
					if(catagory.has("level"))
						videoDetails.setLevel(catagory.getString("level"));
				}
					
				if(!videoDetails.getContentType().equalsIgnoreCase("productgroup"))
					featuredChannelList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredChannelList;
	}
	
	/*This method used to parse the Home Feature Category Channels, Shows under channel and Videos*/
	public static List<VideoDetails> parseHomePopularChannelsResponse(String featureResponse)
	{
		List<VideoDetails> featuredChannelList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("contentPanelElements");
			JSONArray jsonArray = jsonObject1.getJSONArray("contentPanelElement");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("contentKey"))
					videoDetails.setId(json.getString("contentKey"));
				if(json.has("contentType"))
					videoDetails.setContentType(json.getString("contentType"));
				if(json.has("category"))
				{
					JSONObject catagory = json.getJSONObject("category");
					if(catagory.has("level"))
						videoDetails.setLevel(catagory.getString("level"));
				}
					
				if(!videoDetails.getContentType().equalsIgnoreCase("productgroup"))
					featuredChannelList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredChannelList;
	}
	
	/*This method used to parse the Home Popular Shows Category Shows and Videos*/
	public static List<VideoDetails> parseHomePopularShowResponse(String featureResponse)
	{
		List<VideoDetails> popularShowsList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("contentPanelElements");
			JSONArray jsonArray = jsonObject1.getJSONArray("contentPanelElement");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("contentKey"))
					videoDetails.setId(json.getString("contentKey"));
				if(json.has("contentType"))
					videoDetails.setContentType(json.getString("contentType"));
				if(json.has("category"))
				{
					JSONObject catagory = json.getJSONObject("category");
					if(catagory.has("level"))
						videoDetails.setLevel(catagory.getString("level"));
				}
					
				if(!videoDetails.getContentType().equalsIgnoreCase("productgroup"))
					popularShowsList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return popularShowsList;
	}
	
	/*This Method is to parse Home Video from selected Shows*/
	public static List<VideoDetails> parsePopularShowsVideosResponse(String featureResponse)
	{
		List<VideoDetails> popularShowVideoList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
			JSONArray jsonArray = jsonObject1.getJSONArray("asset");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("@id"))
					videoDetails.setId(json.getString("@id"));
				
				popularShowVideoList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return popularShowVideoList;
	}
	
	/*This method is to parse the Home Featured Category Show Count under Channel*/
	public static String parseHomeFeaturedShowCountResponse(String featuredResponse)
	{
		String noOfHits =null;
		
		try {
			JSONObject jsonObject = new JSONObject(featuredResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");
			if(jsonObject1.has("numberOfHits"))
				noOfHits= jsonObject1.getString("numberOfHits");	
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return noOfHits;
	}
	
	
	/*
	 * Module: SUBSCRIPTIONS PAGE
	 * Descripiton: This method is to parse Subscriptions Channels Response
	 */
	
	public static List<VideoDetails> parseSubscriptionChannelsResponse(String featureResponse)
	{
		List<VideoDetails> subscriptionChannelList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("contentPanelElements");
			JSONArray jsonArray = jsonObject1.getJSONArray("contentPanelElement");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("contentKey"))
					videoDetails.setId(json.getString("contentKey"));
				if(json.has("contentType"))
					videoDetails.setContentType(json.getString("contentType"));
				if(json.has("category"))
				{
					JSONObject catagory = json.getJSONObject("category");
					if(catagory.has("level"))
						videoDetails.setLevel(catagory.getString("level"));
				}
					
				if(!videoDetails.getContentType().equalsIgnoreCase("productgroup"))
					subscriptionChannelList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return subscriptionChannelList;
	}
	
	/*This Method is to parse Subscriptions Shows Response*/
	public static List<VideoDetails> parseSubscriptionsShowsResponse(String featureResponse)
	{
		List<VideoDetails> featuredShowList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");
			JSONArray jsonArray = jsonObject1.getJSONArray("category");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("@id"))
					videoDetails.setId(json.getString("@id"));
				if(json.has("level"))
					videoDetails.setLevel(json.getString("level"));
				featuredShowList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredShowList;
	}
	
	/*This Method is to parse Subscriptions Video Response*/
	public static List<VideoDetails> parseSubscriptionsVideosResponse(String featureResponse)
	{
		List<VideoDetails> featuredVideoList = new ArrayList<VideoDetails>();
		
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("assets");
			JSONArray jsonArray = jsonObject1.getJSONArray("asset");			
			
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("@id"))
					videoDetails.setId(json.getString("@id"));
				
				featuredVideoList.add(videoDetails);
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredVideoList;
	}
	
	/*This Method is to parse Featured Channel Response from selected Bundle*/
	public static List<VideoDetails> parseFeaturedBundleResponse(String featureResponse)
	{
		List<VideoDetails> featuredShowList = new ArrayList<VideoDetails>();
		int noOfShows=0;
		JSONArray jsonArray =null;
		try {
			JSONObject jsonObject = new JSONObject(featureResponse);
			JSONObject jsonObject1 = jsonObject.getJSONObject("categories");
			if(jsonObject1.has("numberOfHits"))
			{
				String noOfHits = jsonObject1.getString("numberOfHits");
				if(noOfHits!=null && noOfHits.length()>0)
					noOfShows = Integer.parseInt(noOfHits);
			}
			if(noOfShows ==1)
			{
				JSONObject categoryJson  = jsonObject1.getJSONObject("category");	
				jsonArray = new JSONArray(categoryJson);
			}
			else
				jsonArray = jsonObject1.getJSONArray("category");	
		
			for(int i=0;i<jsonArray.length();i++)
			{
				VideoDetails videoDetails = new VideoDetails();
				JSONObject json = (JSONObject) jsonArray.get(i);
				if(json.has("title"))
					videoDetails.setTitle(json.getString("title"));	
				if(json.has("@id"))
					videoDetails.setId(json.getString("@id"));
				if(json.has("level"))
					videoDetails.setLevel(json.getString("level"));
				featuredShowList.add(videoDetails);
			}
				
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return featuredShowList;
	}
}
