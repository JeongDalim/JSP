package javaExam;

import java.util.*;
import java.util.Map.Entry;

public class Exam_04 {
	public static void main(String[] args) {
		List<String> voca = new ArrayList<String>();
		voca.add("rose");
		voca.add("candle");
		voca.add("paper");
		voca.add("book");
		voca.add("song");
		voca.add("candle");
		voca.add("berry");
		voca.add("paper");
		voca.add("berry");
		voca.add("song");
		voca.add("paper");
		voca.add("rose");
		voca.add("song");
		voca.add("lion");
		voca.add("berry");
		voca.add("rose");
		voca.add("book");
		voca.add("rose");
		voca.add("rose");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < voca.size(); i++) {
			int cnt = 0;
			for (int j = 0; j < voca.size(); j++) {
				if (voca.get(i).equals(voca.get(j))) {
					cnt++;
					map.put(voca.get(i), cnt);
				}
			}
		}
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next() + "times");
		}
		System.out.println("===========================");
		Set<String> set2 = map.keySet();
		Iterator<String> iter2 = set2.iterator();
		while (iter2.hasNext()) {
			String key=iter2.next().toString();
			System.out.println(key+":"+map.get(key)+ "times");
		}
	}
}