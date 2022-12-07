package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class C_Locators {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void findElementById() {

        WebDriver driver = getDriver();

        /** Wpisz imię */
        // Zlokalizuj pole Pierwsze imię przy użyciu identyfikatora
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));

        driver.quit();
    }

    @Test
    public void findElementByName() {

        WebDriver driver = getDriver();

        /** Wpisz nazwisko */
        // Zlokalizuj pole Nazwisko, używając "name"
        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));

        driver.quit();
    }

    @Test
    public void findElementByClassName() {

        WebDriver driver = getDriver();

        /** Wybierz opcję */
        // Zlokalizuj radio przyciski z wyborem opcji, używając "className"
        WebElement optionRadioButtonsByClassName = driver.findElement(By.className("option"));

        driver.quit();
    }

    @Test
    public void findElementByTagName() {

        WebDriver driver = getDriver();

        // Zlokalizuj sekcję strony używając "tagName"
        WebElement sectionByTagName = driver.findElement(By.tagName("section"));

        driver.quit();
    }

    @Test
    public void findElementByCssSelector() {

        WebDriver driver = getDriver();

        /** Wybierz opcję */
        // Zlokalizuj radio przyciski z wyborem opcji, używając "cssSelector" po nazwie klasy
        WebElement optionRadioButtonsByCssClass = driver.findElement(By.cssSelector("span[class='wpcf7-form-control wpcf7-radio option']"));
        WebElement optionRadioButtonsByCssClass2 = driver.findElement(By.cssSelector(".option"));

        /** Wybierz opcję */
        // Zlokalizuj radio przyciski z wyborem opcji, używając "cssSelector" po ID
        WebElement optionRadioButtonsByCssId = driver.findElement(By.cssSelector("#option-radio"));
        WebElement optionRadioButtonsByCssId2 = driver.findElement(By.cssSelector("span#option-radio.wpcf7-form-control.wpcf7-radio.option"));

        /** Zgadzam się z polityką prywatności - polityka prywatności */
        // Zlokalizuj link do polityki prywatności po url używając "cssSelector"
        WebElement linkByCssUrl = driver.findElement(By.cssSelector("a[href='https://programautomatycy.pl/privacy-policy/'"));

        driver.quit();
    }

    @Test
    public void findElementByXpath() throws InterruptedException {

        WebDriver driver = getDriver();

        // Sleep jest zastosowany tylko w ramach treningu
        // Metody Sleep nie powinno się używać w docelowych projektach
        Thread.sleep(1000);
        /** Wybierz ulubiony dzień tygodnia */
        // Zlokalizuj wartość "Poniedziałek" w polu rozwijanym używając pełnego "xpath"
        WebElement dayDropBoxByXpathFull = driver.findElement(By.xpath("/html/body/div[2]/div/div/section/div[2]/div/main/article/div/div/div/div/section/div/div/div[1]/div/div/div[2]/div/div/div/form/p[8]/span/select/option[2]"));

        /** Wybierz ulubiony dzień tygodnia */
        // Zlokalizuj wartość "Poniedziałek" w polu rozwijanym używając skróconego "xpath"
        WebElement dayDropBoxByXpathShort = driver.findElement(By.xpath("//select[@id='day-select']/option[2]"));

        /** Wybierz ulubiony dzień tygodnia */
        // Zlokalizuj wartość "Poniedziałek" w polu rozwijanym używając skróconego "xpath" oraz contains
        WebElement dayDropBoxByXpathContains = driver.findElement(By.xpath("//*[contains(@id,'day')]/option[2]"));
        WebElement dayDropBoxByXpathContains2 = driver.findElement(By.xpath("//*[contains(@id,'day')]")).findElement(By.xpath("//*[@value='Poniedziałek']"));

        /** Wybierz opcję */
        // Zlokalizuj radio przyciski z wyborem opcji, używając "xpath" po nazwie klasy
        WebElement optionRadioButtonsByXpathClass = driver.findElement(By.xpath("//*[@class='wpcf7-form-control wpcf7-radio option']"));

        /** Zgadzam się z polityką prywatności - polityka prywatności */
        // Zlokalizuj link do polityki prywatności po tekście używając "xpath"
        WebElement linkByXpathText = driver.findElement(By.xpath("//*[text()='polityka prywatności']"));

        driver.quit();
    }

    @Test
    public void findGroupElements() {

        WebDriver driver = getDriver();

        // Metoda findElements zwróci listę elementów WebElements.
        // Poniżej przypisujemy do zmiennej inputs wszystkie elementy z tagname "input"
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        // Możemy w ten sposób wyszukać grupę elementów dla wszystkich metod findElements
        // Poniżej przykład z xpath. Wyszuka wszyskie elementy z typem checkbox
        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));

        driver.quit();
    }

    @Test
    public void noSuchElementException() {

        WebDriver driver = getDriver();

        // Poniżej przykład próby znalezienia elementu o id "fake-id", którego nie ma na stronie
        WebElement elementByID = driver.findElement(By.id("fake-id"));

        // Uruchom test i sprawdź czy w logach znajduje się poniższy błąd
        // org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#fake-id"}

        driver.quit();
    }
}
