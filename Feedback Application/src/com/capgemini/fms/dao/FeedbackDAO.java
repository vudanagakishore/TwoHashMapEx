package com.capgemini.fms.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FeedbackDAO implements IFeedbackDAO {
	Map<String, Integer> MathFeedbackMap=new HashMap<String, Integer>();
	Map<String, Integer> EnglishFeedbackMap=new HashMap<String, Integer>();
	Map<String, Integer> FeedbackMap=new HashMap<String, Integer>();
	

	/**
	 *  This method is to add details in English and Math subject Maps
	 */
	
	@Override
	public Map<String, Integer> addFeedbackDetails(String name, int rating, String subject) {
		// TODO Auto-generated method stub
		FeedbackMap.clear();
		if(subject.equalsIgnoreCase("Math"))
		{
			MathFeedbackMap.put(name, rating);
			FeedbackMap.putAll(MathFeedbackMap);;
		}
		else if(subject.equalsIgnoreCase("English"))
		{
			EnglishFeedbackMap.put(name, rating);
			FeedbackMap.putAll(EnglishFeedbackMap);
		}
		return FeedbackMap;
	}


	/**
	 *  This method is for retriving data from maps
	 */
	
	
	@Override
	public Map<String, Integer> getFeedbackReport() {
		// TODO Auto-generated method stub
		Set englishset=EnglishFeedbackMap.entrySet();
		Iterator iObj=englishset.iterator();
		String string;
		FeedbackMap.putAll(MathFeedbackMap);
		while(iObj.hasNext())
		{
			Map.Entry<String, Integer> value=(Map.Entry<String, Integer>)iObj.next();
			string=value.getKey();
			if(FeedbackMap.containsKey(string))
			{
				int dummy=FeedbackMap.get(string);
				if(dummy<value.getValue())
				{
					FeedbackMap.remove(string);
					FeedbackMap.put(string, value.getValue());
				}
			}
			else
			{
				FeedbackMap.put(string, value.getValue());
			}
		}
		return FeedbackMap;
	}

}
