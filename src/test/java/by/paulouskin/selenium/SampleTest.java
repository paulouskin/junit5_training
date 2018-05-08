package by.paulouskin.selenium;

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
    }

    @Test
    public void RunChromeBrowser() {
        wd.get("http://www.google.com");
    }

    @AfterAll
    public static void tearDown() {
        wd.close();
    }
}
