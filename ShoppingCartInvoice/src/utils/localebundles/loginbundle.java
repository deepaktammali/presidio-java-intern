package utils.localebundles;

import java.util.ListResourceBundle;

public class loginbundle extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"Username","Username"},
			{"Password","Password"}
		};
	}
}
