package com.dana;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// a couple of different ways to connect using an HttpURLConnection

// first program is asynchronous and used in Java 11 as it parses JSON data
// in preparation to use a database to hold inventory items in my final project
// from what I have learned this is better to use on an android app

// second program is a simple synchronous connection
// typecasting URLConnection to HttpURLConnection and returns information about
// a particular website

public class HttpURLConnectionMethods {
// API handles asynchronous operations  better for android app development
// https://jsonplaceholder.typicode.com/albums contains 100 development environment albums
// the code runs on a background thread, not blocking the main thread, using the API

    public static void main(String[] args) {
        // wrap in a try catch block to handle an exception
        try {
            // create myClient
            HttpClient myClient = HttpClient.newHttpClient();

            // build the Http myRequest to send to the server URL at jsonplaceholder
            // HttpRequest.Builder myRequest = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums"));
            HttpRequest myRequest = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
/*
// without parseJSON data from array
        // set myClient to send asynchronous myRequest, server to send response
        // as a String of type CompletableFuture
        myClient.sendAsync(myRequest, HttpResponse.BodyHandlers.ofString())
                // using lambda expression :: to use body method from HttpResponse class
                // on line above previous result
                .thenApply(HttpResponse::body)
                // using lambda expression :: print the body method result using println method
                .thenAccept(System.out::println)
                // return results from CompletableFuture to the current state,
                // without .join() no results will display
                .join();
*/

// with parsing JSON data from array
            // set myClient to send asynchronous myRequest, server to send response
            // as a String of type CompletableFuture
            myClient.sendAsync(myRequest, HttpResponse.BodyHandlers.ofString())
                    // using lambda expression :: to use body method from HttpResponse class
                    // on line above previous result
                    .thenApply(HttpResponse::body)
                    // using lambda expression :: print the body method result using parseJSON method
                    // which is in HttpURLConnectionMethods
                    .thenApply(HttpURLConnectionMethods::parseJSON)
                    // return results from CompletableFuture to the current state,
                    // without .join() no results will display
                    .join();

          // catch the exception
        } catch(Exception exception1) {
            // print a stacktrace to decipher what went wrong
            exception1.printStackTrace();
        }
    }
// parse JSON data using a third party library, in an array with elements separated by colons
    // from "https://jsonplaceholder.typicode.com/albums"
    // loop through JSON array and get JSON object out of each index
    // from the object get userID, id, and title

    // define JSON array
    public static String parseJSON(String resultsBody) {
        // define JSON array
        JSONArray jsonAlbums = new JSONArray(resultsBody);
        // iterate through jsonAlbums using a for loop to extract the data
        for (int i = 0; i < jsonAlbums.length(); i++) {
            // each iteration will get one JSON object out of jsonAlbums
            JSONObject albumObject = jsonAlbums.getJSONObject(i);
            // with object I can extract userId, id, and title
            int id = albumObject.getInt("id");
            int userId = albumObject.getInt("userId");
            String title = albumObject.getString("title");

            // the data can be stored in a database, displayed in an
            // application UI, or printed on console to verify it works

            // print data to verify it extracted correctly
            System.out.println(id + " " + title + " " + userId);
        }
        return null;
    }
}

// second program simple synchronous connection, pulls data about the website
class HttpURLConnectionSimple {

    public static void main(String[] args) {
        // wrap in a try catch block
        try {

            // rather than using
            // public URLConnection openConnection() throws IOException{ }
            // and catching an IOException
            // typecast it to HttpURLConnection type
            URL myURL = new URL("http://bigbearshores.org");

            // typecast URLConnection to HttpURLConnection type
            HttpURLConnection myHttpURLConnection = (HttpURLConnection)myURL.openConnection();

            // iterate through each header field using for loop,
            // there are 12 total fields with data
            for(int i = 1; i <= 13; i++) {
                // print each header field key and contents, map with key value fields
                System.out.println(myHttpURLConnection.getHeaderFieldKey(i) + " = " + myHttpURLConnection.getHeaderField(i));
            }

            // close the myHttpURLConnection
            myHttpURLConnection.disconnect();

            // catch the exception
        } catch(Exception exception2) {
            // print a stacktrace to decipher what went wrong
            exception2.printStackTrace();
        }
    }
}
