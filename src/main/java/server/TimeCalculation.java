package server;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeCalculation {

    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;

    public static String getTimeLeft(LocalDateTime start, LocalDateTime end){
        long left = end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC);
        long days = left / SECONDS_PER_DAY;
        long hours = (left % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
        long minutes = (left % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
        long seconds = (left % SECONDS_PER_MINUTE);
        StringBuilder sb = new StringBuilder();
        sb.append(days);
        if(days == 1) {
            sb.append(" D&iacute;a ");
        }else{
            sb.append(" D&iacute;as ");
        }
        sb.append(hours);
        if(hours == 1){
            sb.append(" Hora ");
        }else{
            sb.append(" Horas ");
        }
        sb.append(minutes);
        if(minutes == 1){
            sb.append(" Minuto ");
        }else{
            sb.append(" Minutos ");
        }
        sb.append(seconds);
        if(seconds == 1){
            sb.append(" Segundo");
        }else{
            sb.append(" Segundos");
        }

        return String.valueOf(sb.toString());
    }
}
