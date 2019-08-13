package com.capgemini.fms.dao;

import java.util.Map;

/**
 *  This is Interface Class of Dao Layer 
 */

public interface IFeedbackDAO {
	Map<String, Integer> addFeedbackDetails(String name,int rating,String subject);
	Map<String, Integer> getFeedbackReport();
}
