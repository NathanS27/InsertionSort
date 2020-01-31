package sort;

import java.util.ArrayList;

public class sorter {

	private ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public sorter() {
		
	}
	
	public void addNum(String str) throws ImproperFormatException {
		try {
			
			String[] addedNums = str.split(",");
			for(String numbers:addedNums) {
				if(ints.size()>24) {
					throw new ImproperFormatException("Must be less than 25 numbers");
				}
				ints.add(Integer.parseInt(numbers));
			}
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
	
	private int addNums() {
		int total=0;
		for(Integer i:ints) {
			total+=i;
		}
		return total;
	}
	
	public String getMean() {
		return String.format("%d", addNums()/ints.size());
	}
	
	public String getMedian() {
		return "nah fam";
	}
	
	public double getMode() {
		return 69;
	}
	
	public String getSD() {
		double[] sdArray=new double[ints.size()];
		for(int i=0;i<ints.size();i++) {
			sdArray[i]=Math.pow((ints.get(i)-getMode()), 2	);
		}
		int total=0;
		for(Double i:sdArray) {
			total+=i;
		}
		return String.format("%f", Math.pow(total/ints.size(), 2));
	}
}
