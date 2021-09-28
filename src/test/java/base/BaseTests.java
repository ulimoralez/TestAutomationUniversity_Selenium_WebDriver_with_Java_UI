package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        //Hacemos un setup del driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        //Esto nos permite manejar la ventana, por ejemplo, para maximizar la ventana al iniciar la aplicación
        /*
        * .fullscreen
        * .minimize
        * Podemos setear un tamaño en específico en pixeles con .setSize(new Dimension())
        * */
        driver.manage().window().maximize();

        //Seteamos el url que vamos a utilizar, esto abre el enlace en el navegador, este caso Chrom
        driver.get("https://the-internet.herokuapp.com/");

        //Chapter 3: Finding Web Elements
        //Tenemos 2 tipos de FindElement, uno en plural y uno en singular
        //findElement nos permite mediante un objeto By, elegir cómo queremos encontrar ese elemento
        //Tenemos el objeto Inputs, que lo traemos mediante texto y le damos click
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();
        //FindElements retorna una lista de elementos
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        //Tareita opcional -> No probada
        WebElement shiftingContent = driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        WebElement menuelement = driver.findElement(By.linkText("Example 1: Menu Element"));
        menuelement.click();
        System.out.println(driver.findElements(By.tagName("a")));
        //Fin Chapter 3: Finding Web Elements

        //Chapter 4.1: Element Interactions
        /*For this chapter we gonna use the Page Object Model, we create a package in main, called pages and put
        a class inside called HomePage
        * */
        //End of Chapter 4.1: Element Interactions

        //Quit va a cerrar la sesión con el navegador, close va a cerrar la ventana
        driver.quit();
        //Get the title of the application
        System.out.println(driver.getTitle());
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
