import {test, expect} from '@playwright/test'
import {allure} from 'allure-playwright'

test('Budget Formulation-to-Execution (BF2E) Login Test', async ({ page }, testInfo) => {
    allure.label('env', 'ddf')
    allure.label('acctValueStream','budget-formulation-to-execution')
    allure.epic('User Authentication');
    allure.feature('Login Feature BF2E');
    allure.story('Valid Login Test BF2E');
    allure.tag('smoke', 'login');
    await test.step('Open BF2E Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await test.step('Enter BF2E credentials', async () => {
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