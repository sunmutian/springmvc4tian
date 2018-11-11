package com.tian.sort.list;

/**
 * @auther: lawt
 * @date: 2018/11/6 16
 * @Description: 判断是否为回文数
 */
public class PalindromeNumbe {
    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println("123454321 是否为回文数=" + isPalindromeByInt(123454321));
        System.out.println("12345432 是否为回文数=" + isPalindromeByInt(12345432));
        System.out.println("12324 是否为回文数=" + isPalindromeByInt(12324));
        System.out.println("12 是否为回文数=" + isPalindromeByInt(12));
        System.out.println("1 是否为回文数=" + isPalindromeByInt(1));
        System.out.println("198765432 是否为回文数=" + isPalindromeByInt(198765432));
        System.out.println("----------------------------");
        System.out.println("1 是否为回文数=" + isPalindromeByString(1));
        System.out.println("0 是否为回文数=" + isPalindromeByString(0));
        System.out.println("11000 是否为回文数=" + isPalindromeByString(11000));
        System.out.println("12332 是否为回文数=" + isPalindromeByString(12332));
        System.out.println("123454321 是否为回文数=" + isPalindromeByString(123454321));
        System.out.println("198765432 是否为回文数=" + isPalindromeByString(198765432));
    }

    /**
     * 通过字符串来校验是否为回文数
     *
     * @param num 需求判断的参数
     * @return 是否为回文数
     */
    public static boolean isPalindromeByString(int num) {
        //负数
        if (num < 0) {
            return false;
        }
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 直接通过int数来对比是否为回文数
     *
     * @param num 需要校验的数字
     * @return 是否为回文数
     */
    public static boolean isPalindromeByInt(int num) {
        /**
         * 特殊情况：
         *  如上所述，当 x < 0 时，x 不是回文数。
         *  同样地，如果数字的最后一位是 0，为了使该数字为回文，
         *  则其第一位数字也应该是 0
         *  只有 0 满足这一属性
         */
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }

        /**
         * 当数字长度为奇数时，我们可以通过
         * revertedNumber/10 去除处于中位的数字。
         * 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到
         *  x = 12，revertedNumber = 123，
         *  由于处于中位的数字不影响回文（它总是与自己相等），
         *  所以我们可以简单地将其去除。
         */
        return num == revertedNumber || num == revertedNumber / 10;
    }
}
