import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class SimpleJUnitTest {

    static String url;
    static String text ;

    @BeforeAll
    static void befoerEach() {
        url = "ya.ru";
        text = "selenide";
    }

    @Test
    void firstTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue(text).pressEnter();
        $("[id=search-result]").shouldHave(text(text));

    }

    @Test
    void secondTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue(text).pressEnter();
        $("[id=search-result]").shouldHave(text(text));
    }

    @Test
    void thidTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue(text).pressEnter();
        $("[id=search-result]").shouldHave(text(text));
    }

}
