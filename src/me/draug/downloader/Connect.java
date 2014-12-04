package me.draug.downloader;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public class Connect {

    private URL url;
    private String link = "http://www.youtube.com/get_video_info?video_id="; // video site
    private String vid = "35W7-gCxslo"; // video
    BufferedReader reader;


    public Connect() throws MalformedURLException, Exception {
        url = new URL(link + vid);

        URLConnection connection = url.openConnection();

        connection.setDoInput(true);
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder sb = new StringBuilder();


        while ((line = reader.readLine()) != null) {
            sb.append(line).append("&\r\n");
        }

        StringBuilder lsb = new StringBuilder();

        for (String l : URLDecoder.decode(sb.toString(), "UTF-8").split("&")) {
            lsb.append(l).append("&\r\n");
        }


        String content = URLDecoder.decode(lsb.toString(), "UTF-8");
        System.out.println(content);

    }


//    private void setLink(String setLink) {
//        reader = new BufferedReader();
//    }

}