import java.io.*;
import java.util.*;

public class Image {
	private Pixel[][] pic;
	private int max;
	private int height;
	private int width;

	public void write(String OutFile) {
		FileOutputStream out = null;
		String s = "P3 ";
		try {
			out = new FileOutputStream(OutFile);
			out.write(s.getBytes());
			out.write(String.valueOf(width).getBytes());
			out.write(String(" ").getBytes());
			out.write(String.valueOf(height).getBytes());
			out.write(String(" ").getBytes());
			out.write(String.valueOf(max).getBytes());
			out.write(String("\n").getBytes());
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					out.write(pic[i][j].toString());
				}
			}
		}
		catch (IOException e) {
			System.err.printf("ERR: %v\n", e.getMessage());
		}
	}
	public void setUp(String InFile) {
		FileInputStream in = null;
		Scanner input = null;
		
		try {
			input = new Scanner(new FileInputStream(InFile));
			while (!input.hasNextInt()) {
				input.next();
			}
			int width = input.nextInt();
			while (!input.hasNextInt()) {
				input.next();
			}
			int height = input.nextInt();
			while (!input.hasNextInt()) {
				input.next();
			}
			max = input.nextInt();
			
			while (input.hasNextInt()) {
				System.out.println(input.nextInt());
			}
			pic = new Pixel[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					pic[i][j] = new Pixel(input.nextInt(), input.nextInt(), input.nextInt());
				}
			}
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
	public static void main (String Args[]) throws IOException {
		Image m = new Image;
		m.setUp(Args[0]);
	}
}
