package com.nametest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

/**
 * Created by andrei on 17.07.17.
 */
class RunnableThread implements Runnable {
    private Thread t;
    private String threadName;

    RunnableThread( String name) {
        threadName = name;
    }

    public void run() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/lin/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/screenshots");

        WebElement setALinkTest = driver.findElementById("screenshots");
        setALinkTest.click();
        setALinkTest.clear();
        setALinkTest.sendKeys("https://de.nametests.com/");

        WebElement peakIPadAir = driver.findElementByCssSelector("a[device='iPad Air']");
        peakIPadAir.click();

        WebElement generateScreenshotsTest = driver.findElementById("btnSnapshot");
        generateScreenshotsTest.click();

        WebDriverWait waitLogin = new WebDriverWait(driver, 10, 1000);
        waitLogin.until(ExpectedConditions.elementToBeClickable(By.id("user_email_login"))).click();
        WebElement setAnEmail = driver.findElementById("user_email_login");
        setAnEmail.click();
        setAnEmail.clear();
        setAnEmail.sendKeys("andrei.suvorkov@socialsweethearts.de");

        WebElement setAPassword = driver.findElementById("user_password");
        setAPassword.click();
        setAPassword.clear();
        setAPassword.sendKeys("Rim_2707");

        WebElement signIn = driver.findElementById("user_submit");
        signIn.click();

        // **************************************************Normal work************************************************
        // **********************************************Desktop Screenshots********************************************
        WebDriverWait wait = new WebDriverWait(driver, 20, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("screenshots"))).click();
        WebElement setALink = driver.findElementById("screenshots");
        setALink.click();
        setALink.clear();

        int testNumber = Integer.parseInt(threadName);
        String linkName;
        switch (testNumber){
            case 1: linkName = "https://de.nametests.com/"; break;
            case 2: linkName = "https://de.nametests.com/test/welche-freunde-sind-deine-blumen/17786/"; break;
            case 3: linkName = "https://de.nametests.com/test/result/johannes/slm_5900435341/?redir=no"; break;
            case 4: linkName = "https://de.nametests.com/test/forwarded/29781/welche-freunde-sind-/nichts-macht-dich-so/slm_5900435341/"; break;
            case 5: linkName = "https://de.nametests.com/test/result/johannes/slm_5900435341/index_new/"; break;
            case 6: linkName = "https://de.nametests.com/test/result/lisa/ps_5900133572/index_new/b/"; break;
            default: linkName = "invalid testNumber"; break;
        }
        setALink.sendKeys(linkName);

        WebElement clearAllBrowsers = driver.findElementByClassName("icon-cross");
        clearAllBrowsers.click();

        WebElement peakDesktop = driver.findElementByCssSelector("a[os='Windows'][browser_version='50.0']");
        peakDesktop.click();

        int numberOfAvailableDownloads = 0;
        while (numberOfAvailableDownloads != 1) {
            WebDriverWait waitOfGenerateBtn = new WebDriverWait(driver, 30, 5000);
            waitOfGenerateBtn.until(ExpectedConditions.elementToBeClickable(By.id("btnSnapshot"))).click();
            WebElement generateScreenshots = driver.findElementById("btnSnapshot");
            generateScreenshots.click();

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (generateScreenshots.isDisplayed()){
                generateScreenshots.click();
            }

            if (numberOfAvailableDownloads != 1) {
                WebDriverWait waitForUp = new WebDriverWait(driver, 30, 1000);
                waitForUp.until(ExpectedConditions.elementToBeClickable(By.className("up")));
                WebElement up = driver.findElementByClassName("up");
                up.click();
            }

            WebDriverWait waitScreenshotsOneMoreTime = new WebDriverWait(driver, 800, 10000);
            waitScreenshotsOneMoreTime.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("a[title='Live Test on BrowserStack']"), 1));
            numberOfAvailableDownloads = driver.findElementsByCssSelector("a[title='Download']").size();
        }

        if (linkName == "https://de.nametests.com/test/result/johannes/slm_5900435341/index_new/"){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait waitToZIP = new WebDriverWait(driver, 20, 1000);
            waitToZIP.until(ExpectedConditions.elementToBeClickable(By.id("zipper")));
            WebElement zipper = driver.findElementById("zipper");
            zipper.click();
        }else {
            WebDriverWait waitToDownload = new WebDriverWait(driver, 20, 1000);
            waitToDownload.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='win10']")));
            WebElement desktop = driver.findElementByCssSelector("a[href*='win10']");
            desktop.click();
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // *******************************************Samsung Screenshots***********************************************
        WebElement peakDesktop2 = driver.findElementByCssSelector("a[os='Windows'][browser_version='50.0']");
        peakDesktop2.click();
        WebElement peakSamsung = driver.findElementByCssSelector("a[device='Samsung Galaxy S5']");
        peakSamsung.click();

        numberOfAvailableDownloads = 0;
        while (numberOfAvailableDownloads != 1) {
            WebDriverWait waitOfGenerateBtn2 = new WebDriverWait(driver, 30, 5000);
            waitOfGenerateBtn2.until(ExpectedConditions.elementToBeClickable(By.id("btnSnapshot"))).click();
            WebElement generateScreenshots2 = driver.findElementById("btnSnapshot");
            generateScreenshots2.click();

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (generateScreenshots2.isDisplayed()){
                generateScreenshots2.click();
            }

            if (numberOfAvailableDownloads != 1) {
                WebDriverWait waitForUp = new WebDriverWait(driver, 30, 1000);
                waitForUp.until(ExpectedConditions.elementToBeClickable(By.className("up")));
                WebElement up = driver.findElementByClassName("up");
                up.click();
            }

            WebDriverWait waitScreenshotsOneMoreTime2 = new WebDriverWait(driver, 800, 10000);
            waitScreenshotsOneMoreTime2.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("a[title='Live Test on BrowserStack']"), 1));
            numberOfAvailableDownloads = driver.findElementsByCssSelector("a[title='Download']").size();
        }

        if (linkName == "https://de.nametests.com/test/result/johannes/slm_5900435341/index_new/"){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait waitToZIP = new WebDriverWait(driver, 20, 1000);
            waitToZIP.until(ExpectedConditions.elementToBeClickable(By.id("zipper")));
            WebElement zipper = driver.findElementById("zipper");
            zipper.click();
        }else {
            WebDriverWait waitToDownloadSamsung = new WebDriverWait(driver, 20, 1000);
            waitToDownloadSamsung.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='Samsung-Galaxy']")));
            WebElement samsung = driver.findElementByCssSelector("a[href*='Samsung-Galaxy']");
            samsung.click();
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // **********************************************iPad Screenshots***********************************************
        WebElement peakSamsung2 = driver.findElementByCssSelector("a[device='Samsung Galaxy S5']");
        peakSamsung2.click();
        WebElement peakIPadMini = driver.findElementByCssSelector("a[device='iPad Mini 2']");
        peakIPadMini.click();

        numberOfAvailableDownloads = 0;
        while (numberOfAvailableDownloads != 1) {
            WebDriverWait waitOfGenerateBtn3 = new WebDriverWait(driver, 30, 5000);
            waitOfGenerateBtn3.until(ExpectedConditions.elementToBeClickable(By.id("btnSnapshot"))).click();
            WebElement generateScreenshots3 = driver.findElementById("btnSnapshot");
            generateScreenshots3.click();

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (generateScreenshots3.isDisplayed()){
                generateScreenshots3.click();
            }

            if (numberOfAvailableDownloads != 1) {
                WebDriverWait waitForUp = new WebDriverWait(driver, 30, 1000);
                waitForUp.until(ExpectedConditions.elementToBeClickable(By.className("up")));
                WebElement up = driver.findElementByClassName("up");
                up.click();
            }

            WebDriverWait waitScreenshotsOneMoreTime3 = new WebDriverWait(driver, 800, 10000);
            waitScreenshotsOneMoreTime3.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("a[title='Live Test on BrowserStack']"), 1));
            numberOfAvailableDownloads = driver.findElementsByCssSelector("a[title='Download']").size();
        }

        if (linkName == "https://de.nametests.com/test/result/johannes/slm_5900435341/index_new/"){
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait waitToZIP = new WebDriverWait(driver, 20, 1000);
            waitToZIP.until(ExpectedConditions.elementToBeClickable(By.id("zipper")));
            WebElement zipper = driver.findElementById("zipper");
            zipper.click();
        }else {
            WebDriverWait waitToDownloadIPad = new WebDriverWait(driver, 10, 1000);
            waitToDownloadIPad.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='iPad-Mini']")));
            WebElement iPad = driver.findElementByCssSelector("a[href*='iPad-Mini']");
            iPad.click();
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    public void start () {
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class seleniumWebDriverThreads {

    public static void main(String args[]) {
        RunnableThread R1 = new RunnableThread( "1");
        R1.start();
        RunnableThread R2 = new RunnableThread( "2");
        R2.start();
        RunnableThread R3 = new RunnableThread( "3");
        R3.start();
        RunnableThread R4 = new RunnableThread( "4");
        R4.start();
        RunnableThread R5 = new RunnableThread( "5");
        R5.start();
        RunnableThread R6 = new RunnableThread( "6");
        R6.start();
    }
}
