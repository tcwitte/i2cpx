import java.io.*;
import java.lang.String;
import java.lang.Integer;
import java.util.Stack;
import java.lang.Math;

public class QueueMin {
				public static void main(String[] args) throws IOException {
								String fileName = "queuemin";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								Stack<Integer> inbox = new Stack<Integer>();
								Stack<Integer> outbox = new Stack<Integer>();

								int inbox_min = Integer.MAX_VALUE;
								int outbox_min = Integer.MAX_VALUE;

								String line;
								String number;
								int numberInt;
								int value;

								reader.readLine(); // Ignore first line
								while ((line = reader.readLine()) != null) {
												if (line.charAt(0) == '+') {
																number = line.substring(2);
																numberInt = Integer.valueOf(number);
																inbox.push(numberInt);
																if (numberInt < inbox_min) {
																				inbox_min = numberInt;
																}
												} else if (line.charAt(0) == '-') {
																if (outbox.empty()) {
																				value = inbox.pop();
																				outbox_min = value;
																				outbox.push(0); // Store difference with minimal value

																				while (!inbox.empty()) {
																								value = inbox.pop();
																								outbox.push(value - outbox_min);
																								if (value < outbox_min) {
																												outbox_min = value;
																								}
																				}
																				inbox_min = Integer.MAX_VALUE;
																}

																value = outbox.pop();
																if (value < 0) {
																				outbox_min -= value; // Minimal value was just popped
																}
																if (outbox.empty()) {
																				outbox_min = Integer.MAX_VALUE;
																}
												} else if (line.charAt(0) == '?') {
																out.println(Math.min(inbox_min, outbox_min));
												}
								}
								out.flush();
				}
}
