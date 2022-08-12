import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void myFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vladislav");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("petrov.v.g@bk.com");
        $("[for=\"gender-radio-1\"]").click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $("[class=\"react-datepicker__day react-datepicker__day--030\"]").click();
        $("[id=\"subjectsInput\"]").setValue("En").pressEnter();
        $("[class=\"custom-control custom-checkbox custom-control-inline\"]").click();
        $("[id=\"uploadPicture\"]").uploadFile(new File("src/test/resources/file2.png"));
        $("[id=\"currentAddress\"").setValue("Samara, Aerodromnaya, 36");
        $("#react-select-3-input").scrollTo().setValue("Harya").pressEnter();
        $("#react-select-4-input").setValue("Panip").pressEnter();
        $("#submit").scrollIntoView(false).pressEnter();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Vladislav"),
                text("Petrov"),
                text("petrov.v.g@bk.com"),
                text("8005553535"),
                text("30 July,1996"),
                text("English"),
                text("Sports"),
                text("file2.png"),
                text("Samara, Aerodromnaya, 36"),
                text("Haryana Panipat"));


    }
}
