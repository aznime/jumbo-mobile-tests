import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

class UICatalogScreen {
    UICatalogWidget uiCatalogWidget

    UICatalogScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this)
    }

    boolean isActionSheetsDisplayed() {
        uiCatalogWidget.text == 'Action Sheets'
    }
}
