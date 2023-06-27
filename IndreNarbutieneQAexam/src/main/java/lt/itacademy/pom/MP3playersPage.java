package lt.itacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MP3playersPage extends AbstractPage {

    @FindBy(css = "button[id='list-view']")
    private WebElement itemsAsListButton;

    @FindBy(css = ".product-layout > div > div > div > h4 > a")
    private List<WebElement> listOfItems;

    @FindBy(css = ".product-layout > div > div > div > h4 > a")
    private WebElement mp3PlayerName;


    @FindBy(css = "#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1)")
    private WebElement wishListButton;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    private WebElement alertMessage;

    @FindBy(xpath = "//button[@id='button-cart']")
    private WebElement addToCartButton;

    @FindBy(css = "div[id='cart'] > button")
    private WebElement shoppingCart;


    public MP3playersPage(WebDriver driver) {
        super(driver);
    }

    public void clickItemsAsLIstButton(){
        itemsAsListButton.click();
    }

    public List<WebElement> listedItems(){
        return listOfItems;
    }

    public void clickWishListButton(){
        wishListButton.click();
    }

    public String getAlertMessage(){
        return alertMessage.getText();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public String getTextInShoppingCart(){
        return shoppingCart.getText();
    }

    public String getMp3PayerName(){
        return mp3PlayerName.getText();
    }

    public void clickToSelectProduct(){
        mp3PlayerName.click();
    }
}
