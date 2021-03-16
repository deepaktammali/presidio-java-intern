package concepts;

public class HandlingCorruption {
	public static void main(String[] args) {
		Government.SevaKendra sevaKendra = new Government().new SevaKendra();
		
		DeathCertificateBroker deathCertificateBroker = new DeathCertificateBroker(sevaKendra);
		HotelPermitBroker hotelPermitBroker = new HotelPermitBroker(sevaKendra);
		FoodAuthorisationBroker foodAuthorisationBroker = new FoodAuthorisationBroker(sevaKendra);
		
		deathCertificateBroker.submit();
		hotelPermitBroker.submit();
		foodAuthorisationBroker.submit();
		
	}
}


// brokers

abstract class Broker{	
	protected Government.SevaKendra  sevaKendra;
	public Broker(Government.SevaKendra sevaKendra) {
		this.sevaKendra = sevaKendra;
	}
	abstract void submit();
}

class DeathCertificateBroker extends Broker{

	public DeathCertificateBroker(Government.SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.deathCertificateService();
	}
	
}

class HotelPermitBroker extends Broker{

	public HotelPermitBroker(Government.SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.hotelConstructionPermitService();
	}
	
}

class FoodAuthorisationBroker extends Broker{

	public FoodAuthorisationBroker(Government.SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.foodAuthorisingService();
	}
	
}



class Government {

//	Seva Department

	public class SevaKendra{
		private PoliceDepartment policeDepartment;
		private Hospital hospital;
		private ConstructionDepartment constructionDepartment;
		private FoodSafetyDepartment foodSafetyDepartment;
		

		public SevaKendra() {
			policeDepartment = new PoliceDepartment();
			hospital = new Hospital();
			constructionDepartment = new ConstructionDepartment();
			foodSafetyDepartment = new FoodSafetyDepartment();	
		}
		
		// services
		
		private abstract class Service {
			abstract void execute();
		}

		private class DeathCertService extends Service {

			@Override
			void execute() {
				hospital.signDeathCert();
				policeDepartment.verifyDeathCert();
			}
		}

		private class HotelOpeningService extends Service {
			@Override
			void execute() {
				constructionDepartment.permitHotelConstruction();
			}
		}

		private class FoodTestingService extends Service {
			@Override
			void execute() {
				foodSafetyDepartment.authoriseProduct();
			}
		}
		
		
		public void hotelConstructionPermitService() {
			System.out.println("Applied for hotel permit.");
			new HotelOpeningService().execute();
		}
		
		public void deathCertificateService() {
			System.out.println("Applied for death certificate.");
			new DeathCertService().execute();
		}
		
		public void foodAuthorisingService() {
			System.out.println("Applied for food authorisation.");
			foodSafetyDepartment.authoriseProduct();
		}
	}
	
	
	
// Government Organisations

	private class ConstructionDepartment {
		public void permitHotelConstruction() {
			System.out.println("	Permitted Hotel Construction.");
		}
	}

	private class Hospital {
		public void signDeathCert() {
			System.out.println("	Signed Death Certificate");
		}
	}

	private class PoliceDepartment {
		public void verifyDeathCert() {
			System.out.println("	Death Certificate Verified.");
		}
	}

	private class FoodSafetyDepartment {
		public void authoriseProduct() {
			System.out.println("	Product tested.");
			System.out.println("	Product permitted to be supplied to people");
		}
	}

}