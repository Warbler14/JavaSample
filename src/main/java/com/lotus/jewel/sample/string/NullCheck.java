package com.lotus.jewel.sample.string;

public class NullCheck {



	public static void main(String[] args) {
		check(true);
		check(false);



	}

	private static void check(boolean useDateStamp) {
		/**
		 * The prefix that is added to log file filenames.
		 */
		String prefix = "access_log";

		/**
		 * The suffix that is added to log file filenames.
		 */
		String suffix = "";

		/**
		 * The as-of date for the currently open log file, or a zero-length string if
		 * there is no open log file.
		 */
		String dateStamp = "";

		final String targetPath;
		if (useDateStamp) {
			targetPath = prefix + dateStamp + suffix;
		} else {
			targetPath = prefix + suffix;
		}

		System.out.println(targetPath);
	}
}
