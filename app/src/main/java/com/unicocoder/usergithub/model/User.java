package com.unicocoder.usergithub.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.unicocoder.usergithub.R;

public class User implements Parcelable {

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("twitter_username")
    private String twitterUsername;

    @SerializedName("bio")
    private String bio;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("login")
    private String login;

    @SerializedName("type")
    private String type;

    @SerializedName("blog")
    private String blog;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("company")
    private String company;

    @SerializedName("id")
    private int id;

    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("email")
    private String email;

    @SerializedName("organizations_url")
    private String organizationsUrl;

    @SerializedName("hireable")
    private String hireable;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("public_gists")
    private int publicGists;

    @SerializedName("url")
    private String url;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("followers")
    private int followers;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("following")
    private int following;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("node_id")
    private String nodeId;

    protected User(Parcel in) {
        gistsUrl = in.readString();
        reposUrl = in.readString();
        followingUrl = in.readString();
        twitterUsername = in.readString();
        bio = in.readString();
        createdAt = in.readString();
        login = in.readString();
        type = in.readString();
        blog = in.readString();
        subscriptionsUrl = in.readString();
        updatedAt = in.readString();
        siteAdmin = in.readByte() != 0;
        company = in.readString();
        id = in.readInt();
        publicRepos = in.readInt();
        gravatarId = in.readString();
        email = in.readString();
        organizationsUrl = in.readString();
        hireable = in.readString();
        starredUrl = in.readString();
        followersUrl = in.readString();
        publicGists = in.readInt();
        url = in.readString();
        receivedEventsUrl = in.readString();
        followers = in.readInt();
        avatarUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        following = in.readInt();
        name = in.readString();
        location = in.readString();
        nodeId = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @BindingAdapter({"android:show"})
    public static void ShowImage(ImageView imageView, String urlImage) {
//		Picasso.get().load(urlImage).into(imageView);
        Glide.with(imageView.getContext())
                .load(urlImage)
                .centerCrop()
                .placeholder(R.drawable.ic_person)
                .into(imageView);
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBlog() {
        return blog;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public String getHireable() {
        return hireable;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowers() {
        return followers;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowing() {
        return following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return nodeId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gistsUrl);
        dest.writeString(reposUrl);
        dest.writeString(followingUrl);
        dest.writeString(twitterUsername);
        dest.writeString(bio);
        dest.writeString(createdAt);
        dest.writeString(login);
        dest.writeString(type);
        dest.writeString(blog);
        dest.writeString(subscriptionsUrl);
        dest.writeString(updatedAt);
        dest.writeByte((byte) (siteAdmin ? 1 : 0));
        dest.writeString(company);
        dest.writeInt(id);
        dest.writeInt(publicRepos);
        dest.writeString(gravatarId);
        dest.writeString(email);
        dest.writeString(organizationsUrl);
        dest.writeString(hireable);
        dest.writeString(starredUrl);
        dest.writeString(followersUrl);
        dest.writeInt(publicGists);
        dest.writeString(url);
        dest.writeString(receivedEventsUrl);
        dest.writeInt(followers);
        dest.writeString(avatarUrl);
        dest.writeString(eventsUrl);
        dest.writeString(htmlUrl);
        dest.writeInt(following);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(nodeId);
    }
}