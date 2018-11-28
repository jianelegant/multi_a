package com.yy.adam.helper.compat;

/**
 * @author yy
 */

public class ObjectsCompat {

	/**
	 * Null-safe equivalent of {@code a.equals(b)}.
	 */
	public static boolean equals(Object a, Object b) {
		return (a == null) ? (b == null) : a.equals(b);
	}
}
