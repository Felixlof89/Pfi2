
public class Cat extends Mamal {

	private int numberOfLives;
	
	public Cat(String latinName, int gestationTime, int numberOfLives) {
		super(latinName, gestationTime);
		this.numberOfLives = numberOfLives;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}
	
	@Override
	public String getInfo() {
		String info = "A cat named " + getFriendlyName() + ", in latin " + getLatinName() +
				" which has a gestation period of " + getGestationTime() + " months" +
				" and has " + getNumberOfLives() + " lives";
		return info;
	}

}