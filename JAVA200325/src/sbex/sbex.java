package sbex;

import java.util.StringTokenizer;

public class sbex {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("aaa");
		System.out.println(sb);
		StringTokenizer st = new StringTokenizer("���¹�/������/�ڵ���/������","/");
		while (st.hasMoreElements())
		System.out.println(st.nextElement());
	}
}
