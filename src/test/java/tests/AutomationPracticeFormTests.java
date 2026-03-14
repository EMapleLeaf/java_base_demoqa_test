package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void successfulFillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maple");
        $("#lastName").setValue("Leaf");
        $("#userEmail").setValue("maple@leaf.com");
        $("#gender-radio-3").click();
        $("#userNumber").setValue("9161234567");

        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").$("select.react-datepicker__month-select").selectOption(11);
        $("#dateOfBirthInput").setValue("01 Mar 2014").pressEnter();

        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-3").click();

        $("#subjectsContainer #subjectsInput").setValue("111111111");

        $("#currentAddress").setValue("Tu-lu-la");

        $("#react-select-3-input").click();
        $(byText("Haryana")).click();

        $("#react-select-4-input").click();
        $(byText("Panipat")).click();

        $("#submit").click();


        $("div.modal-body").shouldHave(text("Maple"));
        $("div.modal-body").shouldHave(text("Leaf"));
        $("div.modal-body").shouldHave(text("maple@leaf.com"));
        $("div.modal-body").shouldHave(text("Other"));
        $("div.modal-body").shouldHave(text("9161234567"));

        $("div.modal-body").shouldHave(text("01 Mar 2014"));

        $("div.modal-body").shouldHave(text("Sports"));
        $("div.modal-body").shouldHave(text("Reading"));
        $("div.modal-body").shouldHave(text("Music"));

        $("div.modal-body").shouldHave(text("111111111"));
        $("div.modal-body").shouldHave(text("Tu-lu-la"));
        $("div.modal-body").shouldHave(text("Haryana"));
        $("div.modal-body").shouldHave(text("Panipat"));


    }
}
