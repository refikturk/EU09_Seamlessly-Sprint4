package net.seamlessly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static net.seamlessly.utilities.BrowserUtils.*;
import static net.seamlessly.utilities.Driver.*;
import static org.junit.Assert.*;

public class CalendarPage extends BasePage {


    @FindBy(xpath = "//header[@class='app-navigation-header']//button[@class='icon vue-button action-item__menutoggle action-item__menutoggle--with-icon-slot']")
    private WebElement timeSectionsBtn;

    @FindBy(xpath = "//span[contains(text(),'Day')]//parent::button")
    private WebElement dayBtn;

    @FindBy(xpath = "//div[@class='fc-scrollgrid-sync-inner']//a")
    private WebElement dailyCalendarDate;

    @FindBy(xpath = "//span[contains(text(),'Week')]//parent::button")
    private WebElement weekBtn;

    @FindBy(xpath = "//span[contains(text(),'Month')]//parent::button")
    private WebElement monthBtn;

    @FindBy(xpath = "//header[@class='app-navigation-header']//button[@class='button primary new-event']")
    private WebElement newEventBtn;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    private WebElement inputEventTitle;

    @FindBy(xpath = "//*[@class=\"popover vue-popover-theme event-popover\"]/div/div[1]/div[1]/div[4]/div[1]/div[1]/div/input")
    private WebElement inputEventStartedDate;

    @FindBy(xpath = "//*[@class=\"popover vue-popover-theme event-popover\"]/div/div[1]/div[1]/div[4]/div[1]/div[2]/div/input")
    private WebElement inputEventFinishedDate;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text']")
    private WebElement pickADateBtn;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement eventOkBtn;

    @FindBy(xpath = "//button[@class='mx-btn mx-btn-text mx-btn-current-year']")
    private WebElement selectedEventYear;

    @FindBy(xpath = "//textarea[@placeholder='Add a location']")
    private WebElement inputEventLocationBox;

    @FindBy(xpath = "//textarea[@placeholder='Add a description']")
    private WebElement inputEventDescriptionBox;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement eventSaveBtn;

    @FindBy(xpath = "//button[@class='datepicker-button-section__datepicker-label button datepicker-label']")
    private WebElement calendarPageDateBtn;

    @FindBy(xpath = "//div[@class='popover vue-popover-theme event-popover']//button[@class='icon vue-button action-item__menutoggle action-item__menutoggle--default-icon']")
    private WebElement moreOptionBtn;

    @FindBy(xpath = "//div[@class='popover vue-popover-theme open']//button[@class='action-button focusable']")
    private WebElement deleteBtn;


    public void verifyViewCalendarPage() {
        assertTrue(getDriver().getTitle().contains("Calendar - Seamlessly"));
    }

    public void clickTimeSectionsBtn() {
        waitForClickablility(timeSectionsBtn, 10).click();
    }

    public void verifyViewDayBtn() {
        assertTrue(waitForClickablility(dayBtn, 10).isDisplayed());
    }

    public void clickDayBtn() {
        waitForClickablility(dayBtn, 10).click();
    }

    public void verifyDailyCalendarModuleIsDisplayed() {
        String currentPageUrl = getDriver().getCurrentUrl();
        String currentPageTitle = getDriver().getTitle();

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");

        String dateNow = dateFormat.format(today);

        assertTrue(currentPageUrl.contains("timeGridDay"));
        assertTrue(currentPageTitle.contains(dateNow));
    }

    public void verifyViewWeekBtn() {
        assertTrue(waitForClickablility(weekBtn, 10).isDisplayed());
    }

    public void clickWeekBtn() {
        waitForClickablility(weekBtn, 10).click();
    }

    public void verifyWeeklyCalendarModuleIsDisplayed() {
        String currentPageUrl = getDriver().getCurrentUrl();
        String currentPageTitle = getDriver().getTitle();

        Date dateYear = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

        String currentYear = dateFormat.format(dateYear);

//        Date week = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("ww");
//
//        String dateWeek = dateFormat.format(week);
//        System.out.println("dateNow = " + dateWeek);

        Calendar calendar = Calendar.getInstance();

        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        String expectedWeeklyTitle = ("Week " + weekOfYear + " of " + currentYear);


        assertTrue(currentPageTitle.contains(expectedWeeklyTitle));
        assertTrue(currentPageUrl.contains("timeGridWeek"));

    }

    public void verifyViewMonthBtn() {
        assertTrue(waitForClickablility(monthBtn, 10).isDisplayed());
    }

    public void clickMonthBtn() {
        waitForClickablility(monthBtn, 10).click();
        waitFor(1);
    }

    public void verifyMonthlyCalendarModuleIsDisplayed() {
        String currentPageUrl = getDriver().getCurrentUrl();
        String currentPageTitle = getDriver().getTitle();

        Date dateMonthYear = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

        String expectedTitleDate = dateFormat.format(dateMonthYear);

        assertTrue(currentPageTitle.contains(expectedTitleDate));
        assertTrue(currentPageUrl.contains("dayGridMonth"));
    }

    public void clickNewEventBtn() {
        waitForClickablility(newEventBtn, 10).click();
    }

    public void typeNewEventTitle(String eventTitle) {
        waitForClickablility(inputEventTitle, 10).sendKeys(eventTitle);
        waitFor(2);
    }

    public void selectedEventStartDate(String startTime, String eventDate) {
        waitForClickablility(inputEventStartedDate, 10).click();
        waitFor(2);

        int dotIndex = (startTime.lastIndexOf("."));
        int spaceIndex = (startTime.lastIndexOf(" "));

        String inputClock = startTime.substring(0, dotIndex);
        inputClock = inputClock.trim();
        System.out.println("inputClock = " + inputClock);

        String inputMinute = startTime.substring(dotIndex + 1, spaceIndex);
        inputMinute = inputMinute.trim();
        System.out.println("inputMinute = " + inputMinute);

        String amPm = startTime.substring(spaceIndex);
        amPm = amPm.trim().toUpperCase(Locale.ROOT);
        System.out.println("amPm = " + amPm);


        WebElement minute = getDriver().findElement(By.xpath("//div//ul[@data-type='minute']/li[contains(text(),'" + inputMinute + "')]"));

        waitForClickablility(minute, 10).click();

        WebElement hour = getDriver().findElement(By.xpath("//div//ul[@data-type='hour']/li[contains(text(),'" + inputClock + "')]"));

        waitForClickablility(hour, 10).click();

        WebElement amPM = getDriver().findElement(By.xpath("//div//ul[@data-type='ampm']/li[contains(text(),'" + amPm + "')]"));
        waitForClickablility(amPM, 10).click();

        waitFor(1);
        pickADateBtn.click();

        waitForClickablility(selectedEventYear, 10).click();

        String selectedYearStr = eventDate;

        int lastSpace = selectedYearStr.lastIndexOf(" ");

        String year = selectedYearStr.substring(lastSpace + 1, eventDate.length());

        WebElement selectedYear = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-year']//td[@data-year='" + year + "']"));

        waitForClickablility(selectedYear, 10).click();

        // waitForClickablility(selectedEventMonth, 10).click();

        eventDate = eventDate.toLowerCase(Locale.ROOT).trim();

        int firstSpace = eventDate.indexOf(' ');
        String eventMonth = eventDate.substring(0, firstSpace);

        String monthNameNum = (eventMonth.equalsIgnoreCase("January")) ? "0" : (eventMonth.equalsIgnoreCase("February")) ? "1" :
                (eventMonth.equalsIgnoreCase("March")) ? "2" : (eventMonth.equalsIgnoreCase("April")) ? "3" :
                        (eventMonth.equalsIgnoreCase("May")) ? "4" : (eventMonth.equalsIgnoreCase("June")) ? "5" :
                                (eventMonth.equalsIgnoreCase("July")) ? "6" : (eventMonth.equalsIgnoreCase("August")) ? "7" :
                                        (eventMonth.equalsIgnoreCase("September")) ? "8" : (eventMonth.equalsIgnoreCase("October")) ? "9" :
                                                (eventMonth.equalsIgnoreCase("November")) ? "10" : (eventMonth.equalsIgnoreCase("December")) ? "11" :
                                                        "please write valid month name";


        WebElement selectedMonth = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-month']//td[@data-month='" + monthNameNum + "']"));

        waitForClickablility(selectedMonth, 10).click();

        String dayNum = eventDate.substring(firstSpace + 1, lastSpace);

        WebElement selectedDayNum = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-date']//td[@class='cell']/div[text()='" + dayNum + "']"));

        waitForClickablility(selectedDayNum, 10).click();

        waitForClickablility(eventOkBtn, 10).click();

        sleep(5);
    }

    public void selectedEventFinishedDate(String finishedTime) {
        waitForClickablility(inputEventFinishedDate, 10).click();
        waitFor(2);

        int dotIndex = (finishedTime.lastIndexOf("."));
        int spaceIndex = (finishedTime.lastIndexOf(" "));

        String inputClock = finishedTime.substring(0, dotIndex);
        inputClock = inputClock.trim();
        System.out.println("inputClock = " + inputClock);

        String inputMinute = finishedTime.substring(dotIndex + 1, spaceIndex);
        inputMinute = inputMinute.trim();
        System.out.println("inputMinute = " + inputMinute);

        String amPm = finishedTime.substring(spaceIndex);
        amPm = amPm.trim().toUpperCase(Locale.ROOT);
        System.out.println("amPm = " + amPm);


        WebElement minute = getDriver().findElement(By.xpath("//div//ul[@data-type='minute']/li[contains(text(),'" + inputMinute + "')]"));

        waitForClickablility(minute, 10).click();

        WebElement hour = getDriver().findElement(By.xpath("//div//ul[@data-type='hour']/li[contains(text(),'" + inputClock + "')]"));

        waitForClickablility(hour, 10).click();

        WebElement amPM = getDriver().findElement(By.xpath("//div//ul[@data-type='ampm']/li[contains(text(),'" + amPm + "')]"));
        waitForClickablility(amPM, 10).click();

        waitFor(1);
        pickADateBtn.click();

        waitForClickablility(eventOkBtn, 10).click();

        sleep(3);
    }

    public void typeEventLocation(String eventLocation) {
        waitForClickablility(inputEventLocationBox, 10).sendKeys(eventLocation);
    }

    public void typeEventDescription(String eventDescription) {
        waitForClickablility(inputEventDescriptionBox, 10).sendKeys(eventDescription);
        waitFor(5);
    }

    public void clickEventSaveBtn() {
        waitForClickablility(eventSaveBtn, 10).click();
        waitFor(5);
    }

    public void clickCalendarDateBtn() {
        waitForClickablility(calendarPageDateBtn, 10).click();
        waitFor(2);
    }

    String eventDate;

    public void entryEventDate(String eventDate) {
        this.eventDate = eventDate;
        waitForClickablility(selectedEventYear, 10).click();

        String selectedYearStr = eventDate;

        int firstSpace = eventDate.indexOf(' ');
        int lastSpace = selectedYearStr.lastIndexOf(" ");

        String year = selectedYearStr.substring(lastSpace + 1, eventDate.length());

        WebElement selectedYear = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-year']//td[@data-year='" + year + "']"));

        waitForClickablility(selectedYear, 10).click();

        // waitForClickablility(selectedEventMonth, 10).click();

        eventDate = eventDate.toLowerCase(Locale.ROOT).trim();

        String eventMonth = eventDate.substring(0, firstSpace);

        String monthNameNum = (eventMonth.equalsIgnoreCase("January")) ? "0" : (eventMonth.equalsIgnoreCase("February")) ? "1" :
                (eventMonth.equalsIgnoreCase("March")) ? "2" : (eventMonth.equalsIgnoreCase("April")) ? "3" :
                        (eventMonth.equalsIgnoreCase("May")) ? "4" : (eventMonth.equalsIgnoreCase("June")) ? "5" :
                                (eventMonth.equalsIgnoreCase("July")) ? "6" : (eventMonth.equalsIgnoreCase("August")) ? "7" :
                                        (eventMonth.equalsIgnoreCase("September")) ? "8" : (eventMonth.equalsIgnoreCase("October")) ? "9" :
                                                (eventMonth.equalsIgnoreCase("November")) ? "10" : (eventMonth.equalsIgnoreCase("December")) ? "11" :
                                                        "please write valid month name";


        WebElement selectedMonth = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-month']//td[@data-month='" + monthNameNum + "']"));

        waitForClickablility(selectedMonth, 10).click();

        String dayNum = eventDate.substring(firstSpace + 1, lastSpace);

        WebElement selectedDayNum = getDriver().findElement(By.xpath("//table[@class='mx-table mx-table-date']//td[@class='cell']/div[text()='" + dayNum + "']"));

        waitForClickablility(selectedDayNum, 10).click();

        waitForClickablility(eventOkBtn, 10).click();

        sleep(5);
    }

    public void verifyViewEvent(String eventTitle, String eventHour) {

        eventHour = eventHour.toUpperCase();

        WebElement eventTitleElement = getDriver().findElement(By.xpath("//div[contains(text(),'" + eventTitle + "')]"));
        WebElement eventHourElement = getDriver().findElement(By.xpath("//div[contains(text(),'" + eventHour + "')]"));

        assertTrue(eventTitleElement.isDisplayed());
        assertTrue(eventHourElement.isDisplayed());

    }

    public void clickEventTitle(String eventTitle) {
        WebElement eventTitleElement = getDriver().findElement(By.xpath("//div[contains(text(),'" + eventTitle + "')]"));

        waitForClickablility(eventTitleElement, 10).click();

        waitFor(2);
    }

    public void clicksMoreOptionsBtn() {
        waitForClickablility(moreOptionBtn, 10).click();
        waitFor(2);
    }

    public void clickDeleteBtn() {
        waitForClickablility(deleteBtn, 10).click();
    }

    public void verifyEventIsNotDisplayed(String eventTitle) {

        //"June 12 2023"

        String[] dateParts = eventDate.split(" ");

        eventDate = dateParts[0] + " " + dateParts[1] + ", " + dateParts[2];
        String locator = "//a[@title='" + eventDate + "']/ancestor::div[contains(@class,'fc-daygrid-day-frame')][contains(.,'" + eventTitle + "')]";
        WebDriverWait driverWait = new WebDriverWait(getDriver(), 20, 100);

        assertTrue(driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(locator), 0)).size() == 0);

    }


}

