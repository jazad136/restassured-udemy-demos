import {defineConfig} from "allure";

export default defineConfig({
    name: 'Allure Report'
    ,output: './allure-report'
    ,historyPath: './history.jsonl'
    ,environments: { 
        ddf: {
            matcher: ({labels}) => labels.some(({name, value}) => name==='env' && value ==='ddf')
            ,variables: {   
                URL: "file:///C:/Users/JonathanSaddler/Code/tryout/java/selenium-example2/PracticeTestWebsite/practice-test-login/index.html"
               ,
            }
        },
    }
    ,categories: {
        rules: [{ 
            name: 'By Accounting Domain'
            ,id: 'accounting-domain-category'
            ,matchers : testObject => 
                testObject.labels.some(l => l.name === 'accountingDomain')
            ,groupBy: [{label: 'accountingDomain'}]
            ,groupByMessage: false
            ,groupEnvironments: false
            ,expand: true
        }, {
            name: 'Uncategorized'
            ,id: 'uncategorized-category'
            ,matchers : testObject => true
        }]
    }
    
})