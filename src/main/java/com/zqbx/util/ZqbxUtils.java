package com.zqbx.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 */
public class ZqbxUtils {
	static public String STRING_NULL = "-";
	public final static String EQ = "="; // 等于
	public final static String BG = ">"; // 大于
	public final static String BQ = ">="; // 大于等于
	public final static String LE = "<"; // 小于
	public final static String LQ = "<="; // 小于等于
	public final static String NQ = "!="; // 不等于
	public final static String DQ = "=="; // 双等于
	public final static String IN = "in";
	public final static String LIKE = "like";

	/**
	 * 匹配中文正的字符串
	 */
	public static final String REGX_CHINESE = "^[\u4e00-\u9fa5]+$";
	/**
	 * 匹配由汉字、数字和26个英文字母组成的字符串
	 */
	public static final String REGX_LETTER_NUMBER = "^[\u4e00-\u9fa5A-Za-z0-9]+$";
	/**
	 * 匹配有26个英文字母组成的字符串
	 */
	public static final String REGX_LETTER = "^[A-Za-z]+$";
	/**
	 * 匹配非负整数（正整数 + 0)
	 */
	public static final String REGX_NON_NEGATIVE_INTEGERS = "^\\d+$";
	/**
	 * 匹配负浮点数
	 */
	public static final String REGX_NEGATIVE_RATIONAL_NUMBERS = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";
	/**
	 * 匹配电话号码
	 */
	public static final String REGX_PHONENUM = "([0-9]*[-][0-9]*)|[0-9]*";
	/**
	 * 匹配手机号码，支持+86和86开头
	 */
	public static final String REGX_MOBILENUM = "^((\\+86)|(86))?(13|15|17|18)\\d{9}$";
	/**
	 * 匹配日期时间
	 */
	public static final String REGX_DATETIME = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|"
			+ // 年
			"(1[02]))[\\-\\/\\s]?((0?[1-9])|"
			+ // 月
			"([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|"
			+ // 日
			"([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|"
			+ "([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|"
			+ "(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))"
			+
			// 时分秒
			"(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\:([0-5]?[0-9])))))";

	/**
	 * 匹配时间
	 */
	public static final String REGX_TIME = "((((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\:([0-5]?[0-9])))))";

	/**
	 * 匹配年月
	 */
	public static final String REGX_YEARDATE = "^([1-2]\\d{3})[\\-](0?[1-9]|10|11|12)";

	/**
	 * 匹配年
	 */
	public static final String REGX_YEAR = "^([1-2]\\d{3})";

	/**
	 * 手机号和座机号一起验证（包括区号、“-”、座机号）
	 */
	public static final String REGX_CALL = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$|^((\\+86)|(86))?(0[0-9]|13|15|17|18)\\d{9}$";
	/**
	 * 匹配电话号码（带“-”，带区号，带分机号）
	 */
	public static final String REGX_PHONENUM_1 = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$";

	/***
	 * 手机号和座机号一起验证
	 * 
	 * @param inputStr
	 * @return
	 */
	public static Boolean isCall(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_CALL);
		}
		return false;
	}

	/**
	 * 匹配电话号码（带“-”，带区号，带分机号）
	 * 
	 * @param inputStr
	 * @return
	 */
	public static Boolean isLocationNumber_1(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_PHONENUM_1);
		}
		return false;
	}

	/**
	 * 
	 * 匹配时间格式
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午11:18:51
	 */
	public static Boolean isTimeFormat(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_TIME);
		}
		return false;
	}

	/**
	 * 
	 * 匹配年月格式
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午11:19:03
	 */
	public static Boolean isYearDateFormat(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_YEARDATE);
		}
		return false;
	}

	/**
	 * 
	 * 匹配年格式
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午11:19:03
	 */
	public static Boolean isYearFormat(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_YEAR);
		}
		return false;
	}

	/**
	 * 
	 * 匹配是否为日期时间的格式
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午10:53:38
	 */
	public static Boolean isDateTimeFormat(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_DATETIME);
		}
		return false;
	}

	/**
	 * 是否非法字符校验此方法只限制中、英、数字的输入，如果是中、英和数字任意组合将返回true
	 * 例如：宅急送、宅急送123、ABD宅急送123、123、ABC 都将返回true
	 * 
	 * @since 1.0
	 * @author admin
	 * @time 2010-9-19 下午03:10:04
	 */
	public static Boolean isEngChineseNum(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_LETTER_NUMBER);
		}
		return false;
	}

	/**
	 * @Title: isLetter
	 * @Description: 匹配是否由26个英文字符组成的字符串
	 * @param inputStr
	 * @return Boolean
	 * @Date: 2014-12-10 上午11:24:20
	 */
	public static Boolean isLetter(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_LETTER);
		}
		return false;
	}

	/**
	 * 
	 * 匹配电话号码（除了数字之外可以含有一个‘-’）
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午09:23:28
	 */
	public static Boolean isLocationNumber(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_PHONENUM);
		}
		return false;
	}

	/**
	 * 
	 * 匹配手机号码（先支持13，15，17，18开头的手机号码）
	 * <p>
	 * <b>参数说明</b>
	 * 
	 * @param inputStr
	 * @return <p>
	 * @since 1.0
	 * @author admin
	 * @time 2010-11-18 上午09:23:28
	 */
	public static Boolean isMobileNumber(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_MOBILENUM);
		}
		return false;
	}

	/**
	 * 是否数字 如果是数字将返回true
	 * 
	 * @since 1.0
	 * @author admin
	 * @time 2010-9-19 下午03:31:49
	 */
	public static Boolean isNumber(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_NON_NEGATIVE_INTEGERS);
		}
		return false;
	}

	/**
	 * 是否是汉字 如果是汉字将返回true
	 * 
	 * @since 1.0
	 * @author admin
	 * @time 2010-9-19 下午03:31:49
	 */
	public static Boolean isChinese(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_CHINESE);
		}
		return false;
	}

	/**
	 * 是否是负数 包含浮点数，如果是浮点数将返回true，例如：-125.00或-125 都将返回true
	 * 
	 * @since 1.0
	 * @author admin
	 * @time 2010-9-19 下午03:31:49
	 */
	public static Boolean isNegative(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			return inputStr.matches(REGX_NEGATIVE_RATIONAL_NUMBERS);
		}
		return false;
	}

	/**
	 * 
	 * 全角转半角方法
	 * 
	 * @author admin
	 * @time 2010-9-19 下午03:24:21
	 */
	public static String sbcTodbcChange(String inputStr) {
		if (!ZqbxUtils.isNull(inputStr)) {
			StringBuffer outBuffer = new StringBuffer();
			String tempStr = null;
			byte[] b = null;

			for (int i = 0; i < inputStr.length(); i++) {
				try {
					tempStr = inputStr.substring(i, i + 1);
					b = tempStr.getBytes("unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				if (b[2] == -1) {
					b[3] = (byte) (b[3] + 32);
					b[2] = 0;

					try {
						outBuffer.append(new String(b, "unicode"));
					} catch (java.io.UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				} else {
					outBuffer.append(tempStr);
				}
			}
			return outBuffer.toString();
		}
		return null;
	}

	/**
	 * 如果传入参数为null则返回空格
	 * 
	 * @param value
	 * @return " "
	 */
	public static String getString_TrimZeroLenNotAsNull(Object value) {
		if (value == null || value.toString().trim().length() == 0) {
			return " ";
		}
		return value.toString();
	}

	/**
	 * 判断一个或多个对象是否为空
	 * 
	 * @param values
	 *            可变参数，要判断的一个或多个对象
	 * @return 只有要判断的一个对象都为空则返回true,否则返回false
	 */
	public static boolean isNull(Object... values) {
		if (!ZqbxUtils.isNotNullAndNotEmpty(values)) {
			return true;
		}
		for (Object value : values) {
			boolean flag = false;
			if (value instanceof Object[]) {
				flag = !isNotNullAndNotEmpty((Object[]) value);
			} else if (value instanceof Collection<?>) {
				flag = !isNotNullAndNotEmpty((Collection<?>) value);
			} else if (value instanceof String) {
				flag = isOEmptyOrNull(value);
			} else {
				flag = (null == value);
			}
			if (flag) {
				return true;
			}
		}
		return false;
	}

	public static boolean isOEmptyOrNull(Object o) {
		return o == null ? true : isSEmptyOrNull(o.toString());
	}

	public static boolean isSEmptyOrNull(String s) {
		return trimAndNullAsEmpty(s).length() <= 0 ? true : false;
	}

	public static String trimAndNullAsEmpty(String s) {
		if (s != null && !s.trim().equals(STRING_NULL)) {
			return s.trim();
		} else {
			return "";
		}
		// return s == null ? "" : s.trim();
	}

	/**
	 * 判断对象数组是否为空并且数量大于0
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndNotEmpty(Object[] value) {
		boolean bl = false;
		if (null != value && 0 < value.length) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象集合（List,Set）是否为空并且数量大于0
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndNotEmpty(Collection<?> value) {
		boolean bl = false;
		if (null != value && 0 < value.size()) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象数组是否为空并且数量大于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndBiggerSize(Object[] value, int size) {
		boolean bl = false;
		if (null != value && size < value.length) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象集合（List,Set）是否为空并且数量大于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndBiggerSize(Collection<?> value, int size) {
		boolean bl = false;
		if (null != value && size < value.size()) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象数组是否为空并且数量等于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndEqualSize(Object[] value, int size) {
		boolean bl = false;
		if (null != value && size == value.length) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象集合（List,Set）是否为空并且数量等于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndEqualSize(Collection<?> value, int size) {
		boolean bl = false;
		if (null != value && size == value.size()) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象数组是否为空并且数量小于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndSmallerSize(Object[] value, int size) {
		boolean bl = false;
		if (null != value && size > value.length) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象集合（List,Set）是否为空并且数量小于size值
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndSmallerSize(Collection<?> value, int size) {
		boolean bl = false;
		if (null != value && size > value.size()) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 处理空字符串
	 */
	public static String nullProcessing(Object obj) {
		if (isNull(obj)) {
			return "";
		} else {
			return obj.toString();
		}
	}

	public static void main(String[] args) {
		boolean o = ZqbxUtils.isMobileNumber("13578484458");
		System.out.println(o);
	}

	public static String convertCharset(String srcCharSet,
			String targetCharSet, String str) {
		String res = str;
		try {
			if ((srcCharSet.equals("GBK") || srcCharSet.equals("GB18030"))
					&& targetCharSet.equals("UTF-8")) {
				String iso = new String(str.getBytes("UTF-8"), "ISO-8859-1");
				res = new String(iso.getBytes("ISO-8859-1"), "UTF-8");
			} else {
				res = new String(str.getBytes(srcCharSet), targetCharSet);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	/**
	 * 
	 * @Title: stringToList
	 * @Description: String 转换成list
	 * @param values
	 *            list
	 * @Author admin
	 * @Date 2014-9-17 下午5:17:24
	 */
	public List<String> stringToList(String values) {
		List<String> orderCodelist = null;
		if (!ZqbxUtils.isNull(values)) {
			String SEP = ",";
			orderCodelist = new ArrayList<String>();
			String[] orderCode = values.split(SEP);
			for (String order : orderCode) {
				orderCodelist.add(order);
			}
		}
		return orderCodelist;
	}
	
	/**
	 * 这样返回的要是一个字符串,而不是StringBuffer,这样适用性范围更广,更灵活.
	 * 同时StringBuffer效率低于StringBuilder由于处于方法局部,不存在线程安全问题!
	 * 
	 * @param queueList
	 * @return
	 */
	public static String getStringByList(List<?> queueList) {
		StringBuilder condition = new StringBuilder();
		for (int i = 0; i < queueList.size(); i++) {
			if (i > 0) {
				condition.append(",");
			}
			condition.append(queueList.get(i));
		}
		return condition.toString();
	}
	/**
	 * 将字符串解析为Map结构
	 * @param param
	 * @param map
	 */
	public static void parseParamToMap(String param, Map<String, String> map) {
		BufferedReader br = new BufferedReader(new StringReader(param));
		String str = null;
		try {
			while ((str = br.readLine()) != null) {
				String[] kv = str.split("=");
				if (kv.length > 1) {
					map.put(kv[0], kv[1]);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

/*	@SuppressWarnings("rawtypes")
	public static Map<String, Object> parseJsonToMap(Object object) {  
		Map<String, Object> data = new HashMap<String, Object>();  
	    // 将json字符串转换成jsonObject  
	    JSONObject jsonObject = JSONObject.fromObject(object);  
	    Iterator it = jsonObject.keys();  
	    // 遍历jsonObject数据，添加到Map对象  
	    while (it.hasNext()) {  
	        String key = String.valueOf(it.next());  
	        Object value = jsonObject.get(key);  
	        data.put(key, value);  
	    }  
	    return data;  
	} */ 
}
