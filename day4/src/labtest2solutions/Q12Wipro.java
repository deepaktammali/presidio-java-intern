package labtest2solutions;

public class Q12Wipro {
	public static void main(String[] args) {
		Wipro[] wiproCompanies = {new WiproConsumerCare(),new WiproInfrastructure(), new WiproHealthCare()};
		
		for(Wipro company:wiproCompanies) {
			System.out.println("The CEO of company "+ company.getCompanyName() + " is "+company.getCEO());
		}
	
	}
}

class Wipro{
	
	private String CEO = "Thierry Delaporte";
	
	public String getCEO() {
		return CEO;
	}

	public String getCompanyName() {
		return "Wipro Group of Companies";
	}
}

class WiproConsumerCare extends Wipro{
	
	private String CEO = "Anil Chugh";
	
	public String getCEO() {
		return CEO;
	}
	
	@Override
	public String getCompanyName() {
		return "Wipro Consumer Care and Lighting";
	}
}

class WiproInfrastructure extends Wipro{
	
	private String CEO = "Pratik Kumar";
	
	public String getCEO() {
		return CEO;
	}
	
	@Override
	public String getCompanyName() {
		return " Wipro Infrastructure Engineering (WIN)";
	}
}

class WiproHealthCare extends Wipro{
	
	private String CEO = "Nalinikanth Gollagunta";
	
	public String getCEO() {
		return CEO;
	}
	
	@Override
	public String getCompanyName() {
		return "Wipro GE Healthcare Private Limited";
	}
}




