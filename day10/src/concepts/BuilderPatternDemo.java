package concepts;

public class BuilderPatternDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Computer myComputer;
		
		myComputer = new ComputerBuilder(64, 2000).build();
		System.out.println(myComputer);
		
		myComputer = new ComputerBuilder(128, 2000).setMonitor("Dell").setMotherBoard("AMD").setOperatingSystem("Windows").build();
		System.out.println(myComputer);
		
		Computer clonedComputer;
		clonedComputer = myComputer.clone();
		System.out.println(clonedComputer.toString());
		
		
	}
}

class ComputerBuilder {
	private int ram;
	private int diskSpace;
	private String operatingSystem;
	private String motherBoard;
	private String monitor;

	public ComputerBuilder(int ram, int diskSpace) {
		super();
		this.ram = ram;
		this.diskSpace = diskSpace;
	}
	
	public Computer build() {
		return new Computer(this);
	}
	
	public int getRam() {
		return ram;
	}

	public ComputerBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}

	public int getDiskSpace() {
		return diskSpace;
	}

	public ComputerBuilder setDiskSpace(int diskSpace) {
		this.diskSpace = diskSpace;
		return this;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public ComputerBuilder setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
		return this;
	}

	public String getMotherBoard() {
		return motherBoard;
	}

	public ComputerBuilder setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
		return this;
	}

	public String getMonitor() {
		return monitor;
	}

	public ComputerBuilder setMonitor(String monitor) {
		this.monitor = monitor;
		return this;
	}

}

class Computer implements Cloneable{
	private int ram;
	private int diskSpace;
	private String operatingSystem;
	private String motherBoard;
	private String monitor;


	public Computer(ComputerBuilder builder) {
		super();
		this.ram = builder.getRam();
		this.diskSpace = builder.getDiskSpace();
		this.operatingSystem = builder.getOperatingSystem();
		this.motherBoard = builder.getMotherBoard();
		this.monitor = builder.getMonitor();
	}
	
	public Computer clone() throws CloneNotSupportedException {
		return (Computer)super.clone();
	}

	public String toString() {
		return ("Ram :"+ram+" Disk : "+diskSpace+" OS : "+operatingSystem+" MotherBoard : "+motherBoard+" Monitor: "+monitor);
	}
	
	public int getRam() {
		return ram;
	}

	public int getDiskSpace() {
		return diskSpace;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public String getMotherBoard() {
		return motherBoard;
	}

	public String getMonitor() {
		return monitor;
	}

}