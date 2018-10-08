package utility;

import java.io.IOException;


public class NoxPlayerEmulator {
	
	public static Runtime noxPlayer = Runtime.getRuntime();
	
	public static void start() throws InterruptedException, IOException {
		
		noxPlayer.exec("cmd /c start /min " + "C:\\Workspace\\AppiumTesting\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Start_NoxPlayer.bat");
		Thread.sleep(50000);

	}

	
	public static void stop() throws IOException {

		noxPlayer.exec("cmd /c start /min " + "C:\\Workspace\\AppiumTesting\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Stop_NoxPlayer.bat");

	}

}
