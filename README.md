# HelloWorld.java

![thumbnail](./Thumbnail.jpeg)

Welcome to the **Nanowar Of Steel**'s first GitHub project, and first ever example of a **source-code song**.
The aim of this project is to support and enforce "_True metal programming_", that basically means: "_write code so badly that only you can sing it_".

You can find the source-code video in the link below:
https://www.youtube.com/watch?v=yup8gIXxWDU

[Here](https://nanowar.it/) is the Nanowar Of Steel official website.

[Here](https://www.youtube.com/@nanowarVEVO) is the Nanowar Of Steel Youtube Channel.

Some important notes:
1. Beware of ```Joey De Caio```, if set to null It may suddenly cancel the program execution with a NullPointerException.
2. ```metal``` variable is very important! If it is set to "false", it may trigger the Joey De Caio variable mentioned above.
3. ```tizio``` and ```foo``` are very close friends.
4. ```pippo``` isn't ```tizio```'s friend, but he's been flirting with ```foo```.
5. In the comments "**manage**" should be renamed as "**handle**" (we all wish "manage" was the right word, but it's not).
6. The constructor argument is used to control the number of executions. However, It may be completely useless if the execution is cancelled by ```Joey De Caio```.
7. "_Write once, run anywhere_" means literally anywhere (e.g. Hellfest).
8. ```songRefrain()``` identifies itself as a void method.

Below you will find a super detailed guide to the program, of course written with ChatGPT.

---

# HelloWorldMainLauncherClass

This project contains a simple Java application that demonstrates the basic usage of loops, conditionals, and handling null-pointer exceptions. The main functionality includes printing "Hello World!" multiple times based on a user-defined parameter and intentionally introducing a bug to highlight error handling.

## Overview

The `HelloWorldMainLauncherClass` performs the following tasks:

1. **Initialization**: Accepts an integer parameter (`foo`) that controls how many times "Hello World!" will be printed.
2. **Song Refrain**: Prints "Hello World!" twice—first using a `for` loop and then using a `while` loop.
3. **Exception Handling**: Contains a method `falseMethod()` that introduces a `NullPointerException` by calling `length()` on a `null` string to simulate error handling.

## Features

- **Hello World printing**: Outputs the message "Hello World!" a number of times based on the provided parameter.
- **Loops**: Demonstrates basic usage of `for` and `while` loops in Java.
- **Exception simulation**: Introduces a `NullPointerException` for demonstration purposes.
- **Basic Java structure**: Showcases constructor usage, instance variables, and method definitions.

## Prerequisites

- Java Development Kit (JDK) 8 or higher.
- A Java IDE (like IntelliJ IDEA, Eclipse, or NetBeans) or a command-line environment to compile and run the Java program.

## Installation

To set up and run this project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/NanowarOfSteel/HelloWorld.git
   ```

2. Navigate into the project directory:
   ```bash
   cd HelloWorld
   ```

3. Compile the Java file:
   ```bash
   javac HelloWorldMainLauncherClass.java
   ```

4. Run the program:
   ```bash
   java HelloWorldMainLauncherClass
   ```

## Usage

Once you run the program, you will see the following output:

```
Hello World Programmer Start
Hello World!
Hello World!
Hello World!
Hello World!
Program Finished!
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "joeyDeCaio" is null
    at HelloWorldMainLauncherClass.falseMethod(HelloWorldMainLauncherClass.java:35)
    at HelloWorldMainLauncherClass.main(HelloWorldMainLauncherClass.java:27)
```

### Configuration

The number of times "Hello World!" is printed can be controlled by changing the parameter passed to the constructor of `HelloWorldMainLauncherClass`. For example:

```java
HelloWorldMainLauncherClass tizio = new HelloWorldMainLauncherClass(3);
```

This will print "Hello World!" three times.

## Code Explanation

1. **Constructor**: The constructor takes an integer `foo` that determines how many times the message will be printed.
   ```java
   public HelloWorldMainLauncherClass(int foo) {
       super();
       this.foo = foo;
   }
   ```

2. **songRefrain() Method**: The method contains two loops—`for` and `while`—both of which print "Hello World!" the number of times specified by `foo`.
   ```java
   public void songRefrain() {
       for (int i = 0; i < foo; i++) {
           System.out.println("Hello World!");
       }

       int pippo = 0;
       while (pippo < foo) {
           System.out.println("Hello World!");
           pippo++;
       }
   }
   ```

3. **falseMethod() Method**: This method deliberately introduces a bug by attempting to call `length()` on a `null` string.
   ```java
   public void falseMethod() {
       boolean metal = false;
       if (metal == false) {
           String joeyDeCaio = null;
           joeyDeCaio.length();
       }
   }
   ```
### Notes:

- **Bug introduction**: The purpose of `falseMethod()` is to demonstrate a scenario where an exception is thrown. The `NullPointerException` is handled by the JVM, but no explicit exception handling is implemented in this case.
  
- **Extending the Program**: You can extend the program by adding more features like exception handling, more complex message outputs, or additional loops and conditionals.

# Docker Guide

This repository contains a Dockerfile that automates the process of building and running a Java application using Maven. The Docker image is built in two stages: the first stage builds the application with Maven, and the second stage runs the application with a minimal OpenJDK 17 image.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Build and Run Instructions](#build-and-run-instructions)
- [Usage](#usage)
- [Cleaning Up](#cleaning-up)
- [Notes](#notes)

## Prerequisites

Before building and running the Docker image, make sure you have the following installed:

- **Docker**: [Install Docker](https://www.docker.com/get-started)
- **Maven**: (Optional) Maven is only needed locally for building the project if you're not using the Docker build.

## Build and Run Instructions

### 1. Clone the repository

First, clone the repository containing the project and the Dockerfile to your local machine:

```bash
git clone <your-repository-url>
cd <your-repository-directory>
```

### 2. Build the Docker image

You can build the Docker image using the following command. Make sure you're in the root directory of the project, where the Dockerfile is located:

```bash
docker build -t my-java-app .
```

This command will:
1. Use an official Maven image to build the application.
2. Package the application into a JAR file.
3. Use a slim OpenJDK 17 image to run the resulting application.

### 3. Run the Docker container

After the build is complete, you can run the Docker container using:

```bash
docker run -p 8080:8080 my-java-app
```

This will start the application and expose it on port `8080`. You can adjust the port if necessary.

## Usage

Once the container is running, the application should be available at `http://localhost:8080`. This assumes your application is set to listen on port `8080`. You can modify the port mapping as needed.

If the application requires specific environment variables or configuration, you can pass them at runtime like so:

```bash
docker run -p 8080:8080 -e ENV_VAR_NAME=value my-java-app
```

## Cleaning Up

To stop the running container, you can use:

```bash
docker ps  # Find the container ID
docker stop <container_id>
```

You can also remove the container and image once you're done:

```bash
docker rm <container_id>  # Remove the container
docker rmi my-java-app    # Remove the image
```

## Notes

- **Multi-stage build**: The Dockerfile uses a multi-stage build to ensure the final image is small and optimized for running the application. The first stage uses the Maven image to build the application, and the second stage uses a slim JDK image to run it.
- **JAR file location**: The final JAR file is copied from the `/target` directory in the Maven build stage to the working directory in the runtime stage (`/app`).
  
## Troubleshooting

- **Issue**: The application isn't starting or doesn't work as expected.
  - **Solution**: Check the logs for any error messages by running:
    ```bash
    docker logs <container_id>
    ```

- **Issue**: Docker build fails due to missing dependencies.
  - **Solution**: Make sure all necessary dependencies are listed in your `pom.xml` file, and try running `mvn clean install` locally to check for issues before attempting the Docker build.

---

# License

This project is licensed under the IronAvantgarde Publishing & Napalm Records License - see the [Napalm Records Website](https://napalmrecords.com/) for more details.

# Contributing

Feel free to fork this repository, submit issues, or open pull requests if you'd like to improve this code. Contributions are always welcome!

# Contacts

**Do you want some buggy, personalized and singable code by Nanowar Of Steel**? Please contact us [here](mailto:nanowar@nanowar.it). 
