# SeleniumTestNGParallel
A framework which allows different selenium test classes to run in parallel using TestNG

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

Cons:

1. Parallel Execution Reports are not getting generated. Need to debug that.