package com.example.udesc.reservadesalas.Services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {

    private String baseUrl;
    private String repositoryName;
    private String fullUrl;
    private URL url;
    private HttpURLConnection connection;

    public ReservaService() {
        this.baseUrl = "http://10.0.2.2:8080"; //Eh o mesmo que localhost:8080
        this.repositoryName = "reservas";
        this.fullUrl = this.baseUrl + "/" + this.repositoryName;
    }

    public boolean addReserva(
            String id,
            String nome,
            String data,
            String horario,
            String sala
    ) {
        try {
            this.url = new URL(this.fullUrl);
            this.connection = (HttpURLConnection) this.url.openConnection();
            this.connection.setRequestMethod("POST");
            this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            this.connection.setRequestProperty("Accept", "application/json");
            this.connection.setDoOutput(true);

            String jsonInputString = "{\"id\": \"" + id
                    + "\", \"nome\" : \"" + nome
                    +"\", \"data\" : \"" +  data
                    + "\",\"horario\" : \"" + horario
                    + "\",\"sala\" : \"" + sala
                    + "\"}";

            try (OutputStream os = this.connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteReserva(
            String id
    ) {
        try {

            String idURL = "/" + id;

            this.url = new URL(this.fullUrl + idURL);
            this.connection = (HttpURLConnection) this.url.openConnection();
            this.connection.setRequestMethod("DELETE");
            this.connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            this.connection.setRequestProperty("Accept", "application/json");
            this.connection.setDoOutput(true);

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(this.connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
