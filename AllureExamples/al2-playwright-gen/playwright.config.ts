import type { PlaywrightTestConfig } from "@playwright/test";

const config: PlaywrightTestConfig = {
    testMatch : ['e2e/**/*.spec.js'],
    // testIgnore : '**/old/*.spec.ts',
    // testMatch : ['old/**/*.spec.js'],
    reporter: [
        ['list']
        ,['allure-playwright',
            {
            resultsDir: "allure-results"
            }
        ]
    ]
}
export default config;