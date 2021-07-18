# minesweeper-api
Minesweeper Challenge, this is api tha would used for consume for RESTful API's.

Based in `java 11` with `spring boot` using `heroku platform cloud` to running application.

# Table of Contents 

- [`Work Plan to delivery api`](#Work-Plan-to-delivery-api)
- [`Requirements to delivery`](#Requirements-to-delivery)
- [`Configurations`](#Configurations)
- [`Google Java Style Guide`](#google-java-style-guide)
- [`Tools`](#Tools)
- [`Guides`](#Guides)


## Work Plan to delivery minesweeper api
- [x] Created project with initial configurations.
- [x] Created classes with architecture mvc, model, service, controller.
- [x] Created service interface to segregation.
- [x] Included swagger2 with initial swagger configuration.

## Requirements to delivery 
- [ ] Design and implement a documented RESTful API for the game (think of a mobile app for your API)
- [ ] Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
- [ ] When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
- [ ] Ability to 'flag' a cell with a question mark or red flag
- [ ] Detect when game is over
- [ ] Persistence
- [ ] Time tracking
- [ ] Ability to start a new game and preserve/resume the old ones
- [ ] Ability to select the game parameters: number of rows, columns, and mines
- [ ] Ability to support multiple users/accounts



## Configurations

#### Recommended IDE
- IntelliJ IDEA

#### Enabling Lombok plugin:
* Install "lombok" plugin & Enable: Settings -> Compiler -> Annotation Processor -> Enable annotation processing

#### Google Java Style Guide

- All team members should use [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) to keep the code formatting style.
- To format the code you need to install [google-java-format](https://github.com/google/google-java-format), please follow the instructions below.
- The xml file it's found on root project folder. ( intellij-java-google-style.xml )

Steps:


#### The plugin will not be enabled by default.

1. To enable it in the current project, go to "Intellij IDEA→Preferences...→ others plugins → google-java-format
   →
   " and check the "Enable" checkbox.
2. To enable it by default in new projects, use "File→Other Settings→Default Settings...".
3. The xml file it's found on root project folder. ( intellij-java-google-style.xml )
4. (IMPORTANT) Set file on IDEA go to "Intellij IDEA→Preferences...→Editor→Code Style→Java→Gear icon→Import Scheme→Intellij IDEA code style XML".
##Tools

This was principal versions used for this project.

* [Gradle 7.1.1](https://gradle.org/install/) - Great build tool, install before to run locally on your pc.
* [Java 11](https://www.java.com/en/download/) - Used for our Gradle build system and for spring-boot, install before to run locally on your pc.
* [Spring-boot 2.5.2](https://spring.io/blog/2021/06/24/spring-boot-2-5-2-is-now-available) - Spring boot version used for this project.
* [Lombok](https://projectlombok.org) - Compile Tool helps generating code.

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
