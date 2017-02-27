package com.suirenshi.mymvpdemo.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 *
 */
public class StringUtils {
    private static final String TAG = "StringUtils";

   static DecimalFormat df = new DecimalFormat("####0.00");

    static DecimalFormat onPointdf = new DecimalFormat("####0.0");

    /** 空字符串。 */
    public static final String EMPTY_STRING = "";

    /**
     * 判断字符串是否只包含unicode数字。
     * 
     * <p>
     * <code>null</code>将返回<code>false</code>，空字符串<code>""</code>将返回<code>true</code>。
     * </p>
     * <pre>
     * StringUtils.isNumeric(null)   = false
     * StringUtils.isNumeric("")     = true
     * StringUtils.isNumeric("  ")   = false
     * StringUtils.isNumeric("123")  = true
     * StringUtils.isNumeric("12 3") = false
     * StringUtils.isNumeric("ab2c") = false
     * StringUtils.isNumeric("12-3") = false
     * StringUtils.isNumeric("12.3") = false
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果字符串非<code>null</code>并且全由unicode数字组成，则返回<code>true</code>
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        int length = str.length();

        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符串是否不是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * <pre>
     * StringUtil.isBlank(null)      = false
     * StringUtil.isBlank("")        = false
     * StringUtil.isBlank(" ")       = false
     * StringUtil.isBlank("bob")     = true
     * StringUtil.isBlank("  bob  ") = true
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    /**
     * 检查字符串是否不是<code>null</code>和空字符串<code>""</code>。
     * <pre>
     * StringUtil.isEmpty(null)      = false
     * StringUtil.isEmpty("")        = false
     * StringUtil.isEmpty(" ")       = true
     * StringUtil.isEmpty("bob")     = true
     * StringUtil.isEmpty("  bob  ") = true
     * </pre>
     *
     * @param str 要检查的字符串
     *
     * @return 如果不为空, 则返回<code>true</code>
     */
    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    /* ============================================================================ */
    /*  默认值函数。                                                                */
    /*                                                                              */
    /*  当字符串为null、empty或blank时，将字符串转换成指定的默认字符串。            */
    /* ============================================================================ */

    /**
     * 如果字符串是<code>null</code>，则返回空字符串<code>""</code>，否则返回字符串本身。
     * <pre>
     * StringUtil.defaultIfNull(null)  = ""
     * StringUtil.defaultIfNull("")    = ""
     * StringUtil.defaultIfNull("  ")  = "  "
     * StringUtil.defaultIfNull("bat") = "bat"
     * </pre>
     *
     * @param str 要转换的字符串
     *
     * @return 字符串本身或空字符串<code>""</code>
     */
    public static String defaultIfNull(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    /**
     * 如果字符串是<code>null</code>，则返回指定默认字符串，否则返回字符串本身。
     * <pre>
     * StringUtil.defaultIfNull(null, "default")  = "default"
     * StringUtil.defaultIfNull("", "default")    = ""
     * StringUtil.defaultIfNull("  ", "default")  = "  "
     * StringUtil.defaultIfNull("bat", "default") = "bat"
     * </pre>
     *
     * @param str 要转换的字符串
     * @param defaultStr 默认字符串
     *
     * @return 字符串本身或指定的默认字符串
     */
    public static String defaultIfNull(String str, String defaultStr) {
        return (str == null) ? defaultStr : str;
    }

    /**
     * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回空字符串<code>""</code>，否则返回字符串本身。
     * 
     * <p>
     * 此方法实际上和<code>defaultIfNull(String)</code>等效。
     * <pre>
     * StringUtil.defaultIfEmpty(null)  = ""
     * StringUtil.defaultIfEmpty("")    = ""
     * StringUtil.defaultIfEmpty("  ")  = "  "
     * StringUtil.defaultIfEmpty("bat") = "bat"
     * </pre>
     * </p>
     *
     * @param str 要转换的字符串
     *
     * @return 字符串本身或空字符串<code>""</code>
     */
    public static String defaultIfEmpty(String str) {
        return ((str == null) || (str.length() == 0)) ? EMPTY_STRING : str;
    }

    /**
     * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回指定默认字符串，否则返回字符串本身。
     * <pre>
     * StringUtil.defaultIfEmpty(null, "default")  = "default"
     * StringUtil.defaultIfEmpty("", "default")    = "default"
     * StringUtil.defaultIfEmpty("  ", "default")  = "  "
     * StringUtil.defaultIfEmpty("bat", "default") = "bat"
     * </pre>
     *
     * @param str 要转换的字符串
     * @param defaultStr 默认字符串
     *
     * @return 字符串本身或指定的默认字符串
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        return ((str == null) || (str.length() == 0)) ? defaultStr : str;
    }

    /**
     * 如果字符串是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符，则返回空字符串<code>""</code>，否则返回字符串本身。
     * <pre>
     * StringUtil.defaultIfBlank(null)  = ""
     * StringUtil.defaultIfBlank("")    = ""
     * StringUtil.defaultIfBlank("  ")  = ""
     * StringUtil.defaultIfBlank("bat") = "bat"
     * </pre>
     *
     * @param str 要转换的字符串
     *
     * @return 字符串本身或空字符串<code>""</code>
     */
    public static String defaultIfBlank(String str) {
        return isBlank(str) ? EMPTY_STRING : str;
    }

    /**
     * 如果字符串是<code>null</code>或空字符串<code>""</code>，则返回指定默认字符串，否则返回字符串本身。
     * <pre>
     * StringUtil.defaultIfBlank(null, "default")  = "default"
     * StringUtil.defaultIfBlank("", "default")    = "default"
     * StringUtil.defaultIfBlank("  ", "default")  = "default"
     * StringUtil.defaultIfBlank("bat", "default") = "bat"
     * </pre>
     *
     * @param str 要转换的字符串
     * @param defaultStr 默认字符串
     *
     * @return 字符串本身或指定的默认字符串
     */
    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    public static String defaultTrim(String str) {
        if (isNotBlank(str)) {
            if ("null".equals(str)) {
                return EMPTY_STRING;
            } else {
                return "" + str;
            }
        } else {
            return EMPTY_STRING;
        }
    }

    public static String html2Text(String str) {
        Pattern p_script, p_style, p_html; //定义规则
        Matcher m_script, m_style, m_html; //匹配规则
        //正则表达式
        try {
            //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";

            //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";

            //定义HTML标签的正则表达式
            String regEx_html = "<[^>]+>";

            //过滤script标签
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(str);
            str = m_script.replaceAll("");

            //过滤style标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(str);
            str = m_style.replaceAll("");

            //过滤html标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(str);
            str = m_html.replaceAll("");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("过滤HTML标签出错");
            return null;
        }
    }



    // 保留2位小数
    public static double keepTwoPonit(double f) {
        return (double) (Math.round(f * 100) / 100.00);
    }



    /**
     *
     * 保留两位小数的方法
     * @Params： 传递的double类型参数
     *
     * @Return： 返回的String类型的数据
     *
     * */
    public static String keepAboutPoint(double f){
        return df.format(f);
    }



    /**
     *
     * 保留两位小数的方法
     * @Params： 传递的double类型参数
     *
     * @Return： 返回的String类型的数据
     *
     * */
    public static String keepAboutPoint(String f){
        if(!"".equals(f)){
            return df.format(Double.valueOf(f));
        }else{
            return "0.00";
        }

    }

    /**
     *
     * 保留两位小数的方法
     * @Params： 传递的double类型参数
     *
     * @Return： 返回的String类型的数据
     *
     * */
    public static String keepOnePoint(String f){
        if(!"".equals(f)){
            return onPointdf .format(Double.valueOf(f));
        }else{
            return "0.0";
        }

    }


    /**
     *
     * 保留两位小数的方法
     * @Params： 传递的double类型参数
     *
     * @Return： 返回的String类型的数据
     *
     * */
    public static double keepAboutDoublePoint(double f){
        return Double.valueOf(df.format(f));
    }




    /**
     *
     * 2016-01-01 替换成20160101
     *
     * */
    public static String replace(String data) {
        return data.replace("-", "");

    }



    /**
     * 空格
     * @Params num 传递的空格数量
     * @Return 返回的一定数量的空格字符串
     *
     * */
    public static String blankSpace(int num){
        String str="";
        for(int i=0;i<num;i++){
            str+=" ";
        }
        return str;
    }




    /**
    * 测试IP地址是否合法
     * @Params ipAddress
     * @Return true:合法
     *         false：不合法
    *
    * */
    public static boolean isIp(String ipAddress){
//        String test = "([1-9]|[1-9]//d|1//d{2}|2[0-1]//d|22[0-3])(//.(//d|[1-9]//d|1//d{2}|2[0-4]//d|25[0-5])){3}";
//        Pattern pattern = Pattern.compile(test);
//        Matcher matcher = pattern.matcher(ipAddress);
//        return matcher.matches();

        if(ipAddress.length() < 7 || ipAddress.length() > 15 || "".equals(ipAddress))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(ipAddress);

        boolean  flag= mat.find();

        return flag;
    }



//    /**
//     *
//     * @TODO 校验IP+端口号是否有效 可用端口号（1024-65536）
//     *
//     * */
//    public static boolean MatcherIP(String ip) {
//        Pattern pattern = Pattern.compile("^((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
//                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
//                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
//                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
//                + ":((102[4-9])|(10[3-9]\\d)|([1-5]\\d{3,4})|(6[0-4]\\d{3})|(65[0-4]\\d{2})|(655[0-2]\\d)|(6553[0-5]))$");
//
//        Matcher matcher = pattern.matcher(ip);
//        return matcher.matches();
//    }


    /**
     *
     * @TODO 校验IP+端口号是否有效 可用端口号（1024-65536）
     * 192.168.154.555:65536
     *
     * */
    public static boolean MatcherIP(String ipAddress) {
        Pattern pattern = Pattern.compile("^((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + ":((102[4-9])|(10[3-9]\\d)|([1-5]\\d{3,4})|(6[0-4]\\d{3})|(65[0-4]\\d{2})|(655[0-2]\\d)|(6553[0-5]))$");

        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();


//        if(ipAddress.length() < 7 || ipAddress.length() > 21 || "".equals(ipAddress))
//        {
//            return false;
//        }
//        /**
//         * 判断IP格式和范围
//         */
//        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"+":[1024-65536]";
//
//        Pattern pat = Pattern.compile(rexp);
//
//        Matcher mat = pat.matcher(ipAddress);
//
//        boolean  flag= mat.find();
//
//        return flag;


    }



    /**
     * 空格
     * @Params num 传递的空格数量
     * @Return 返回的一定数量的空格字符串
     *
     * */
    public static boolean ListNotNull(List mList){
        if(null!=mList&&mList.size()>0){
           return true;
        }else {
            return false;
        }
    }


    public static int getUUID(String name) {
        SecureRandom srA = null;
        try {
            srA = SecureRandom.getInstance("SHA1PRNG");
            srA.setSeed(name.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new Integer(srA.nextInt());
    }





    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    public static String center(String str, int size, char padChar) {
        if(str != null && size > 0) {
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else {
                str = leftPad(str, strLen + pads / 2, padChar);
                str = rightPad(str, size, padChar);
                return str;
            }
        } else {
            return str;
        }
    }

    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    public static String leftPad(String str, int size, char padChar) {
        if(str == null) {
            return null;
        } else {
            int pads = size - str.length();
            return pads <= 0?str:(pads > 8192?leftPad(str, size, String.valueOf(padChar)):padding(pads, padChar).concat(str));
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        if(str == null) {
            return null;
        } else {
            if(isEmpty(padStr)) {
                padStr = " ";
            }

            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else if(padLen == 1 && pads <= 8192) {
                return leftPad(str, size, padStr.charAt(0));
            } else if(pads == padLen) {
                return padStr.concat(str);
            } else if(pads < padLen) {
                return padStr.substring(0, pads).concat(str);
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for(int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }

                return (new String(padding)).concat(str);
            }
        }
    }




    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    public static String rightPad(String str, int size, char padChar) {
        if(str == null) {
            return null;
        } else {
            int pads = size - str.length();
            return pads <= 0?str:(pads > 8192?rightPad(str, size, String.valueOf(padChar)):str.concat(padding(pads, padChar)));
        }
    }

    public static String rightPad(String str, int size, String padStr) {
        if(str == null) {
            return null;
        } else {
            if(isEmpty(padStr)) {
                padStr = " ";
            }

            int padLen = padStr.length();
            int strLen = str.length();
            int pads = size - strLen;
            if(pads <= 0) {
                return str;
            } else if(padLen == 1 && pads <= 8192) {
                return rightPad(str, size, padStr.charAt(0));
            } else if(pads == padLen) {
                return str.concat(padStr);
            } else if(pads < padLen) {
                return str.concat(padStr.substring(0, pads));
            } else {
                char[] padding = new char[pads];
                char[] padChars = padStr.toCharArray();

                for(int i = 0; i < pads; ++i) {
                    padding[i] = padChars[i % padLen];
                }

                return str.concat(new String(padding));
            }
        }
    }



    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if(repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        } else {
            char[] buf = new char[repeat];

            for(int i = 0; i < buf.length; ++i) {
                buf[i] = padChar;
            }

            return new String(buf);
        }
    }




    /**
     * @Params str 连续打印的字符
     * @Params size 打印的长度
     *
     * return 返回持续长度的字符串
     *
     *
     *
     *
     * **/
    public  static String createAutoString(String str,int size)  {
        String aboutString="";
        for(int i=0;i<size;i++){
            aboutString=aboutString+str;
        }
        return aboutString;
    }


    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params str 传入的需要处理的字符串
     * @Params intType 传入的需要保留的位数
     * @Params 处理后的字符串
     *
     * */
    public static String roundOnPoint(String str,int intType){
        DecimalFormat df_roundOnPoint = null;
        if(1==intType){
            //保留1为小数
            df_roundOnPoint= new DecimalFormat("####0.0");
        }else if(2==intType){
            //保留两位小数
            df_roundOnPoint= new DecimalFormat("####0.00");
        }
       return df_roundOnPoint.format(Double.valueOf(str));
    }

    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
     * @Params intType 传入的需要保留的位数
     * @Params 处理后的字符串
     *
     * */
    public static String roundOnPoint(double dou,int intType){
        DecimalFormat df_roundOnPoint = null;
        if(1==intType){
            //保留1为小数
            df_roundOnPoint= new DecimalFormat("####0.0");
        }else if(2==intType){
            //保留两位小数
            df_roundOnPoint= new DecimalFormat("####0.00");
        }
        return df_roundOnPoint.format(dou);

    }



    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
     * @Params intType 传入的需要保留的位数
     * @Params 处理后的字符串
     *
     * */
    public static double OnPoint(double dou,int intType){
        DecimalFormat df_roundOnPoint = null;
        if(1==intType){
            //保留1为小数
            df_roundOnPoint= new DecimalFormat("####0.0");
        }else if(2==intType){
            //保留两位小数
            df_roundOnPoint= new DecimalFormat("####0.00");
        }

        return Double.valueOf(df_roundOnPoint.format(dou));

    }


    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
     * @Params intType 传入的需要保留的位数
     * @Params 处理后的字符串
     *
     * */
    public static String makePoint(Double dou,int intType){
        DecimalFormat df_roundOnPoint = null;
        if(1==intType){
            //保留1为小数
            df_roundOnPoint= new DecimalFormat("####0.0");
        }else if(2==intType){
            //保留两位小数
            df_roundOnPoint= new DecimalFormat("####0.00");
        }

        Math.floor(dou);
        return df_roundOnPoint.format(dou);

    }


    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
//     * @Params intType 传入的需要保留的位数
     * @Params 返回一个传入数的小数部分
     *
     * */
    public static double makePoint(double dou){
        return dou- Math.floor(dou);
    }


    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
    //     * @Params intType 传入的需要保留的位数
     * @Params 返回一个传入数的小数部分
     *
     * */
    public static String makePoint(String str){
        return df.format(Double.valueOf(str)- Math.floor((Double.valueOf(str))));
    }


    /**
     *@TODO: 该方法主要是处理保留小数位的方法
     * @Params dou 传入的需要处理的Double数据
     * @Params intType 传入的需要保留的位数
     * @Params 处理后的字符串
     *
     * */
//    public static String roundOnPoint(Double dou,int intType){
//        DecimalFormat df_roundOnPoint = null;
//        if(1==intType){
//            //保留1为小数
//            df_roundOnPoint= new DecimalFormat("####0.0");
//        }else if(2==intType){
//            //保留两位小数
//            df_roundOnPoint= new DecimalFormat("####0.00");
//        }
//        return df_roundOnPoint.format(dou);
//
//    }




    /**
     * 字符型数字转化成double类型：保留两位小数
     *
     * @param str
     * @return
     */
    public static double str2Digit(String str) {
        double digit = 0.00;
        if (!TextUtils.isEmpty(str)&&!".".equals(str)&&!str.substring(0,1).equals(".")) {
            str = keepAboutPoint(str);
            digit = Double.valueOf(str);
        }
        return digit;
    }


    /**
     * 字符型数字转化成double类型：保留两位小数
     *
     * @param str
     * @return
     */
    public static double strOneDigit(String str) {
        double digit = 0.0;
        if (!TextUtils.isEmpty(str)&&!".".equals(str)&&!str.substring(0,1).equals(".")) {
            str = keepOnePoint(str);
            digit = Double.valueOf(str);
        }
        return digit;
    }




    public static boolean isConventionStr(String str){
        if (!TextUtils.isEmpty(str)&&!".".equals(str)&&!str.substring(0,1).equals(".")) {
            return true;
        }else{
            return false;
        }

    }

    public static String ReturnConventStr(String str){
        if(StringUtils.isConventionStr(str)){
            return str;
        }else{
            return "0.00";
        }
    }


    public static String data2String(long times){
        Date createdate = new Date(times);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        return String.valueOf(formatter.format(createdate));
    }


    /**
     * @todo 如果当前字符串中小数点的后面还有两位 返回true,当前长度大于等于9则返回true
     * 否则返回 false；
     *
     * */
    public static boolean FilterString2Length(String str){
        boolean falg=false;
        if(StringUtils.isNotEmpty(str)){
            if(str.length()>=12){
                falg=true;
            }
            if(str.contains(".")){
                int index=str.indexOf(".");
                if(str.length()-1-index>=2){
                    falg=true;
                }
            }
        }
        return falg;
    }

    /**
     * @todo 如果当前字符串中小数点的后面还有两位 返回true,当前长度大于等于9则返回true
     * 否则返回 false；
     *
     * */
    public static boolean FilterString2LengthNotInput(EditText et){
        String str=et.getText().toString().trim();
        Editable ea = et.getText();
        boolean falg=false;
        if(StringUtils.isNotEmpty(str)){
            if(str.length()>=12){
                falg=true;
            }
            if(str.contains(".")){
                int index=str.indexOf(".");
                if(str.length()-1-index>=2&&et.getSelectionStart()==ea.length()){
                    falg=true;
                }
            }
        }
        return falg;
    }

    //if(i % 100 == 0)


    /**
     *
     * @todo: 判断当前EditText中的String是否有两位小数，
     * 小数点后有两位则 return false
     * 不够两位      return true
     * 这里是需要判断 "0.00的特殊情况"
     *
     *
     * */
    public static boolean Is2Input(EditText et){
        String str=et.getText().toString().trim();
        if(StringUtils.isNotEmpty(str)){
            if(str.equals("0.00")){
                return false;
            }else if(Double.valueOf(str)*10%1==0){
                //如果当前String 转化为double*100之后%100==0 代表当前已经是两位小数辣
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }


    /**
     * 字符型数字转化成double类型：保留1位小数
     *
     * @param str
     * @return
     */
    public static double strSmartOneDigit(String str) {
        double digit;
        str = ".".equals(str) ? "0" : str;
        str = TextUtils.isEmpty(str) ? "0" : str;
        str = formatSmartOne(str);
        digit = Double.valueOf(str);
        return digit;
    }

    /**
     * 字符型数字转化成double类型：保留1位小数
     *
     * @param str
     * @return
     */
    public static double strSmartOneDigit(double dou) {
        return formatSmartOne(dou);
    }

    /**
     * 使用BigDecimal，保留小数点后1位
     */
    public static String formatSmartOne(String value) {
        if (TextUtils.isEmpty(value))
            return "0.0";
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.toString();
    }
    /**
     * 使用BigDecimal，保留小数点后1位
     */
    public static double formatSmartOne(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }






    /**
     * 字符型数字转化成double类型：保留两位小数
     *
     * @param str
     * @return
     */
    public static double strSmartTwoDigit(String str) {
        double digit;
        str = ".".equals(str) ? "0" : str;
        str = TextUtils.isEmpty(str) ? "0" : str;
        str = formatSmartTwo(str);
        digit = Double.valueOf(str);
        return digit;
    }



    /**
     * 字符型数字转化成double类型：保留两位小数,并且返回类型为String
     *
     * @param str
     * @return
     */
    public static String strSmartTwoDigit2String(String str) {
        double digit;
        str = ".".equals(str) ? "0" : str;
        str = TextUtils.isEmpty(str) ? "0" : str;
        str = formatSmartTwo(str);
        digit = Double.valueOf(str);
        return formatSmartTwo(digit+"");
    }




    /**
     * 使用BigDecimal，保留小数点后两位 有两位小数 "11.5----------11.50"
     */
    public static String formatSmartTwo(String value) {
        if (TextUtils.isEmpty(value))
            return "0.00";
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }



    /**
     * 使用BigDecimal，保留小数点后2位   第二位小数没有0   11.5----------11.5
     */
    public static double formatSmartTwo(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    /**
     * 使用BigDecimal，保留小数点后2位  double------String 并且第二位小数有0补充11.5----------“11.50”
     */
    public static String formatSmartDig2Str(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }







}
