package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_SUBSTRING_AND_DESCRIPTION_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }

    /* TEMPLATE METHODS */
    private static String getResultSearchElement(String substring) {

        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultByTitleAndDescription(String title, String description) {

        return SEARCH_RESULT_BY_SUBSTRING_AND_DESCRIPTION_TPL.replace("{TITLE}", title).replace("{DESCRIPTION}", description);
    }
    /* TEMPLATE METHODS */

    public void initSearchInput() {

        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {

        String search_result_xpath = getResultByTitleAndDescription(title, description);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with title " + title + " or/and with description " + description, 10);

    }

    public void waitForCancelButtonToAppear() {

        this.waitForElementPresent(SEARCH_CANCEL_BUTTON,"Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {

        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON,"Cancel search button is still present", 5);
    }

    public void clickCancelButton() {

        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON,"Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line) {

        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {

        String search_result_xpath = getResultSearchElement(substring);

        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 5);
    }

    public void clickByArticleWithSubstring(String substring) {

        String search_result_xpath = getResultSearchElement(substring);

        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles() {

        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }

    public void waitForEmptyResultsLabel() {

        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);

    }

    public void assertThereIsNoResultOfSearch() {

        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed to find some results");
    }
}
