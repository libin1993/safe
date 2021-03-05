package com.doit.net.utils;

import android.text.TextUtils;

import com.doit.net.application.MyApplication;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Author：Libin on 2020/5/9 17:47
 * Email：1993911441@qq.com
 * Describe：格式转换
 */
public class FormatUtils {
    private static FormatUtils mInstance;

    private FormatUtils() {
    }

    public static FormatUtils getInstance() {
        if (mInstance == null) {
            synchronized (FormatUtils.class) {
                if (mInstance == null) {
                    mInstance = new FormatUtils();
                }
            }
        }
        return mInstance;
    }


    /**
     *  dp转px
     */
    public int dip2px(int dpValue) {

        float scale = MyApplication.mContext.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5);

    }

    /**
     *  dp转px
     */
    public int dip2px(float dpValue) {

        float scale = MyApplication.mContext.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5);

    }

    /**
     *  px转dp
     */

    public int px2dip(float pxValue) {

        float scale = MyApplication.mContext.getResources().getDisplayMetrics().density;

        return (int) (pxValue * scale + 0.5);

    }

    /**
     *  px转dp
     */

    public int px2dip(int pxValue) {

        float scale = MyApplication.mContext.getResources().getDisplayMetrics().density;

        return (int) (pxValue * scale + 0.5);

    }



    public boolean plmnRange(String plmn) {
        if (!TextUtils.isEmpty(plmn) && (plmn.startsWith(",") || plmn.endsWith(","))) {
            return false;
        }
        String[] split = plmn.split(",");
        for (String s : split) {
            if (TextUtils.isEmpty(s) || s.length() != 5) {
                return false;
            }
        }
        return true;
    }

    public boolean gpsRange(String gps) {
        if (!TextUtils.isEmpty(gps) && (gps.startsWith(",") || gps.endsWith(","))) {
            return false;
        }
        String[] split = gps.split(",");

        for (String s : split) {
            if (TextUtils.isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    public boolean pciRange(String pci) {
        if (!TextUtils.isEmpty(pci) && (pci.startsWith(",") || pci.endsWith(","))) {
            return false;
        }
        String[] split = pci.split(",");

        for (String s : split) {
            if (TextUtils.isEmpty(s) || s.length() > 3) {
                return false;
            }
            int pciInt = Integer.parseInt(s);
            if (pciInt > 503) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return FCN校验
     */
    public boolean fcnRange(String band, String input) {
        if (TextUtils.isEmpty(input)){
            ToastUtils.showMessage("请输入3个频点");
            return false;
        }
        String[] split = input.split(",");
        if (split.length != 3){
            ToastUtils.showMessage("请输入3个频点");
            return false;
        }

        Set<String> tempSet = new HashSet<String>(Arrays.asList(split));
        if (tempSet.size() != split.length){
            ToastUtils.showMessage("请输入3个不重复的频点");
            return false;
        }


        for (String s : split) {
            if (TextUtils.isEmpty(s) || s.length() > 5) {
                ToastUtils.showMessage("输入频点格式有误");
                return false;
            }
            int fcn = Integer.parseInt(s);
            switch (band) {
                case "1":
                    if (fcn < 0 || fcn > 599) {
                        ToastUtils.showMessage("请输入0-599范围内数字");
                        return false;
                    }
                    break;
                case "2":
                    if (fcn < 600 || fcn > 1199) {
                        ToastUtils.showMessage("请输入600-1199范围内数字");
                        return false;
                    }
                    break;
                case "3":
                    if (fcn < 1200 || fcn > 1949) {
                        ToastUtils.showMessage("请输入1200-1949范围内数字");
                        return false;
                    }
                    break;
                case "4":
                    if (fcn < 1950 || fcn > 2399) {
                        ToastUtils.showMessage("请输入1950-2399范围内数字");
                        return false;
                    }
                    break;
                case "5":
                    if (fcn < 2400 || fcn > 2649) {
                        ToastUtils.showMessage("请输入2400-2649范围内数字");
                        return false;
                    }
                    break;
                case "6":
                    if (fcn < 2650 || fcn > 2749) {
                        ToastUtils.showMessage("请输入2650-2749范围内数字");
                        return false;
                    }
                    break;
                case "7":
                    if (fcn < 2750 || fcn > 3449) {
                        ToastUtils.showMessage("请输入2750-3449范围内数字");
                        return false;
                    }
                    break;
                case "8":
                    if (fcn < 3450 || fcn > 3799) {
                        ToastUtils.showMessage("请输入3450-3799范围内数字");
                        return false;
                    }
                    break;
                case "9":
                    if (fcn < 3800 || fcn > 4149) {
                        ToastUtils.showMessage("请输入3800-4149范围内数字");
                        return false;
                    }
                    break;
                case "10":
                    if (fcn < 4150 || fcn > 4749) {
                        ToastUtils.showMessage("请输入4150-4749范围内数字");
                        return false;
                    }
                    break;
                case "11":
                    if (fcn < 4750 || fcn > 4949) {
                        ToastUtils.showMessage("请输入4750-4949范围内数字");
                        return false;
                    }
                    break;
                case "12":
                    if (fcn < 5010 || fcn > 5179) {
                        ToastUtils.showMessage("请输入5010-5179范围内数字");
                        return false;
                    }
                    break;
                case "13":
                    if (fcn < 5180 || fcn > 5279) {
                        ToastUtils.showMessage("请输入5180-5279范围内数字");
                        return false;
                    }
                    break;
                case "14":
                    if (fcn < 5280 || fcn > 5379) {
                        ToastUtils.showMessage("请输入5280-5379范围内数字");
                        return false;
                    }
                    break;
                case "17":
                    if (fcn < 5730 || fcn > 5849) {
                        ToastUtils.showMessage("请输入5730-5849范围内数字");
                        return false;
                    }
                    break;
                case "18":
                    if (fcn < 5850 || fcn > 5999) {
                        ToastUtils.showMessage("请输入5850-5999范围内数字");
                        return false;
                    }
                    break;
                case "19":
                    if (fcn < 6000 || fcn > 6149) {
                        ToastUtils.showMessage("请输入6000-6149范围内数字");
                        return false;
                    }
                    break;
                case "20":
                    if (fcn < 6150 || fcn > 6449) {
                        ToastUtils.showMessage("请输入6150-6449范围内数字");
                        return false;
                    }
                    break;
                case "21":
                    if (fcn < 6450 || fcn > 6599) {
                        ToastUtils.showMessage("请输入6450-6599范围内数字");
                        return false;
                    }
                    break;
                case "22":
                    if (fcn < 6600 || fcn > 7399) {
                        ToastUtils.showMessage("请输入6600-7399范围内数字");
                        return false;
                    }
                    break;
                case "23":
                    if (fcn < 7500 || fcn > 7699) {
                        ToastUtils.showMessage("请输入7500-7699范围内数字");
                        return false;
                    }
                    break;
                case "24":
                    if (fcn < 7700 || fcn > 8039) {
                        ToastUtils.showMessage("请输入7700-8039范围内数字");
                        return false;
                    }
                    break;
                case "25":
                    if (fcn < 8040 || fcn > 8689) {
                        ToastUtils.showMessage("请输入8040-8689范围内数字");
                        return false;
                    }
                    break;
                case "33":
                    if (fcn < 36000 || fcn > 36199) {
                        ToastUtils.showMessage("请输入36000-36199范围内数字");
                        return false;
                    }
                    break;
                case "34":
                    if (fcn < 36200 || fcn > 36349) {
                        ToastUtils.showMessage("请输入36200-36349范围内数字");
                        return false;
                    }
                    break;
                case "35":
                    if (fcn < 36350 || fcn > 36949) {
                        ToastUtils.showMessage("请输入36350-36949范围内数字");
                        return false;
                    }
                    break;
                case "36":
                    if (fcn < 36950 || fcn > 37549) {
                        ToastUtils.showMessage("请输入36950-37549范围内数字");
                        return false;
                    }
                    break;
                case "37":
                    if (fcn < 37550 || fcn > 37749) {
                        ToastUtils.showMessage("请输入37550-37749范围内数字");
                        return false;
                    }
                    break;
                case "38":
                    if (fcn < 37750 || fcn > 38249) {
                        ToastUtils.showMessage("请输入37750-38249范围内数字");
                        return false;
                    }
                    break;
                case "39":
                    if (fcn < 38250 || fcn > 38649) {
                        ToastUtils.showMessage("请输入38250-38649范围内数字");
                        return false;
                    }
                    break;
                case "40":
                    if (fcn < 38650 || fcn > 39649) {
                        ToastUtils.showMessage("请输入38650-39649范围内数字");
                        return false;
                    }
                    break;
                case "41":
                    if (fcn < 39650 || fcn > 41589) {
                        ToastUtils.showMessage("请输入39650-41589范围内数字");
                        return false;
                    }
                    break;
                case "42":
                    if (fcn < 41590 || fcn > 43589) {
                        ToastUtils.showMessage("请输入41590-43589范围内数字");
                        return false;
                    }
                    break;
                case "43":
                    if (fcn < 43590 || fcn > 45589) {
                        ToastUtils.showMessage("请输入43590-45589范围内数字");
                        return false;
                    }
                    break;

            }
        }

        return true;
    }


    /**
     *  特殊字符
     */
    public boolean isCommon(String data) {

        return !data.contains(",") && !data.contains("#");
    }

    /**
     * @param data 数组倒序
     */
    public void reverseData(byte[] data) {
        for (int start = 0, end = data.length - 1; start < end; start++, end--) {
            byte temp = data[end];
            data[end] = data[start];
            data[start] = temp;
        }
    }


    /**
     * byte[] 转int
     *
     * @param tempValue
     * @return
     */
    public int byteToInt(byte[] tempValue) {
        int[] tempInt = new int[4];
        tempInt[3] = (tempValue[3] & 0xff) << 0;
        tempInt[2] = (tempValue[2] & 0xff) << 8;
        tempInt[1] = (tempValue[1] & 0xff) << 16;
        tempInt[0] = (tempValue[0] & 0xff) << 24;
        return tempInt[0] + tempInt[1] + tempInt[2] + tempInt[3];
    }


    /**
     * 将传入的字符串转换成byte[]
     *
     * @param tempValue
     * @return
     */
    public byte[] string2BytesForASCII(String tempValue) {
        try {
            return tempValue.getBytes(StandardCharsets.US_ASCII);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 将传入的字符串转换成byte[]
     *
     * @param tempValue
     * @return
     */
    public byte[] string2BytesForUTF(String tempValue) {
        try {
            return tempValue.getBytes(StandardCharsets.UTF_8);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 将传入的byte[]转换成字符串
     *
     * @param data
     * @return
     */
    public String bytes2StringForASCII(byte[] data) {
        return new String(data, StandardCharsets.US_ASCII);
    }


    /**
     * 将传入的byte[]转换成字符串
     *
     * @param data
     * @return
     */
    public String bytes2StringForUTF(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }


    /**
     * byte[] 转short
     *
     * @param
     * @return
     */
    public short byteToShort(byte[] tempValue) {
        return (short) ((tempValue[0] << 8) + (tempValue[1] & 0xFF));
    }


    /**
     * Byte转Bit
     */
    public String byteToBit(byte b) {
        return "" + (byte) ((b >> 7) & 0x1) +
                (byte) ((b >> 6) & 0x1) +
                (byte) ((b >> 5) & 0x1) +
                (byte) ((b >> 4) & 0x1) +
                (byte) ((b >> 3) & 0x1) +
                (byte) ((b >> 2) & 0x1) +
                (byte) ((b >> 1) & 0x1) +
                (byte) ((b >> 0) & 0x1);
    }


    public String getPhoneNumber(String imsi) {
        String strAttach = "";

        char[] szImsi = imsi.toCharArray();

        char[] szMsisdn = new char[7];
        szMsisdn[0] = 0;
        if (szImsi[0] != '4' || szImsi[1] != '6' || szImsi[2] != '0') {
            return strAttach;
        }
        //移动GSM 135-139
        if (szImsi[4] == '0')//46000
        {
            if (szImsi[8] >= '5' && szImsi[8] <= '9') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = szImsi[8];
                szMsisdn[3] = '0';
                szMsisdn[4] = szImsi[5];
                szMsisdn[5] = szImsi[6];
                szMsisdn[6] = szImsi[7];

            } else if (szImsi[8] >= '0' && szImsi[8] <= '4') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = (char) (szImsi[8] + 5);
                szMsisdn[3] = szImsi[9];
                szMsisdn[4] = szImsi[5];
                szMsisdn[5] = szImsi[6];
                szMsisdn[6] = szImsi[7];

            } else {
                return "";
            }
        }
        //移动
        else if (szImsi[4] == '7')//46007
        {
            //188
            if (szImsi[5] == '8') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '8';
            }
            //147
            else if (szImsi[5] == '9')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '4';
                szMsisdn[2] = '7';
            }
            //157
            else if (szImsi[5] == '7')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '7';
            } else {
                return strAttach;
            }
            szMsisdn[3] = szImsi[6];
            szMsisdn[4] = szImsi[7];
            szMsisdn[5] = szImsi[8];
            szMsisdn[6] = szImsi[9];

        }
        //联通GSM
        else if (szImsi[4] == '1')//46001
        {
            //130
            if (szImsi[9] == '0' || szImsi[9] == '1') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = '0';

            }
            //131
            else if (szImsi[9] == '9') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = '1';

            }
            //132
            else if (szImsi[9] == '2') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = '2';

            }
            //145
            else if (szImsi[9] == '7')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '4';
                szMsisdn[2] = '5';

            }
            //155
            else if (szImsi[9] == '4')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '5';


            }
            //156
            else if (szImsi[9] == '3') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '6';

            }
            //186
            else if (szImsi[9] == '6')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '6';

            } else {
                return "";
            }
            szMsisdn[3] = szImsi[8];
            szMsisdn[4] = szImsi[5];
            szMsisdn[5] = szImsi[6];
            szMsisdn[6] = szImsi[7];

        } else if (szImsi[4] == '2')//46002
        {
            //134
            if (szImsi[5] == '0') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = '4';

            }
            //150
            else if (szImsi[5] == '3') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '0';
            }

            //151
            else if (szImsi[5] == '1') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '1';
            }
            //152
            else if (szImsi[5] == '2') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '2';
            }
            //158
            else if (szImsi[5] == '8') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '8';
            }
            //159
            else if (szImsi[5] == '9') {
                szMsisdn[0] = '1';
                szMsisdn[1] = '5';
                szMsisdn[2] = '9';
            }
            //182
            else if (szImsi[5] == '6')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '2';
            }
            //183
            else if (szImsi[5] == '5')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '3';
            }
            //187
            else if (szImsi[5] == '7')//lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '7';
            } else {
                return strAttach;
            }
            szMsisdn[3] = szImsi[6];
            szMsisdn[4] = szImsi[7];
            szMsisdn[5] = szImsi[8];
            szMsisdn[6] = szImsi[9];

        }
        //联通CDMA
        else if (szImsi[4] == '3')//46003
        {
            int nH0H1H2H3 = 0;
            char[] szH0H1H2H3 = new char[3];
            String strH0H1;
            if (szImsi[5] == '6') {
                // 2.0.1 [9/10/2009 yxm]
                //153
                if (szImsi[8] == '0')//lyt 110922
                {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '5';
                    szMsisdn[2] = '3';
                }
                //189
                else if (szImsi[8] == '1')//lyt 110922
                {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '8';
                    szMsisdn[2] = '9';
                } else {
                    return strAttach;
                }
                // 2.0.1 [9/10/2009 yxm]
                szMsisdn[3] = szImsi[6];
                szMsisdn[4] = szImsi[7];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            }
            //133
            else if (szImsi[6] == '9') {
                //133 0100-133 0199
                if (szImsi[7] == '0' && szImsi[8] == '0') {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '3';
                    szMsisdn[2] = '3';

                    szMsisdn[3] = '0';
                    szMsisdn[4] = '1';
                    szMsisdn[5] = szImsi[9];
                    szMsisdn[6] = szImsi[10];

                } else if (szImsi[7] == '5' && szImsi[8] == '3') {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '3';
                    szMsisdn[2] = '3';

                    szMsisdn[3] = '9';
                    szMsisdn[4] = '8';

                    szMsisdn[5] = szImsi[9];
                    szMsisdn[6] = szImsi[10];

                } else if (szImsi[7] == '5' && szImsi[8] == '4')//lyt 110922我的文档里没有找到
                {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '3';
                    szMsisdn[2] = '3';

                    szMsisdn[3] = '9';
                    szMsisdn[4] = '9';

                    szMsisdn[5] = szImsi[9];
                    szMsisdn[6] = szImsi[10];

                } else {
                    szMsisdn[0] = '1';
                    szMsisdn[1] = '3';
                    szMsisdn[2] = '3';

                    szMsisdn[3] = szImsi[7];
                    szMsisdn[4] = szImsi[8];
                    szMsisdn[5] = szImsi[9];
                    szMsisdn[6] = szImsi[10];

                }

            }
            //////////////////////////////////////////////////////////////////////////
            //lyt 110922 //180 电信
            //180 H0H1H2H3 ABCD				46003 X0X1 H0H1H2H3 ABCD
            else if (szImsi[6] == '1' && szImsi[7] == '3')//18000-18008
            {
                //1800H1H2H3
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = '0';
                szMsisdn[4] = szImsi[8];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '1' && szImsi[7] == '6')//18009-18017
            {
                //180(H0H1－51)H2H3
                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 51;
                if (nH0H1H2H3 < 10) {
                    szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();
                    szH0H1H2H3[1] = 0;
                    szMsisdn[3] = '0';
                    szMsisdn[4] = szH0H1H2H3[0];
                } else {
                    szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();
                    szMsisdn[3] = szH0H1H2H3[0];
                    szMsisdn[4] = szH0H1H2H3[1];
                }
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '2' && szImsi[7] == '3')//18018-18026
            {
                //180(H0H1－12)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 12;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '2' && szImsi[7] == '5')//18027-18035
            {
                //180(H0H1－23)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 23;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '2' && szImsi[7] == '6')//18036-18044
            {
                //180(H0H1－24)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 24;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if ((szImsi[6] == '3' && szImsi[7] == '6') || (szImsi[6] == '3' && szImsi[7] == '7'))//18045-18055
            {
                //180(H0H1－15)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 15;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '4' && szImsi[7] == '0')//18056-18065
            {
                //180(H0H1+56)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 += 56;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if ((szImsi[6] == '4' && szImsi[7] == '1') || (szImsi[6] == '4' && szImsi[7] == '2' && szImsi[8] == '0'))//18066-18073
            {
                //180(H0H1+53)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 += 53;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if ((szImsi[6] == '4' && szImsi[7] == '2' && szImsi[8] == '3') || (szImsi[6] == '4' && szImsi[7] == '3'))//18074-18081
            {
                //180(H0H1+51)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 += 51;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if (szImsi[6] == '4' && szImsi[7] == '9')//18082-18087
            {
                //180(H0H1－11)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 -= 11;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else if ((szImsi[6] == '7' && szImsi[7] == '2') && (szImsi[6] == '7' && szImsi[7] == '3' && szImsi[1] == '3'))//18088-18099
            {
                //180(H0H1+68)H2H3
                strH0H1 = String.valueOf(szImsi[7]) + szImsi[8];
                nH0H1H2H3 = Integer.parseInt(strH0H1);
                nH0H1H2H3 += 68;
                szH0H1H2H3 = String.valueOf(nH0H1H2H3).toCharArray();

                szMsisdn[0] = '1';
                szMsisdn[1] = '8';
                szMsisdn[2] = '0';
                szMsisdn[3] = szH0H1H2H3[0];
                szMsisdn[4] = szH0H1H2H3[1];
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            }
            //lyt 110922
            //////////////////////////////////////////////////////////////////////////
            //1335000-1335999
            else if (szImsi[6] == '3' && szImsi[7] == '3' && szImsi[8] == '0') //lyt 110922
            {
                szMsisdn[0] = '1';
                szMsisdn[1] = '3';
                szMsisdn[2] = '3';

                szMsisdn[3] = '5';
                szMsisdn[4] = '0';
                szMsisdn[5] = szImsi[9];
                szMsisdn[6] = szImsi[10];

            } else {
                return "";
            }
        } else//无对应关系
        {
            return strAttach;
        }


        strAttach = String.valueOf(szMsisdn);
        return strAttach;
    }
}
