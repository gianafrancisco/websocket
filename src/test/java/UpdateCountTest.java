import org.junit.Assert;
import org.junit.Test;
import server.TimeCalculation;

import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;

public class UpdateCountTest {

    @Test
    public void Test_N_Days() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T00:00:00");
        LocalDateTime start = LocalDateTime.parse("2017-05-28T00:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("365 D&iacute;as 0 Horas 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_1_Day() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T00:00:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-27T00:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("1 D&iacute;a 0 Horas 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_0_Day() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T00:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 10 Horas 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_N_Hours() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T00:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 10 Horas 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_1_Hour() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T09:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 1 Hora 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_0_Hours() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 0 Minutos 0 Segundos"));

    }

    @Test
    public void Test_N_Minutes() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:02:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 2 Minutos 0 Segundos"));

    }

    @Test
    public void Test_1_Minute() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:02:00");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:01:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 1 Minuto 0 Segundos"));

    }

    @Test
    public void Test_0_Minutes() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:10");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:00:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 0 Minutos 10 Segundos"));

    }

    @Test
    public void Test_N_Seconds() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:02:02");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:02:00");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 0 Minutos 2 Segundos"));

    }

    @Test
    public void Test_1_Second() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:02:02");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:02:01");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 0 Minutos 1 Segundo"));

    }

    @Test
    public void Test_0_Seconds() {
        LocalDateTime end = LocalDateTime.parse("2018-05-28T10:00:10");
        LocalDateTime start = LocalDateTime.parse("2018-05-28T10:00:10");

        String result = TimeCalculation.getTimeLeft(start, end);
        Assert.assertThat(result, is("0 D&iacute;as 0 Horas 0 Minutos 0 Segundos"));

    }
}
