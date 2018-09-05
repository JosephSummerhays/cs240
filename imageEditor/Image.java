import java.io.*;
import java.util.*;

public class Image {
	public static void main (String Args[]) throws IOException {
		FileInputStream in = null;
		Scanner input = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(Args[0]);
			input = new Scanner(in);
			System.out.println(input.nextLine());
			System.out.println(input.nextLine());
			while (input.hasNextInt()) {
				System.out.println(input.nextInt());
			}
			
			out = new FileOutputStream(Args[1]);
			String s = "Hello, World!";
			out.write(s.getBytes());
		}
		catch (IOException e) {
			System.err.printf("ERR: %v\n", e.getMessage());
		}
		finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
