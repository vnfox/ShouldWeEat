package com.how.should.eat.data.network.model.feed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.how.should.eat.data.network.model.BaseResponse;

import java.util.List;

public class FeedResponse extends BaseResponse {

    @Expose
    @SerializedName("data")
    private List<Feed> data;

    public List<Feed> getData() {
        return data;
    }

    public void setData(List<Feed> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedResponse)) return false;

        FeedResponse that = (FeedResponse) o;

        if (!statusCode.equals(that.statusCode)) return false;
        if (!message.equals(that.message)) return false;
        return data.equals(that.data);

    }

    @Override
    public int hashCode() {
        int result = statusCode.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }

    public static class Feed {

        @Expose
        @SerializedName("blog_url")
        private String blogUrl;

        @Expose
        @SerializedName("img_url")
        private String coverImgUrl;

        @Expose
        @SerializedName("title")
        private String title;

        @Expose
        @SerializedName("description")
        private String description;

        @Expose
        @SerializedName("author")
        private String author;

        @Expose
        @SerializedName("published_at")
        private String date;

        public String getBlogUrl() {
            return blogUrl;
        }

        public void setBlogUrl(String blogUrl) {
            this.blogUrl = blogUrl;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Feed)) return false;

            Feed blog = (Feed) o;

            if (!blogUrl.equals(blog.blogUrl)) return false;
            if (!coverImgUrl.equals(blog.coverImgUrl)) return false;
            if (!title.equals(blog.title)) return false;
            if (!description.equals(blog.description)) return false;
            if (!author.equals(blog.author)) return false;
            return date.equals(blog.date);

        }

        @Override
        public int hashCode() {
            int result = blogUrl.hashCode();
            result = 31 * result + coverImgUrl.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + description.hashCode();
            result = 31 * result + author.hashCode();
            result = 31 * result + date.hashCode();
            return result;
        }
    }
}
