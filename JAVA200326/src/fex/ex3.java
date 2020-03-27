package fex;

import java.io.File;

public class ex3 {
	public static void main(String[] args) {
		File f = new File("c:\\temp");
		File[] list = f.listFiles();
		for (int i = 0; i < list.length; i++) {
			File f2 = list[i];
			System.out.print(f2.getName() + "\t"+f2.length() + "\t");
			long t = f2.lastModified();
			System.out.printf("%1$tY³â %tb %td %ta %tT \n",t,t,t,t);
		}
	}
}
