package com.softeem.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class NetInfoUtil {
	public static String callCmd(String[] cmd) {
		String result = "";
		String line = "";
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStreamReader is = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(is);
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param cmd
	 */
	public static String callCmd(String[] cmd, String[] another) {
		String result = "";
		String line = "";
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);
			proc.waitFor(); // 宸茬粡鎵ц瀹岀涓�釜鍛戒护锛屽噯澶囨墽琛岀浜屼釜鍛戒护
			proc = rt.exec(another);
			InputStreamReader is = new InputStreamReader(proc.getInputStream());
			BufferedReader br = new BufferedReader(is);
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 */
	public static String filterMacAddress(final String ip, final String sourceString, final String macSeparator) {
		String result = "";
		String regExp = "((([0-9,A-F,a-f]{1,2}" + macSeparator + "){1,5})[0-9,A-F,a-f]{1,2})";
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(sourceString);
		while (matcher.find()) {
			result = matcher.group(1);
			if (sourceString.indexOf(ip) <= sourceString.lastIndexOf(matcher.group(1))) {
				break; //
			}
		}

		return result;
	}

	/**
	 *
	 * @param ip
	 * @return Mac Address
	 *
	 */
	public static String getMacInWindows(final String ip) {
		String result = "";
		String[] cmd = { "cmd", "/c", "ping " + ip };
		String[] another = { "cmd", "/c", "arp -a" };

		String cmdResult = callCmd(cmd, another);
		result = filterMacAddress(ip, cmdResult, "-");

		return result;
	}

	/**
	 * @param ip
	 * @return Mac Address
	 *
	 */
	public static String getMacInLinux(final String ip) {
		String result = "";
		String[] cmd = { "/bin/sh", "-c", "ping " + ip + " -c 2 && arp -a" };
		String cmdResult = callCmd(cmd);
		result = filterMacAddress(ip, cmdResult, ":");

		return result;
	}

	/**
	 * @param ip
	 * 
	 * @return
	 */
	public static Map<String, String> getComputerInfo(final String ip) {
		Map<String, String> result = new HashMap<String, String>();
		String[] cmd = (isWinOs()) ? new String[] { "cmd", "/c", "nbtstat -a " + ip }
				: new String[] { "/bin/sh", "-c", "nmblookup -A " + ip };
		String cmdResult = callCmd(cmd);
		if (cmdResult != null) {
			Pattern pat = Pattern.compile("[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}");
			Matcher mat = pat.matcher(cmdResult);
			while (mat.find()) {
				result.put("Address", mat.group(0).trim()); //
				break;
			}
			pat = Pattern.compile("([^s *]+[ *]+<[0-9A-F]{2}>){1}");
			mat = pat.matcher(cmdResult);
			while (mat.find()) {
				result.put("Name", mat.group(0).trim().replaceFirst("[ *]+<[0-9A-F]{2}>", "")); //
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public static String getMacAddress(String ip) {
		String macAddress = "";
		macAddress = getMacInWindows(ip).trim();
		if (StringUtils.isEmpty(macAddress)) {
			macAddress = getMacInLinux(ip).trim();
		}
		return macAddress;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 
	 * @return
	 */
	public static String runShell(String shell) {
		try {
			Process ps = Runtime.getRuntime().exec(shell);
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception t) {
			t.printStackTrace();
		}
		return null;
	}

	/***
	 * @param shell
	 * @return
	 */
	public static int runCmd(String shell) {
		try {
			// String[] cmd = new String[]{"/bin/sh","-c", shell};
			Process ps = Runtime.getRuntime().exec(shell);
			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			int exitVal = ps.waitFor();
			return exitVal;
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return 0;
	}

	public static boolean isWinOs() {
		String os = System.getProperties().getProperty("os.name");
		boolean isWin = (os.toLowerCase().startsWith("win")) ? true : false;
		return isWin;
	}

}
