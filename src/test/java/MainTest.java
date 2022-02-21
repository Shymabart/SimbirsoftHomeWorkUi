import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MailMainPage;
import pageObject.MessageWindow;
import pageObject.YandexStartPage;
import properties.ConfProperties;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static YandexStartPage yandexStartPage;
    public static MailMainPage mailMainPage;
    public static MessageWindow messageWindow;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        yandexStartPage = new YandexStartPage(driver);
        mailMainPage = new MailMainPage(driver);
        messageWindow = new MessageWindow(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS).pageLoadTimeout(10, TimeUnit.SECONDS).setScriptTimeout(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void changeCountMessage() {
        //логинемся
        yandexStartPage.inputAllRegInfo();
        int countTitleBefore = mailMainPage.getTitleSize();
        //нажимаем кнопку "Отправить сообщениие"
        mailMainPage.sendMassage();
        //отправляем сообщение себе
        messageWindow.inputEmail();
        //это действие необходимо,чтоб обновился шильдик сообщений и мы могли его корректно распарсить
        mailMainPage.canceledCheckbox();
        //считаем кол-во писем с темой "Simbirsoft Theme" после отправки письма
        int countTitleAfter = mailMainPage.getTitleSize();
        Assert.assertEquals("Кол-во тем на 1",countTitleBefore+1,countTitleAfter);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit(); }
}