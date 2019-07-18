import java.io.*;

public class Snowmen {
				static class Node {
							public Node next = null;
							public long value = 0;
				}

				public static void main(String[] args) throws IOException {
								String fileName = "snowmen";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								String line = reader.readLine();
								int n = Integer.valueOf(line);
								Node[] snowmen = new Node[n+1]; // Linked list. Snow balls are added at the front.
								snowmen[0] = new Node();

								long[] totalmasses = new long[n+1];
								totalmasses[0] = 0;

								// Fill linked lists.
								int snowman, action;
								int whitespace;
								for (int i = 0; i < n; i++) {
												snowmen[i+1] = new Node();
												line = reader.readLine();
												whitespace = line.indexOf(' ');
												snowman = Integer.valueOf(line.substring(0, whitespace));
												action = Integer.valueOf(line.substring(whitespace+1, line.length()));

												if (action == 0) {
																// Snowman is identical to given snowman, minus last ball.
																snowmen[i+1] = snowmen[snowman].next;
																totalmasses[i+1] = totalmasses[snowman] - snowmen[snowman].value;
												} else {
																// Add one ball.
																snowmen[i+1].next = snowmen[snowman];
																snowmen[i+1].value = action;
																totalmasses[i+1] = totalmasses[snowman] + action;
												}
								}

								// Traverse to determine total mass
								long totalmass = 0;
								for (int i = 0; i <= n; i++) {
												totalmass += totalmasses[i];
												//node = snowmen[i];
												//if (node == null) {
												//				continue;
												//}
												//totalmass += node.value;
												//while ((node = node.next) != null) {
												//				totalmass += node.value;
												//}
								}

								out.println(totalmass);
								out.flush();
				}
}
