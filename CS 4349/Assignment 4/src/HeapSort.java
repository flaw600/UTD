import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {
	
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
			mainArray = new int[100]; //fix later; worst case
		}
		if (input==1) {
			 Random rand = new Random();
		        for (int i = 0; i< mainArray.length; i++)
		            mainArray[i] = rand.nextInt(100);
		}
		System.out.println("Old array: " + Arrays.toString(mainArray));
        long startTime = System.nanoTime();
        heapSort(mainArray, mainArray.length-1);
        long endTime = System.nanoTime();
        float finalTime = (((float) (endTime-startTime)) / ((float) 1000000000));
        System.out.println("Sorted array: " + Arrays.toString(mainArray));
        System.out.println("Runtime: " + finalTime + " seconds");
        in.close();
	}

	private static void heapSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		buildMaxHeap(arr, n);
		
		for (int i = n; i>0; i--) {
			exchange(arr, 0, i);
			maxHeapify(arr, 0, i-1);
		}
	}

	private static void maxHeapify(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		int l = 2*i;
		int r = 2*i+1;
		int largest;
		
		if(l<=n && arr[l]>arr[i]) {
			largest = l;
		} else {
			largest = i;
		}
		
		if(r<=n && arr[r]>arr[largest]) {
			largest = r;
		}
		
		if (largest!=i) {
			exchange(arr, i, largest);
			maxHeapify(arr, largest, n);
		}
	}

	private static void exchange(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void buildMaxHeap(int[] arr, int n) {
		// TODO Auto-generated method stub
		for (int i = n/2; i>=0; i--) {
			maxHeapify(arr, i, n);
		}
	}

}
