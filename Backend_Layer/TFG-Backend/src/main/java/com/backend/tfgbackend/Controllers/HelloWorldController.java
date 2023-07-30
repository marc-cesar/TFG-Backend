package com.backend.tfgbackend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.*;

@RestController
public class HelloWorldController {

    @GetMapping("/sayHello")
    public String sayHelloWorld() throws Exception {
        URL url = new URL("http://127.0.0.1:5000/hello");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        }
        return "BadRequest";
    }

    @GetMapping("/Predict")
    public String Predict() throws Exception {
        URL url = new URL("http://127.0.0.1:5000/Predict");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString="{\"0\": [0],\n" +
                "         \"1\": [6],\n" +
                "         \"2\": [4],\n" +
                "         \"3\": [3],\n" +
                "         \"4\": [200],\n" +
                "         \"5\": [4],\n" +
                "         \"6\": [4],\n" +
                "         \"7\": [4],\n" +
                "         \"8\": [2],\n" +
                "         \"9\": [0],\n" +
                "         \"10\": [4],\n" +
                "         \"11\": [0],\n" +
                "         \"12\": [67],\n" +
                "         \"13\": [2],\n" +
                "         \"14\": [1],\n" +
                "         \"15\": [2],\n" +
                "         \"16\": [2],\n" +
                "         \"17\": [1],\n" +
                "         \"18\": [1],\n" +
                "         \"19\": [0]\n" +
                "         }";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        if (con.getResponseCode() == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        }
        return "BadRequest";
    }


}
