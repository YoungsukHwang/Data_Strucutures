
public class Selection {

	public int[] sort(int[] arr, int n) {
		System.out.println("---Selection sort Starts---");
		int[] play = new int[n];
		for(int i=0; i<n; i++)
			play[i]= arr[i];

		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (play[j] < play[min])
					min = j;

			int temp = play[min];
			play[min] = play[i];
			play[i] = temp;
		}

		return play;
	}

}