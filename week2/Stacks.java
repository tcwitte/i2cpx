import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Stacks {
				public static void main(String[] args) throws IOException {
								String filename = "stacks";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								Scanner scanner = new Scanner(reader);
								PrintWriter out = new PrintWriter(filename + ".out");

								PriorityQueue<Integer> stacks = new PriorityQueue<Integer>();
								int n = scanner.nextInt();

								int cup, stackSize;
								for (int i = 0; i < n; i++) {
												cup = scanner.nextInt();
												if (cup > 0) {
																// Start a new stack
																stacks.add(1);
												} else if (stacks.size() == 0) {
																// First stack
																stacks.add(1);
												} else {
																// Add empty cup to smallest stack
																stackSize = stacks.poll();
																stacks.add(stackSize + 1);
												}
								}

								// Largest stack is the one that is retrieved last
								Integer size;
								int largest = 0;
								while ((size = stacks.poll()) != null) {
												largest = size;
								}

								out.println(largest);
								out.flush();
				}
}
