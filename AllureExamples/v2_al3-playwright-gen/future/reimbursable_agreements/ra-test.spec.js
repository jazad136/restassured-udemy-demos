import {test, expect} from '@playwright/test'
import * as allure from 'allure-js-commons'

test('Reimbursable Agreements (RA) Login Test', async ({ page }) => {
    allure.owner('Jonathan Saddler');
    allure.epic('User Authentication');
    allure.label('accountingDomain','reimbursable-agreements')
    allure.feature('Login Feature');
    allure.story('Valid Login Test');
    allure.severity('critical');
    allure.tag('smoke', 'login');
    allure.label('env', 'ddf')
    allure.description('This test validates successful login with valid credentials');
    allure.testCaseId('ITCGI-0001');
    await allure.step('Open Login Page', async () => {
        await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
        // await expect(page).toHaveTitle(/Login/);
        await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
    });
    await allure.step('Enter credentials', async () => {
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