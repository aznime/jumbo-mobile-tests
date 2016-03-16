import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.IOSElement
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.openqa.selenium.remote.DesiredCapabilities
import spock.lang.Specification

import static io.appium.java_client.remote.MobileCapabilityType.*

class UICatalogSpec extends Specification {
    private IOSDriver<IOSElement> driver;
    private static AppiumDriverLocalService service;

    def setupSpec() {
        service = AppiumDriverLocalService.buildDefaultService()
        service.start()
    }

    def setup() {
        def appDir = new File("src/test/resources")
        def app = new File(appDir, "UICatalog.app.zip");
        def capabilities = new DesiredCapabilities().with {
            setCapability(PLATFORM_VERSION, "9.2");
            setCapability(DEVICE_NAME, "iPhone Simulator");
            setCapability(APP, app.getAbsolutePath());
            it
        }
        driver = new IOSDriver<IOSElement>(service.getUrl(), capabilities);
    }

    def "it should display the action sheets"() {
        when:
        def screen = new UICatalogScreen(driver)

        then:
        assert screen.actionSheetsDisplayed
    }
}

