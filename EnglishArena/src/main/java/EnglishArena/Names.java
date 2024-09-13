package EnglishArena;
 
public class Names {
	private String[] names;
	
	Names(String path){
		ReadExcelSheet Xlsheet = new ReadExcelSheet(path);
		names = Xlsheet.readFile();
	}
	
	public String getName(int index) {
		return names[index];
	}
	public int getLength() {
		return names.length;
	}
	
}
