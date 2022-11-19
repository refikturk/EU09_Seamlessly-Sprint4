package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ContactsModule_Page extends BasePage {

    Actions actions = new Actions(Driver.getDriver());

    @FindBy(id = "new-contact-button")
    private WebElement newContactButton;

    @FindBy(xpath = "//div[@class='app-navigation-entry__counter']")
    private WebElement contactNumberCounter;

    public void clickNewContactButton() {
        BrowserUtils.sleep(2);
        BrowserUtils.waitForClickablility(newContactButton, 2).click();

    }

    @FindBy(id = "contact-fullname")
    private WebElement contactFullName;

    @FindBy(xpath = "//a[@class='header-icon icon-error header-icon--pulse has-tooltip']")
    private WebElement waitForSavingToServer;

    public void typeContactName(String fullName) {
        BrowserUtils.waitForVisibility(contactFullName, 2).click();
        contactFullName.clear();
        contactFullName.sendKeys(fullName);
        BrowserUtils.waitFor(2);
        //Assert.assertFalse(waitForSavingToServer.isEnabled());
    }

    @FindBy(xpath = "//*[@placeholder='Company']")
    private WebElement inputCompany;

    @FindBy(xpath = "//*[@placeholder='Title']")
    private WebElement inputTitle;

    public void putCompanyAndTitle(String company, String title) {
        BrowserUtils.waitForClickablility(inputCompany, 2).click();
        inputCompany.sendKeys(company);
        BrowserUtils.sleep(1);
        BrowserUtils.waitForClickablility(inputTitle, 2).click();
        inputTitle.sendKeys(title);
        BrowserUtils.sleep(3);
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

    public void inputPhoneNumber(String phoneNumberType, String phoneNumber) {
        BrowserUtils.waitForClickablility(phoneNumberDropDown, 5).click();
        WebElement numberType = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[1]/div/div/div/div[3]/ul/li//div[@title='" + phoneNumberType + "']"));
        BrowserUtils.waitForVisibility(numberType, 2).click();
        BrowserUtils.sleep(2);
        inputPhoneNumberPlaceHolder.click();
        inputPhoneNumberPlaceHolder.sendKeys(phoneNumber);
    }

    public void inputEmail(String emailType, String email) {
        BrowserUtils.waitForClickablility(emailDropDown, 5).click();
        WebElement mailType = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[2]/div/div/div/div[3]/ul/li//div[@title='" + emailType + "']"));
        BrowserUtils.waitForVisibility(mailType, 2).click();

        inputEmailPlaceHolder.click();
        inputEmailPlaceHolder.sendKeys(email);
    }

    public void addressPlaceHolders(String placeHolderName, String inputInformation) {
        WebElement inputPlaceHolder = Driver.getDriver().findElement(By.xpath("//*[@id=\"app-content-vue\"]/div/div/div[3]/div/section/div[3]/div/div//div[normalize-space(text())='" + placeHolderName + "']/following-sibling::input"));
        BrowserUtils.waitForClickablility(inputPlaceHolder, 2);
        actions.doubleClick(inputPlaceHolder).perform();
        inputPlaceHolder.sendKeys(Keys.DELETE);
        inputPlaceHolder.sendKeys(inputInformation);
        BrowserUtils.sleep(1);
    }


    @FindBy(xpath = "//div[@role='group']/div/span/div[2]/span[@class='option__lineone']")
    private List<WebElement> listOfContacts;

    //Returns contacts names as a list of String from the middle column of Contacts Module to verify actual contact names
    public List<String> verifyUserNameIsOnTheMiddleColumn() {
        List<String> listOfContactNames = new ArrayList<>();

        for (WebElement listOfContact : listOfContacts) {
            String contactName = listOfContact.getText();
            listOfContactNames.add(contactName);
        }
        System.out.println(listOfContactNames);
        System.out.println("listOfContactNames.size() = " + listOfContactNames.size());
        return listOfContactNames;

    }

    public int theNumberOfContacts() {
        String getTextFromWebElement = StringUtils.deleteWhitespace(contactNumberCounter.getText());
        Integer numberOfContacts = parseInt(getTextFromWebElement);
        System.out.println("numberOfContacts = " + numberOfContacts);
        return numberOfContacts;


    }

    //User can change the profile picture of any contact with a previously uploaded picture by using “Choose from files” option, webElements and methods

    //contact avatar name web element on third column, it represents initials of contact's full name as default
    @FindBy(xpath = "//div[@class='contact-header__avatar']//*[contains(@aria-label,'Avatar of ')]/div[@class='unknown']")
    private WebElement avatarNameOfContact;

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-picture-force-white']")
    private WebElement pictureMenuIcon;

    @FindBy(xpath = "//ul[@id='menu-linfp']//span[contains(text(),' ')]")
    private List<WebElement> listOfPictureMenuActions;
    //

    @FindBy(xpath = "//div[@role='group']//*[contains(@aria-label,'Avatar of ')]/..")
    private List<WebElement> contactSectionInTheMiddleColumn;

    public void selectContactFromMiddleSection(String contactFullName) {
        BrowserUtils.sleep(2);
        WebElement selectContact = Driver.getDriver().findElement(By.xpath("//div[@role='group']//*[contains(@aria-label,'Avatar of "+contactFullName+"')]/.."));
        BrowserUtils.sleep(2);

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click()", selectContact);

    }

    public void clickOnPictureMenuIcon(){
        BrowserUtils.waitForClickablility(pictureMenuIcon, 2).click();
    }

    public void clictToUploadPicture(String action) {

        if (action.equalsIgnoreCase("upload a new picture")) {
            Driver.getDriver().findElement(By.xpath("//ul//span[contains(text(),'Upload a new picture')]")).click();

        } else if (action.equalsIgnoreCase("choose from files")) {
            Driver.getDriver().findElement(By.xpath("//ul//span[contains(text(),'Choose from Files')]")).click();

        }else {
            Driver.getDriver().findElement(By.xpath("//ul//span[contains(text(),'Get from gravatar')]")).click();
        }


    }

    //

    @FindBy(xpath = "//button[@class='primary']")
    private WebElement chooseButton;

    public void selectPictureFromFiles(String pictureName){
        BrowserUtils.waitForVisibility(By.xpath("//*[@id=\"body-user\"]/div[7]/h2"),2);
        WebElement selectedPicture = Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='"+pictureName+"']"));
        selectedPicture.click();
        BrowserUtils.waitForClickablility(chooseButton,2);
        chooseButton.click();

    }


}