package com;

import java.io.*;
import java.util.*;

public class Q2Solution {

	public static void main(String[] argv) {
		// Q2 inputs and function calls
		   char[][] grid1 = {
	 				{'c', 'c', 'x', 't', 'i', 'b'},
	 				{'c', 'c', 'a', 't', 'n', 'i'},
	 				{'a', 'c', 'n', 'n', 't', 't'},
	 				{'t', 'c', 's', 'i', 'p', 't'},
	 				{'a', 'o', 'o', 'o', 'a', 'a'},
	 				{'o', 'a', 'a', 'a', 'o', 'o'},
	 				{'k', 'a', 'i', 'c', 'k', 'i'}
	 			};
		List<String> wordlist = new ArrayList<String>();
	 		String word1 = "catnip";wordlist.add(word1);
	 		String word2 = "cccc";wordlist.add(word2);
	 		String word3 = "s";wordlist.add(word3);
	 		String word4 = "bit";wordlist.add(word4);
	 		String word5 = "aoi";wordlist.add(word5);
	 		String word6 = "ki";wordlist.add(word6);
	 		String word7 = "aaa";wordlist.add(word7);
	 		String word8 = "ooo";wordlist.add(word8);
	 		Q2Solution sol = new Q2Solution();
	 		wordlist.stream().forEach((word)->{
	 			System.out.print("coordinates of " + word + " => [");
	 			sol.find_word_location(grid1, word1).stream().forEach(arr -> System.out.print(Arrays.toString(arr) + ", "));
	 			System.out.println("]");
	 		});
	 		char[][] grid2 = { { 'a' } };
	 		String word9 = "a";
	 		System.out.print("coordinates of " + word8 + " => [");
	 		sol.find_word_location(grid2, word9).stream().forEach(arr ->    System.out.print(Arrays.toString(arr) + ", "));
	 		System.out.println("]");
	//  Q2 
	}

	List<int[]> output = null;

	public List<int[]> find_word_location(char[][] grid, String word) {
		char[] wordArray = word.toCharArray();
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				List<int[]> result = new ArrayList<int[]>();
				if (find_word_location(grid, wordArray, row, column, 0, result))
					return output;
			}
		}

		return Collections.emptyList();
	}

	private boolean find_word_location(char[][] grid, char[] word, int row, int column, int i, List<int[]> result) {
		if (i == word.length) {
			output = new ArrayList<>(result);
			return true;
		}
		if (row < 0 || column < 0 || row == grid.length || column == grid[row].length)
			return false;

		if (grid[row][column] != word[i])
			return false;

		result.add(new int[] { row, column });

		return find_word_location(grid, word, row + 1, column, i + 1, result) ? true
				: find_word_location(grid, word, row, column + 1, i + 1, result);

	}
}
