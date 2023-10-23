package pages

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page

class MainPage(override val page: Page): basePage(page) {
    override val url = "https://www.saucedemo.com/inventory.html"
    private val cartButton: Locator = page.locator("#shopping_cart_container")

    fun isOnPage(): Boolean {
        return urlMatches() && cartButton.isVisible
    }

}