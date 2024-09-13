package EnglishArena;

import java.util.*;

public class Topics {
	private List<Integer> index ;
	Random rand;
	
	private String[] topics ;
	
	
	
	Topics(String path){
		index = new ArrayList<>();
		rand = new Random();
		ReadExcelSheet XlSheet = new ReadExcelSheet(path);
		topics = XlSheet.readFile();
	}
	
	public String getTopic() {
		int len = topics.length;
		while(index.size() != len) {
			int ind = rand.nextInt(len);
			
			if(!index.contains(ind)) {
				index.add(ind);
				return topics[ind];
			}
		}
		return "";
	}
}
