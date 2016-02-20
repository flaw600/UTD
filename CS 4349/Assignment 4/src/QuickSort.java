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
			break;
		case 2:
			int[] temp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
					31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,52,53,54,55,56,57,58,59,60,
					61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,
					92,93,94,95,96,97,98,99,100,51};
			mainArray = temp;
			break;
		case 3:
			mainArray = new int[100];
			for (int i = 0; i< mainArray.length; i++)
	            mainArray[i] = i+1;
			break;
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
