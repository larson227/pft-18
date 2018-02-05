package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class GroupCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void GroupCreationTests() {
        wd.get("http://localhost/addressbook/group.php");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("\\undefined");
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
        wd.findElement(By.cssSelector("html")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("body"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]"))).build().perform();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']//form[normalize-space(.)='']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("hr"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("new"))).build().perform();
        wd.findElement(By.name("new")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("group_name"))).build().perform();
        wd.findElement(By.name("group_name")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("group_header"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("group_name"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("group_header"))).build().perform();
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("sdf");
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("sdfsdf");
        new Actions(wd).moveToElement(wd.findElement(By.name("group_footer"))).build().perform();
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("sdf");
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']/form"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("submit"))).build().perform();
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).sendKeys("\\undefined");
        wd.findElement(By.name("submit")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("html"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("footer"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='footer']//li[.='php-addressbook v8.2.5']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.msgbox"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("group page"))).build().perform();
        wd.findElement(By.linkText("group page")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='content']//form[normalize-space(.)='sdf']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("span.group"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("body"))).build().perform();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
