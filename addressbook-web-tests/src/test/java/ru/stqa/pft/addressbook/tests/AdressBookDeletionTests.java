package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AdressBookDeletionTests extends TestBase {

    @Test
    public void AdressBookDeletionTests() {
        app.getUsersHelper().selectUser();
        app.getUsersHelper().acceptDeletion();
    }
}
    

