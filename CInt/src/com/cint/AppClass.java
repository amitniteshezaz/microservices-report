package com.cint;

public class AppClass {
	private static AppClass app;
	//It will prevent to instantiate the Singleton class from outside the class.
	private AppClass() {
		
	}
	public static AppClass getInstance() {
		if(app==null) {
			app=new AppClass();
		}
		return app;
		
	}
	public static void main(String args[]) {
		AppClass ap=AppClass.getInstance();
	}

}
