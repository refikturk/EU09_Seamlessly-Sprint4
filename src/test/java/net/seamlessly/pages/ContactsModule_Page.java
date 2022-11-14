package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsModule_Page extends BasePage{

    @FindBy(id = "new-contact-button")
    private WebElement newContactButton;

    @FindBy(id = "contact-fullname")
    private WebElement contactFullName;

    @FindBy(xpath = "//*[@placeholder='Company']")
    private  WebElement inputCompany;

    @FindBy(xpath = "//*[@placeholder='Title']")
    private  WebElement inputTitle;




}
