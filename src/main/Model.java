package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Model {
	
	public void setAsset(String asset) throws IOException {
		processCmd("WinAIAPackage.exe --silent --set \"USERASSETDATA.ASSET_NUMBER=" + asset + "\"");
	}
	
	public void getAssetInfo() throws IOException {
		processCmd("WinAIAPackage.exe --get");
	}
	
	public void processCmd(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\DRIVERS\\WINAIA\" && " + command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
	}
}
