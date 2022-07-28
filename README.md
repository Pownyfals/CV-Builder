
# My Book

Library aplications using [Google Books API](https://developers.google.com/books) and powered by [Spring](https://spring.io/).

![ezgif com-gif-maker](https://user-images.githubusercontent.com/38776020/181439493-a5b8589d-171c-49c3-8ea2-85836f3ea536.gif)



## Installation
since this app is still in development, you can start by cloning this repository through your directory

```bash
  git clone https://github.com/Pownyfals/google-book-api-website.git
  cd google-book-api-website
```

Please install the prequisites below to start using the app
 - [Maven](https://maven.apache.org/install.html)


## Getting Started

You can start the application by simple run DemoApplication.java


Type this url in your browser address bar to use the app 
(except you already change the default url in application.properties)

```bash
  localhost:8080
```



## API Reference

#### Peforming Search

```http
  GET https://www.googleapis.com/books/v1/volumes?q=search+terms
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `q` | `string` | special keyword you can specify in search |

Here is an example of searching for Daniel Keyes' "Flowers for Algernon":
```http
  GET https://www.googleapis.com/books/v1/
  volumes?q=flowers+inauthor:keyes&key=yourAPIKey
```




## Documentation
You can see the full google books api documentation below.

[Google Books API](https://developers.google.com/books/docs/v1/using)


## Authors

- [Kevin Febrian](https://github.com/Pownyfals)

