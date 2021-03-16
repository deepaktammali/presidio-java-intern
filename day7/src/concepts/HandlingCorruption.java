package concepts;

public class HandlingCorruption {
	public static void main(String[] args) {
		SevaKendra sevaKendra = new SevaKendra();

		DeathCertificateBroker deathCertificateBroker = new DeathCertificateBroker(sevaKendra);
		HotelPermitBroker hotelPermitBroker = new HotelPermitBroker(sevaKendra);
		FoodAuthorisationBroker foodAuthorisationBroker = new FoodAuthorisationBroker(sevaKendra);

		deathCertificateBroker.submit();
		hotelPermitBroker.submit();
		foodAuthorisationBroker.submit();

	}
}

// brokers

abstract class Broker {
	protected SevaKendra sevaKendra;

	public Broker(SevaKendra sevaKendra) {
		this.sevaKendra = sevaKendra;
	}

	abstract void submit();
}

class DeathCertificateBroker extends Broker {

	public DeathCertificateBroker(SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.deathCertificateService();
	}

}

class HotelPermitBroker extends Broker {

	public HotelPermitBroker(SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.hotelConstructionPermitService();
	}

}

class FoodAuthorisationBroker extends Broker {

	public FoodAuthorisationBroker(SevaKendra sevaKendra) {
		super(sevaKendra);
	}

	@Override
	void submit() {
		this.sevaKendra.foodAuthorisingService();
	}

}

//Seva Department

class SevaKendra {
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

//Government Organisations

class ConstructionDepartment {
	public void permitHotelConstruction() {
		System.out.println("	Permitted Hotel Construction.");
	}
}

class Hospital {
	public void signDeathCert() {
		System.out.println("	Signed Death Certificate");
	}
}

class PoliceDepartment {
	public void verifyDeathCert() {
		System.out.println("	Death Certificate Verified.");
	}
}

class FoodSafetyDepartment {
	public void authoriseProduct() {
		System.out.println("	Product tested.");
		System.out.println("	Product permitted to be supplied to people");
	}
}