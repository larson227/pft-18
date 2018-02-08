package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class AddressBookCreateUserTests extends TestBase {

    @Test
    public void testAddressBookCreateUsers() {
        app.getNavigationHelper().gotoAddressbookPage();
        app.getUsersHelper().initUserCreation();
        app.getUsersHelper().fillUserData(new UserData("First name:", "Middle", "last name", "nickname", "title", "company", "adress"));
        app.getUsersHelper().submitUserCreation();
        app.getUsersHelper().returnToHomePage();
    }
}
