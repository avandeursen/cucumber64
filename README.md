# Running Cucumber with Maven and JUnit

Test project to illustrate https://github.com/junit-team/junit5/issues/616.

Surefire class names expose the internal JUnit 5 base64 encoding it uses to create unique ids for test cases.

## Junit 4

    git checkout junit4
    mvn test
    grep classname target/surefire-reports/TEST-nl.tudelft.cucumber64.CucumberTest.xml

(Desired) Output:

    <testcase name="Given I have chosen to sign up" classname="Scenario: Successful sign up." time="0.001"/>
    <testcase name="When I sign up with valid details" classname="Scenario: Successful sign up." time="0"/>
    <testcase name="Then I should receive a confirmation email" classname="Scenario: Successful sign up." time="0"/>
    <testcase name="And I should see a personalized greeting message" classname="Scenario: Successful sign up." time="0.001"/>
    <testcase name="Scenario: Successful sign up." classname="Scenario: Successful sign up." time="0.001"/>    


## Junit 5 (M3)

    git checkout junit5
    mvn test
    grep classname target/surefire-reports/TEST-nl.tudelft.cucumber64.CucumberTest.xml

(Incompatible) Output (for just first output):

      <testcase name="Given I have chosen to sign up" classname="[engine:junit-vintage]/[runner:nl.tudelft.cucumber64.CucumberTest]/[test:rO0ABXNyAB9naGVya2luLmZvcm1hdHRlci5tb2RlbC5GZWF0dXJlAAAAAAAAAAECAAB4cgAkZ2hlcmtpbi5mb3JtYXR0ZXIubW9kZWwuVGFnU3RhdGVtZW50AAAAAAAAAAECAAJMAAJpZHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABHRhZ3N0ABBMamF2YS91dGlsL0xpc3Q7eHIAKmdoZXJraW4uZm9ybWF0dGVyLm1vZGVsLkRlc2NyaWJlZFN0YXRlbWVudInoQ7yJkLCFAgABTAALZGVzY3JpcHRpb25xAH4AAnhyACZnaGVya2luLmZvcm1hdHRlci5tb2RlbC5CYXNpY1N0YXRlbWVudPM3wIsDVBUvAgAETAAIY29tbWVudHNxAH4AA0wAB2tleXdvcmRxAH4AAkwABGxpbmV0ABNMamF2YS9sYW5nL0ludGVnZXI7TAAEbmFtZXEAfgACeHIAGmdoZXJraW4uZm9ybWF0dGVyLk1hcHBhYmxl42CLFPnowjUCAAB4cHNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAAAdwQAAAAAeHQAB0ZlYXR1cmVzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAAXQACFNpZ24gdXAudAAlU2lnbiB1cCBzaG91bGQgYmUgcXVpY2sgYW5kIGZyaWVuZGx5LnQACHNpZ24tdXAuc3EAfgAJAAAAAHcEAAAAAHg=]/[test:rO0ABXNyACBnaGVya2luLmZvcm1hdHRlci5tb2RlbC5TY2VuYXJpbwAAAAAAAAABAgABTAAEdHlwZXQAEkxqYXZhL2xhbmcvU3RyaW5nO3hyACRnaGVya2luLmZvcm1hdHRlci5tb2RlbC5UYWdTdGF0ZW1lbnQAAAAAAAAAAQIAAkwAAmlkcQB+AAFMAAR0YWdzdAAQTGphdmEvdXRpbC9MaXN0O3hyACpnaGVya2luLmZvcm1hdHRlci5tb2RlbC5EZXNjcmliZWRTdGF0ZW1lbnSJ6EO8iZCwhQIAAUwAC2Rlc2NyaXB0aW9ucQB+AAF4cgAmZ2hlcmtpbi5mb3JtYXR0ZXIubW9kZWwuQmFzaWNTdGF0ZW1lbnTzN8CLA1QVLwIABEwACGNvbW1lbnRzcQB+AANMAAdrZXl3b3JkcQB+AAFMAARsaW5ldAATTGphdmEvbGFuZy9JbnRlZ2VyO0wABG5hbWVxAH4AAXhyABpnaGVya2luLmZvcm1hdHRlci5NYXBwYWJsZeNgixT56MI1AgAAeHBzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2GdAwABSQAEc2l6ZXhwAAAAAHcEAAAAAHh0AAhTY2VuYXJpb3NyABFqYXZhLmxhbmcuSW50ZWdlchLioKT3gYc4AgABSQAFdmFsdWV4cgAQamF2YS5sYW5nLk51bWJlcoaslR0LlOCLAgAAeHAAAAAEdAATU3VjY2Vzc2Z1bCBzaWduIHVwLnQAXE5ldyB1c2VycyBzaG91bGQgZ2V0IGEgY29uZmlybWF0aW9uIGVtYWlsIGFuZCBncmVldGVkIHBlcnNvbmFsbHkgYnkgdGhlIHNpdGUgb25jZSBzaWduZWQgaW4udAAcc2lnbi11cC47c3VjY2Vzc2Z1bC1zaWduLXVwLnNxAH4ACQAAAAB3BAAAAAB4dAAIc2NlbmFyaW8=]/[test:rO0ABXNyABxnaGVya2luLmZvcm1hdHRlci5tb2RlbC5TdGVwAAAAAAAAAAECAAJMAApkb2Nfc3RyaW5ndAAjTGdoZXJraW4vZm9ybWF0dGVyL21vZGVsL0RvY1N0cmluZztMAARyb3dzdAAQTGphdmEvdXRpbC9MaXN0O3hyACZnaGVya2luLmZvcm1hdHRlci5tb2RlbC5CYXNpY1N0YXRlbWVudPM3wIsDVBUvAgAETAAIY29tbWVudHNxAH4AAkwAB2tleXdvcmR0ABJMamF2YS9sYW5nL1N0cmluZztMAARsaW5ldAATTGphdmEvbGFuZy9JbnRlZ2VyO0wABG5hbWVxAH4ABHhyABpnaGVya2luLmZvcm1hdHRlci5NYXBwYWJsZeNgixT56MI1AgAAeHBzcgATamF2YS51dGlsLkFycmF5TGlzdHiB0h2Zx2GdAwABSQAEc2l6ZXhwAAAAAHcEAAAAAHh0AAZHaXZlbiBzcgARamF2YS5sYW5nLkludGVnZXIS4qCk94GHOAIAAUkABXZhbHVleHIAEGphdmEubGFuZy5OdW1iZXKGrJUdC5TgiwIAAHhwAAAAB3QAGEkgaGF2ZSBjaG9zZW4gdG8gc2lnbiB1cHBw]" time="0.005"/>


## Junit 5 (SNAPSHOT)

This is the current master. Fixed after PR https://github.com/junit-team/junit5/pull/622
