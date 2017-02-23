package com.duke.main;

public class MergeBU {
	private static Comparable<?>[] aux;

	public static void sort(Comparable<?>[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}

	public static void merge(Comparable<?>[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		System.out.println(String.format("i:%d,j:%d,hi:%d,distance:%d", i, j,
				hi, (hi - i)));
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
			System.out.println(String.format("k:%d,i:%d,j:%d", k, i, j));
		}
		print(aux);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	@SuppressWarnings("rawtypes")
	public static void print(Comparable[] target) {
		for (Comparable<?> comparable : aux) {
			System.out.print(comparable + ",");
		}
		System.out.println("\n");
	}
}
