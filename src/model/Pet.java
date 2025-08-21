package model;

public class Pet {

	// Attributes
	
	private int idPet;
	private String pet_name;
	private String breed;
	private int age;
	private double weight;
	private String additionalInfo;
	private int owner;
	
	//Builder
	public Pet(int idPet, String pet_name, String breed, double weight, String addInfo, int owner) {
		this.idPet = idPet;
		this.pet_name = pet_name;
		this.breed = breed;
		this.weight = weight;
		this.additionalInfo = addInfo;
		this.owner = owner;
	}
	
	//Getters and Setters
	public int getIdPet() {
		return idPet;
	}

	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String raza) {
		this.breed = raza;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	public int getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Pet [idPet=" + idPet + ", pet_name=" + pet_name + ", breed=" + breed + ", age=" + age + ", weight="
				+ weight + ", additionalInfo=" + additionalInfo + ", owner=" + owner + "]";
	}

	
	
	
	
}
