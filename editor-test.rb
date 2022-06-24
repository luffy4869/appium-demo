require 'appium_lib'
require 'test-unit'

class EditorTest < Test::Unit::TestCase
  def setup
    caps = {}
    caps['fullreset'] = false
    caps['platformName'] = 'Android'
    caps['uiautomator2ServerInstallTimeout'] = '100000'
    caps['platformVersion'] = '10'
    caps['deviceName'] = 'Galaxy A11'
    caps['automationName'] = 'UiAutomator2'
    caps['newCommandTimeout'] = '1000'
    caps['appActivity'] = 'com.atlasv.android.mvmaker.mveditor.SplashActivity'
    caps['appPackage'] = 'vidma.video.editor.videomaker'
    caps['autoGrantPermissions'] = false
    caps['noReset'] = true
    appium_driver = Appium::Driver.new({
                                         'caps' => caps,
                                         'appium_lib' => {
                                           :server_url => "http://127.0.0.1:4723/wd/hub"
                                         } }, true)
    @driver = appium_driver.start_driver
  end

  def test_editor_search
    sleep 5
    @driver.find_element(:id, "vidma.video.editor.videomaker:id/ivAdd").click
    sleep 3
    @driver.find_elements(:id, "vidma.video.editor.videomaker:id/ivIcon")[6].click
    sleep 3
    @driver.find_element(:id, "vidma.video.editor.videomaker:id/tvNext").click
    sleep 3
    @driver.find_element(:id, "vidma.video.editor.videomaker:id/ivBack").click
  end

  def teardown
    @driver.quit
  end
end