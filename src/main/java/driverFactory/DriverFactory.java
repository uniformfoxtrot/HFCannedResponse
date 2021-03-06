package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

	private static final DriverFactory instance = new DriverFactory();

	private DriverFactory() {
	}

	public static DriverFactory getInstance() {
		return instance;
	}


	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();


	public WebDriver getDriver(String browser) {
		if (threadLocal.get() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				threadLocal.set(new ChromeDriver());

			} else if (browser.equalsIgnoreCase("firefox")) {
				threadLocal.set(new FirefoxDriver());

			}
		}
		return threadLocal.get();
	}

	public WebDriver getDriver(String browser, ChromeOptions options) {
		if (threadLocal.get() == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				// ChromeOptions options = new ChromeOptions();
				threadLocal.set(new ChromeDriver(options));

			}

		}
		return threadLocal.get();
	}
}