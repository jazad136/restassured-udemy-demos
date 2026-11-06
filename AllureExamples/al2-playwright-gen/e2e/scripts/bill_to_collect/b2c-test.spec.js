import {test, expect} from '@playwright/test'
import {allure} from 'allure-playwright'

test('Bill-to-Collect (B2C) Login Test', async ({ page }, testInfo) => {
    allure.label('env', 'ddf')
    allure.label('acctValueStream','Bill to Collect')
    allure.epic('User Authentication');
    allure.feature('Login Feature B2C');
    allure.story('Valid Login Test B2C');
    allure.tag('smoke', 'login');
    await test.step('Open B2C Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await test.step('Enter B2C credentials', async () => {
        await page.fill('#username', 'student');
        await page.fill('#password', 'Password123');
        await page.click('button[id="submit"]');
    });

    await test.step('Validate B2C dashboard redirection', async () => {
        const screenshot = await page.screenshot();
        testInfo.attach('Dashboard Screenshot', {body: screenshot, contentType: 'image/png'});
        await expect(page).toHaveTitle(/Test Post Login \| Practice Test Automation/);
    });
});