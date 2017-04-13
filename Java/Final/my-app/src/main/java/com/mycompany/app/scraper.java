
package com.mycompany.app;

import com.google.gson.Gson;
import java.util.List;
import org.jboss.resteasy.client.ClientRequest;


public class scraper {
    
    public List<RifleData> RifleDataList(String id) {
        String result = "";
        
        String steamid = "steamid=" + id + "&";
        String query = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?"
                + "appid=730&key=F73E7724099FDD0F60829638F5E7A9FF&steamid="
                + steamid;

        ClientRequest cr = new ClientRequest(query);
        try
        {
            result = cr.get(String.class).getEntity();
        }
        catch(Exception ex)
        {
            System.out.println("We failed");
        }
        //System.out.println(result);
        Gson gson = new Gson();
        RifleDataListRoot myRifleDataList = gson.fromJson(result, RifleDataListRoot.class);
        return myGameList.response.games;
        
    }
    
}

class stats {
    playerstats stats;
}


