package objectmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {
    WebDriver driver;
    WebDriverWait wait;

    public WaitManager(WebDriver driver){
        this.driver=driver;
    }

    public void applyImplicitWait(int waitTime){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
    }
    public WebDriverWait applyExplicitWait(int waitTime){
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait;
    }
    public void applyWait(long waitTime) throws InterruptedException {
        Thread.sleep(waitTime);
    }
}
