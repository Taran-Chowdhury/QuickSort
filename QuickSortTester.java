package Sort;

import java.io.File;
import java.io.IOException;

public class QuickSortTester {
	/*
	 * create new instance of QuickSorter to read a file with data of type int and
	 * pass into array. sort the data and print sorted array.
	 */
	public static void main(String[] args) throws IOException {
		QuickSorter qs = new QuickSorter();
		File file = new File(
				"C:\\Users\\taran\\Desktop\\CS146\\HW2 - Iterataive sorting\\QuickSort\\bin\\MyList-2.txt");
		int[] QSarr = qs.ReadFile(file, 70);
		qs.quickSort(QSarr, 0, QSarr.length - 1);
		qs.printArray(QSarr);
	}
}
