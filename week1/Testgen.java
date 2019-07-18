import java.io.*;
import java.util.Scanner;

public class Testgen {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "testgen";
								Scanner scanner = new Scanner(new File(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								int k = scanner.nextInt();
								if (k < 12) {
									int numDivisors[] = {0, 1, 1, 2, 1, 1, 1, 1, 2, 2, 3, 3};
									out.print(numDivisors[k]);
									out.flush();
									return;
								}
								int numDivisors[] = new int[k+1]; // need only half
								int maxDivisors = 0;
								
								// Find primes
								for (int i = (int) k/2; i <= k; i++) {
									int divisors = 0;
									if (i % 2 == 0){
										divisors++;
									}
									if (i % 3 == 0){
										divisors++;
									}
									if (i % 5 == 0){
										divisors++;
									}
									if (i % 7 == 0){
										divisors++;
									}
									numDivisors[i] = divisors;
									if (divisors > maxDivisors) {
										maxDivisors = divisors;
									}
								}

								// Determine exact number of divisors for best numbers
								for (int i = (int) k/2; i <= k; i++) {
									if (numDivisors[i] < maxDivisors) {
										continue;
									}
									
									int exactDivisors = 1;
									int n = i;

									int twoCount = 0;
									while (n%2==0) {
										twoCount++;
										n /= 2;
									}
									exactDivisors *= (twoCount + 1);
									
									// Number to divide by should be odd
									for (int d = 3; d < n; d += 2) {
										int count = 0;
										while (n%d==0) {
											count++;
											n /= d;
										}
										exactDivisors *= (count + 1);
									}
									
									numDivisors[i] = exactDivisors;
									System.out.println("" + i + "has " + exactDivisors + " divisors");
									if (exactDivisors > maxDivisors) {
										maxDivisors = exactDivisors;
									}
								}
								
								// Count
								int numberOfMaxDividable = 0;
								for (int i = (int) k/2; i <= k; i++) {
									if (numDivisors[i] == maxDivisors) {
										numberOfMaxDividable++;
									}
								}
								
								out.print(numberOfMaxDividable);
								out.flush();
				}
}
