package com.webmusicplayer.musicplayer.domain;

public class Singer {

    private String singerName;
    private String singerImageUrl;
    private String singerIntroduction;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerImageUrl() {
        return singerImageUrl;
    }

    public void setSingerImageUrl(String singerImageUrl) {
        this.singerImageUrl = singerImageUrl;
    }

    public String getSingerIntroduction() {
        return singerIntroduction;
    }

    public void setSingerIntroduction(String singerIntroduction) {
        this.singerIntroduction = singerIntroduction;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerName='" + singerName + '\'' +
                ", singerImageUrl='" + singerImageUrl + '\'' +
                ", singerIntroduction='" + singerIntroduction + '\'' +
                '}';
    }
}
