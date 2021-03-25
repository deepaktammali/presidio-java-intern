package concepts;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

public class PropertiesDemo {
	public static void main(String[] args) throws IOException {
		String packagePropertiesFilePath = "C:\\Users\\VC\\Desktop\\Presidio_Intern\\JavaFullStack\\day14\\src\\concepts\\package.properties";
		Properties packageProperties = new Properties();
		packageProperties.load(new FileInputStream(packagePropertiesFilePath));
		packageProperties.setProperty("version", "1");
		packageProperties.setProperty("author", "Deepak");
		
		Set<Entry<Object,Object>> propertiesIterator = packageProperties.entrySet();
		
		for(Entry<Object,Object> propertyEntry:propertiesIterator) {
			System.out.println(propertyEntry.getKey()+" : "+propertyEntry.getValue());
		}
		
		packageProperties.store(new FileOutputStream(packagePropertiesFilePath), "package properties");
		
	}
}
