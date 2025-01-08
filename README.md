# OrangeHRM Project

Welcome to the **OrangeHRM Project** repository! This project demonstrates the implementation of automated test cases for the **OrangeHRM** platform using Selenium WebDriver, Java, and TestNG. The aim is to ensure the platform's reliability, functionality, and performance.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

The **OrangeHRM Project** focuses on building a robust automated testing framework to validate the core functionalities of the OrangeHRM application. With Selenium as the core testing library, the project ensures seamless browser automation, detailed test reporting, and easy scalability.

---

## Features

- Automated test cases for key modules like:
  - Login
  - User Management
  - Employee Information
  - Leave Management
- Cross-browser compatibility testing.
- Detailed TestNG reports for test execution results.
- Modular and reusable page object model (POM) architecture.
- Easy integration with CI/CD pipelines.

---

## Technologies Used

- **Programming Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Logging:** Log4j
- **Reporting:** TestNG reports

---

## Setup Instructions

### Prerequisites

1. Install [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher).
2. Install [Apache Maven](https://maven.apache.org/).
3. Install a modern web browser (e.g., Google Chrome, Mozilla Firefox).
4. Download the corresponding WebDriver for the browser:
   - [ChromeDriver](https://chromedriver.chromium.org/downloads)
   - [GeckoDriver](https://github.com/mozilla/geckodriver/releases)

### Clone the Repository

```bash
git clone https://github.com/sailesh123kumar/OrangeHRMproject.git
cd OrangeHRMproject
```

### Install Dependencies

Run the following Maven command to download and install all required dependencies:

```bash
mvn clean install
```

### Configure WebDriver

1. Place the browser driver (e.g., `chromedriver.exe` or `geckodriver.exe`) in a directory of your choice.
2. Update the WebDriver path in the configuration file (e.g., `config.properties`).

---

## Usage

### Running Test Cases

1. Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse).
2. Execute the following Maven command to run the tests:

```bash
mvn test
```

### Viewing Test Reports

After execution, the test reports can be found in the `test-output` directory.

---

## Contributing

Contributions are welcome! If you'd like to enhance the project or fix issues:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature-name`).
5. Open a Pull Request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

