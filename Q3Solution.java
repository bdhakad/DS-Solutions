package com;

import java.io.*;
import java.util.*;

public class Q3Solution {
	private static final int[] row = { 1, 0 };
	private static final int[] col = { 0, 1 };

	public static void main(String[] argv) {
		char[][] mat = { { 'A', 'B', 'A', 'B' },
						{ 'B', 'A', 'B', 'A' },
						{ 'A', 'B', 'Y', 'B' },
						{ 'B', 'Y', 'A', 'A' },
						{ 'A', 'B', 'B', 'A' } };
		String word = "ABY";
		Q3Solution sol = new Q3Solution();
		sol.findAllOccurences(mat, word);
	}

	ArrayList<List<Node>> paths = new ArrayList<List<Node>>();

	public void findAllOccurences(char[][] mat, String word) {
		if (mat == null || mat.length == 0 || word == null) {
			return;
		}

		List<Node> path = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				DFS(mat, word, Node.of(i, j), path, 0);
			}
		}
	}

	public void DFS(char[][] mat, String word, Node next, List<Node> path, int index) {
		int i = next.x;
		int j = next.y;

		if (mat[i][j] != word.charAt(index)) {
			return;
		}
		path.add(Node.of(i, j));
		if (index == word.length() - 1) {
			System.out.println(path);
			paths.add(path);
		} else {
			for (int k = 0; k < row.length; k++) {
				next = Node.of(i + row[k], j + col[k]);
				if (isValid(next, path, mat.length, mat[0].length)) {
					DFS(mat, word, next, path, index + 1);
				}
			}
		}
		path.remove(path.size() - 1);
		return;
	}

	public static boolean isValid(Node next, List<Node> path, int M, int N) {
		return (next.x >= 0 && next.x < M) && (next.y >= 0 && next.y < N) && !path.contains(next);
	}

}

class Node {
	public int x, y;

	private Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Node of(int x, int y) {
		return new Node(x, y);
	}

	@Override
	public boolean equals(Object o) {
		Node node = (Node) o;
		return x == node.x && y == node.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}
}
