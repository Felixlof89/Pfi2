package assignment4_lof_felix;

public class Human {
	private String humanName;
	private Dog dog;
	
	
	
	public Human (String humanName){
		
		this.humanName = humanName;
		
	}
	
	// ändring
	public String getName(){
		return this.humanName;
	}
	
	// isaks ändinrgar på samma ställe
	public void buyDog(Dog dogName){
		this.dog = dogName;
	}
	
	public String getInfo(){
		//check if human owns a dog or not
		String s = "";
			if (dog !=null){
				s = getName()  + " �ger hunden " + dog.getName();
				return s;
			} 	else {
					s = getName() + " �ger ingen hund";
				}
			return s;
	
	}
}
