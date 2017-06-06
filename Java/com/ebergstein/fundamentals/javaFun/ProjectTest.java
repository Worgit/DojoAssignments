class ProjectTest{
	public static void main(String[] args){
		Project test = new Project();
		Project name = new Project("testing");
		Project full = new Project("full", "insert desc here");
		System.out.println(test.getName());
		System.out.println(name.getName());
		System.out.println(name.getDescription());
		System.out.println(full.getName());
		System.out.println(full.elevatorPitch());
		test.setInitialCost((float)5.86);
		name.setInitialCost((float)3.12);
		full.setInitialCost((float)15.99);
		Portfolio portfolio = new Portfolio();
		portfolio.addProject(test);
		portfolio.addProject(name);
		portfolio.addProject(full);
		portfolio.showPortfolio();
	}
}