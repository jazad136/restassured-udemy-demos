import {test, expect} from '@playwright/test'
import {allure} from 'allure-playwright'

test('Acquire to Dispose (A2D) Login Test', async ({ page }, testInfo) => {
    allure.label('env', 'ddf')
    allure.label('acctValueStream','acquire-to-dispose')
    allure.epic('User Authentication');
    allure.feature('Login Feature A2D');
    allure.story('Valid Login Test A2D');
    allure.tag('smoke', 'login');
    await test.step('Open A2D Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await test.step('Enter A2D credentials', async () => {
        await page.fill('#username', 'student');
        await page.fill('#password', 'Password123');
        await page.click('button[id="submit"]');
    });

    await test.step('Validate A2D dashboard redirection', async () => {
        const screenshot = await page.screenshot();
        testInfo.attach('Dashboard Screenshot', {body: screenshot, contentType: 'image/png'});
        await expect(page).toHaveTitle(/Test Post Login \| Practice Test Automation/);
    });
});