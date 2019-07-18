import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.lang.String;
import java.lang.Integer;

public class QueueProg {
				public static void main(String[] args) throws IOException {
								String fileName = "queue";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								LinkedList<Integer> queue = new LinkedList<Integer>();

								String line;
								String number;

								reader.readLine(); // Ignore first line
								while ((line = reader.readLine()) != null) {
												if (line.charAt(0) == '+') {
																number = line.substring(2);
																queue.add(Integer.valueOf(number));
												} else {
																out.println(queue.remove());
												}
								}
								out.flush();
				}
}
