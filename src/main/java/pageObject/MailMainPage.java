package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MailMainPage {
    private WebDriver driver;
    public MailMainPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.driver = driver;
    }
    /**
     * Боковое меню.Кнопка "Входящие"
     */
    @FindBy(xpath = "//a[@class='mail-NestedList-Item mail-Tabs-Item mail-Tabs-Item_relevant js-tabs-item js-valid-drag-target js-tab-relevant mail-NestedList-Item_current']")
    private WebElement incomingButton;

    /**
     * Боковое меню.Кнопка "Написать"
     */
    @FindBy(xpath = "//a[@class='mail-ComposeButton js-main-action-compose']")
    private WebElement sendMassage;

    /**
     * Колличество писем
     */
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/div[1]/a/div[2]/span")
    private WebElement mailCount;

    /**
     * Перезагружаем страницу
     */
    @FindBy(xpath = "//span[@class='mail-ComposeButton-Refresh js-main-action-refresh ns-action']")
    private WebElement reloadPage;

    /**
     * Отметить как прочитанное
     */
    @FindBy(xpath = "//span[@class=' js-read-toggleable mail-MessageSnippet-Item mail-MessageSnippet-Item_read state_toRead']")
    private WebElement asReaded;
    /**
     * Тайтлы Simbirsoft theme
     */
    @FindBy(xpath = "//span[@title='Simbirsoft theme' and text()='Simbirsoft theme']")
    private List<WebElement> titleSimbirsoft;


    /**
     * Нажимаем кнопку "Отправить письмо"
     */
    public void sendMassage(){
       sendMassage.click();
    }
    /**
     * Получаем колличество писем
     */
    public String getMailCount(){
        return mailCount.getText();
    }
    /**
     * Нажимаем кнопку "Отправить письмо"
     */
    public void setAsReaded(){
        asReaded.click();
    }

    /**
     * Нажимаем кнопку "Отметить как прочитанное"
     */
    public void setReloadPage(){
        reloadPage.click();
    }

    /**
     * Нажимаем кнопку "Отметить как прочитанное" и перезагружаем страницу
     */
    public void canceledCheckbox(){
        setReloadPage();
        setAsReaded();
        setReloadPage();
    }
    /**
     * Получаем колличество писем с тайтлом Simbirsoft
     */
    public int getTitleSize() {
        int i = titleSimbirsoft.size();
        return i;
    }
}
