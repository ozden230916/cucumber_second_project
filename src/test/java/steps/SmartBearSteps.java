package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.OrderPage;
import pages.SmartBearHomePage;
import pages.ViewAllOrdersPage;
import pages.WebOrdersPage;
import utils.Driver;

public class SmartBearSteps {

    WebDriver driver;
    SmartBearHomePage smartBearHomePage;
    WebOrdersPage webOrdersPage;
    OrderPage orderPage;
    ViewAllOrdersPage viewAllOrdersPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        smartBearHomePage = new SmartBearHomePage();
        webOrdersPage = new WebOrdersPage();
        orderPage = new OrderPage();
        viewAllOrdersPage = new ViewAllOrdersPage();
    }


    @When("user enters username as {string}")
    public void userEntersUsernameAs(String username) {
        smartBearHomePage.usernameInputBox.sendKeys(username);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        smartBearHomePage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearHomePage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertTrue(smartBearHomePage.message.isDisplayed());
        Assert.assertEquals(message, smartBearHomePage.message.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable itemsList) {
        for (int i = 0; i < itemsList.asList().size(); i++) {
            Assert.assertTrue(webOrdersPage.webOrderMenuItems.get(i).isDisplayed());
            Assert.assertEquals(itemsList.asList().get(i), webOrdersPage.webOrderMenuItems.get(i).getText());

        }

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        switch (buttonName){
            case "Check All":
                webOrdersPage.checkAllButton.click();
                break;
            case "Uncheck All" :
                webOrdersPage.uncheckAllButton.click();
                break;

            case "Process" :
                orderPage.processButton.click();
                break;

            case "Delete Selected" :
                webOrdersPage.deleteSelectedButton.click();
                break;
        }

    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < webOrdersPage.checkboxList.size(); i++) {
            Assert.assertTrue(webOrdersPage.checkboxList.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < webOrdersPage.checkboxList.size(); i++) {
            Assert.assertFalse(webOrdersPage.checkboxList.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        switch (menuItem){
            case "Order" :
                webOrdersPage.webOrderMenuItems.get(2).click();
                break;

            case "View all orders":
                webOrdersPage.webOrderMenuItems.get(0).click();
                break;

        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String productType) {
        Select select = new Select(orderPage.productTypeDropdown);
        select.selectByValue(productType);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        orderPage.quantityInputBox.sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        orderPage.customerNameInputBox.sendKeys("Ozden Firat");
        orderPage.streetInputBox.sendKeys("Kipling Ave");
        orderPage.cityInputBox.sendKeys("WOODBRIDGE");
        orderPage.stateInputBox.sendKeys("Ontario");
        orderPage.zipInputBox.sendKeys("07011");
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        orderPage.cardTypeVisa.click();
        orderPage.cardNumberInputBox.sendKeys("1234567891232345");
        orderPage.expireDateInputBox.sendKeys("08/25");
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String table) {
        Assert.assertTrue(viewAllOrdersPage.myOrder.isDisplayed());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        for (int i = 1; i <= viewAllOrdersPage.allOrdersList.size() - 1; i++) {
            Assert.assertEquals(dataTable.asList().get(i), viewAllOrdersPage.allOrdersList.get(i).getText());
        }


    }


    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String lists) {
        Assert.assertTrue(webOrdersPage.allRows.size() == 0);
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, webOrdersPage.addMessage.getText());
    }
}
