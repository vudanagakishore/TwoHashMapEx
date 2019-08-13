package com.capgemini.fms.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.fms.bean.Feedback;
import com.capgemini.fms.service.FeedbackService;

public class Client 
{

	
	public static void main(String[] args) 
	{
		FeedbackService serviceObj=new FeedbackService();
		Scanner scanObj=new Scanner(System.in);
		Map<String, Integer> map=new HashMap<String, Integer>();
		Map<String, Integer> newmap=new HashMap<String, Integer>();
		int choice;
		while(true)
		{
			System.out.println("1) Add Feedback\n"
					+ "2) Print Feedback Report\n"
					+ "3) Exit");
			choice=scanObj.nextInt();
			switch(choice)
			{
			
			/**
			 *  This method is for Adding Feedback
			 */
			
		
			case 1:
				try
				{
					Feedback fbobj=new Feedback();
					System.out.println("Enter TeacherName:");
					String teacherName = scanObj.next();
					fbobj.setTeacherName(teacherName);
					System.out.println("Enter topic:");
					String topic =scanObj.next();
					fbobj.setTopic(topic);
					System.out.println("Enter Rating:");
					int rating = scanObj.nextInt();
					fbobj.setRating(rating);
					map=serviceObj.addFeedbackDetails(fbobj.getTeacherName(), fbobj.getRating(), fbobj.getTopic());
					System.out.println("Successfully added to  map");
					showMap(map);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
				
				/**
				 *  This case is for print Feedback Report
				 */
			case 2:
				System.out.println("Feedback Report:");
				newmap=serviceObj.getFeedbackReport();
				showMap(map);
				break;
				

				/**
				 *  This case is for Exit
				 */
				
			case 3:
				System.out.println("Exit");
				scanObj.close();
				System.exit(0);
			default:
				System.out.println("Please Enter a Valid Choice");
				break;
			}
		}
	}
	

	/**
	 *  This method is for displaying map
	 */
	
	
	
	public static void showMap(Map<String, Integer> map)
	{	
		System.out.println("Teacher Name\t Feedback Rating");
		if(map.isEmpty())
		{
			System.out.println("The Database is Empty");
		}
		Set entryset=map.entrySet();
		Iterator iObj=entryset.iterator();
		while(iObj.hasNext())
		{
			Map.Entry<String, Integer> values=(Map.Entry<String, Integer>)iObj.next();
			System.out.println(values.getKey()+"\t\t\t"+values.getValue());
		}
	}

}
