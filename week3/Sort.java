import java.io.*;
import java.util.Scanner;

public class Sort {
				public static void mergeSort(PrintWriter out, long[] list, long[] tmp, int s, int t) {
								if (s + 1 == t) {
												out.println("" + (s+1) + " " + t + " " + list[s] + " " + list[t-1]);
												return;
								}
								
								int midpoint = s + (t - s)/2;

								mergeSort(out, list, tmp, s, midpoint);
								mergeSort(out, list, tmp, midpoint, t);

								int i = s;
								int j = midpoint;
								int k = s;
								while (i < midpoint || j < t) {
												if ((j == t) || (i < midpoint && list[i] <= list[j])) {
																tmp[k] = list[i];
																i++;
																k++;
												} else {
																tmp[k] = list[j];
																j++;
																k++;
												}
								}

								for (i = s; i < t; i++) {
												list[i] = tmp[i];
								}

								out.println("" + (s+1) + " " + t + " " + list[s] + " " + list[t-1]);
				}

				public static void main(String[] args) throws IOException {
								String filename = "sort";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								Scanner scanner = new Scanner(reader);
								PrintWriter out = new PrintWriter(filename + ".out");

								int n = scanner.nextInt();
								long[] list = new long[n];
								for (int i = 0; i < n; i++) {
												list[i] = scanner.nextLong();
												System.out.println(list[i]);
								}

								long[] tmp = new long[n];
								mergeSort(out, list, tmp, 0, list.length);

								for (int i = 0; i < n; i++) {
												out.print(list[i]);
												if (i != n - 1) {
																out.print(" ");
												}
								}

								out.flush();
				}
}
