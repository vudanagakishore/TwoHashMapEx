package com.capgemini.fms.service;

import java.util.Map;

/**
 *  This is Interface Class of Service
 */


public interface IFeedbackService {
	Map<String, Integer> addFeedbackDetails(String name,int rating,String subject) throws Exception;
	Map<String, Integer> getFeedbackReport();
}
