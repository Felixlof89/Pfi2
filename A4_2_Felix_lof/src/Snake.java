
public class Snake extends Animal {
	
	private boolean poisonous;

	public Snake(String latinName, boolean isPoisonous) {
		super(latinName);
		this.poisonous = isPoisonous;
	}

	@Override
	public String getInfo() {
		String info = "";
		if(poisonous) {
			info = "A snake named " + getFriendlyName() + ", in latin " + getLatinName() +
				" which is poisonous";
		} else {
			info = "A snake named " + getFriendlyName() + ", in latin " + getLatinName() +
				" which isnt poisonous";
		}
		
		return info;
	}

	public boolean poisonous() {
		return poisonous;
	}
	
	

}