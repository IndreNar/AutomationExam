package lt.itacademy.pom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MP3playersPageTest extends BaseTest {

    NavbarPage navbarPage;
    MP3playersPage mp3playersPage;


    @ParameterizedTest
    @CsvFileSource(resources = "/searchedItems.txt")
    public void addMP3playerToShoppingCart(String searchedItem){

//        @Test
//        public void addMP3playerToShoppingCart(){
        navbarPage = new NavbarPage(driver);
        mp3playersPage = new MP3playersPage(driver);

        navbarPage.clickMP3players();
        navbarPage.clickToShowAllMP3players();
        mp3playersPage.clickItemsAsLIstButton();

//        String searchedItem = "iPod Classic";
 //           String displayedItemName = mp3playersPage.getMp3PayerName();


        List<WebElement> displayedItems = mp3playersPage.listedItems();

        Optional<WebElement> matchingElement = displayedItems.stream().filter(d -> d.getText().equals(searchedItem)).findFirst();


        if (matchingElement.isPresent()){
            WebElement product = matchingElement.get();
            Assertions.assertTrue(product.getText().equals(searchedItem), searchedItem + " is displayed on the screen");
            product.click();

//        String MP3playerName = mp3playersPage.getMp3PayerName();
//        Assertions.assertEquals(, searchedItem, "Names do not match");

   //     mp3playersPage.clickToSelectProduct();
            mp3playersPage.clickWishListButton();

            String expectedMessageWishList = "You must login or create an account to save " + searchedItem + " to your wish list!\n×";


            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button-cart']")));
            String displayedMessage = mp3playersPage.getAlertMessage();
            Assertions.assertEquals(expectedMessageWishList, displayedMessage, "Messages do not match");

            driver.navigate().refresh();

            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button-cart']")));

            mp3playersPage.clickAddToCartButton();

            String expectedMessageAddToCart = "You have added " + searchedItem + " to your shopping cart!";

            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.alert-success.alert-dismissible")));
            String displayedMessageAddToCart = mp3playersPage.getAlertMessage();

            Assertions.assertTrue(displayedMessageAddToCart.contains(expectedMessageAddToCart), "Messages do not match after adding " + searchedItem + " to shopping cart");


            Assertions.assertTrue(mp3playersPage.getTextInShoppingCart().contains("1 item"), "Item was not added into the shopping cart");
        } else {
            System.out.println(searchedItem + " does not exist in the eshop");
        }
    }









    }

