package com.cwe_client.app;

import com.google.gson.*;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    HTTPClient client = new HTTPClient("http://bald.su:1337/");
    Gson gson = new Gson();
    JsonObject jsonData = JsonParser.parseString(gson.toJson(new Data())).getAsJsonObject();
    JsonObject response = client.POST(jsonData, "register");
    System.out.println(response);
    client.close();
  }
}
