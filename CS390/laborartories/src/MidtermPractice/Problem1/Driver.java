package MidtermPractice.Problem1;

public class Driver {
	public static void main(String[] args) {
		Figure[] figures = {
				new HatMaker(),
				new HatMaker(),
				new VeeMaker(),
				new ParallelMaker(),
				new FaceMaker()
		};
		
		new Driver(figures);
	}

	//Modify this code
	public Driver(Object[] figures){
		final String SPACE = " ";
		for(Object o : figures){
			if(o instanceof HatMaker) {
				HatMaker h = (HatMaker)o;
				System.out.print(h.getFigure()+SPACE);
			}
			if(o instanceof VeeMaker) {
				VeeMaker v = (VeeMaker)o;
				System.out.print(v.getFigure()+ SPACE);
			}
			if(o instanceof ParallelMaker) {
				ParallelMaker p = (ParallelMaker)o;
				System.out.print(p.getFigure()+ SPACE);
			}

			if(o instanceof FaceMaker) {
				FaceMaker f = (FaceMaker) o;
				System.out.print(f.getFigure()+ SPACE);
			}
		}
	}

}
