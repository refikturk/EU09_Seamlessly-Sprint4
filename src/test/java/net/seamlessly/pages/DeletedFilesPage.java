package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DeletedFilesPage extends BasePage{

@FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

@FindBy(xpath = "//a[@data-templatename='New text file.md']")
public WebElement newTextFile;

@FindBy(id = "view11-input-file")
public WebElement giveName;

@FindBy(xpath = "//button[@rel='nofollow noreferrer noopener']")
    public WebElement xButton;

@FindBy(xpath = "(//tbody[@id='fileList'])[1]//tr")
    public List<WebElement> allFiles;

@FindBy(xpath = "(//span[@id='selectedActionsList'])[1]/a")
    public WebElement actions;

@FindBy(xpath = "//div[@class='filesSelectMenu popovermenu bubble menu-center']/ul//li[@class='item-delete']")
    public WebElement actionsDelete;

@FindBy(xpath = "//div[@id='app-navigation']/ul/li[@data-id='files']")
public WebElement allFilesTab;

@FindBy (xpath = "//div[@id='app-navigation']/ul//li[@data-id='trashbin']")
    public WebElement deletedFilesTab;

@FindBy(xpath = "(//table[@id='filestable'][@class='list-container has-controls']//th[@class='column-mtime'])[2]")
public WebElement deletedButton;

@FindBy(xpath = "//div[@id='app-content-trashbin']//table[@id='filestable']/thead/tr//th/div/a/span")
public WebElement nameButton;

@FindBy(xpath = "//div[@id='app-content-trashbin']/table/tbody//tr[1]")
    public WebElement firstDeleted;
@FindBy(xpath = "//div[@id='app-content-trashbin']/table/tbody//tr[1]//td/label")
public WebElement checkboxDeleted;

@FindBy(xpath = "(//span[@id='selectedActionsList'])[2]")
public WebElement deletedActions;

@FindBy(xpath = "(//a/span[@class='icon icon-delete'])[3]")
public WebElement deleteIcon;

@FindBy(xpath = "(//a/span[@class='icon icon-history'])[1]")
public WebElement restoreIcon;

@FindBy(xpath = "(//tbody[@id='fileList'])[11]//tr")
public List<WebElement> deletedFiles;

@FindBy(xpath = "(//tbody[@id='fileList'])[11]//tr//td/following-sibling::td//span[@class='innernametext']")
public List<WebElement> deletedFilesNames;

public static void deletePermanently(){
    DeletedFilesPage deletedFilesPage=new DeletedFilesPage();
    BrowserUtils.sleep(3);
    deletedFilesPage.checkboxDeleted.click();
    deletedFilesPage.deletedActions.click();
    deletedFilesPage.deleteIcon.click();
}
public static void deleteFromFiles(){
    DeletedFilesPage deletedFilesPage=new DeletedFilesPage();
    deletedFilesPage.allFilesTab.click();
    for (WebElement each : deletedFilesPage.allFiles) {
        if (each.getAttribute("data-file").contains("File to delete")) {
            int index = deletedFilesPage.allFiles.indexOf(each)+1;
            Driver.getDriver().findElement(By.xpath("((//tbody[@id='fileList'])[1]//tr)["+index+"]/td")).click();

        }
    }
    deletedFilesPage.actions.click();
    deletedFilesPage.actionsDelete.click();
    deletePermanently();
}

}
