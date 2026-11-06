import {test, expect} from '@playwright/test'
import {allure} from 'allure-playwright'

// test.describe('Allure Integration Example', () => {
test('Login functionality test', async ({ page }, testInfo) => {
    allure.suite('User Authentication');
    // allure.feature('Login Feature');
    // allure.story('Valid Login Test');
    // allure.tag('smoke', 'login');
    allure.label('accountingDomain','user-login')
    allure.label('env', 'ddf')
    // allure.description('This test validates successful login with valid credentials');
    // allure.testCaseId('TC-LOGIN-001');
    await test.step('Open Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await test.step('Enter credentials', async () => {
        await page.fill('#username', 'student');
        await page.fill('#password', 'Password123');
        await page.click('button[id="submit"]');
    });

    await test.step('Validate dashboard redirection', async () => {
        const screenshot = await page.screenshot();
        testInfo.attach('Dashboard Screenshot', {body: screenshot, contentType: 'image/png'});
        await expect(page).toHaveTitle(/Test Post Login \| Practice Test Automation/);
    });
});
// });