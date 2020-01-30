package sort;

import java.util.ArrayList;

public class sorter {

	private ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public sorter() {
		
	}
	
	public void addNum(String str) throws ImproperFormatException {
		try {
			ints.add(Integer.parseInt(str));
		}
		catch(NumberFormatException e) {
			throw new ImproperFormatException("input must be an integer");
		}
	}
	public String print() {
		String str=String.format("%d", ints.get(0));
		for(int i=1;i<ints.size();i++) {
			str+=String.format(", %d", ints.get(i));
		}
		return str;
	}
	public void clear() {
		ints.clear();
	}
}
