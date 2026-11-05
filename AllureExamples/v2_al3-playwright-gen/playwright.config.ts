import type { PlaywrightTestConfig } from "@playwright/test";

const config: PlaywrightTestConfig = {
    reporter: [
        ['line']
        ,['allure-playwright',
            {
            resultsDir: "allure-results",
            }
        ]
    ]
}
export default config;