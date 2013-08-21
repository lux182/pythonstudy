package test;

import java.text.SimpleDateFormat;

public final class IDCardUtil {

	  /**
	   * 掩码
	   */
	  private static int[] MASK = {
	      7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1
	  };

	  /**
	   * 验证码
	   */
	  private static final char[] VERIFY = {
	      '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'
	  };

	  /**
	   * 卡号长度
	   */
	  private static final int CARD_NO_LENGTH = 18;

	  /**
	   * 验证码位置
	   */
	  private static final int VERIFY_CODE_INDEX = CARD_NO_LENGTH - 1;

	  /**
	   * 生日码长度
	   */
	  private static final int BIRTHDAY_CODE_LENGTH = 8;

	  /**
	   * 生日码开始位置
	   */
	  private static final int BIRTHDAY_CODE_START = 6;

	  /**
	   * 生日码结束位置
	   */
	  private static final int BIRTHDAY_CODE_END = BIRTHDAY_CODE_START
	      + BIRTHDAY_CODE_LENGTH;

	  /**
	   * 不需要实例化。
	   */
	  private IDCardUtil() {
	  }

	  /**
	   * 验证是否是合法的身份证号码。
	   * 
	   * @param idCardNo
	   *          身份证号码
	   * @return 身份证号码是否合法
	   */
	  public static final boolean isValid(String idCardNo) {
	    try {
	      if (idCardNo.length() != CARD_NO_LENGTH) {
	        return false;
	      }
	      char verifyCode = idCardNo.charAt(VERIFY_CODE_INDEX);
	      if (verifyCode != getVerifyCode(idCardNo)) {
	        return false;
	      }
	      if (!isValidBirthday(idCardNo)) {
	        return false;
	      }
	      return true;
	    } catch (Exception ex) {
	      return false;
	    }
	  }

	  /**
	   * 根据身份证前17位数字，计算第18位验证码。
	   * 
	   * @param idCardNo
	   *          身份证号码（至少包含前17位数字）
	   * @return 第18位验证码
	   */
	  public static final char getVerifyCode(String idCardNo) {
	    int sum = 0;
	    for (int i = 0; i < VERIFY_CODE_INDEX; i++) {
	      sum += MASK[i] * (idCardNo.charAt(i) - '0');
	    }
	    return VERIFY[sum % VERIFY.length];
	  }

	  /**
	   * 验证身份证的生日代码是否正确。
	   * 
	   * @param idCardNo
	   *          身份证号码
	   * @return 身份证的生日代码是否正确
	   */
	  private static final boolean isValidBirthday(String idCardNo) {
	    String birthday = idCardNo.substring(BIRTHDAY_CODE_START, BIRTHDAY_CODE_END);
	    try {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	      sdf.setLenient(false);
	      return sdf.parse(birthday) != null;
	    } catch (Exception ex) {
	      return false;
	    }
	  }
	}
