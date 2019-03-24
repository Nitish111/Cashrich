package com.example.nitish.myapplication.modal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewsModal {


    /**
     * status : ok
     * totalResults : 36
     * articles : [{"source":{"id":"engadget","name":"Engadget"},"author":"Jon Fingas","title":"Family tracking app leaked real-time location data for weeks - Engadget","description":"A family tracking app left its live location data exposed for weeks, making it possible to spy on kids' whereabouts.","url":"https://www.engadget.com/2019/03/24/family-tracking-app-leaked-real-time-location-data/","urlToImage":"https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fcrop%3D4498%252C3000%252C0%252C0%26quality%3D85%26format%3Djpg%26resize%3D1600%252C1067%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-images%252F2019-03%252Fc885b720-4db0-11e9-b339-e5f93b87d40a%26client%3Da1acac3e1b3290917d92%26signature%3Deb51cac3cfde2b1907ef63a245911b7b003228bb&client=amp-blogside-v2&signature=140d17902b223c5fc1ceb261e33d167629b48ee3","publishedAt":"2019-03-24T08:26:45Z","content":"This wasn't helped by React's own issues with accountability. Its site had no contact information, and even its WHOIS record masked the email address. Messages through the feedback form turned up nothing. The database didn't go offline until TechCrunch asked \u2026 [+454 chars]"},{"source":{"id":"cnn","name":"CNN"},"author":"Susannah Cullinane and Nicole Chavez, CNN","title":"Tug boats try to pull stranded cruise ship to shore as rescuers rush to evacuate passengers - CNN","description":"Tug boats are trying to move a cruise ship to shore after it was stranded in rough seas off Norway with 1,300 people aboard following engine failure, rescue officials said Sunday.","url":"https://edition.cnn.com/2019/03/24/europe/norway-cruise-ship-stranded/index.html","urlToImage":"https://cdn.cnn.com/cnnnext/dam/assets/190323195153-04-viking-sky-cruise-0323-super-tease.jpg","publishedAt":"2019-03-24T07:52:16Z","content":"(CNN) Tug boats are trying to move a cruise ship to shore after it was stranded in rough seas off Norway with 1,300 people aboard following engine failure, rescue officials said Sunday. Three of the Viking Sky ship's four engines are working, and the ship has\u2026 [+4339 chars]"}]
     */

    private String status;
    private int totalResults;
    private List<ArticlesBean> articles;

    public static NewsModal objectFromData(String str) {

        return new Gson().fromJson(str, NewsModal.class);
    }

    public static NewsModal objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NewsModal.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NewsModal> arrayNewsModalFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewsModal>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NewsModal> arrayNewsModalFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NewsModal>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean {
        /**
         * source : {"id":"engadget","name":"Engadget"}
         * author : Jon Fingas
         * title : Family tracking app leaked real-time location data for weeks - Engadget
         * description : A family tracking app left its live location data exposed for weeks, making it possible to spy on kids' whereabouts.
         * url : https://www.engadget.com/2019/03/24/family-tracking-app-leaked-real-time-location-data/
         * urlToImage : https://o.aolcdn.com/images/dims?thumbnail=1200%2C630&quality=80&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fcrop%3D4498%252C3000%252C0%252C0%26quality%3D85%26format%3Djpg%26resize%3D1600%252C1067%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-images%252F2019-03%252Fc885b720-4db0-11e9-b339-e5f93b87d40a%26client%3Da1acac3e1b3290917d92%26signature%3Deb51cac3cfde2b1907ef63a245911b7b003228bb&client=amp-blogside-v2&signature=140d17902b223c5fc1ceb261e33d167629b48ee3
         * publishedAt : 2019-03-24T08:26:45Z
         * content : This wasn't helped by React's own issues with accountability. Its site had no contact information, and even its WHOIS record masked the email address. Messages through the feedback form turned up nothing. The database didn't go offline until TechCrunch asked … [+454 chars]
         */

        private SourceBean source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;

        public static ArticlesBean objectFromData(String str) {

            return new Gson().fromJson(str, ArticlesBean.class);
        }

        public static ArticlesBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ArticlesBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ArticlesBean> arrayArticlesBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ArticlesBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ArticlesBean> arrayArticlesBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ArticlesBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class SourceBean {
            /**
             * id : engadget
             * name : Engadget
             */

            private String id;
            private String name;

            public static SourceBean objectFromData(String str) {

                return new Gson().fromJson(str, SourceBean.class);
            }

            public static SourceBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), SourceBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<SourceBean> arraySourceBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<SourceBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<SourceBean> arraySourceBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<SourceBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
