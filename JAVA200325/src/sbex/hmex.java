package sbex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hmex {
	public static void main(String[] args) {
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		
		scoreMap.put("�輺��", 97);
		scoreMap.put("Ȳ����", 88);
		scoreMap.put("�賲��", 98);
		scoreMap.put("���繮", 70);
		scoreMap.put("�ѿ���", 99);
		
		System.out.println("HashMap�� ��� ���� : "+scoreMap.size());
		
		Set<String> keys = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext()) {
			String name = (String) it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " : " + score);
		}
		
	}
}
