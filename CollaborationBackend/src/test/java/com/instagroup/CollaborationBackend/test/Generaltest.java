package com.instagroup.CollaborationBackend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Generaltest {
	public static void main(String [] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.instagroup.CollaborationBackend");
		context.refresh();
	}

}
