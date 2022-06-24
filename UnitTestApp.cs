using System;
using NUnit.Framework;
using OpenQA.Selenium.Remote;
using System.Threading;

namespace AppTest
{
    public class Tests
    {
        public DesiredCapabilities capabilities;
        public RemoteWebDriver driver;

        [SetUp]
        public void Setup()
        {
            capabilities = new DesiredCapabilities();
            capabilities.SetCapability("fullreset", false);
            capabilities.SetCapability("platformName", "android");
            capabilities.SetCapability("uiautomator2ServerInstallTimeout", "100000");
            capabilities.SetCapability("platformVersion", "10");
            capabilities.SetCapability("deviceName", "Galaxy A11");
            capabilities.SetCapability("automationName", "UiAutomator2");
            capabilities.SetCapability("newCommandTimeout", "1000");
            capabilities.SetCapability("appActivity", "com.atlasv.android.mvmaker.mveditor.SplashActivity");
            capabilities.SetCapability("newCommandTimeout", "1000");
            capabilities.SetCapability("appPackage", "vidma.video.editor.videomaker");
            capabilities.SetCapability("autoGrantPermissions", false);
            capabilities.SetCapability("noReset", true);
            driver = new RemoteWebDriver(new Uri("http://127.0.0.1:4723/wd/hub"), capabilities);
        }

        [Test]
        public void TestEditor()
        {
            Thread.Sleep(5000);
            driver.FindElementById("vidma.video.editor.videomaker:id/ivAdd").Click();
            Thread.Sleep(3000);
            driver.FindElementsById("vidma.video.editor.videomaker:id/ivIcon")[6].Click();
            Thread.Sleep(3000);
            driver.FindElementById("vidma.video.editor.videomaker:id/tvNext").Click();
            Thread.Sleep(3000);
            driver.FindElementById("vidma.video.editor.videomaker:id/ivBack");
        }

        [TearDown]
        public void TearDown()
        {
            driver.Quit();
        }
    }
}