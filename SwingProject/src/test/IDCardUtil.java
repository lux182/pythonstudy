package test;

import java.text.SimpleDateFormat;

public final class IDCardUtil {

	  /**
	   * ����
	   */
	  private static int[] MASK = {
	      7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1
	  };

	  /**
	   * ��֤��
	   */
	  private static final char[] VERIFY = {
	      '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'
	  };

	  /**
	   * ���ų���
	   */
	  private static final int CARD_NO_LENGTH = 18;

	  /**
	   * ��֤��λ��
	   */
	  private static final int VERIFY_CODE_INDEX = CARD_NO_LENGTH - 1;

	  /**
	   * �����볤��
	   */
	  private static final int BIRTHDAY_CODE_LENGTH = 8;

	  /**
	   * �����뿪ʼλ��
	   */
	  private static final int BIRTHDAY_CODE_START = 6;

	  /**
	   * ���������λ��
	   */
	  private static final int BIRTHDAY_CODE_END = BIRTHDAY_CODE_START
	      + BIRTHDAY_CODE_LENGTH;

	  /**
	   * ����Ҫʵ������
	   */
	  private IDCardUtil() {
	  }

	  /**
	   * ��֤�Ƿ��ǺϷ������֤���롣
	   * 
	   * @param idCardNo
	   *          ���֤����
	   * @return ���֤�����Ƿ�Ϸ�
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
	   * �������֤ǰ17λ���֣������18λ��֤�롣
	   * 
	   * @param idCardNo
	   *          ���֤���루���ٰ���ǰ17λ���֣�
	   * @return ��18λ��֤��
	   */
	  public static final char getVerifyCode(String idCardNo) {
	    int sum = 0;
	    for (int i = 0; i < VERIFY_CODE_INDEX; i++) {
	      sum += MASK[i] * (idCardNo.charAt(i) - '0');
	    }
	    return VERIFY[sum % VERIFY.length];
	  }

	  /**
	   * ��֤���֤�����մ����Ƿ���ȷ��
	   * 
	   * @param idCardNo
	   *          ���֤����
	   * @return ���֤�����մ����Ƿ���ȷ
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
