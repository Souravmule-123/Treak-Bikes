    package objectmanager;

    import enums.DriverType;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;


    public class DriverManager {

    private final DriverType driverType;
    private WebDriver driver;

    public DriverManager(){
    driverType=FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver(){
    String type=driverType.toString();
        if (driver == null && !type.equals("none")) driver = createDriver();
        return driver;
    }

  private WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    switch (driverType) {
      case FIREFOX:
        driver = new ChromeDriver();
        break;
      case CHROME:
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        break;
        case CHROMEHEADLESS:
      WebDriverManager.chromedriver().setup();
            options.addArguments("--headless", "--window-size=1366,768");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            break;
        case EDGE:
            WebDriverManager.chromedriver().setup();
            driver=new EdgeDriver();
            break;
        case CHROMEINCOGNITO:
            WebDriverManager.chromedriver().setup();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
            break;
      default:
//        log.info("No option available");
    }
      Boolean windowSize = FileReaderManager.getInstance().getConfigReader().getWindowBrowserSize();
      if (Boolean.TRUE.equals(windowSize)) {
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      }
      return driver;
  }

    public void closeDriver(){
    driver.close();
    driver.quit();
    }
    }
