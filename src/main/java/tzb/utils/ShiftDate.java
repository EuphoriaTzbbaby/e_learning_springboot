package tzb.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ShiftDate {
    public String toChineseDate(String s) {
        // 2024-05-13T08:28:15.051Z
        String utcDateTimeStr = s;
        Instant instant = Instant.parse(utcDateTimeStr);

        ZonedDateTime chinaDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String chinaDateTimeStr = chinaDateTime.format(formatter);
        return chinaDateTimeStr;
    }
}
