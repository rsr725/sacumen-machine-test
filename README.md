# sacumen-machine-test

This app is deployed on heroku and can be accessed via the URL:
https://sacumen-machine-test.herokuapp.com/get

This app documentation is available on this URL:
https://sacumen-machine-test.herokuapp.com/swagger-ui.html

Note that the above applicaion is deployed on free dynos of heroku, which means that the applicaion sleeps after some minutes of inactivity. So the first access to the above url may be slow and require some time for dynos to start. The subsequent access will be faster.

The file is in JSON format V1:
```
{
    <csv file name> : [
        "<issue id 1>",
        "<issue id 2>",
        ...,
        ...
    ]
    ...
}
```

This is version 2.0.
--------------------

Here I just added user interface for this app and can be accessed via the URL:
https://sacumen-machine-test.herokuapp.com

![Sacumen_machine_test](https://user-images.githubusercontent.com/25204144/56497928-376f2a80-651d-11e9-9e49-5d9fef3557d2.png)
