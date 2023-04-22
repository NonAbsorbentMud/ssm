package own.cfb.utils;

import sun.misc.Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式：
 * 1、横向模糊匹配
 * {m , n}  ：表示连续出现最少 m 次，最多 n 次
 * {m , }   ：表示至少出现m次
 * {m}      ：表示出现m次
 * ？  　　  ：等价于{0，1} 表示出现或不出现
 * +        ：等价于{1，} 表示至少出现1次
 * *        ：等价于{0，} 表示出现任意次，可以不出现
 * 2、常用简写形式
 * \d  :表示[0-9]，表示一位数字
 * \D  :表示[^0-9]，表示除数字外的任意字符
 * \w  :表示[0-9a-zA-Z_]，表示数字、大小写字母和下划线
 * \W  :表示[^0-9a-zA-Z_]，非单词字符
 * \b  :表示匹配一个单词边界，也就是指单词和空格间的位置。例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中的“er”
 * \B  :匹配非单词边界。“er\B”能匹配“verb”中的“er”，但不能匹配“never”中的“er”。
 * \s  :匹配任何空白字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。
 * \S  :匹配任何非空白字符。等价于[^ \f\n\r\t\v]。
 */
public class RegexpUtil {
    //电子邮箱正则：^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
    private static final String EmailRegexp="^\\w+@[\\da-z\\.-]+\\.([a-z]{2,6}|[\\u2E80-\\u9FFF]{2,3})$";
    //手机号正则：^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$
    private static final String PhoneRegexp="^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
    //座机正则：^(0\d{2,3})-?(\d{7,8})$
    private static final String StudioCameraRegexp="^(0\\d{2,3})-?(\\d{7,8})$";
    /**
     * 身份证正则：
     * 普通校验：(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)
     * 精准校验：
     *      18位：^[1-9]\d{5}(19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$
     *      15位：^[1-9]\d{5}\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$
     *      后6位：^(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$
     */
    private static final String IdCardRegexp="(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
    //中文正则：/^[\u4e00-\u9fa5]+$/
    private static final String ChineseRegexp="^[\\u4e00-\\u9fa5]+$";
    //QQ号码正则：^[1-9][0-9]\d{4,9}$
    private static final String QQCodeRegexp="^[1-9][0-9]\\d{4,9}$";
    //邮政编码正则：^[1-9]\d{5}$
    private static final String PostalcodeRegexp="^[1-9]\\d{5}$";
    //全数字正则：^[0-9]+$
    private static final String NumberRegexp="^[0-9]+$";

    public static void main(String[] args){
        boolean flag=RegexpUtil.checkNumber("2");
        System.out.println("校验结果："+flag);
    }

    public static boolean checkRegexp(String str,String regexp){
        boolean flag=true;
        Pattern pattern=Pattern.compile(regexp);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkNumber(String number){
        return checkRegexp(number,NumberRegexp);
    }
    /**
     * 邮箱账号格式都符合“名称@域名”的规律：
     * 1、只允许英文字母、数字、下划线、英文句号、以及中划线组成
     * 邮件名称部分：
     *      26个大小写英文字母表示为a-zA-Z；
     *      数字表示为0-9；
     *      下划线表示为_
     *      中划线表示为-
     *      由于名称是由若干个字母、数字、下划线和中划线组成，所以需要用到+表示多次出现。
     *      根据以上条件得出邮件名称表达式：[a-zA-Z0-9_-]+
     *
     * 域名部分：
     *      一般域名的规律为“[N级域名][三级域名.]二级域名.顶级域名”，比如“qq.com”、“www.qq.com”、“mp.weixin.qq.com”、
     *      “12-34.com.cn”，分析可得域名类似“** .** .** .**”组成。
     *      “**”部分可以表示为[a-zA-Z0-9_-]+
     *      “.**”部分可以表示为\.[a-zA-Z0-9_-]+
     *      多个“.**”可以表示为(\.[a-zA-Z0-9_-]+)+
     *      综上所述，域名部分可以表示为[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+
     * 最终表达式：
     *      由于邮箱的基本格式为“名称@域名”，需要使用“^”匹配邮箱的开始部分，
     *      用“$”匹配邮箱结束部分以保证邮箱前后不能有其他字符，所以最终邮箱的正则表达式为：
     *      ^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
     * 2、名称允许汉字、字母、数字，域名只允许英文域名
     * 邮件名称部分：
     *      汉字在正则表示为[\u4e00-\u9fa5]
     *      字母和数字表示为A-Za-z0-9
     *      通过分析得出邮件名称部分表达式为[A-Za-z0-9\u4e00-\u9fa5]+
     * 邮件域名部分表达式为[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+
     * 最终表达式：
     *      用@符号将邮箱的名称和域名拼接起来，因此完整的邮箱表达式为
     *      ^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        return checkRegexp(email,EmailRegexp);
    }

    /**
     * 各大运营商手机号码段（新）
     * 中国电信号段
     *      133、153、173、177、180、181、189、190、191、193、199
     * 中国联通号段
     *      130、131、132、145、155、156、166、167、171、175、176、185、186、196
     * 中国移动号段
     *      134(0-8)、135、136、137、138、139、1440、147、148、150、151、152、157、158、159、172、
     *      178、182、183、184、187、188、195、197、198
     * 中国广电号段
     *      192
     * 其他号段
     *      14号段部分为上网卡专属号段：中国联通145，中国移动147，中国电信149
     * 虚拟运营商：
     *      电信：1700、1701、1702、162
     *      移动：1703、1705、1706、165
     *      联通：1704、1707、1708、1709、171、167
     *      卫星通信：1349、174
     *      物联网：140、141、144、146、148
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone){
        return checkRegexp(phone,PhoneRegexp);
    }

    public static boolean checkIdCard(String idCard){
        return checkRegexp(idCard,IdCardRegexp);
    }

    public static boolean checkQQCode(String QQCode){
        return checkRegexp(QQCode,QQCodeRegexp);
    }

    public static boolean checkStudioCamera(String studioCamera){
        return checkRegexp(studioCamera,StudioCameraRegexp);
    }

    public static boolean checkPostalcode(String postalcode){
        return checkRegexp(postalcode,PostalcodeRegexp);
    }
}
