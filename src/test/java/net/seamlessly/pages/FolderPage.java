package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FolderPage extends BasePage {

    @FindBy(xpath = "//label[@for='select_all_files']")
    private WebElement selectAllCheckBox;

    @FindBy(xpath = "//tbody[@id='fileList']//tr[@data-type='dir']")
    private List<WebElement> folders;

    @FindBy(xpath = "//tbody[@id='fileList']//tr[@data-type='file']")
    private List<WebElement> files;

    @FindBy(xpath = "//div[@id='headerName-container']//span[contains(text(),'folders')]")
    private WebElement totalCountOfFoldersFiles;

    public void verifyTheTotalCountOfAllItems(){
        //3 folders and 2 files
        //012345678901234567890
        String fullStatement = totalCountOfFoldersFiles.getText();
        int actualFolderCount =Integer.parseInt(fullStatement.substring(0,fullStatement.indexOf(' ')));
        int actualFilesCount =Integer.parseInt(fullStatement.substring(fullStatement.indexOf("d ")+2,fullStatement.lastIndexOf(" f")));
        System.out.println("actualFolderCount = " + actualFolderCount);
        System.out.println("actualFilesCount = " + actualFilesCount);
        int expectedFolderCount = getFoldersCount();
        int expectedFilesCount = getFilesCount();
        System.out.println("expectedFolderCount = " + expectedFolderCount);
        System.out.println("expectedFilesCount = " + expectedFilesCount);

        Assert.assertEquals(expectedFolderCount,actualFolderCount);
        Assert.assertEquals(expectedFilesCount,actualFilesCount);

    }


    public int getFoldersCount(){
        return folders.size();
    }

    public int getFilesCount(){
        return files.size();
    }

    public void clickSelectAllCheckBox(){
        BrowserUtils.waitForClickablility(selectAllCheckBox,10);
        BrowserUtils.clickWithJS(selectAllCheckBox);
        BrowserUtils.sleep(2);
    }
}

