package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static net.seamlessly.utilities.BrowserUtils.*;

public class TaskPage extends BasePage{


    @FindBy(xpath = "(//li[@data-id='contacts'])[1]/following-sibling::li[4]")
    public WebElement tasksModule;

    @FindBy(xpath = "//span[contains(text(),'Add List…')]/parent::a")
    public WebElement addListName;


    @FindBy(xpath = "//input[@id='newListInput']")
    public WebElement newListName;


    @FindBy(xpath = "//*[@id=\"app-content-vue\"]/div/div[1]/div[1]/form/input")
    public WebElement addAtask;

    @FindBy(xpath = "//*[@id=\"app-content-vue\"]/div/div[2]/div/ol[1]/li/div[1]/div[2]/div")
    public WebElement newTaskName;



    public void typeNewListBox (String string){
        waitFor(3);
        newListName.sendKeys(string, Keys.ENTER);
        waitFor(10);
       List<WebElement> currentNewlistName = Driver.getDriver().findElements(By.xpath("//div[@class='draggable-container']//li//a//span"));
        for (int i = 0; i < currentNewlistName.size()-1 ; i++) {
            if (currentNewlistName.get(i).getText().contains(string)){
                Assert.assertTrue(currentNewlistName.get(i).getText().contains(string));
            }
        }

    }











}
