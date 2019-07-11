/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
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
package org.mybatis.jpetstore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class DriverInitializer {

  private static Properties properties = null;

  static {
    try {
      properties = new Properties();
      properties.load(DriverInitializer.class.getClassLoader().getResourceAsStream("application.properties"));
      System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.path"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static WebDriver getDriver(String browser) {
    WebDriver driver = null;
    switch (getProperty("browser")) {
      case "chrome":
        driver = new ChromeDriver();
        break;
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        driver = new ChromeDriver();
    }
    return driver;
  }

  public static String getProperty(String key) {
    return properties == null ? null : properties.getProperty(key, "");
  }
}