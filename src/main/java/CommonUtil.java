package main.java;

import com.google.protobuf.Timestamp;
import com.mifmif.common.regex.Generex;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CommonUtil {
    private static Timestamp convertMilliSecondsToTimestamp(long milliSeconds) {
        return Timestamp.newBuilder().setSeconds(milliSeconds / 1000)
                .setNanos((int) ((milliSeconds % 1000) * 1000000)).build();
    }

    public static Timestamp getCurrentUTCTimestamp() {
        return convertMilliSecondsToTimestamp(System.currentTimeMillis());
    }

    private static String generex(String regexPattern) {
        Generex generex = new Generex(regexPattern);
        return generex.random();
    }

    public static String generateRandomSSName() {
        Timestamp timestamp = getCurrentUTCTimestamp();
        String timezone = String.valueOf(ZoneId.of("Asia/Kolkata"));
        LocalDateTime localDate = Instant
                .ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos())
                .atZone(ZoneId.of(timezone))
                .toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        String date = localDate.format(formatter);
        String generexPattern = "Screenshot_" + date;
        return generex(generexPattern);
    }

    public static String generateRandomString(int length) {
        String generexPattern = "([a-z]{" + length + "})";
        return generex(generexPattern);

    }

    public static String generateRandomEmailId() {
        return CommonUtil.generateRandomString(5) + "@" + CommonUtil.generateRandomString(5) + ".com";
    }
}
