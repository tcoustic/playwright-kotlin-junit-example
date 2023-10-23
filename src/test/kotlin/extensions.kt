import com.microsoft.playwright.Page
import pages.LoginPage
import pages.MainPage

fun main(page: Page, func: MainPage.() -> Unit) = MainPage(page).apply(func)
fun login(page: Page, func: LoginPage.() -> Unit) = LoginPage(page).apply(func)