import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] mainArray = null;
		System.out.println("Pick an option and enter in the number. 1) Random array 2) Best case 3) Worst Case");
		int input = in.nextInt();
		switch(input) {
		case 1:
			System.out.println("What size? 1) 100 2) 1000 3) 10000");
			int input2 = in.nextInt();
			if (input2==1) {
				mainArray = new int[100];
			} else if (input2==2) {
				mainArray = new int[1000];
			} else {
				mainArray = new int[10000];
			}
		case 2:
			mainArray = new int[100]; //fix later; best case
		case 3:
			mainArray = new int[100];
	        for (int i = 0; i< mainArray.length; i++)
	            mainArray[i] = i+1;
		}
		if (input==1) {
			 Random rand = new Random();
		        for (int i = 0; i< mainArray.length; i++)
		            mainArray[i] = rand.nextInt(100);
		}
		System.out.println("Old array: " + Arrays.toString(mainArray));
        long startTime = System.nanoTime();
        quickSort(mainArray, 0, mainArray.length-1); //ask
        long endTime = System.nanoTime();
        float finalTime = (((float) (endTime-startTime)) / ((float) 1000000000));
        System.out.println("Sorted array: " + Arrays.toString(mainArray));
        System.out.println("Runtime: " + finalTime + " seconds");
        in.close();
	}

	private static void quickSort(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		if (p<r) {
			int q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}

	private static int partition(int[] a, int p, int r) {
		// TODO Auto-generated method stub
		int x = a[r];
		int i = p-1;
		for (int j=p; j<=r-1; j++) {
			if (a[j]<=x) {
				i++;
				exchange(a, i, j);
			}
		}
		exchange(a, i+1, r);
		return i+1;
	}
	
	private static void exchange(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
