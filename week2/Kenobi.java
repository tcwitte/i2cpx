import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
import java.lang.Integer;

// Note: incorrect solution
public class Kenobi {
				public static void main(String[] args) throws IOException {
								String filename = "kenobi";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								PrintWriter out = new PrintWriter(filename + ".out");

								LinkedList<Integer> sabers = new LinkedList<Integer>();

								reader.readLine(); // Ignore first line
								String line, saber;
								int size, shuffles, i, j;
								int consecutiveMums = 0;
								while ((line = reader.readLine()) != null) {
												if (!line.startsWith("mum!") && consecutiveMums > 0) {
																// Do the mum!s now
																size = sabers.size();
																shuffles = size / 2; // for one mum! rounds towards zero
																if (size % 2 == 0) {
																				if (consecutiveMums == 1) {
																								for (i = 0; i < shuffles; i++) {
																												sabers.addLast(sabers.removeFirst());
																								}
																				}
																				// else, they cancel out
																} else {
																				// two mum!s don't cancel out
																				consecutiveMums = consecutiveMums % size;
																				for (j = 0; j < consecutiveMums; j++) {
																								for (i = 0; i < shuffles; i++) {
																												sabers.addLast(sabers.removeFirst());
																								}
																				}

																}
																consecutiveMums = 0;
												}

												if (line.startsWith("add")) {
																saber = line.substring(4, line.length());
																sabers.addLast(Integer.valueOf(saber));
												} else if (line.startsWith("take")) {
																sabers.removeLast();
												} else if (line.startsWith("mum!")) {
																consecutiveMums += 1;
												}
								}

								if (consecutiveMums > 0) {
												// Code duplication
												// Do the mum!s now
												size = sabers.size();
												shuffles = size / 2; // for one mum! rounds towards zero
												if (size % 2 == 0) {
																if (consecutiveMums == 1) {
																				for (i = 0; i < shuffles; i++) {
																								sabers.addLast(sabers.removeFirst());
																				}
																}
																// else, they cancel out
												} else {
																// two mum!s don't cancel out
																consecutiveMums = consecutiveMums % size;
																for (j = 0; j < consecutiveMums; j++) {
																				for (i = 0; i < shuffles; i++) {
																								sabers.addLast(sabers.removeFirst());
																				}
																}

												}
								}

								out.println(sabers.size());
								while (!(sabers.size() == 0)) {
												out.print(sabers.pop() + " ");
								}

								out.flush();
				}
}
