# Instructions

- Following Playwright test failed.
- Explain why, be concise, respect Playwright best practices.
- Provide a snippet of code with the fix, if possible.

# Test info

- Name: e2e\create-portfolio-test.spec.js >> Test Portfolio Marketplace >> Create Portfolio
- Location: e2e\create-portfolio-test.spec.js:8:9

# Error details

```
Test timeout of 30000ms exceeded.
```

```
Error: page.click: Test timeout of 30000ms exceeded.
Call log:
  - waiting for locator('button[id="createPortfolioDialogOpen"]')

```

# Page snapshot

```yaml
- generic [active] [ref=f1e1]:
  - link "Press \"Enter\" to skip to content" [ref=f1e2] [cursor=pointer]:
    - /url: https://practicetestautomation.com/practice/#main-container
  - generic [ref=f1e4]:
    - banner [ref=f1e5]:
      - generic [ref=f1e6]:
        - generic:
          - navigation
      - link [ref=f1e10] [cursor=pointer]:
        - /url: https://practicetestautomation.com/
        - heading "Practice Test Website" [level=2] [ref=f1e11]
      - navigation [ref=f1e16]:
        - navigation [ref=f1e17]:
          - list [ref=f1e18]:
            - listitem [ref=f1e19]:
              - link "Home" [ref=f1e20] [cursor=pointer]:
                - /url: https://practicetestautomation.com/
            - listitem [ref=f1e21]:
              - link "Practice" [ref=f1e22] [cursor=pointer]:
                - /url: https://practicetestautomation.com/practice/
            - listitem [ref=f1e23]:
              - link "Courses" [ref=f1e24] [cursor=pointer]:
                - /url: https://practicetestautomation.com/courses/
            - listitem [ref=f1e25]:
              - link "AI Workshop" [ref=f1e26] [cursor=pointer]:
                - /url: https://practicetestautomation.com/workshop
            - listitem [ref=f1e27]:
              - link "Blog" [ref=f1e28] [cursor=pointer]:
                - /url: https://practicetestautomation.com/blog/
            - listitem [ref=f1e29]:
              - link "Contact" [ref=f1e30] [cursor=pointer]:
                - /url: https://practicetestautomation.com/contact/
            - listitem [ref=f1e31]:
              - link "Sign In" [ref=f1e32] [cursor=pointer]:
                - /url: ../practice-test-login/index.html
    - main [ref=f1e33]:
      - article [ref=f1e36]:
        - heading "Logged In Successfully" [level=1] [ref=f1e38]
        - generic [ref=f1e39]:
          - paragraph [ref=f1e40]:
            - strong [ref=f1e41]: Congratulations student. You successfully logged in!
          - generic [ref=f1e43]:
            - link "Log out" [ref=f1e45] [cursor=pointer]:
              - /url: ../practice-test-login/index.html
            - generic [ref=f1e47]:
              - heading "My portfolios" [level=3] [ref=f1e48]
              - combobox [ref=f1e50] [cursor=pointer]:
                - generic [ref=f1e52]: "--"
            - link "Create Portfolio" [ref=f1e54] [cursor=pointer]:
              - /url: "#"
            - link "Delete Portfolio" [ref=f1e56] [cursor=pointer]:
              - /url: "#"
    - contentinfo:
      - generic [ref=f1e58]:
        - text: © Copyright 2020
        - link "Jonathan Saddler." [ref=f1e59] [cursor=pointer]:
          - /url: "#"
        - text: All rights reserved |
        - link "Privacy Policy" [ref=f1e60] [cursor=pointer]:
          - /url: "#"
```

# Test source

```ts
  1  | import {test, expect} from '@playwright/test'
  2  | import * as allure from 'allure-js-commons'
  3  | 
  4  | // type SessionPageFixtures = { 
  5  | //     app : ApplicationKeywords
  6  | // }
  7  | test.describe('Test Portfolio Marketplace', () => {
  8  |     test('Create Portfolio', async ({ page }) => {
  9  |         await allure.step('doLogin', async () => {
  10 |             console.log("Login Application");  
  11 |             // app.openBrowser("browser_name"); // browser already open
  12 |             await page.goto('file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html');
  13 |             await expect(page).toHaveTitle(/Test Login \| Practice Test Automation/);
  14 |             await page.fill('#username', 'student');
  15 |             await page.fill('#password', 'Password123');
  16 |             await page.click('button[id="submit"]');
  17 |         });
  18 |         await allure.step('createPortfolio', async() => { 
  19 |             const portfolioName = "MyPortfolio9999";
  20 |             console.log("Creating portfolio...");
  21 |             // app.click("createPortfolio_id");
> 22 |             await page.click('button[id="createPortfolioDialogOpen"]')
     |                        ^ Error: page.click: Test timeout of 30000ms exceeded.
  23 |             const txtPortfolioName = page.locator('#portfolioname')
  24 |             // app.clear("portfolioname_id");
  25 |             await txtPortfolioName.clear();
  26 |             // app.type("portfolioname_id", portfolioName);
  27 |             await txtPortfolioName.fill(portfolioName)
  28 |             // app.click("confirmCreatePortfolio_id");
  29 |             const btnConfirmCreatePortfolio = page.locator('#createPortfolioButton')
  30 |             await btnConfirmCreatePortfolio.click()
  31 |             // app.waitForWebPageToLoad(); // not required in playwright
  32 | 
  33 |             // app.validateSelectedValueInDropdown("portfolio_dropdown_id", portfolioName);
  34 |             
  35 |             // app.reportAll();
  36 | 
  37 |         });
  38 |     });
  39 | });
```