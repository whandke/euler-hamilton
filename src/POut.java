public class POut {
	public static void beginTableRow(boolean excel){
		if(!excel)
			System.out.print("|\t");
	}
	
	public static void separatorTableRow(boolean excel){
		if(!excel)
			System.out.print("\t|\t");
		else
			space();
	}
	
	public static void endTableRow(boolean excel){
		if(!excel)
			System.out.print("\t|\n");
		else
			newLine();
	}
	
	public static void space(){
		System.out.print(" ");
	}
	public static void newLine(){
		System.out.print("\n");
	}
	
	

}
