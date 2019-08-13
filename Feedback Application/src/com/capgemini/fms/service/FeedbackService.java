package com.capgemini.fms.service;

import java.util.Map;

import com.capgemini.fms.dao.FeedbackDAO;

public class FeedbackService implements IFeedbackService{
	FeedbackDAO daoObj=new FeedbackDAO();
	Validate validator=new Validate();
	

	/**
	 *  This method is for Sending Data into Dao
	 */
	

	
	
	@Override
	public Map<String, Integer> addFeedbackDetails(String name, int rating, String subject) throws Exception {
		// TODO Auto-generated method stub
		try
		{
			validator.validateData(name, rating, subject);
			return daoObj.addFeedbackDetails(name, rating, subject);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	/**
	 *  This method is for Sending Data into Dao
	 */
	
	@Override
	public Map<String, Integer> getFeedbackReport() {
		// TODO Auto-generated method stub
		return daoObj.getFeedbackReport();
	}

}
