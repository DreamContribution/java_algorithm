package com.duke.main;

public class Merge {
	private static Comparable<?>[] aux;

	public static void sort(Comparable<?>[] a) {
		aux = new Comparable<?>[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable<?>[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
