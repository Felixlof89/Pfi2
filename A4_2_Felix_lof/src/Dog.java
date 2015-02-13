public class Dog extends Mamal {
private boolean stupid;

	public Dog(String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
	}
	
	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName) {
		super(latinName, gestationTime);
		this.stupid = stupid;
		setFriendlyName(friendlyName);
	}

	public boolean stupid() {
		return stupid;
	}
	
	@Override
	public String getInfo() {
		String info = "";
		if(stupid) {
			info = "A dog named: " + getFriendlyName() + ", in latin: " + getLatinName() + 
			" which has a gestation time of " + getGestationTime() + " months and is stupid.";
		} else {
			info = "A dog named: " + getFriendlyName() + ", in latin: " + getLatinName() + 
			" which has a gestation time of " + getGestationTime() + " months and is smart";
		}
		return info;
	}
	
	
}
