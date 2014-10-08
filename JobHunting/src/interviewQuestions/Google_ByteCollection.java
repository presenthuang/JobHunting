package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Google_ByteCollection {
//	输入： 乱序的byte collection ， 输出：有序byte 除去dup  
//	说白了就是排序和去重 然后数据结构我说输入输出可以用List么 
//	他说可以 所以大概就是输入一个无序的 List<Byte> 输出一个有序的且无重复元素的 List<Byte>
	
	public static List<Byte> sortByteCollection(List<Byte> list){
		boolean [] existed = new boolean[256];
		if(list == null)
			return null;
		for(Byte b : list){
			existed[b+128] = true;
		}
		List<Byte> result = new ArrayList<Byte>();
		
		for(int i = 0; i < 256; ++i){
			if(existed[i]){
				byte b = (byte) (i - 128);
				result.add(b);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Byte> list = new ArrayList<>();
		list.add(new Byte((byte) 1));
		list.add(new Byte((byte) 1));
		list.add(new Byte((byte) 1));
		list.add(new Byte((byte) 2));
		list.add(new Byte((byte) -1));
		list.add(new Byte((byte) 1));
		List<Byte> result = Google_ByteCollection.sortByteCollection(list);
		for(Byte byte1 : result){
			System.out.print(byte1 + " ");
		}
	}
}
