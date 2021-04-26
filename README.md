# SeleniumTestNGParallel
A framework which allows different Selenium test classes to run in parallel using TestNG

Pros:

1. Static method utilization is reduced
2. Each test case has its own base class instance initiated at the beginning of the test, which controls all other aspects like driver, reporting, test data management etc.
3. Parallel run of different test classes is enabled
4. As test methods, static methods can be utilized as well as dynamic ones.
5. Page Object Model is implemented
6. Easier to maintain the existing test cases.
7. Extent report along with TestNG report is included.
8. Ongoing process of adding new test methods.
9. Temp file management
10. Element Highlighting implemented.
11. Element Screenshot implemented.
12. Running batch file implemented along with task kill chromedriver.exe and chrome.exe
13. Running VBScripts implemented. Although not tested.
14. Replaced deprecated implicit wait and explicit waits with the latest ones.
15. Introduced Fluent Wait.
16. Wrapped the WebDriver with ThreadGuard to protect the thread's ownership of the WebDriver instance.
17. Scroll to middle of the page added.
18. Handling JavaScript alerts, confirmations and prompts are added.
19. HTTP Proxy Setting added with webdriver.
20. Added page loading strategy, pop up blocker and download path in ChromeOptions.
21. Implemented Assertion Manager, controlling Hard & Soft Assert from Configuration file, for each test case.
22. Added remote webdriver but not implemented.

Cons:

1. Parallel Execution Reports are not getting generated. Need to debug that.
2. Screenshot cannot be taken for JavaScript alerts. Need to check later.