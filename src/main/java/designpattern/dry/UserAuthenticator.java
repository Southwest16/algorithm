package designpattern.dry;

import org.apache.commons.lang3.StringUtils;

public class UserAuthenticator {
	public void authenticate(String username, String password) {
		if (!isValidUsername(username)) {
		}
	}

	public boolean isValidUsername(String username) {
		if (StringUtils.isBlank(username)) return false;

		int length = username.length();
		if (length < 4 || length > 64) return false;

		if (!StringUtils.isAllLowerCase(username)) return false;

		for (int i = 0; i < length; i++) {
			char c = username.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.') return false;
		}

		return true;
	}
}
