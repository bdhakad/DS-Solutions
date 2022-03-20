package com;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] argv) {
		// Q1 inputs and function calls
		String[] words = new String[] { "cat", "baby", "dog", "bird", "car", "ax" };
		String string1 = "tcabnihjs";
		String string2 = "tbcanihjs";
		String string3 = "baykkjl";
		String string4 = "bbabylkkj";
		String string5 = "ccc";
		String string6 = "breadmaking";
		Q1Solution sol = new Q1Solution();
		System.out.println(sol.find_embedded_word(words, string1));
		System.out.println(sol.find_embedded_word(words, string2));
		System.out.println(sol.find_embedded_word(words, string3));
		System.out.println(sol.find_embedded_word(words, string4));
		System.out.println(sol.find_embedded_word(words, string5));
		System.out.println(sol.find_embedded_word(words, string6));
		// Q1
	}

	public String find_embedded_word(String[] words, String str) {
		for (int i = 0; i < words.length; i++) {
			if (isContain(str, words[i])) {
				return words[i];
			}
		}
		return null;
	}

	public boolean isContain(String str, String s) {
		if (str.length() < s.length())
			return false;
		HashMap<Character, Integer> map1 = createMap(s.toLowerCase());
		HashMap<Character, Integer> map2 = createMap(str.toLowerCase());

		for (Character c : map1.keySet()) {
			if (!(map1.get(c) != null && map2.get(c) != null && map1.get(c) <= map2.get(c))) {
				return false;
			}
		}
		return true;
	}

	public HashMap<Character, Integer> createMap(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
}
