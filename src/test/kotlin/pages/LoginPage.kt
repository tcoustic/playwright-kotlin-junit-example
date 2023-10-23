package pages

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page

class LoginPage(override val page: Page): basePage(page) {
    override val url = "https://www.saucedemo.com/"
    private val usernameField: Locator = page.locator("input[data-test=\"username\"]")
    private val passwordField: Locator = page.locator("input[data-test=\"password\"]")
    private val loginButton: Locator = page.locator("input[data-test=\"login-button\"]")


    fun open() {
        page.navigate(url)
    }
    fun login(username: String, password: String) {
        usernameField.fill(username)
        passwordField.fill(password)
        loginButton.click()
    }

    infix fun loginWithCorrectCredentials(func: MainPage.() -> Unit): MainPage {
        login("standard_user", "secret_sauce")
        return MainPage(page).apply(func)
    }
}