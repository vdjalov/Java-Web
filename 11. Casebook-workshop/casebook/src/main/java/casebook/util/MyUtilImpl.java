package casebook.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MyUtilImpl implements MyUtils {

	@Override
	public String hashPassword(String password) {
		return DigestUtils.sha256Hex(password);
	}

}
