import io.appium.java_client.ios.IOSElement
import io.appium.java_client.pagefactory.Widget
import io.appium.java_client.pagefactory.iOSFindBy
import org.openqa.selenium.WebElement

@iOSFindBy(uiAutomator = '.tableViews()[0].cells()[0]')
class UICatalogWidget extends Widget {
    @iOSFindBy(uiAutomator = '.staticTexts()[0]')
    IOSElement actionSheets

    @iOSFindBy(uiAutomator = '.staticTexts()[1]')
    IOSElement actionSheetsCtrl

    protected UICatalogWidget(WebElement element) {
        super(element)
    }

    def getText() {
        actionSheets.text.trim()
    }
}
