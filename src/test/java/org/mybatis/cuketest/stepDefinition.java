/**
 *    Copyright 2010-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.cuketest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class stepDefinition {
  WebDriver webDriver = null;

  @Given("^I open chrome browser$")
  public void iOpenChromeBrowser() throws Throwable {
    webDriver = DriverInitializer.getDriver("chrome");
  }

  @When("^I navigate to index\\.html page$")
  public void iNavigateToLoginHtmlPage() throws Throwable {
    webDriver.get(DriverInitializer.getProperty("login.url"));
  }

  @When("^I provide username as hi and password as hi$")
  public void iProvideUsernameAsHiAndPasswordAsHi() throws Throwable {
    WebElement webElement = webDriver.findElement(By.id("username"));
    webElement.sendKeys("hi");
    webElement = webDriver.findElement(By.id("password"));
    webElement.sendKeys("hi");
  }

  @When("^I click on login button$")
  public void iClickOnLoginButton() throws Throwable {
    WebElement webElement = webDriver.findElement(By.id("login-btn"));
    webElement.click();
  }

}
