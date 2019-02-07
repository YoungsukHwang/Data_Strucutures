
public class Quick {

	public int[] sort(int[] arr, int numOfInts) {
		// TODO Auto-generated method stub
		System.out.println("---Quick sort Starts---");
		int[] play = arr.clone();
		quickSort(play);

		return play;
	}

	public static void quickSort(int[] play) {
		quickSort(play, 0, play.length - 1);
	}

	private static void quickSort(int[] play, int start, int end) {
		int part2 = partition(play, start, end);
		if (start < part2 - 1)
			quickSort(play, start, part2 - 1);
		if(part2<end)
			quickSort(play, part2, end);
	}

	private static int partition(int[] play, int start, int end) {
		int pivot = play[(start+end)/2];
		while(start<=end){
			while(play[start]<pivot) start++;
			while(play[end]>pivot) end--;
			
			if (start<=end){
				swap( play, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] play, int start, int end) {
		int temp = play[start];
		play[start] = play[end];
		play[end] = temp;
	}

}
