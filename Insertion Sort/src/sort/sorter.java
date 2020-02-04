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
		sort();
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
	
	public double getMean() {
		return (double)addNums()/ints.size();
	}
	
	public String getMedian() {
		if(ints.size()%2!=0) {
			return String.format("%d", ints.get((ints.size()/2)));
		}
		return String.format("%.3f", ((double)ints.get(ints.size()/2)+ints.get((ints.size()/2)-1))/2);
	}
	
	public String getMode() {
		ArrayList<Integer>mode=new ArrayList<Integer>();
		int modeCount=2;
		int count=0;
		for(int i=0;i<ints.size();i++) {
			for(int k=0;k<ints.size();k++) {
				if(ints.get(i).equals(ints.get(k))) {
					count++;
					System.out.println("i: "+ints.get(i));
					System.out.println("k: "+ints.get(k));
					System.out.println("modeCount: "+modeCount);
					System.out.println("Count: "+count);
					System.out.println("");
				}
			}
			if(count==modeCount) {
				modeCount=count;
				count=0;
				mode.add(ints.get(i));
			}
			else if(count>modeCount) {
				modeCount=count;
				count=0;
				mode.clear();
				mode.add(ints.get(i));
			}
		}

		if(mode.isEmpty()||ints.size()<2) {
			return "None";
		}
		String str="";
		for(Integer i:mode) {
			if(i==mode.get(0)) {
				str+=String.format("%d", i);
			}
			else {
				str+=String.format(", %d", i);
			}
			
		}
		return str;
	}
	
	public String getSD() {
		double[] sdArray=new double[ints.size()];
		
		for(int i=0;i<ints.size();i++) {
			sdArray[i]=Math.pow((ints.get(i)-getMean()), 2	);
		}
		
		double total=0;
		for(Double i:sdArray) {
			total+=i;
		}
		
		return String.format("%.3f", Math.sqrt(total/ints.size()));
	}
	private void sort(){
		 int holePosition;
		 int valueToInsert;
		  for(int i=1;i<ints.size();i++) {
			  valueToInsert=ints.get(i);
			  holePosition=i;
			  while(holePosition>0 && ints.get(holePosition-1)>valueToInsert) {
				  ints.set(holePosition, ints.get(holePosition-1));
				  holePosition-=1;
			  }
			  ints.set(holePosition, valueToInsert);
		  }
	}
}
