import java.util.Random;

public class Compare {
	
	public static void main(String[] args) {
		
		myLinkedList myl = new myLinkedList();
		myArraylist mya = new myArraylist();
		
		Random r = new Random();
		final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

		// Adding initialization of both.
		int strSize = 100000;
		for(int i=0; i< strSize; i++){
			
			String str = new String();
			for(int j=0; j<5;j++){
				int a = r.nextInt(ALPHA.length());
				str+= ALPHA.substring(a, a+1);    
			}
			
			myl.add(0, str);
			mya.add(mya.size, str);
		}

		int index_query= r.nextInt(strSize);
	//ADD
		long cT1 = System.nanoTime();
		mya.add(index_query, "abc");
		long eT1 = System.nanoTime();
		long myaAddTime= eT1-cT1;
		
		long cT2 = System.nanoTime();
		myl.add(index_query, "abc");
		long eT2 = System.nanoTime();
		long mylAddTime= eT2-cT2;
		
		index_query = r.nextInt(strSize);
	//GET
		cT1 = System.nanoTime();
		mya.get(index_query);
		eT1 = System.nanoTime();
		long myaGetTime= eT1-cT1;
		
		cT2 = System.nanoTime();
		myl.get(index_query);
		eT2 = System.nanoTime();
		long mylGetTime= eT2-cT2;
		
		index_query = r.nextInt(strSize);
	//REMOVE
		cT1 = System.nanoTime();
		mya.remove(index_query);
		eT1 = System.nanoTime();
		long myaRemoveTime= eT1-cT1;
		
		cT2 = System.nanoTime();
		myl.remove(index_query);
		eT2 = System.nanoTime();
		long mylRemoveTime= eT2-cT2;
		
		System.out.println("\tArrayList\tLinkedList");
		System.out.println("---------------------------------------");
		System.out.println("Add\t|"+myaAddTime+"\t|"+mylAddTime);  //O(size) O(size)  | <-how to deal with it???
		System.out.println("---------------------------------------");
		System.out.println("Get\t|"+myaGetTime+"\t|"+mylGetTime); //O(1) O(i)
		System.out.println("---------------------------------------");
		System.out.println("Remove\t|"+myaRemoveTime+"\t|"+mylRemoveTime); //O(size) O(size)
		
		
	}
	
}
