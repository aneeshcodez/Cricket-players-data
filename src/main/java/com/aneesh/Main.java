package com.aneesh;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String continentsDomain = SecretsHelper.getProperty("cricketAPI.continents");
    private static final String countriesDomain = SecretsHelper.getProperty("cricketAPI.countries");
    private static final String playersDomain = SecretsHelper.getProperty("cricketAPI.players");


    // Static method to get all continents
    public static void getAllContinents() {
        try {
            Continentsresponse continentsresponse = OkhttpUtility.getRequest(continentsDomain, Continentsresponse.class);
            displayContinents(continentsresponse);
        } catch (IOException e) {
            System.out.println("Error fetching continents: " + e.getMessage());
        }
    }


    private static void displayContinents(Continentsresponse continentsresponse) {
        // Validate API response
        if (continentsresponse == null || continentsresponse.getContinents() == null || continentsresponse.getContinents().isEmpty()) {
            System.out.println("No continents found");
            return;
        }

        // Display continents
        System.out.println("Here's the list of continents you can explore:");
        List<ContinentDto> continents = continentsresponse.getContinents();
        for (int i = 0; i < continents.size(); i++) {
            System.out.println((i + 1) + ". " + continents.get(i).getName());
        }

    }
    public static int getContinentNo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a No from 1 to 7:");

        int continentId = scanner.nextInt();

        return continentId;

    }
    public static void getCountries(int id) {
        try {
            CountriesResponse countriesResponse = OkhttpUtility.getRequest(countriesDomain + id, CountriesResponse.class);
            displayCountries(countriesResponse);
        } catch (IOException e) {
            System.out.println("Error fetching countries: " + e.getMessage());
        }
    }
    private static void displayCountries(CountriesResponse countriesResponse){
        System.out.println("Here's the list of countries");
        for (int i = 0; i < countriesResponse.getData().size(); i++) {
            CountryDto countryDto = countriesResponse.getData().get(i);
            System.out.println(countryDto.getId() + ". " + countryDto.getName());
        }
    }

    public static int getCountryId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country ID:");

        int countriesId = scanner.nextInt();
        scanner.close();
        return countriesId;
    }

    public static void getPlayers(int countriesId) {
        try {
            PlayersResponse playersResponse = OkhttpUtility.getRequest(playersDomain + countriesId, PlayersResponse.class);
            displayPlayers(playersResponse);
        } catch (IOException e) {
            System.out.println("Error fetching players: " + e.getMessage());
        }
    }

    private static void displayPlayers(PlayersResponse playersResponse) {
        System.out.println("Players for the selected country:");
        for (PlayerDto playerDto : playersResponse.getData()) {
            System.out.println(playerDto.getFullname());
        }
    }


    public static void main(String[] args) {
        // Call the method to get continents
        int continentId;
        int countriesId;

        getAllContinents();
        continentId = getContinentNo();
        getCountries(continentId);
        countriesId = getCountryId();
        getPlayers(countriesId);
    }
}
