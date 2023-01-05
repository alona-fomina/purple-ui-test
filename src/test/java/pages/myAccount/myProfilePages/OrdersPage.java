package pages.myAccount.myProfilePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends UserDashboard{
    public OrdersPage(){super();}

    @FindBy(css = ".no-orders-box")
    public WebElement emptyOrdersMessage;

    @FindBy(css = ".c-white")
    public WebElement shopNowButton;

}
