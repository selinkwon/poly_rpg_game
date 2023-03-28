package poly_rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tool {
	public static StringBuffer inputText = new StringBuffer();
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;

	public static String input() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void write(String message) {
		StringBuffer buffer = new StringBuffer();
		try {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			buffer.append(message);
			bw.write(buffer.toString());
			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
