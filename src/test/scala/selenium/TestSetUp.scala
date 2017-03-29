package selenium

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait


trait TestSetUp {

  val BASE_URL = "http://www.myntra.com/"
  val EMAIl = "shivangi1015@gmail.com"
  val password = "shivangi1015"
  System.setProperty("webdriver.chrome.driver", "/home/knoldus/application/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 10)



}
