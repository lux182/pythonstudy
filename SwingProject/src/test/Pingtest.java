package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pingtest {
	public static void main(String[] args) {
		try {
			new Pingtest().ping();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ping() throws Exception {
		String cmd = "cmd.exe ping ";
		String ipprefix = "192.168.10.";
		int begin = 101;
		int end = 200;
		Process p = null;

		for (int i = begin; i < end; i++) {
			p = Runtime.getRuntime().exec(cmd + ipprefix + i);
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			while ((line = reader.readLine()) != null) {
				System.out.println(line+": Handling line , may logs it");
			}
			reader.close();
			p.destroy();
		}
	}
}
