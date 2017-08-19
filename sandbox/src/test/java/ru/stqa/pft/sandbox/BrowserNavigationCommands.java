package ru.stqa.pft.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Denis on 27.05.2017.
 */
public class BrowserNavigationCommands {

    @Test
    public void testNavigation() throws InterruptedException {

        //  <input id="name_3_firstname" class="input_fields piereg_validate[required] input_fields" type="text" name="first_name" value=""/>
        String getId;
        String getEverything;
        String getClass;
        String getType;
        String getName;
        String getValue;
        String getTagName;

        FirefoxDriver wd;
        String url = "http://demoqa.com/";

        wd = new FirefoxDriver();


        //Go to Home
        wd.navigate().to(url);
        //Wait for 3 Sec
        Thread.sleep(3);

        //Go to Registration page
        wd.findElement(By.xpath(".//*[@id=\"menu-item-374\"]/a")).click();
        //Wait for 3 Sec
        Thread.sleep(3);

        //Check if Registration page is opened
        WebElement element = wd.findElement(By.xpath(".//*[@id=\"name_3_firstname\"]"));
        //Wait for 3 Sec
        Thread.sleep(3);

        getId = element.getAttribute("id");
        getEverything = element.toString();
        getClass = element.getAttribute("class");
        getType = element.getAttribute("type");
        getName = element.getAttribute("Name");
        getValue = element.getAttribute("Value");
        getTagName = element.getTagName();
        //Back to Home
        wd.navigate().back();
        //Wait for 3 Sec
        Thread.sleep(3);

        //Forward to Registration page
        wd.navigate().forward();
        //Wait for 3 Sec
        Thread.sleep(3);


        //Back to Home
        wd.navigate().to(url);
        //Wait for 3 Sec
        Thread.sleep(3);

        //Refresh
        //  wd.navigate().refresh();
        //Wait for 3 Sec
        Thread.sleep(3);



        System.out.println("id");
        System.out.println(getId);
        System.out.println("class");
        System.out.println(getClass);
        System.out.println("type");
        System.out.println(getType);
        System.out.println("name");
        System.out.println(getName);
        System.out.println("value");
        System.out.println(getValue);
        System.out.println("TagName");
        System.out.println(getTagName);

        System.out.println("Everything");
        System.out.println(getEverything);



        //End
        wd.quit();


    }


}
