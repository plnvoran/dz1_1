package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Denis on 19.03.2017.
 */
public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;
    private DbHelper dbHelper;



    public ApplicationManager(String browser) {
                this.browser = browser;

        properties=new Properties();
    }


    public void init() throws IOException {
        String target=System.getProperty("target", "local");

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper= new DbHelper();

       if ("".equals(properties.getProperty("selenium.server"))) {
           if (Objects.equals(browser, BrowserType.FIREFOX)) {
               wd = new FirefoxDriver();
           } else if (Objects.equals(browser, BrowserType.CHROME)) {
               wd = new ChromeDriver();
           } else if (Objects.equals(browser, BrowserType.IE)) {
               wd = new InternetExplorerDriver();
           }
       } else {

           DesiredCapabilities  capabilities=new  DesiredCapabilities() ;
           capabilities.setBrowserName (browser );
           wd= new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
       }

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        wd.get(properties.getProperty("web.baseUrl"));
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));


    }



    public void stop() {
        wd.quit();
    }

    public DbHelper db()
    {
        return dbHelper;
    }
    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper conact() {
        return contactHelper;
    }
}
