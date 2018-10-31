package com.tian.sort;

import com.sun.deploy.util.StringUtils;

/**
 * 达数相加
 */
public class LongAdd {
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        //用字符串表示大数
        String str1 = "1234597";
        String str2 = "1111";
        System.out.println(add(str1, str2));
    }


    static String bigNumberAdd(String a, String b) {
        String str = "";
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = (lenA > lenB) ? lenA : lenB;
        int minLen = (lenA < lenB) ? lenA : lenB;
        String strTmp = "";
        for (int i = maxLen - minLen; i > 0; i--) {
            strTmp += "0";
        }
        //把长度调整到相同
        if (maxLen == lenA) {
            b = strTmp + b;
        } else {
            a = strTmp + a;
        }
        //进位
        int jw = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int tempA = Integer.parseInt(String.valueOf(a.charAt(i)));
            int tempB = Integer.parseInt(String.valueOf(b.charAt(i)));
            int temp;
            if (tempA + tempB + jw >= 10 && i != 0) {
                temp = tempA + tempB + jw - 10;
                jw = 1;
            } else {
                temp = tempA + tempB + jw;
                jw = 0;
            }
            str = String.valueOf(temp) + str;
        }
        return str;
    }


    /**
     * 求超大整数的和
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String bigNumberSumBetter(String num1, String num2,char sign) {

        char sign1 = num1.charAt(0);
        char sign2 = num2.charAt(0);

        String number1;
        String number2;

        // 去符号位操作
        if (sign1 == '-' || sign1 == '+') {
            number1 = num1.substring(1);
        } else {
            sign1 = '+';
            number1 = num1;
        }
        // 去符号位操作
        if (sign2 == '-' || sign2 == '+') {
            number2 = num2.substring(1);
        } else {
            sign2 = '+';
            number2 = num2;
        }

        boolean isDig1 = number1.matches("[1-9][0-9]*");
        boolean isDig2 = number2.matches("[1-9][0-9]*");
        if (!isDig1 || !isDig2) {
            throw new NumberFormatException("输入的数据不是正确的格式的整数");
        }

        //两个数的长度
        int length1 = number1.length();
        int length2 = number2.length();
        int len = length1 >= length2 ? length1 + 1 : length2 + 1;

        StringBuffer number1Buffer = new StringBuffer();
        StringBuffer number2Buffer = new StringBuffer();
        //扩展数据的长度,使它们的长度一样
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                number2Buffer.append("0");
            }
        } else if (length1 < length2) {
            for (int i = 0; i < length2 - length1; i++) {
                number1Buffer.append("0");
            }
        }

        number1Buffer.append(number1);
        number2Buffer.append(number2);

        char[] chars1 = number1Buffer.reverse().toString().toCharArray();
        char[] chars2 = number2Buffer.reverse().toString().toCharArray();
        //存储每位相加的结果
        int[] result = new int[len];
        //同号相加
        if (sign1 == sign2) {
            sign = sign1;
            for (int i = 0; i < len - 1; i++) {
                result[i] = (chars1[i] - '0') + (chars2[i] - '0');
            }

            // 处理进位
            for (int i = 0; i < len; i++) {
                if (result[i] >= 10) {
                    result[i + 1] += result[i] / 10;
                    result[i] = result[i] % 10;
                }
            }
        } else {
            // 拿大的数减去小的数
            boolean lager = number1.compareTo(number2) > 0 ? true : false;
            if (lager) {
                sign = sign1;
                for (int i = 0; i < len - 1; i++) {
                    result[i] = (chars1[i] - '0') - (chars2[i] - '0');
                }
            } else {
                sign = sign2;
                for (int i = 0; i < len - 1; i++) {
                    result[i] = (chars2[i] - '0') - (chars1[i] - '0');
                }
            }

            // 处理借位
            for (int i = 0; i < len; i++) {
                if (result[i] < 0) {
                    result[i] += 10;
                    result[i + 1]--;
                }
            }
        }

        // 结果没有进位时的0处理
        boolean flag = true;
        StringBuffer resultStr = new StringBuffer();

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            flag = false;
            resultStr.append(result[i]);
        }

        // 符号处理
        if (sign == '-') {
            return "-" + resultStr.toString();
        } else {
            return resultStr.toString();
        }
    }


    /**
     * 大数相加
     */
    public static String bigAdd(String a, String b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        boolean af = true, bf = true;
        if (a.charAt(0) == '-') {
            af = false;
            a = a.substring(1);
        }
        if (b.charAt(0) == '-') {
            bf = false;
            b = b.substring(1);
        }
        int maxsize = a.length() > b.length() ? a.length() + 2 : b.length() + 2;
        int[] m = new int[maxsize];
        int[] n = new int[maxsize];
        m[0] = af ? 0 : 9;
        n[0] = bf ? 0 : 9;
        for (int i = 0; i < a.length(); i++) {
            m[maxsize - a.length() + i] = Integer.parseInt("" + a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            n[maxsize - b.length() + i] = Integer.parseInt("" + b.charAt(i));
        }
        int[] result = add(buma(m), buma(n));
        return intToString(buma(result));
    }

    /**
     * 加法器，a，b的位数必须相同，首位为符合位，0代表正，9代表负
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] add(int[] a, int[] b) {
        if (a.length < b.length) {
            return null;
        }
        int size = a.length;
        int t = 0;//进位
        for (int i = 0; i < size; i++) {
            int k = a[size - i - 1] + b[size - i - 1];
            k += t;//加进位
            if (k >= 10) {
                t = 1;
            } else {
                t = 0;
            }
            k %= 10;
            a[size - i - 1] = k;
        }

        return a;
    }

    /**
     * 标准输出
     *
     * @param a
     * @return
     */
    private static String intToString(int[] a) {
        StringBuffer s = new StringBuffer();
        if (a[0] == 9) {
            s.append('-');
        } else {
            //s.append('0');
        }
        int tag = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                tag++;
            } else {
                break;
            }
        }
        for (int j = tag + 1; j < a.length; j++) {
            s.append(a[j]);
        }
        if (s.length() == 0) {
            return "0";
        }
        return s.toString();
    }

    /**
     * 10进制求补码
     *
     * @param a
     * @return
     */
    private static int[] buma(int[] a) {
        if (a[0] == 9) {
            for (int i = 1; i < a.length; i++) {
                a[i] = 9 - a[i];
            }
            int[] tmp = new int[a.length];
            tmp[a.length - 1] = 1;
            return add(a, tmp);
        } else {
            return a;
        }
    }


    public static String add(String... params) {
        int maxLeng = 0;
        //获取最大长度
        for (String s : params) {
            if (s.length() > maxLeng) maxLeng = s.length();
        }

        StringBuffer result = new StringBuffer();
        //进位 数
        int high = 0;
        //将每个待加参数每一位相加 进位
        for (int i = 0; i < maxLeng; i++) {
            int charInt = 0;
            for (String s : params) {
                //高位不够用0代替
                charInt += s.length() - 1 < i ? 0 : Integer.parseInt(s.charAt(s.length() - 1 - i) + "");
            }
            charInt += high;
            //进位
            high = charInt / 10;
            //当前位的值 为charInt 余数
            int remainder = charInt % 10;
            result.append(remainder);
        }
        //最后一次进位
        if (high > 0) {
            result.append(high);
        }
        //反转 输出结果
        return result.reverse().toString();
    }
}
