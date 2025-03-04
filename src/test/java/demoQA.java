import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class demoQA {

    @BeforeAll
        static void BeforeAll() {
            //Configuration.browser = "Edge";
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserSize = "1920x2000";
            Configuration.baseUrl = "https://demoqa.com";
        }

    @Test
    void FormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Andrew");
        $("#lastName").setValue("Tek");
        $("#userEmail").setValue("andrew@exp.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2024");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__month").$(byText("9")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $(byText("Sports")).click();
        File fileToUpload = new File("src/test/resources/file.jpg");
        $("#uploadPicture").uploadFile(fileToUpload);
        $("#currentAddress").setValue("st.Pushkin");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

    }
}