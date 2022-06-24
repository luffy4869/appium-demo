# coding=utf-8
import time
import unittest
from appium import webdriver


class MyTestCase(unittest.TestCase):
    def setUp(self):
        desired_caps = {
            "fullreset": False,
            "platformName": "android",
            "uiautomator2ServerInstallTimeout": "100000",
            "platformVersion": "10",
            "deviceName": "Galaxy A11",
            "automationName": "UiAutomator2",
            "newCommandTimeout": "1000",
            "appActivity": "com.atlasv.android.mvmaker.mveditor.SplashActivity",
            "appPackage": "vidma.video.editor.videomaker",
            "autoGrantPermissions": False,
            "noReset": True
        }
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_caps)

    def testOpenEditor(self):
        time.sleep(5)
        self.driver.find_element_by_id("vidma.video.editor.videomaker:id/ivAdd").click()
        time.sleep(3)
        self.driver.find_elements_by_id("vidma.video.editor.videomaker:id/ivIcon")[6].click()
        time.sleep(3)
        self.driver.find_element_by_id("vidma.video.editor.videomaker:id/tvNext").click()
        time.sleep(3)
        self.driver.find_element_by_id("vidma.video.editor.videomaker:id/ivBack").click()

    def tearDown(self):
        self.driver.quit()


if __name__ == '__main__':
    unittest.main()
