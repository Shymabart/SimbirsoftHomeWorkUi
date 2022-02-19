package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexStartPage {
    private WebDriver driver;
    public YandexStartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Поле ввода email/телефона
     */
    @FindBy(xpath = "//input[@id='passp-field-login']")
    private WebElement idInput;

    /**
     * Кнопка войти
     */
    @FindBy(xpath = "//button[@id='passp:sign-in']")
    private WebElement enterButton;

    /**
     * Выпадашка с email
     */
    @FindBy(xpath = "//span[@class='CurrentAccount-displayName']")
    private WebElement confirmEmail;

    /**
     * Поле ввода пароля
     */
    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordInput;

    /**
     * Скипаем привязку телефона
     */
    @FindBy(xpath = "//div[@data-t='phone_skip']")
    private WebElement numberSkip;


    /**
     * Вводим email на главной и жмем "Далее"
     */
    public void inputEmail(){
        idInput.click();
        idInput.sendKeys("simbirsoftTest1@yandex.ru");
        enterButton.click();
    }

    /**
     * Получаем текст ил плашки
     */
    public String getTextNotis(){
        return confirmEmail.getText();
    }

    /**
     * Вводим пароль на главной и жмем "Далее"
     */
    public void inputAllRegInfo(){
        idInput.click();
        idInput.sendKeys("simbirsoftTest1@yandex.ru");
        enterButton.click();
        passwordInput.click();
        passwordInput.sendKeys("simbirsoft12345");
        enterButton.click();
//      numberSkip.click();
    }
}
