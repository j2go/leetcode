package com.github.stiangao.string;

/**
 * 1163. 按字典序排在最后的子串
 * https://leetcode-cn.com/problems/last-substring-in-lexicographical-order/
 */
public class P1163 {
    public String lastSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 1;
        int k = 1;
        while (r + k < n) {
            if (s.charAt(l) < s.charAt(r)) {
                l = r;
                k = 1;

                while (++r < n && s.charAt(r) < s.charAt(l)) ;
            } else if (s.charAt(l) > s.charAt(r)) {

                while (++r < n && s.charAt(r) < s.charAt(l)) ;
            } else {
                while (r + k < n && s.charAt(l + k) == s.charAt(r + k)) k++;
                if (r + k == n)
                    return s.substring(l);
                if (s.charAt(l + k) < s.charAt(r + k)) {
                    l = r;
                    k = 1;

                    while (++r < n && s.charAt(r) < s.charAt(l)) ;
                } else {
                    while (++r < n && s.charAt(r) < s.charAt(l)) ;
                }
            }
        }
        return s.substring(l);
    }

    public static void main(String[] args) {
        System.out.println(new P1163().lastSubstring("qq" +
                "zgnrrrwxbibtcutnfankdqrvhkfinplemrqvf" +
                "znliobyjetpuluygxqrngxpcpiuvigtetdydgfcmwrl" +
                "zqddnqdegndpbavponftggnhdqyqgxhjlxdckqmqyupwkcapatycmwgsgomobtclgrosw" +
                "zfcjmsodcbjljloaarcrprlfu" +
                "zxrtngpiamrbq" +
                "ztyd" +
                "zvmoaupdbgp" +
                "zeqwlgqykopeauegxjcvionsjchiumqddny" +
                "zsbcdptyycgbakypuhtjdle" +
                "zls" +
                "zsiyhkycyivefql" +
                "zvb" +
                "zusyxrwswbdtqudtpommplthnhocdrn" +
                "zfbyuv" +
                "zjrxpsquaqnvhpwercjpmothnnvaulpyslofccixocddhvvjfwedxljiyr" +
                "zajyle" +
                "zjmxtcxodyovdsprpqnfamtcufhdiiuiytjwovkebqcqubfqneffbhgbevbqhvvjukadklupnrhghbqxqpkhlnuxcjqgkqfrfbuwiecklbrc" +
                "zyuhebntehmv" +
                "zqsmfberrtumaux" +
                "zsyxchwgbthuygd" +
                "zieisqudyx" +
                "zkhnoykwagvbuoxolslhipnvetpwycubeynhhtqbjkshvgebowatckrusbfghbvyphhrmlrrsdshwxyrcmbdwkwclvuuwrfnribdpxwsbdyikdlff" +
                "zltrefzcijwjnqqarcienppkjrnbshyqwoegyagckkykhdfkivnsurtwdciqanayhmnmmyirevknyrcnmjqncwvmyawpchowap" +
                "zxmyoyjcjgizroinwxwttkruqeqjtxgojjjhmplujouyikmmgiroxrchavunzjkzaptmudrwjmhofqnmmdplvntps" +
                "zgvagpdcifrylkqgmanagxiitrolbnnpnpeyeykkfexgpxipxcjyysodkijlenmfzhkbwgmqxuvudbubfwa" +
                "zzczkhzyrdbljmodgipygudfzvfnbbuozdfztflkwehdmauqspeeoxtccywnenyhoxbitzlw"));
    }
}
