package Sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSorter {
	/*
	 * Reads a file with integers and creates an array. Returns an array comprising
	 * of integers from the file read.
	 * 
	 * @Precondition file consists data of type int.
	 * 
	 * @param file A file that consists of integers.
	 * 
	 * @param aSize The size of the array that needs to be created.
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException if file is not found.
	 * 
	 * @return an array of type int.
	 */
	public int[] ReadFile(File file, int aSize) throws IOException {
		int[] array = new int[aSize];
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				for (int counter = 0; counter < aSize; counter++) {
					array[counter] = Integer.parseInt(br.readLine());
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return array;
	}

	/*
	 * Sorts the given array using quick sort sort method. Recursively calls quick
	 * sort until both partitions of the array are sorted. one partition has smaller
	 * elements than the pivot and one has larger elements.
	 * 
	 * @param array array of randomly sorted integers
	 * 
	 * @param low lower bound index of array.
	 * 
	 * @param high higher bound index of array.
	 */
	public void quickSort(int array[], int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);

			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}

	}

	/*
	 * compares each unsorted element with the pivot and increments m if the pivot
	 * is greater than the kth element swaps kth element and mth element or
	 * increments k if pivot is less than the kth element. swaps lowerbound index
	 * and mth element once the iteration is over.
	 * 
	 * @param array array of randomly sorted integers
	 * 
	 * @param lowerBound lower bound index of array.
	 * 
	 * @param higherBound higher bound index of array.
	 * 
	 * @return m pivot index.
	 */
	public int partition(int[] array, int lowerBound, int higherBound) {
		int pivot = array[lowerBound];
		int m = lowerBound;

		for (int k = lowerBound + 1; k <= higherBound; k++) {
			if (array[k] < pivot) {
				m++;
				swap(array, k, m);
			}
		}
		swap(array, lowerBound, m);
		return m;
	}

	/*
	 * Swaps array elements between two array indices.
	 * 
	 * @param array array whose elements need to be swapped at specified indices.
	 * 
	 * @param i first index at which the element needs to be swapped.
	 * 
	 * @param j second index at which the element needs to be swapped.
	 */
	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/*
	 * Prints the given array's elements horizontally.
	 * 
	 * @param array an array that needs to be printed.
	 */
	public void printArray(int[] a) {

		System.out.println("This is the array using Quick Sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
