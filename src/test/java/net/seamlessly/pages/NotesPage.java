package net.seamlessly.pages;

import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class NotesPage extends BasePage {

    @FindBy(xpath = "//*[@id='appmenu']/li[7]/a")
    public WebElement pencilIcon;

    @FindBy(id = "notes_new_note")
    public WebElement newNoteModule;

    @FindBy(xpath = "//pre[@role='presentation'][1]")
    public WebElement noteWritingPage;

    @FindBy(xpath = "//span[@title='Arife']/../..//button")
    public WebElement threeDots;

    @FindBy(xpath = "//span[.='Add to favorites']")
    public WebElement addToFavourites;

    @FindBy(xpath = "//div[@class='app-navigation-entry-icon nav-icon icon-starred']")
    public WebElement starIcon;


    @FindBy(xpath = "(//div[@style='display: inline-block;']/button/span)[12]")
    public WebElement detailsThreeDots;

    @FindBy(xpath = "//button//span[.='Details']")
    public WebElement detailsButton;

    @FindBy(xpath = "//p[@class='app-sidebar-header__subtitle']")
    public WebElement countOfWordsCharsText;


    @FindBy(id = "category")
    public WebElement category;

    @FindBy(xpath = "//input[@class='icon-confirm loading']")
    public WebElement arrowIcon;

    @FindBy(xpath = "//span[@title='Categories']")
    public WebElement categoriesModule;


    @FindBy(xpath = "//span[@title='animals']")
    public WebElement animalCategory;



    public WebElement clickThreeDotByText(String text){
        String xpath = "//span[@title='"+text+"']/../..//button//span";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        return element;
    }

    public void verifyTheTotalCountOfAllItems(){
        //3 folders and 2 files
        //012345678901234567890
        String fullStatement = countOfWordsCharsText.getText();
        int actualWordsCount =Integer.parseInt(fullStatement.substring(0,fullStatement.indexOf(' ')));
        int actualCharsCount =Integer.parseInt(fullStatement.substring(fullStatement.indexOf(", ")+2,fullStatement.lastIndexOf(" c")));
        System.out.println("actualWordsCount = " + actualWordsCount);
        System.out.println("actualCharsCount = " + actualCharsCount);

Assert.assertTrue(fullStatement.equals(actualWordsCount + " words, " + actualCharsCount +" characters"));


    }










}
