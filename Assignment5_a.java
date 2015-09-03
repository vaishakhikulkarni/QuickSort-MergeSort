//package DAY1;

//Vaishakhi Kulkarni
//Net Id:vpk140230

import java.util.Random;

public class Assignment5_a {

	//Array size is fixed
	final static int n = 8000000;
	private static long startTime;

	//MergeSort 
	public static <T extends Comparable<? super T>> void MergeSort(T[] A,
			int p, int r, T[] B) {
		if (p < r) {
			int q = (p + r) >>> 1;
			MergeSort(A, p, q, B);
			MergeSort(A, q + 1, r, B);
			Merge(A, p, q, r, B);
		}
	}

	//Function to perform erge operation
	public static <T extends Comparable<? super T>> void Merge(T[] A, int p,
			int q, int r, T[] B) {
		for (int i = p; i <= r; i++)
			B[i] = A[i];

		int i = p;
		int j = q + 1;
		for (int k = p; k <= r; k++) {
			if (j > r || (i <= q && (B[i].compareTo(B[j]) <= 0)))
				A[k] = B[i++];
			else
				A[k] = B[j++];
		}
	}

	//Insertion Sort code
	public static <T extends Comparable<? super T>> void InsertionSort(T[] C,
			int p, int r) {
		for (int i = p; i <= r; i++) {

			for (int j = i; j > p; j--) {
				if (C[j].compareTo(C[j - 1]) < 0) {
					T temp = C[j];
					C[j] = C[j - 1];
					C[j - 1] = temp;
				} else
					break;
			}
		}
	}

	//QuickSort function
	public static <T extends Comparable<? super T>> void QuickSort(T[] A,
			int p, int r) {
		if (p < r) {
			int q = Partition(A, p, r);
			if (q > p)
				QuickSort(A, p, q - 1);
			if (q < r - 1)
				QuickSort(A, q + 1, r);
		}
	}
	
	//Function to perform partition in quick sort
	public static <T extends Comparable<? super T>> int Partition(T[] A, int p,
			int r) {
		Random random = new Random();
		int i = Math.abs(random.nextInt(r - p) + p);

		T temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		T pivot = A[r];
		i = p - 1;

		for (int j = p; j <= r - 1; j++) {
			if (A[j].compareTo(pivot) <= 0) {
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp;

		return i + 1;
	}

	public static void main(String args[]) {
		Integer[] arr = new Integer[n];//Input array
		Integer[] auxi = new Integer[n];//Auxi array
		Integer[] arrCopy = new Integer[n];
		Integer[] arrCopyInsert = new Integer[n];
		Random random = new Random();
		System.out.println("***Compare Run time complexity***");
		for (int i = 0; i < n; i++) {
			arr[i] = new Integer(random.nextInt(n * 10));
			arrCopy[i] = new Integer(arr[i]);
			arrCopyInsert[i] = new Integer(arr[i]);
		}
		// Merge Sort
		System.out.println("Merge Sort");
		StartTimer();
		MergeSort(arr, 0, n - 1, auxi);
		StopTimer();

		// Quick Sort
		System.out.println("Quick Sort");
		StartTimer();
		QuickSort(arrCopy, 0, n - 1);
		StopTimer();

		// Insertion Sort
		System.out.println("Insertion Sort");
		StartTimer();
		InsertionSort(arrCopyInsert, 0, n - 1);
		StopTimer();

	}
	//Stop timer
	private static void StopTimer() {
		long stopTime = System.currentTimeMillis();
		System.out.println("Total time : " + (stopTime - startTime) + " msec.");

	}
	//Start timer
	private static void StartTimer() {
		startTime = System.currentTimeMillis();
	}
}
