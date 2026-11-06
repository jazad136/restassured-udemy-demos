import {test, expect} from '@playwright/test'
import * as allure from 'allure-js-commons'

test('Bill-to-Collect (B2C) Login Test', async ({ page }) => {
    allure.label('env', 'ddf')
    allure.label('acctValueStream','bill-to-collect')
    allure.epic('User Authentication');
    allure.feature('Login Feature B2C');
    allure.story('Valid Login Test B2C');
    allure.tag('smoke', 'login');
    // allure.owner('Jonathan Saddler');
    // allure.severity('critical');
    // allure.description('This test validates successful login with valid credentials');
    // allure.testCaseId('ITCGI-0001');
    await allure.step('Open B2C Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await allure.step('Enter B2C credentials', async () => {
        await page.fill('#username', 'student');
        await page.fill('#password', 'Password123');
        await page.click('button[id="submit"]');
    });

    await allure.step('Validate B2C dashboard redirection', async () => {
        await expect(page).toHaveTitle(/Test Post Login \| Practice Test Automation/);
        const screenshot = await page.screenshot();
        allure.attachment('Dashboard Screenshot', screenshot, 'image/png');
    });
});