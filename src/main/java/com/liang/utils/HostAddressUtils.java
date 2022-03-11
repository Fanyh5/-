package com.liang.utils;

import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostAddressUtils {

    public static String getHostAddress(int port) {
        String HostAddress = null;
        try {
            HostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "127.0.0.1:"+port;
        }
        return HostAddress!=null?HostAddress+":"+port:"127.0.0.1:"+port;
    }
}
