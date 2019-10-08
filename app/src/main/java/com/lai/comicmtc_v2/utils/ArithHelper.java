package com.lai.comicmtc_v2.utils;

import java.math.BigDecimal;

/**
 * @Description
 * @Author AA
 * @DateTime 2018/3/28 下午3:55
 */
public class ArithHelper {

    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 16;

    // 这个类不能实例化
    private ArithHelper() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static double add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    public static double sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */

    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    public static float mul(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).floatValue();
    }

    public static double mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    public static float div(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static double div(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static float div(int v1, int v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static float div(long v1, long v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 十进制转十六进制
     *
     * @param value
     * @return
     */
    public static String intToHex(int value) {
        StringBuffer s = new StringBuffer();
        String a;
        char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (value != 0) {
            s = s.append(b[value % 16]);
            value = value / 16;
        }
        a = s.reverse().toString();
        return a;
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 格式化视频时长字符串
     */
    public static String formatDecimal(String value) {
        if (value.endsWith(".0") || value.endsWith(".00")) {
            return value.substring(0, value.indexOf("."));
        }
        return value;
    }

    /**
     * 字符串是否为数字
     */
    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str.trim())) {
            return str.matches("^[0-9]*$");
        }
        return false;
    }

    /**
     * 数值升值格式化。逢单位"万"格式化
     *
     * @param number   要格式化的数
     * @param typeEnum {@link NumericFormatTypeEnum}
     * @return 单位"万"格式化数据内容
     */
    public static String appreciationFormat(long number, NumericFormatTypeEnum typeEnum) {
        String result = number + "";
        int miriade = 10000;
        if (number >= miriade) {
            String type;
            if (typeEnum == NumericFormatTypeEnum.CHINESE) {
                type = "万";
            } else {
                type = "w";
            }
            result = number / miriade + type;
        }
        return result;
    }

    /**
     * 数值升值格式化。逢单位"千"或以上单位格式化
     *
     * @param number   要格式化的数
     * @param typeEnum {@link NumericFormatTypeEnum}
     * @return 逢"千" 和 "万"格式化内容
     */
    public static String appreciationThousandFormat(float number, NumericFormatTypeEnum typeEnum) {
        int thousand = 1000;
        String result = number + "";
        if (number >= thousand) {
            String type;

            int miriade = 10000;
            if (number >= miriade) {
                if (typeEnum == NumericFormatTypeEnum.CHINESE) {
                    type = "万";
                } else {
                    type = "w";
                }
                result = number / miriade + type;
            } else {
                if (typeEnum == NumericFormatTypeEnum.CHINESE) {
                    type = "千";
                } else {
                    type = "k";
                }

                result = number / thousand + type;
            }
        }
        return result;
    }

    /**
     * 数值升值格式化。逢单位"千"或以上单位格式化
     *
     * @param number   要格式化的数
     * @param typeEnum {@link NumericFormatTypeEnum}
     * @return 逢"千" 和 "万"格式化内容
     */
    public static String appreciationThousandFormat(int number, NumericFormatTypeEnum typeEnum) {
        int thousand = 1000;
        String result = number + "";
        if (number >= thousand) {
            String type;

            int miriade = 10000;
            if (number >= miriade) {
                if (typeEnum == NumericFormatTypeEnum.CHINESE) {
                    type = "万";
                } else {
                    type = "w";
                }
                result = number / miriade + type;
            } else {
                if (typeEnum == NumericFormatTypeEnum.CHINESE) {
                    type = "千";
                } else {
                    type = "k";
                }

                result = number / thousand + type;
            }
        }
        return result;
    }

    /**
     * 转换类型枚举
     */
    public enum NumericFormatTypeEnum {
        /**
         * 中文提示语
         */
        CHINESE,
        /**
         * 英文提示语
         */
        ENGLISH
    }
}