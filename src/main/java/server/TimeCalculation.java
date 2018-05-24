package server;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeCalculation {

    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final String DIA = "d ";
    public static final String DIAS = "d ";
    public static final String HORA = "h ";
    public static final String HORAS = "h ";
    public static final String MINUTO = "m ";
    public static final String MINUTOS = "m ";
    public static final String SEGUNDO = "s";
    public static final String SEGUNDOS = "s";

    public static String getTimeLeft(LocalDateTime start, LocalDateTime end){
        long left = end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC);
        if(left < 0){
            left = 0;
        }
        long days = left / SECONDS_PER_DAY;
        long hours = (left % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
        long minutes = (left % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
        long seconds = (left % SECONDS_PER_MINUTE);
        StringBuilder sb = new StringBuilder();
        sb.append(days);
        if(days == 1) {
            sb.append(DIA);
        }else{
            sb.append(DIAS);
        }
        sb.append(hours);
        if(hours == 1){
            sb.append(HORA);
        }else{
            sb.append(HORAS);
        }
        sb.append(minutes);
        if(minutes == 1){
            sb.append(MINUTO);
        }else{
            sb.append(MINUTOS);
        }
        sb.append(seconds);
        if(seconds == 1){
            sb.append(SEGUNDO);
        }else{
            sb.append(SEGUNDOS);
        }

        return String.valueOf(sb.toString());
    }
}
