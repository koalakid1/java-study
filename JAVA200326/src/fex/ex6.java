package fex;

import java.io.*;

public class ex6 {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\image.jpg"); // ���� ���� ��θ�
		// ������ 7������ File("c:\\Users\\Public\\Pictures\\Sample Pictures\\desert.jpg");�� ����϶�.

		File dest = new File("c:\\Temp\\copyimg.jpg"); // ���� ���� ��θ�

		int c;
		try {
			FileInputStream fi = new FileInputStream(src); // ���� �Է� ����Ʈ ��Ʈ�� ����
			FileOutputStream fo = new FileOutputStream(dest); // ���� ��� ����Ʈ ��Ʈ�� ����
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath()+ "�� " + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("���� ���� ����");
		}
	}
}