package com.example.demo.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LoggerUtils {

	protected static Logger logger = LogManager.getLogger("file");

	public static void info(String message) {
		logger.info(message);
	}

	public static void error(String message) {
		logger.error(message);
	}
	public static void error(Throwable e) {
		StringWriter sw=new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		LoggerUtils.error(sw.toString());
	}
	public static void warn(String message) {
		logger.warn(message);
	}


}
