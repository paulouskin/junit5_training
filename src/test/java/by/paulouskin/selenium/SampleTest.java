package by.paulouskin.selenium;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    static WebDriver wd;

    @BeforeAll
    public static void setUp() {
        wd = new ChromeDriver();
        wd.get("http://www.google.com");
    }

    @Test
    public void RunChromeBrowser() {
        Assert.assertEquals("Google",wd.getTitle());
    }

    @AfterAll
    public static void tearDown() {
        wd.close();
    }
}
