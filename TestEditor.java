import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;

public class TestEditor {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("fullreset", false);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", "100000");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "Galaxy A11");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("newCommandTimeout", "1000");
        capabilities.setCapability("appActivity", "com.atlasv.android.mvmaker.mveditor.SplashActivity");
        capabilities.setCapability("newCommandTimeout", "1000");
        capabilities.setCapability("appPackage", "vidma.video.editor.videomaker");
        capabilities.setCapability("autoGrantPermissions", false);
        capabilities.setCapability("noReset", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void openEditor() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementById("vidma.video.editor.videomaker:id/ivAdd").click();
        Thread.sleep(3000);
        driver.findElementsById("vidma.video.editor.videomaker:id/ivIcon").get(6).click();
        Thread.sleep(3000);
        driver.findElementById("vidma.video.editor.videomaker:id/tvNext").click();
        Thread.sleep(3000);
        driver.findElementById("vidma.video.editor.videomaker:id/ivBack").click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
