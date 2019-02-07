import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//2010-12086 Hwang Young suk :)
public class Sort {

	public static void main(String[] args) throws IOException {
		System.out.println("[The Program starts.]\nThis is input.");

		// Create Input.txt file
		FileWriter filewriter = new FileWriter("input.txt");
		int numOfInts = 100;
		Random random = new Random();
		for (int i = 0; i < numOfInts; i++)
			filewriter.write(Integer.toString(random.nextInt(100000)) + " ");
		filewriter.close();

		// Read file
		File file = new File("input.txt");
		int[] arr = new int[10000];
		int cnt = 0;
		Scanner reader = new Scanner(file);
		while (reader.hasNext()) {
			int i = reader.nextInt();
			System.out.print(i + " ");
			arr[cnt] = i;
			cnt++;
		}
		reader.close();
		System.out.println("\nInput Sorted Check:"+checkIfSorted(arr, numOfInts));
		
		double t; int[] result;
		// Use each sorting algorithm
		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Selection selection = new Selection();
		result = selection.sort(arr, numOfInts);
		System.out.println("Sorted Check:"+checkIfSorted(result, numOfInts));
	
		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Quick quick = new Quick();
		result = quick.sort(arr, numOfInts);
		System.out.println("Sorted Check:"+checkIfSorted(result, numOfInts));

		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Heap heap = new Heap(arr, numOfInts);
		result = heap.sort1(arr, numOfInts);
		System.out.println("Sorted Check:"+checkIfSorted(result, numOfInts));
		
		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Heap iniHeap = new Heap(arr, numOfInts);
		result = iniHeap.sort2(arr, numOfInts);
		System.out.println("Sorted Check:"+checkIfSorted(result, numOfInts)); 

		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		BST bst = new BST(arr, numOfInts);
		result = bst.sort(arr, numOfInts);
		//Array length of BSTsort can be lower than numOfInts due to duplication.
		int bstLength = result.length;
		System.out.println("Sorted Check:"+checkIfSorted(result, bstLength));
 
		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Splay spt = new Splay();
		result = spt.sort(arr, numOfInts);
		//Array length of Splaysort can be lower than numOfInts due to duplication.
		int splayLength = result.length;
		System.out.println("Sorted Check:"+checkIfSorted(result, splayLength ));  

		System.out.println("\nSorted Check:"+checkIfSorted(arr, numOfInts));
		Merge mrg = new Merge();
		result = mrg.sort(arr, numOfInts);
		System.out.println("Sorted Check:"+checkIfSorted(result, numOfInts));
		
		System.out.println("[The Program for Validity ends]");
		System.out.println("\n[The Program for Analysis starts]");
		for(int i=1; i<=7;i++){
			t=System.currentTimeMillis();
			for(int j=0; j<100; j++)
				switch(i){
					case 1:
						selection.sort(arr, numOfInts);break;
					case 2:
						quick.sort(arr, numOfInts); break;
					case 3:
						heap.sort1(arr, numOfInts); break;
					case 4:
						iniHeap.sort2(arr, numOfInts); break;
					case 5:
						bst.sort(arr, numOfInts); break;
					case 6:
						spt.sort(arr, numOfInts);break;
					case 7:
						mrg.sort(arr, numOfInts); break;
				}
			t=System.currentTimeMillis()-t;
			System.out.println("Method " +i+" takes "+ t+" ms when sorting 100 times with numOfInts:"+numOfInts+"integers");
		}

		FileWriter filewriter2 = new FileWriter("output.txt");
		for(int i=0; i<result.length;i++)
			filewriter2.write(result[i]+" ");
		filewriter2.close();
	}
	
	public static boolean checkIfSorted(int[] arr, int n){
		for(int i=0; i<n-1;i++)
			if(arr[i]>arr[i+1])
				return false;
		return true;
	}
	
	public static void print(int[] arr){
		for(int i=0; i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
}
