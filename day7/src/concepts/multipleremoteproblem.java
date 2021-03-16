package concepts;

import java.util.ArrayList;

public class multipleremoteproblem {
	public static void main(String[] args) {
		CommandExecuter commandExecuter = CommandExecuter.getInstance();
//		instantiating appliances
		TV tv = new TV();
		PlayStation playStation = new PlayStation();
		Netflix netflix = new Netflix();
		Prime prime = new Prime();
		
//		adding commands
		commandExecuter.addCommand(new ChannelCommand(tv, playStation, netflix, prime, 5));
		commandExecuter.addCommand(new ChannelCommand(tv, playStation, netflix, prime, 15));
		commandExecuter.addCommand(new GameCommand(tv, playStation, netflix, prime, "Hockey"));
		commandExecuter.addCommand(new NetflixCommand(tv, playStation, netflix, prime, "Some Movie"));
		commandExecuter.addCommand(new PrimeCommand(tv, playStation, netflix, prime, "Some Content"));
		
		commandExecuter.executeCommand();
		commandExecuter.executeCommand();
		commandExecuter.executeCommand();
		commandExecuter.executeCommand();
		commandExecuter.executeCommand();
		
	}
}



class CommandExecuter{
	
	private final int SIZE = 10;
	private Command[] commandsList = new Command[SIZE];
	private int currentIndex = 0;
	private static CommandExecuter commandExecutor;
	
	private CommandExecuter() {
		
	}
	
	
	public void addCommand(Command command) {
		if(currentIndex<SIZE) {
			commandsList[currentIndex] = command;
			currentIndex+=1;
		}
		else {
			System.out.println("Cannot add more commands - Overloaded");
		}
	}
	
	
	public void executeCommand() {
		if(currentIndex==0) {
			System.out.println("No Commands Added Yet");
			return;
		}
		commandsList[currentIndex-1].execute();
		currentIndex -= 1;
	}
	
	
	public static CommandExecuter getInstance() {
		if(commandExecutor==null) {
			commandExecutor = new CommandExecuter();
		}
		
		return commandExecutor;
	}
	
}




abstract class Command{
	
	protected TV tv;
	protected PlayStation playStation;
	protected Netflix netflix;
	protected Prime prime;
	
	public Command(TV tv,PlayStation playStation,Netflix netflix,Prime prime){
		this.tv = tv;
		this.playStation = playStation;
		this.netflix = netflix;
		this.prime = prime;
	}
	
	abstract void execute();
}


class GameCommand extends Command{
	private final String game;
	
	public GameCommand(TV tv,PlayStation playStation,Netflix netflix,Prime prime,String game){
		super(tv,playStation,netflix,prime);
		this.game = game;
	}
	

	@Override
	void execute() {
		this.playStation.switchOn();
		this.playStation.playGame(game);
	}
}

class ChannelCommand extends Command{
	
	private final int channel;

	public ChannelCommand(TV tv, PlayStation playStation, Netflix netflix, Prime prime,int channel) {
		super(tv, playStation, netflix, prime);
		this.channel = channel;
	}

	@Override
	void execute() {
		this.tv.switchOn();
		this.tv.playChannel(channel);
	}

}


class NetflixCommand extends Command{

	private final String content;
	public NetflixCommand(TV tv, PlayStation playStation, Netflix netflix, Prime prime,String content) {
		super(tv, playStation, netflix, prime);
		this.content = content;
	}


	@Override
	void execute() {
		netflix.logIn();
		netflix.playVideo(content);
	}
	
}


class PrimeCommand extends Command{

	private final String content;
	public PrimeCommand(TV tv, PlayStation playStation, Netflix netflix, Prime prime,String content) {
		super(tv, playStation, netflix, prime);
		this.content = content;
	}


	@Override
	void execute() {
		prime.logIn();
		prime.playVideo(content);
	}
	
}





class TV{
	public void switchOn() {
		System.out.println("Switched on TV.");
	}
	
	public void playChannel(int channel) {
		System.out.println("Playing channel "+channel);
	}
	
	public void switchOff() {
		System.out.println("Switched off TV.");
	}
}

class PlayStation{
	public void switchOn() {
		System.out.println("Switched on PlayStation.");
	}
	
	public void playGame(String game) {
		System.out.println("Opened game "+game);
	}
	
	public void switchOff() {
		System.out.println("Switched off PlayStation.");
	}
}

class Netflix{
	public void logIn() {
		System.out.println("Logged in to Netflix.");
	}
	
	public void playVideo(String video) {
		System.out.println("Playing "+video+" on Netflix.");
	}
	
	public void logOut() {
		System.out.println("Logged out of Netflix.");
	}
}

class Prime{
	public void logIn() {
		System.out.println("Logged in to Prime.");
	}
	
	public void playVideo(String video) {
		System.out.println("Playing "+video+" on Prime.");
	}
	
	public void logOut() {
		System.out.println("Logged out of Prime.");
	}
}