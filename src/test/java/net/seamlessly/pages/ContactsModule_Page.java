package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsModule_Page extends BasePage {

    @FindBy(id = "new-contact-button")
    private WebElement newContactButton;

    public void clickNewContactButton() {
        BrowserUtils.waitForClickablility(newContactButton, 2).click();

    }

    @FindBy(id = "contact-fullname")
    private WebElement contactFullName;

    public void typeContactName(String fullName){
        BrowserUtils.waitForVisibility(contactFullName,2).click();
        contactFullName.clear();
        contactFullName.sendKeys(fullName);
    }

    @FindBy(xpath = "//*[@placeholder='Company']")
    private WebElement inputCompany;

    @FindBy(xpath = "//*[@placeholder='Title']")
    private WebElement inputTitle;

    public void putCompanyAndTitle(String company, String title){
        BrowserUtils.waitForClickablility(inputCompany,2).click();
        inputCompany.sendKeys(company);
        BrowserUtils.waitForClickablility(inputTitle,2).click();
        inputTitle.sendKeys(title);
    }

    @FindBy(xpath = "(//input[@class='multiselect__input'])[1]")
    private WebElement phoneNumberDropDown;

    @FindBy(xpath = "(//input[@class='multiselect__input'])[2]")
    private WebElement emailDropDown;

    @FindBy(xpath = "//input[@inputmode='email']")
    private WebElement inputEmailPlaceHolder;

    @FindBy(xpath = "(//input[@class='multiselect__input'])[3]")
    private WebElement addressDropDown;

    @FindBy(xpath = "//input[@inputmode='tel']")
    private WebElement inputPhoneNumberPlaceHolder;

    public void inputPhoneNumber(String phoneNumberType, String phoneNumber){
        BrowserUtils.waitForClickablility(phoneNumberDropDown,5).click();
        WebElement numberType = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[1]/div/div/div/div[3]/ul/li//div[@title='"+phoneNumberType+"']"));
        BrowserUtils.waitForVisibility(numberType, 2).click();

        inputPhoneNumberPlaceHolder.click();
        inputPhoneNumberPlaceHolder.sendKeys(phoneNumber);
    }

    public void inputEmail(String emailType, String email){
        BrowserUtils.waitForClickablility(emailDropDown,5).click();
        WebElement mailType = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[2]/div/div/div/div[3]/ul/li//div[@title='"+emailType+"']"));
        BrowserUtils.waitForVisibility(mailType, 2).click();

        inputEmailPlaceHolder.click();
        inputEmailPlaceHolder.sendKeys(email);
    }

    public void addressPlaceHolders(String placeHolderName, String inputInformation){
        WebElement inputPlaceHolder = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[3]/div/div/div[normalize-space(text())='"+placeHolderName+"']"));
        BrowserUtils.waitForClickablility(inputPlaceHolder,2).click();
        inputPlaceHolder.sendKeys(inputInformation);
    }

}
