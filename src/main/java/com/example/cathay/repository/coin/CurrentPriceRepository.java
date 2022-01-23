package com.example.cathay.repository.coin;

import com.example.cathay.repository.ICurrentPriceRepository;
import com.example.cathay.response.CoinDeskResponse;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Repository
public class CurrentPriceRepository implements ICurrentPriceRepository {

    private HttpURLConnection connection;

    @Override
    public CoinDeskResponse getCoin()  {
        CoinDeskResponse response;
        try {
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();

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
