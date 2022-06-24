// javascript
const webdriver = require("webdriverio");
const sleep = require("sleep");
const caps = {
    path: '/wd/hub',
    port: 4723,
    capabilities: {
        fullreset: false,
        platformName: "android",
        uiautomator2ServerInstallTimeout: 100000,
        platformVersion: "10",
        deviceName: "Galaxy A11",
        automationName: "UiAutomator2",
        newCommandTimeout: 1000,
        appActivity: "com.atlasv.android.mvmaker.mveditor.SplashActivity",
        appPackage: "vidma.video.editor.videomaker",
        autoGrantPermissions: false,
        noReset: true
    }
};


async function main() {
    const client = await webdriver.remote(caps);
    sleep.sleep(5);
    await client.$("id=vidma.video.editor.videomaker:id/ivAdd").click()
    sleep.sleep(3);
    await client.$$("id=vidma.video.editor.videomaker:id/ivIcon")[1].click();
    sleep.sleep(3);
    await client.$("id=vidma.video.editor.videomaker:id/tvNext").click();
    sleep.sleep(3);
    await client.$("id=vidma.video.editor.videomaker:id/ivBack").click();
    client.closeApp();
}

main().then(() => console.log("执行完成！"));