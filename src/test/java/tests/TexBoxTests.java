package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TexBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {
        String boxUserName = "Maple Leaf";
        String boxUserEmail = "maple@leaf.com";
        String boxCurrentAddress = "first address 1";
        String boxPermanentAddress = "second address 2";

        textBoxPage.openPage()
                .typeUserName(boxUserName)
                .typeUserEmail(boxUserEmail)
                .typeCurrentAddress(boxCurrentAddress)
                .typePermanentAddress(boxPermanentAddress)
                .submitForm()
                .checkField("name", boxUserName)
                .checkField("email", boxUserEmail)
                .checkField("currentAddress", boxCurrentAddress)
                .checkField("permanentAddress", boxPermanentAddress);

    }
}
