import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class subArray {

	public static void main(String[] args) throws IOException {
		//Read File
		File file = new File("./array.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		ArrayList<Integer> inputList = new ArrayList<Integer>(100);	
		String st;
		while ( (st=br.readLine()) != null) {
			Integer elem = Integer.parseInt(st);
			inputList.add(elem);
		}
		br.close();
		
		//Calculate Sums and input the same sums into HT.
		ArrayList<Integer> sumList = new ArrayList<>(100);
		Hashtable<Integer, LinkedList<Integer>> ht = new Hashtable<>(); //Use
		int index=0, sumSoFar=0;
		Iterator<Integer> it = inputList.iterator();
		while(it.hasNext()){
			Integer a = it.next();
			sumSoFar += a.intValue();
			sumList.add(index, sumSoFar);
			
			LinkedList<Integer> list = ht.get(sumSoFar);
			if(list==null){
				list = new LinkedList<Integer>();
				ht.put(sumSoFar, list);
			}
			list.add(index);
			//System.out.println("Index "+index+". Integer "+a+ ". sumSoFar "+sumSoFar+ ". list " + list.toString());
			index++;
		}	

		// Scan through sumlist => Find index i whose sumSoFar==0 => Printout "Subarray found from Index 0 to i"
		// Scan through hashtable ht => Find lists with multiple elements => Print out all combinations "Subarray found from Index i+1 to j"
		Iterator<Integer> iter = sumList.iterator();
		index=0;
		while(iter.hasNext()){
			Integer a = iter.next();
			if(a==0)
				System.out.println("Subarray found from Index 0 to "+index);
			index++;
		}
		
		Set<Integer> keys = ht.keySet();
		for(Integer key : keys){
			LinkedList<Integer> list = ht.get(key);
			if(list.size()>1){
				//System.out.println(list.toString()+" This list has more than 1 element.");
				for(int i=0; i<list.size()-1;i++)
					for(int j=i+1; j<list.size();j++)
						System.out.println("Subarray found from Index "+list.get(i)+" to "+list.get(j));
			}
		}
		
		System.out.println("---The Program ends---");
	}
	

}
