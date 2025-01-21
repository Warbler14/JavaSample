package com.lotus.jewel.sample.string;

public class AlterColumn {
	public static void main(String[] args) {

		int limit = 0;
		do {
			System.out.println("ALTER TABLE `CL_CONN_CLIENT_TC" + limit + "` MODIFY COLUMN `CLIENT_TOKEN` VARCHAR(255) NULL COMMENT 'CLIENT TOKEN';");

		} while (limit++ < 9);
	}
}
