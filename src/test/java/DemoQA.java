import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQA {

    @BeforeAll
        static void beforeAll() {
            //Configuration.browser = "Edge";
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserSize = "1920x2000";
            Configuration.baseUrl = "https://demoqa.com";
        }

    @Test
    void formTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");//Закрывают баннеры
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Andrew");
        $("#lastName").setValue("Tek");
        $("#userEmail").setValue("andrew@exp.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2024");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__month").$(byText("9")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("file.jpg"); //более короткий способ
        //File fileToUpload = new File("src/test/resources/file.jpg");
        //$("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("st.Pushkin");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Andrew Tek"));
        $(".modal-body").shouldHave(text("andrew@exp.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("09 October,2024"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("file.jpg"));
        $(".modal-body").shouldHave(text("st.Pushkin"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
    }
}