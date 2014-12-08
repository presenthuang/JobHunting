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
		String alter = list.get(list.size()-1);
		list.set(index, alter);
		list.remove(list.size()-1);
		table.put(alter, index);
		table.remove(s);
	}
	
	public boolean contain(String s){
		return table.containsKey(s);
	}
	
	public String getRandom(){
		Random rand = new Random(System.currentTimeMillis());
		int num = rand.nextInt(list.size());
		return list.get(num);
	}
	
	public static void main(String[] args) {
		Google_MySet myRandomSet = new Google_MySet();
		String st1 = "Apple";
		String st2 = "Banana";
		String st3 = "Cat";
		myRandomSet.add(st1);
		myRandomSet.add(st2);
		myRandomSet.add(st3);
		
		myRandomSet.remove(st1);

		System.out.println(myRandomSet.table.size());
		System.out.println(myRandomSet.getRandom());
	}
}
