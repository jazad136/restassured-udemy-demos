import {test, expect} from '@playwright/test'
import * as allure from 'allure-js-commons'

// type SessionPageFixtures = { 
//     app : ApplicationKeywords
// }
const portfolioName = "MyPortfolio9999";

test.describe('Test Portfolio Marketplace', () => {
    test('Create Portfolio', async ({ page }) => {
        allure.owner('jsaddler');
        allure.epic('Create Portfolio');
        allure.label('accountingDomain', 'portfolio-create')
        allure.label('env', 'ddf')
        await allure.step('doLogin', async () => {
            console.log("Login Application");  
            // app.openBrowser("browser_name"); // browser already open
            await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
            await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
            await page.fill('#username', 'student');
            await page.fill('#password', 'Password123');
            await page.click('button[id="submit"]');
        });
        await allure.step('createPortfolio', async() => { 
            console.log("Creating portfolio...");
            // app.click("createPortfolio_id");
            await page.click('a[id="createPortfolioDialogOpen"]')
            const txtPortfolioName = page.locator('#portfolioname')
            // app.clear("portfolioname_id");
            await txtPortfolioName.clear();
            // app.type("portfolioname_id", portfolioName);
            await txtPortfolioName.fill(portfolioName)
            // app.click("confirmCreatePortfolio_id");
            const btnConfirmCreatePortfolio = page.locator('#createPortfolioButton')
            await btnConfirmCreatePortfolio.click()
            // app.waitForWebPageToLoad(); // not required in playwright
        });
        await allure.step('validatePortfolioCreated', async() => { 
            // app.validateSelectedValueInDropdown("portfolio_dropdown_id", portfolioName);
            const screenshot = await page.screenshot();
            allure.attachment('Dashboard Screenshot', screenshot, 'image/png');
            const selPortfolios = page.locator('#portfolioList');
            await expect(selPortfolios).toHaveValue(portfolioName);
        });
    });
});