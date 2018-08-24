import org.brunocvcunha.jiphy.Jiphy;
import org.brunocvcunha.jiphy.JiphyConstants;
import org.brunocvcunha.jiphy.model.JiphyGif;
import org.brunocvcunha.jiphy.model.JiphySearchResponse;
import org.brunocvcunha.jiphy.requests.JiphySearchRequest;

import java.io.IOException;

public class Giphy {
    Jiphy jiphy = Jiphy.builder()
            .apiKey(JiphyConstants.API_KEY_BETA)
            .build();
    public String getGif(String data) throws IOException {
        JiphySearchResponse returnedGif = jiphy.sendRequest(new JiphySearchRequest(data));
        System.out.println(returnedGif.getData().get(0).getUrl());
        return (returnedGif.getData().get(0).getUrl());
    }
}
