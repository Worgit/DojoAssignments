class Project{
	private String name;
	private String description;
	private float initialCost;
	
	public Project(){
		this.name="No Name";
		this.description = "No Description";
	}
	
	public Project(String name){
		this.name=name;
		this.description = "No Description";
	}

	public Project(String name, String description){
		this.name=name;
		this.description = description;
	}
	
	public String getName(){
		return (name);
	}
	public void setName(String name){
		this.name = name;
	}
	public String getDescription(){
		return (description);
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String elevatorPitch(){
		return (name + " (" + initialCost + "):" + description);
	}
	public float getInitialCost(){
		return (initialCost);
	}
	public void setInitialCost(float initialCost){
		this.initialCost = initialCost;
	}
}