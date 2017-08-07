package framework.debug.banking.asd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class FileAppender implements Appender {

	public static BufferedReader bufread;
	// Create the file name and path
	private static String path = "d:/Asdlog.txt";
	private static File filename = new File(path);
	private static String readStr = "";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Override
	public void append(LogItem logitem) {
		String logcontent = "Log level:" + logitem.loggerlevel + "." + "Message:" + logitem.message + "." + "Date:"
				+ new Date() + "\n";
		try {
			creatTxtFile();
			// readStr=readTxtFile();
			writeTxtFile(logcontent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create log text file.
	 * 
	 * @throws IOException
	 * 
	 */
	public static void creatTxtFile() throws IOException {
		if (!filename.exists()) {
			filename.createNewFile();
			System.err.println(filename + "was created.");
		}
	}

	/**
	 * Read the log file.
	 * 
	 */
	public static String readTxtFile() {
		String read;
		FileReader fileread;
		try {
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try {
				while ((read = bufread.readLine()) != null) {
					readStr = readStr + read + "\r\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("log file content:"+ "\r\n" + readStr);
		return readStr;
	}

	/**
	 * Write log file.
	 * 
	 */
	public static void writeTxtFile(String newStr) throws IOException {
		FileWriter fw = new FileWriter(filename, true);
		try {
			fw.write(newStr+LINE_SEPARATOR);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("Fail to close.");
				}
		}
	}
}
