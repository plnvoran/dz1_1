package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.openqa.selenium.remote.BrowserType.CHROME;

/**
 * Created by Denis on 18.03.2017.
 */
public class TestBase {
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {

        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info ("Start test "+ m.getName() + "with parametres "+Arrays.asList(p));
    }
    @AfterMethod (alwaysRun=true)
    public void logTestStop(Method m){
        logger.info ("Stop test "+ m.getName());
    }

}
