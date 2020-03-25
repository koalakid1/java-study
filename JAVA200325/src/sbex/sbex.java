package sbex;

import java.util.StringTokenizer;

public class sbex {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("aaa");
		System.out.println(sb);
		StringTokenizer st = new StringTokenizer("이태민/정원영/박도영/이지훈","/");
		while (st.hasMoreElements())
		System.out.println(st.nextElement());
	}
}
