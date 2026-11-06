import {test, expect} from '@playwright/test'
import * as allure from 'allure-js-commons'

test('Budget Formulation-to-Execution (BF2E) Login Test', async ({ page }) => {
    allure.label('env', 'ddf')
    allure.label('acctValueStream','budget-formulation-to-execution')
    allure.epic('User Authentication');
    allure.feature('Login Feature BF2E');
    allure.story('Valid Login Test BF2E');
    allure.tag('smoke', 'login');
    // allure.owner('Jonathan Saddler');
        // allure.severity('critical');
    // allure.description('This test validates successful login with valid credentials');
    // allure.testCaseId('ITCGI-0001');
    await allure.step('Open BF2E Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await allure.step('Enter BF2E credentials', async () => {
        await page.fill('#username', 'student');
        await page.fill('#password', 'Password123');
        await page.click('button[id="submit"]');
    });

    await allure.step('Validate dashboard redirection', async () => {
        await expect(page).toHaveTitle(/Test Post Login \| Practice Test Automation/);
        const screenshot = await page.screenshot();
        allure.attachment('Dashboard Screenshot', screenshot, 'image/png');
    });
});