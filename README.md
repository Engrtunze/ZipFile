# FILE COMPRESSOR

A simple Java backend rest service that zips a file and returns it to the user.
## Prerequisites
Download :

[Docker](https://www.docker.com/)

[Postman](https://www.postman.com/) or any other HTTP client to test.


## Created with

- [Java](https://www.java.com/en/)
- [Spring boot](https://spring.io/)
- [Docker](https://www.docker.com/)
- [Git](https://github.com/)

## Installation

To run this program simply clone the repo from GitHub using the following command,

```bash
 https://github.com/Engrtunze/ZipFile.git
```

Then open the application with an IDE preferably IntelliJ or eclipse, after this run the project by right-clicking on the project class `FileConverterApplication` and then click on the play button to run.
the run with `http://localhost:8080/compress` because port 8080 is the default server port on spring boot.

OR

Run on docker by cloning the repo from the docker hub using the following command,

```
docker pull engrtunze/file-compressor:latest
```

Then check if the image is added to your docker using the following command,

```bash
 docker images
```
expected output will be
```
REPOSITORY                    TAG       IMAGE ID       CREATED       SIZE
engrtunze/file-compressor     latest    27200cfec375   time creaded    421MB`
```
After building run the command below to run the docker container
```bash
 docker run -p [8000]:[8080] engrtunze/file-compressor or any port of your choice this will what will determine what will be used to access or test the project on postman `http://localhost:[8000]/compress`
```
## Usage on Postman
[Http method: POST]
```
127.0.0.1:[8080]/compress
```
OR

```
http://localhost:[8080]/compress
```
![App Screenshot](https://i.postimg.cc/vTFfmwsG/Screenshot-2022-12-15-at-1-13-57-AM.png)

After calling the endpoint it returns resources. I know it looks gibberish 😁 but this won't display like this when consumed on the front end instead it will display a download dialog box.
![App Screenshot](https://i.postimg.cc/pd0txPKn/Screenshot-2022-12-15-at-1-14-54-AM.png)

Then click on the `Save Response` drop-down as shown in the image above and click on `Save to a file this will display the save to location dialog box shown in the image below.
![App Screenshot](https://i.postimg.cc/9Fc1PZ6C/Screenshot-2022-12-15-at-1-15-12-AM.png)

You can decide to save the zip file in a preferred location in a system.

# Development Documentation 🤓
## classes and interfaces created
- FileCompressor
- FileConverter
- FileConverterImpl
- FileConverterController

--> Created a utility class called FileCompressor which has two methods which are
- zipFIle : This methods returns a string of file path that can be downloaded after zipping and also accept MultipartFile type
  and a String that a user passes from the frontend into the service to process it to zip.

- compressAndDownload: This method receives path file as a String, this methods returns the path file sent to it as a resources that can be downloaded.
  This was done because of the single responsibility principles in The S.O.L.I.D principles.

--> Created a FileConverter interface which returns `Resources` and accept `MultipartFile`(which represent any kind of file type)
  and `fileName`(This represent a custom name that can be given to the zipped file).

--> FileConverterImpl implements the interface this is the service layer where the logic is written the method makes a call to the methods in the utility class.

--> FileConverterController this is the rest service layer that phases the client and exposes the url or endpoint to access the service,
because we need to pass in a file i had to use `@RequestParam` to accept file and String.

## EXTRAS

- This can also be done by saving the uploaded file in AWS S3 bucket and then the link will be returned and saved into the database for referencial purposes in a live applicaion.
