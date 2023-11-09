package com.lotus.jewel.sample.net.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckInetAddress {

    public static void main(String[] args) {

//        printAdress(PrintType.HOST_NAME, "google.com");
//        printAdress(PrintType.CANOICAL_HOST_NAME, "google.com");
//        printAdress(PrintType.HOST_ADRESS, "google.com");
//        printAdress(PrintType.ADDRESS, "google.com");
        printAdress(null, "google.com");
    }

    private static void printAdress(final PrintType printType, final String name) {

        try {
            InetAddress[] addresses = InetAddress.getAllByName(name);
            for (InetAddress address: addresses) {
                if (printType == null) {
                    System.out.println(address);
                    continue;
                }

                switch (printType) {
                    case HOST_NAME:
                        System.out.println(address.getHostName());
                        break;
                    case CANOICAL_HOST_NAME:
                        System.out.println(address.getCanonicalHostName());
                        break;

                    case HOST_ADRESS:
                        System.out.println(address.getHostAddress());
                        break;
                    case ADDRESS:
                        System.out.println(address.getAddress());
                        break;
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not found " + name);
        }

    }

    private static enum PrintType {
        HOST_NAME,
        CANOICAL_HOST_NAME,
        HOST_ADRESS,
        ADDRESS;
    }
}
