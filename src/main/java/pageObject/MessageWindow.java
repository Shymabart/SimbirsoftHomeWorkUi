package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessageWindow {
    private WebDriver driver;
    public MessageWindow(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * Инпут ввода email
     */
    @FindBy(xpath = "//div[@class='composeYabbles'][1]")
    private WebElement mailAdressInput;

    /**
     * Инпут ввода темы
     */
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement themeInput;

    /**
     * Инпут ввода Текста сообщения
     */
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textInput;

    /**
     * Кнопка отправить сообщение
     */
    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendMessageButton;

    /**
     * Вернуться во входящие
     */
    @FindBy(xpath = "//a[@class='control link link_theme_normal ComposeDoneScreen-Link']")
    private WebElement returnInMessage;

    /**
     * Колличество писем
     */
    @FindBy(xpath = "//span[@class='mail-NestedList-Item-Info-Extras'][1]")
    private WebElement mailCount;
    public String getMailCount(){
        return mailCount.getText();
        }

    /**
     * Тайтлы Simbirsoft theme
     */
    @FindBy(xpath = "//span[@title='Simbirsoft theme' and text()='Simbirsoft theme']")
    private List<WebElement> titleSimbirsoft;
    /**
     * Получаем колличество писем с тайтлом Simbirsoft
     */
    public int getTitleSize() {
        return titleSimbirsoft.size();
    }
    /**
     * Отправляем сообщение
     */
    public void inputEmail()  {
        themeInput.click();
        themeInput.sendKeys("Simbirsoft theme");
        textInput.click();
        textInput.sendKeys("Найдено " + getTitleSize() + " писем\\ьма");
        mailAdressInput.click();
        mailAdressInput.sendKeys("simbirsoftTest1@yandex.ru");
        sendMessageButton.click();
        returnInMessage.click();
    }
}
