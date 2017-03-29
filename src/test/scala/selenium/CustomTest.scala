package selenium

import java.util.concurrent.TimeUnit
import org.openqa.selenium.{WebElement, By}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.FlatSpec
import org.openqa.selenium.support.ui.Select

class CustomTest extends FlatSpec with TestSetUp {

  "A user" should "visit on myntra.com" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
    if (driver.getCurrentUrl == BASE_URL) {
      println("WELCOME TO Myntra.com with title : " + title)
      println("the lenght of the pagesource is: " + page_source)
    } else {
      println("something went wrong")
    }
  }

  "user" should "fail to login with invalid credentials" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys("abc@gmail.com")

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys("xyz")

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "logged in " in {

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys(EMAIl)

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys(password)

    driver.findElementByCssSelector("button.login-login-button").click()
  }

  "user" should "select category" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    driver.findElement(By.cssSelector("a[href='/tops-and-tees-menu?src=bNav']")).click()
  }

  "user" should "select a top" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }



  "user" should "be able to choose the desired size of the selected top and then add it to the cart" in {

    driver.findElementByCssSelector("button.size-buttons-size-button.size-buttons-size-button-default").click()

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()
  }

  "user" should "search for sunglass category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.desktop-searchBar")))

    val search: WebElement = driver.findElementByCssSelector("input.desktop-searchBar")
    search.sendKeys("sunglasses")
    driver.findElementByCssSelector("a.desktop-submit").click()
  }


  "user" should "select a sunglass" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-base a:nth-child(2)")))

    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to add the sunglass to the cart" in {

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()

  }


  "user" should "be able to verify the products added to cart" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

  "user" should "be able to add mailing address" in {


    driver.findElementByCssSelector("div.order-total.footer div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable").click()

    driver.findElementByCssSelector("input.pincode").sendKeys("201012")

    driver.findElementById("locality").click()
    Thread.sleep(3000)
    driver.findElementById("locality").sendKeys("Vasundhra")
    driver.findElementByCssSelector("input.locality").click()
    driver.findElementByCssSelector("input.name").sendKeys("Shivangi Gupta")
    driver.findElementByCssSelector("textarea.address").sendKeys("Block No. 10, House No 9")
    driver.findElementByCssSelector("input.mobile").sendKeys("9999999999")
    driver.findElementByCssSelector("button.green-button.submit.clickable").click()
    Thread.sleep(3000)
    driver.close()
  }
}
