package com.example.cathay.repository.coin;

import com.example.cathay.repository.ICurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class CurrentPriceRepository implements ICurrentPriceRepository {

    private HttpURLConnection connection;

    @Override
    public CoinDeskResponse getCoin()  {
        CoinDeskResponse response;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            String text = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
            response = objectMapper.readValue(text, CoinDeskResponse.class);

            JSONObject jsonObject = new JSONObject(text);
            TypeReference<HashMap<String, CoinDeskResponse.Bpi>> typeReference = new TypeReference<HashMap<String, CoinDeskResponse.Bpi>>() {};
            HashMap<String, CoinDeskResponse.Bpi> bpiHashMap = objectMapper.readValue(jsonObject.get("bpi").toString(), typeReference);
            response.setBpi(bpiHashMap);

            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }
}
