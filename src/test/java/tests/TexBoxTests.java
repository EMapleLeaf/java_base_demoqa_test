package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TexBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        //Configuration.browserVersion = "144.0";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000; //default 4000
    }

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("Maple Leaf");
        $("[id=userEmail]").setValue("maple@leaf.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Maple Leaf"));
        $("[id=output] [id=email]").shouldHave(text("maple@leaf.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));


    }
}
