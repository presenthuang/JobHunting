package interviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Google_MySet {
	private final HashMap<String, Integer> table = new HashMap<>();
	private final ArrayList<String> list = new ArrayList<>();
	public Google_MySet() {
		
	}
	public void add(String s){
		if(table.containsKey(s))
			return;
		list.add(s);
		table.put(s,list.size()-1);
	}
	
	public void remove(String s){
		if(!table.containsKey(s)){
			return;
		}
		int index = table.get(s);
		table.remove(s);
		list.set(index, list.get(list.size()-1));
		table.put(list.get(list.size()-1), index);
		list.remove(list.size()-1);
	}
	
	public boolean contain(String s){
		return table.containsKey(s);
	}
	
	public String getRandom(){
		Random rand = new Random(System.currentTimeMillis());
		int num = rand.nextInt(list.size());
		return list.get(num);
	}
}
