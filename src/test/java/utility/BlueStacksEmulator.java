package utility;

import java.io.IOException;


public class BlueStacksEmulator {
	
	public static Runtime bluestacks = Runtime.getRuntime();
	
	public static void start() throws InterruptedException, IOException {
		
		bluestacks.exec("cmd /c start /min " + "C:\\Eclipse\\workspace\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Start_BlueStacks.bat");
		Thread.sleep(45000);

	}

	
	public static void stop() throws IOException {

		bluestacks.exec("cmd /c start /min " + "C:\\Eclipse\\workspace\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Stop_BlueStacks.bat");

	}

}
