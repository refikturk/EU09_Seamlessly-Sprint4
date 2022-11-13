package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NotesPage extends BasePage {

    @FindBy(xpath = "//*[@id='appmenu']/li[7]/a")
    public WebElement pencilIcon;

    @FindBy(id = "notes_new_note")
    public WebElement newNoteModule;

    @FindBy(xpath = "//pre[@role='presentation'][1]")
    public WebElement noteWritingPage;

    @FindBy(xpath = "//ul//li[@class='app-navigation-entry router-link-exact-active active']//button")
    public WebElement threeDots;

    @FindBy(xpath = "//span[.='Add to favorites']")
    public WebElement addToFavourites;

    @FindBy(xpath = "//div[@class='app-navigation-entry-icon nav-icon icon-starred']")
    public WebElement starIcon;


    @FindBy(className = "material-design-icon__svg")
    public WebElement detailsThreeDots;

    @FindBy(xpath = "//button//span[.='Details']")
    public WebElement detailsButton;

    @FindBy(xpath = "//p[@class='app-sidebar-header__subtitle']")
    public WebElement countOfWordsCharsText;

    @FindBy(xpath = "//span[@title='Hello World!']")
    public WebElement note;

    @FindBy(id = "category")
    public WebElement category;

    @FindBy(xpath = "//input[@class='icon-confirm loading']")
    public WebElement arrowIcon;

    @FindBy(xpath = "//span[@title='animals']")
    public WebElement animalCategory;


}
