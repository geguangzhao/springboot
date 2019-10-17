package com.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

	private static  Logger log=LogManager.getLogger(LoggerUtil.class);
	private static LoggerUtil instance = new LoggerUtil();
	public static LoggerUtil getInstance() {
		return instance;
	}
	
	public void infoToFile(String message) {
		log.info(message);
	}
	
	public void errorToFile(String message) {
		log.error(message);
	}
	public void debugToConsole(String message) {
		log.debug(message);
	}
}
