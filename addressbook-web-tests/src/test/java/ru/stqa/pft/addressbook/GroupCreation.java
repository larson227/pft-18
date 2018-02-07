package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreation extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("sdf", "sdf", "sdf"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
