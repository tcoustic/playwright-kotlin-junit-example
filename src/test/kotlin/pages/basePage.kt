package pages

import com.microsoft.playwright.Page

abstract class basePage(open val page: Page) {
    abstract val url: String
    fun urlMatches(): Boolean {
        return page.url() == url
    }
}