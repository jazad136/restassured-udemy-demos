import type { PlaywrightTestConfig } from "@playwright/test";

const config: PlaywrightTestConfig = {
    testMatch : ['e2e/**/*.spec.js'],
    // testIgnore : '**/old/*.spec.ts',
    reporter: [
        ['list']
        ,['allure-playwright',
            {
            resultsDir: "allure-results",
            suiteTitle: true,
            }
        ]
    ]
}
export default config;