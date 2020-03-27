package fex;

import java.io.File;

public class ex4 {
	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath()+"의 서브 리스트 입니다. -----");
		File[] subFiles = dir.listFiles();
		
		for (int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일크기: "+ f.length());
			System.out.printf("\t수정한 시간: %tb %td %ta %tT \n",t,t,t,t);
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
	}
}
