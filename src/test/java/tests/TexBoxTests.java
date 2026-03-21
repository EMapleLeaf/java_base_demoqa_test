package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TexBoxTests extends TestBase {

    String userName;
    String userEmail;
    String currentAddress;
    String permanentAddress ;

    @BeforeEach
    public void setup() {
        // userName = getRandomString(10);
        userName = "Maple Leaf";
        userEmail = "maple@leaf.com";
        currentAddress  = "first address 1";
        permanentAddress = "second address 2";
    }

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue(userName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text(userName));
        $("[id=output] [id=email]").shouldHave(text(userEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));


    }
}
