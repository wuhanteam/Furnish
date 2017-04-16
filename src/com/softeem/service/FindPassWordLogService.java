package com.softeem.service;

public interface FindPassWordLogService {
	
	public void recordLog(String userCode,String ipaddress,String email);
	
	public int findLogSameDay(String userCode);
}
