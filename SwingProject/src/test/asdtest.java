package test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;

public class asdtest {
	public static void main(String args[]) throws IOException, SQLException,
			NamingException {

		File file = new File("D:\\11.txt");
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		PrintWriter pw = new PrintWriter(output);
		pw.println("sab");
		pw.println("sab");
		pw.println("sab");
		output.close();
		pw.close();

	}
}