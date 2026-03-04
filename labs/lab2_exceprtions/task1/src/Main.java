import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setLenient(false);
        return format.parse(dateString);
    }
    public static void main(String[] args) {

        String inputDate = "28-02-2026";

        try {
            Date result = parseDate(inputDate);
            System.out.println("Дата успішно перетворена: " + result);
        } catch (ParseException e) {
            System.out.println("Помилка! Невірний формат дати.");
            System.out.println("Деталі: " + e.getMessage());
        }
    }
}