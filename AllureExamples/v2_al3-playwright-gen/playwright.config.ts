import type { PlaywrightTestConfig } from "@playwright/test";

const config: PlaywrightTestConfig = {
    reporter: [
        ['list']
        ,['allure-playwright',
            {
            resultsDir: "allure-results",
            }
        ]
    ]
}
export default config;