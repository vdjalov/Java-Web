package app.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class UtilsImpl implements Utils {

	@Override
	public String hashPassword(String password) {
		return DigestUtils.sha256Hex(password);
	}

}
