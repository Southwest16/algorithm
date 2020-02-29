package designpattern.kiss;

import org.apache.commons.lang3.StringUtils;

/**
 * 检查输入的字符串ipAddress是否是合法的IP地址
 */
public class CheckIpAddress {
	//方法一: 正则表达式
	public boolean isValidIpAddressV1(String ipAddress) {
		if (StringUtils.isBlank(ipAddress)) return false;

		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
				"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
				"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
				"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.";

		return ipAddress.matches(regex);
	}

	//方法二: 工具类
	public boolean isValidIpAddressV2(String ipAddress) {
		if (StringUtils.isBlank(ipAddress)) return false;

		String[] ipUtils = StringUtils.split(ipAddress, ".");

		if (ipUtils.length != 4) return false;

		for (int i = 0; i < 4; i++) {
			int ipUnitIntValue;

			try {
				ipUnitIntValue = Integer.parseInt(ipUtils[i]);
			} catch (NumberFormatException e) {
				return false;
			}

			if (ipUnitIntValue < 0 || ipUnitIntValue > 255) return false;

			if (i == 0 && ipUnitIntValue == 0) return false;
		}
		return true;
	}

}
