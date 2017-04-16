package com.softeem.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.softeem.dao.IJdbcDAO;
import com.softeem.service.FindPassWordLogService;
import com.softeem.utils.DateTimeUtil;
import com.softeem.utils.DateUtils;
import com.softeem.utils.IDGenerator;

@Service("findPassWordLogServiceImpl")
public class FindPassWordLogServiceImpl implements FindPassWordLogService {
	private Logger logger = Logger.getLogger(UserInfoServiceImpl.class);
	@Resource(name = "iJdbcDAO")
	private IJdbcDAO jdbcDAO;

	@Override
	public void recordLog(String userCode, String ipaddress, String email) {
		String sql = "insert into tbl_findpwd_log(LOGID,USERCODE,EMAIL,IPADDRESS,CREATETIME) values(?,?,?,?,?)";
		jdbcDAO.executeUpdate(sql, new String[] { IDGenerator.generateStrID("LOG"), userCode, email, ipaddress, DateTimeUtil.getNow() });

	}

	@Override
	public int findLogSameDay(String userCode) {
		String sql = "select l.usercode from TBL_FINDPWD_LOG l where substr(l.createtime,0,10) = ? and l.usercode = ?";
		String nowDate = DateUtils.getDate();
		return jdbcDAO.getCount(sql, new String[] { nowDate, userCode });
	}

}
