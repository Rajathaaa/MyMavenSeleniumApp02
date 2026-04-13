/*package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
    }
}
*/

package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// OPTIONAL but recommended
//import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main(String[] args) 
    {
        // 🔥 Automatically manages ChromeDriver (NO PATH ISSUES)
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // 🔥 MUST for Jenkins / CI
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://practicetestautomation.com/practice-test-login/");

            // ❌ Avoid maximize in headless
            // driver.manage().window().maximize();

            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // ✅ Debug output (VERY useful in Jenkins logs)
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

        } finally {
            driver.quit(); // 🔥 MUST (prevents stuck builds)
        }
    }
}
