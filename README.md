## Getting started

### Prerequisites

You need to have a Selenium Grid running, to be able to execute the Selenium test.

```
mvn clean test -Dgrid.server.url=http://192.168.99.100:4444/wd/hub
```

### Start Selenium Grid using Docker

1. Create docker-compose.yml file with the following content.
2. Start containers using 'docker-compose up' 

For more details, see https://sandro-keil.de/blog/2015/03/23/selenium-grid-in-minutes-with-docker/

```
selhub:
  image: selenium/hub
  ports:
    - 4444:4444

nodeff:
  image: selenium/node-firefox-debug
  ports:
    - 5900
  links:
    - selhub:hub

nodechrome:
  image: selenium/node-chrome-debug
  ports:
    - 5900
  links:
    - selhub:hub
```
