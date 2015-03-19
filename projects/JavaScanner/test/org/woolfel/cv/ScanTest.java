package org.woolfel.cv;

import org.opencv.core.*;
import org.opencv.highgui.*;

public class ScanTest {

	public ScanTest() {
	}

	public static void main(String[] args) {
		String file = "./samples/image1-small.jpg";
		int scanwidth = 10;
		if (args != null && args.length > 0) {
			file = args[0];
		}
		if (args != null && args.length == 2) {
			scanwidth = Integer.parseInt(args[1]);
		}
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat imagematrix = Highgui.imread(file);
		VLScanner scanner = new VLScanner();
		VLScanner.setScanwidth(scanwidth);
		int loop = 30;
		int ignore = 5;
		double total = 0;
		for (int i=0; i < loop; i++) {
			long t = scanner.scanImage(imagematrix);
			if (i > ignore) {
				total += t;
			}
		}
		ScannedColumn[] result = scanner.getResults();
		for (int i=0; i < result.length; i++) {
			ScannedColumn c = result[i];
			System.out.println(c);
		}
		System.out.println("Avg=" + (total/(loop-ignore))/1000000.0 + "ms");
		System.out.println("file: " + file + " : width=" + scanwidth);
	}

}
