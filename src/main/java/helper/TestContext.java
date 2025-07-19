package helper;


import enums.DriverType;
import objectmanager.DriverManager;
import objectmanager.FileReaderManager;
import objectmanager.PageObjectManager;

public class TestContext {
        private final ScenarioContext scenarioContext;
        private final DriverType driverType =
                FileReaderManager.getInstance().getConfigReader().getBrowser();
        private DriverManager driverManager = null;
        private PageObjectManager pageObjectManager = null;

        public TestContext() {
            String driver = driverType.toString();
            if (!driver.equalsIgnoreCase("NONE")) {
                driverManager = new DriverManager();
                pageObjectManager = new PageObjectManager(driverManager.getDriver());
            }
            scenarioContext = new ScenarioContext();
        }

        public DriverManager getWebDriverManager() {
            return driverManager;
        }

        public PageObjectManager getPageObjectManager() {
            return pageObjectManager;
        }

        public ScenarioContext getScenarioContext() {
            return scenarioContext;
        }
    }


