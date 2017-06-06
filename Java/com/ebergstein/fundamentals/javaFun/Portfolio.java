import java.util.ArrayList;
class Portfolio{
	private ArrayList<Project> projects = new ArrayList<>();
	
	public ArrayList<Project> getProjects(){
		return (projects);
	}
	public void setProjects(ArrayList<Project> projects){
		this.projects = projects;
	}
	
	public void addProject(Project project){
		projects.add(project);
	}
	public float getPortfolioCost(){
		float result = 0;
		for(Project element: projects){
			result = result + element.getInitialCost();
		}
		return (result);
	}
	public void showPortfolio(){
		for(Project element: projects){
			System.out.println(element.elevatorPitch());
		}
		System.out.println(getPortfolioCost());
	}
}