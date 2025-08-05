package com.lotus.jewel.sample.uuid;

import com.fasterxml.uuid.Generators;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TestUuidV1 {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) {

        int limit = 1000;

        String formatString = "%0" + (int)Math.log10(limit) + "d";
        System.out.println(formatString);

        Set<String> uuidSet = new HashSet<>();

        for(int idx = 0 ; idx < limit ; idx++) {
            final String uuid = getUuid();
            uuidSet.add(uuid);

            System.out.println(String.format(formatString, idx) + " : " + uuid);
        }

        System.out.println("Size of set : " + uuidSet.size());
        uuidSet.clear();

        UUID uuidV1 = Generators.timeBasedGenerator().generate();
        String uuidV1AsString = uuidV1.toString();
        System.out.println(uuidV1AsString + " " +  uuidV1AsString.length());

        String uuidAsString = getUuid();
        System.out.println(uuidAsString + " " + uuidAsString.length());

    }

    public static String getUuid() {
        byte[] uuidBytes = createUUIDBytes();
        return bytesToHex(uuidBytes);
    }


    public static byte[] createUUIDBytes() {
        UUID uuidV1 = Generators.timeBasedGenerator().generate();
        String[] uuidV1Parts = uuidV1.toString().split("-");

        String sequentialUuidV1 = new StringBuilder().append(uuidV1Parts[2]).append(uuidV1Parts[1])
                .append(uuidV1Parts[0]).append(uuidV1Parts[3]).append(uuidV1Parts[4]).toString();

        ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
        buffer.putLong(Long.parseUnsignedLong(sequentialUuidV1.substring(0, 16), 16));
        buffer.putLong(Long.parseUnsignedLong(sequentialUuidV1.substring(16), 16));
        return buffer.array();
    }

    //UUID 생성 후 binary 변환
    public static byte[] createUUID() {
        UUID uuidV1 = Generators.timeBasedGenerator().generate();
        String[] uuidV1Parts = uuidV1.toString().split("-");
        String sequentialUUID = uuidV1Parts[2]+uuidV1Parts[1]+uuidV1Parts[0]+uuidV1Parts[3]+uuidV1Parts[4];

        String sequentialUuidV1 = String.join("", sequentialUUID);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(Long.parseUnsignedLong(sequentialUuidV1.substring(0, 16), 16));
        bb.putLong(Long.parseUnsignedLong(sequentialUuidV1.substring(16), 16));
        return bb.array();
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars).toLowerCase();
    }
}
