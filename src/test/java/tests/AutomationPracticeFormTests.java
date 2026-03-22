package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.city;
import static tests.testdata.TestData.currentAddress;
import static tests.testdata.TestData.dateOfBirth;
import static tests.testdata.TestData.fileName;
import static tests.testdata.TestData.firstName;
import static tests.testdata.TestData.hobbyMusicName;
import static tests.testdata.TestData.hobbyReadingName;
import static tests.testdata.TestData.hobbySportName;
import static tests.testdata.TestData.lastName;
import static tests.testdata.TestData.monthOfBirth;
import static tests.testdata.TestData.sexName;
import static tests.testdata.TestData.state;
import static tests.testdata.TestData.subjectName;
import static tests.testdata.TestData.userEmail;
import static tests.testdata.TestData.userNumber;
import static tests.testdata.TestData.yearOfBirth;

public class AutomationPracticeFormTests extends TestBase {

    @Test
    void successfulFillPracticeFormTest() {
        open("/automation-practice-form");

        // удаляем рекламные баннеры
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-3").click();
        $("#userNumber").setValue(userNumber);


        $("#dateOfBirthInput").click();
        executeJavaScript("arguments[0].value = '';", $("#dateOfBirthInput"));
        $("#dateOfBirthInput").sendKeys(dateOfBirth + " " + monthOfBirth + " " + yearOfBirth);
        $("#dateOfBirthInput").pressEnter();
//        $("#dateOfBirthInput").$("select.react-datepicker__month-select").selectOption(11);
//        $("#dateOfBirthInput").setValue("01 Mar 2014").pressEnter();

        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("maple.jfif");

        $("#subjectsContainer #subjectsInput").click();
        $("#subjectsContainer #subjectsInput").setValue("c");
        $("#subjectsContainer").$(byText(subjectName)).click();

        $("#currentAddress").setValue(currentAddress);

        $("#react-select-3-input").click();
        $("#state").$(byText(state)).click();

        $("#react-select-4-input").click();
        $("#city").$(byText(city)).click();

        $("#submit").click();


        $("div.modal-body").shouldHave(text(firstName));
        $("div.modal-body").shouldHave(text(lastName));
        $("div.modal-body").shouldHave(text(userEmail));
        $("div.modal-body").shouldHave(text(sexName));
        $("div.modal-body").shouldHave(text(userNumber));

        $("div.modal-body").shouldHave(text(dateOfBirth));
        $("div.modal-body").shouldHave(text(yearOfBirth));

        $("div.modal-body").shouldHave(text(hobbySportName));
        $("div.modal-body").shouldHave(text(hobbyReadingName));
        $("div.modal-body").shouldHave(text(hobbyMusicName));
        $("div.modal-body").shouldHave(text(fileName));


        $("div.modal-body").shouldHave(text(subjectName));
        $("div.modal-body").shouldHave(text(currentAddress));
        $("div.modal-body").shouldHave(text(state));
        $("div.modal-body").shouldHave(text(city));


    }
}
