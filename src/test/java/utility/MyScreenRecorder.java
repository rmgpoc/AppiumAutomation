package utility;

import java.io.IOException;


public class MyScreenRecorder {
	
	public static Runtime myscreenrecorder = Runtime.getRuntime();
	
	public static void start() throws InterruptedException, IOException {

		//Thread.sleep(35000);
		myscreenrecorder.exec("cmd /c start /min " + "C:\\Workspace\\AppiumTesting\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Start_ScreenRecorder.bat");

	}

	
	public static void stop() throws IOException, InterruptedException {
		
		Thread.sleep(15000);
		myscreenrecorder.exec("wscript.exe " + "C:\\Workspace\\AppiumTesting\\BlueStacks.BA.Poc\\src\\test\\resources\\batch\\Stop_ScreenRecorder.vbs");

	}

}
