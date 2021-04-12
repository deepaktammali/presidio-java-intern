package utils.beans;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalBean {
	Locale currentLocale;
	ResourceBundle resourceBundle;
	public LocalBean() {
		currentLocale = Locale.US;
	}
	public Locale getCurrentLocale() {
		return currentLocale;
	}
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
		resourceBundle = ResourceBundle.getBundle("utils.localebundles.loginbundle",currentLocale);
	}
	
	public String getString(String attribute) {
		System.out.println(resourceBundle.getString(attribute));
		return resourceBundle.getString(attribute);
	}
	
	public Object getObject(String attribute) {
		
		return resourceBundle.getObject(attribute);
	}
	
}
