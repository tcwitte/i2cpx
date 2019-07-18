import java.io.*;
import java.util.Scanner;

public class Inversions {
				public static long mergeSort(long[] list, long[] tmp, int start, int tail) {
								if (start + 1 == tail) {
												return 0;
								}
								
								long outoforder = 0;
								int midpoint = start + (tail - start)/2;

								outoforder += mergeSort(list, tmp, start, midpoint);
								outoforder += mergeSort(list, tmp, midpoint, tail);

								int i = start;
								int j = midpoint;
								int k = start;
								while (i < midpoint || j < tail) {
												if (i == midpoint) {
																tmp[k] = list[j];
																j++;
																k++;
												} else if (j == tail) {
																tmp[k] = list[i];
																i++;
																k++;
												} else if (list[i] <= list[j]) {
																tmp[k] = list[i];
																i++;
																k++;
												}
												else {
																tmp[k] = list[j];
																j++;
																k++;
																outoforder += midpoint - i;
												}
								}

								for (i = start; i < tail; i++) {
												list[i] = tmp[i];
								}

								return outoforder;
				}

				public static void main(String[] args) throws IOException {
								String filename = "inversions";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								Scanner scanner = new Scanner(reader);
								PrintWriter out = new PrintWriter(filename + ".out");

								int n = scanner.nextInt();
								long[] list = new long[n];
								for (int i = 0; i < n; i++) {
												list[i] = scanner.nextLong();
								}

								long[] tmp = new long[n];
								out.println(mergeSort(list, tmp, 0, list.length));
								out.flush();
				}
}
