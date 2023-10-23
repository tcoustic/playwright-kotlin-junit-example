import com.microsoft.playwright.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import pages.LoginPage
import pages.MainPage


class TestExample {
    private var context: BrowserContext? = null
    private  var page: Page? = null
    @BeforeEach
    fun createContextAndPage() {
        context = browser!!.newContext()
        page = context!!.newPage()
    }

    @AfterEach
    fun closeContext() {
        context!!.close()
    }

    @Test
    fun shouldLogIn() {
        val loginPage = LoginPage(page!!)
        val mainPage = MainPage(page!!)
        loginPage.open()
        loginPage.login("standard_user", "secret_sauce")
        assertTrue(mainPage.isOnPage())
    }

    @Test
    fun shouldAlsoLogIn() {
        login(page!!) { open() } loginWithCorrectCredentials {
            assertTrue(isOnPage())}
    }

    companion object {
        var playwright: Playwright? = null
        var browser: Browser? = null

        @JvmStatic
        @BeforeAll
        fun launchBrowser() {
            playwright = Playwright.create()
            browser = playwright!!.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
        }

        @JvmStatic
        @AfterAll
        fun closeBrowser() {
            playwright!!.close()
        }
    }
}
