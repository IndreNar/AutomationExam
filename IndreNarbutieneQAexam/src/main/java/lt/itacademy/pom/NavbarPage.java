package lt.itacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarPage extends AbstractPage {

    @FindBy(css = "div.navbar-collapse > ul :nth-child(8)")
    private WebElement mp3players;

    @FindBy(css = "div.navbar-collapse > ul :nth-child(8) > div > a")
    private WebElement showAllMP3players;

    public NavbarPage(WebDriver driver) {
        super(driver);
    }


    public void clickMP3players(){
        mp3players.click();
    }

    public void clickToShowAllMP3players(){
        showAllMP3players.click();
    }
}
