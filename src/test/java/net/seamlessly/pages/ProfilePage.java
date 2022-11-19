package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage{



    @FindBy(id="displayname")
 public WebElement fullName;
    public void fullNameVerify(){
        Driver.getDriver().get("https://qa.seamlessly.net/index.php/settings/user");
        BrowserUtils.waitFor(10);
        Assert.assertTrue(nameHolder.getText().contains("Full name"));
    }


    @FindBy(xpath = "//*[@id=\"phoneform\"]/h3/a")
    public WebElement menuItem;

    @FindBy(xpath = "//div/ul//a[@class='menuitem action action-v2-private permanent active']")
    public WebElement privateButton;


    @FindBy(id="phone")
    private WebElement phone;

    public void phonePrivate(){
        phone.sendKeys("05064251472");

        BrowserUtils.sleep(10);
    }

    public void phoneVerify(){
        phone.sendKeys("05064251472");
        BrowserUtils.waitFor(10);
        BrowserUtils.sleep(5);
        Assert.assertTrue(phone.getText().contains("05064251472"));
        //Assert.assertFalse(profilePage.phone.getText().contains("05065251472"));
    }


    @FindBy(id="localeinput")
    private WebElement LocaleInput;

    public void LocaleBtnVerify(){
        WebElement Locale = LocaleInput;
        Select MultiLocale = new Select(Locale);
        MultiLocale.selectByVisibleText("Turkish");
        BrowserUtils.waitFor(10);
        Assert.assertTrue(LocaleInput.getText().contains("Turkish"));
    }


    @FindBy(xpath = "//a[@class='federation-menu']//ul//Li//a")
    public WebElement btnPrivate;

    public void PrivatePhoneVerify(){
        Driver.getDriver().get("https://qa.seamlessly.net/index.php/settings/user");
        BrowserUtils.waitFor(15);
        menuItem.click();
        btnPrivate.click();
        BrowserUtils.sleep(10);
    }


    @FindBy(xpath = "//label[@for='displayname']")
   private WebElement nameHolder;
    public void nameChangeVerify(){
        BrowserUtils.waitFor(10);
        Assert.assertTrue(nameHolder.getText().contains("Full name"));
        System.out.println("user see verify that  new full name");
    }


    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailTrue;
    public void emailTrueVerify(){
        BrowserUtils.waitFor(10);
        Assert.assertTrue(emailTrue.getText().contains("Email"));
    }

    @FindBy(xpath = "//*[@id=\"personal-settings-avatar-container\"]/div[2]/h3")
    public WebElement ProfilePicture;

   @FindBy(xpath = "//div[@class='displayname__actions-container']")
    public WebElement nameHolder;

   @FindBy(xpath = "//label[@for='email']")
    public WebElement emailTrue;

   @FindBy(xpath = "//*[@id=\"personal-settings-avatar-container\"]/div[2]/h3")
    public WebElement ProfilePicture;


}
