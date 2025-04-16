import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork3Test {

    public static String firstName = "Shadow" ;
    public static String secondName = "Fiend" ;
    public static String userMail = "sf@ya.ru" ;
    public static String userSex = "Male" ;
    public static String phoneNumber = "4815162342" ;
    public static String imagePath = "dota-shadow-fiend.gif" ;
    public static String myFavouriteSubject = "Chemistry" ;
    public static String myAddress = "only Middle st." ;

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000 ;
        Configuration.holdBrowserOpen = true ;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(secondName);
        $("#userEmail").setValue(userMail);
        $(byText(userSex)).click();
        $("#userNumber").setValue(phoneNumber);


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--008").click();


        $("#subjectsInput").setValue(myFavouriteSubject).pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        // Загрузка файла
        $("#uploadPicture").uploadFromClasspath(imagePath);

        // Адрес
        $("#currentAddress").setValue(myAddress);

        // Штат и город
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        // Отправка формы
        $("#submit").click();

        // Проверка результатов
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + secondName),
                text(userMail),
                text(userSex),
                text(phoneNumber),
                text("08 May,1991"),
                text(myFavouriteSubject),
                text("Sports, Music"),
                text(imagePath),
                text(myAddress),
                text("NCR Delhi")
        );
    }
}