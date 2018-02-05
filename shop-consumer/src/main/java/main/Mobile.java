package main;

import interfaces.mobile.MobileCodeWS;
import interfaces.mobile.MobileCodeWSSoap;

public class Mobile {
    public static void main(String[] args) {
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getPort(MobileCodeWSSoap.class);
        String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("13957541317", "");
        System.out.println(mobileCodeInfo);
    }
}
