package lib.ui.anroid;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {

        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/search_results_container']//*[contains(@text,'{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_AND_DESCRIPTION_TPL = "//*[@resource-id='org.wikipedia:id/search_results_container']//*[contains(@text,'{TITLE}')]/following-sibling::*[contains(@text,'{DESCRIPTION}')]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[contains(@text,'No results found')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
