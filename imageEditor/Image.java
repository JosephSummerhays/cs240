import java.io.*;

public class Image {
	public static void main (String Args[]) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			inStream = new FileInputStream(Args[0]);
			Reader in = new InputStreamReader(inStream);
			String c;
			while ((c = in.read()) != -1) {
				System.out.println(c);
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
