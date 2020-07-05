package com.github.stiangao.string;

/**
 * @author shitiangao
 */
public class P984 {
    char[] d;
    public String strWithout3a3b(int A, int B) {
        d = new char[A + B];
        if(backtrace(0, A, B)) return new String(d);
        return "";
    }
    boolean backtrace(int i,int A, int B) {
        if(i > 2 && !validate(i-1)) return false;
        if(A == 0 && B == 0) return true;

        if(A > 0) {
            d[i] = 'a';
            if(backtrace(i+1,A-1, B)) return true;
        }
        if(B > 0){
            d[i] = 'b';
            if(backtrace(i+1,A, B-1)) return true;
        }
        return false;
    }

    boolean validate(int i) {
        for(int k = 1; k < i; k++) {
            if(d[k-1] == d[k] && d[k] == d[k+1]) return false;
        }
        return true;
    }

}
