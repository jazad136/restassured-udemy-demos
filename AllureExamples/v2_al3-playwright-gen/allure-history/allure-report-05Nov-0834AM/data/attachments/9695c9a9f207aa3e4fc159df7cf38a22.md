# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: e2e\allure-test.spec.js >> Login functionality test
- Location: e2e\allure-test.spec.js:5:5

# Error details

```
Error: expect(page).toHaveTitle(expected) failed

Expected pattern: /Test Post Logi \| Practice Test Automation/
Received string:  "Test Post Login | Practice Test Automation"
Timeout: 5000ms

Call log:
  - Expect "toHaveTitle" with timeout 5000ms
    13 × locator resolved to <html lang="en-US">…</html>
       - unexpected value "Test Post Login | Practice Test Automation"

```

```yaml
- link "Press \"Enter\" to skip to content":
  - /url: https://practicetestautomation.com/practice/#main-container
- banner:
  - navigation
  - link "Practice Test Website":
    - /url: https://practicetestautomation.com/
    - heading "Practice Test Website" [level=2]
  - navigation:
    - navigation:
      - list:
        - listitem:
          - link "Home":
            - /url: https://practicetestautomation.com/
        - listitem:
          - link "Practice":
            - /url: https://practicetestautomation.com/practice/
        - listitem:
          - link "Courses":
            - /url: https://practicetestautomation.com/courses/
        - listitem:
          - link "AI Workshop":
            - /url: https://practicetestautomation.com/workshop
        - listitem:
          - link "Blog":
            - /url: https://practicetestautomation.com/blog/
        - listitem:
          - link "Contact":
            - /url: https://practicetestautomation.com/contact/
        - listitem:
          - link "Sign In":
            - /url: ../practice-test-login/index.html
- main:
  - article:
    - heading "Logged In Successfully" [level=1]
    - paragraph:
      - strong: Congratulations student. You successfully logged in!
    - link "Log out":
      - /url: ../practice-test-login/index.html
    - heading "My portfolios" [level=3]
    - combobox: "--"
    - link "Create Portfolio":
      - /url: "#"
    - link "Delete Portfolio":
      - /url: "#"
- contentinfo:
  - text: © Copyright 2020
  - link "Jonathan Saddler.":
    - /url: "#"
  - text: All rights reserved |
  - link "Privacy Policy":
    - /url: "#"
```

# Test source

```ts
  1  | import {test, expect} from '@playwright/test'
  2  | import * as allure from 'allure-js-commons'
  3  | 
  4  | // test.describe('Allure Integration Example', () => {
  5  | test('Login functionality test', async ({ page }) => {
  6  |     allure.owner('Automation User');
  7  |     allure.epic('User Authentication');
  8  |     allure.feature('Login Feature');
  9  |     allure.story('Valid Login Test');
  10 |     allure.severity('critical');
  11 |     allure.tag('smoke', 'login');
  12 |     allure.description('This test validates successful login with valid credentials');
  13 |     allure.testCaseId('TC-LOGIN-001');
  14 |     await allure.step('Open Login Page', async () => {
  15 |         await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
  16 |         // await expect(page).toHaveTitle(/Login/);
  17 |         await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
  18 |     });
  19 |     await allure.step('Enter credentials', async () => {
  20 |         await page.fill('#username', 'student');
  21 |         await page.fill('#password', 'Password123');
  22 |         await page.click('button[id="submit"]');
  23 |     });
  24 | 
  25 |     await allure.step('Validate dashboard redirection', async () => {
> 26 |         await expect(page).toHaveTitle(/Test Post Logi \| Practice Test Automation/);
     |                            ^ Error: expect(page).toHaveTitle(expected) failed
  27 |         const screenshot = await page.screenshot();
  28 |         allure.attachment('Dashboard Screenshot', screenshot, 'image/png');
  29 |     });
  30 | });
  31 | // });
```