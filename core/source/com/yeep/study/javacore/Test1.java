package com.yeep.study.javacore;

import java.sql.Timestamp;
import java.util.Date;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		System.out.println(date.getTime());
	}

}
