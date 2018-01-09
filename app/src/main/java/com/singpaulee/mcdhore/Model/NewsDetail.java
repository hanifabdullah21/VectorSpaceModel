package com.singpaulee.mcdhore.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 30/12/2017.
 */

public class NewsDetail {
	@SerializedName("Date")
	@Expose
	private String date;
	@SerializedName("Screen_Name")
	@Expose
	private String screenName;
	@SerializedName("Full_Name")
	@Expose
	private String fullName;
	@SerializedName("Tweet_Text")
	@Expose
	private String tweetText;
	@SerializedName("Tweet_ID")
	@Expose
	private String tweetID;
	@SerializedName("App")
	@Expose
	private String app;
	@SerializedName("Followers")
	@Expose
	private Integer followers;
	@SerializedName("Follows")
	@Expose
	private Integer follows;
	@SerializedName("Retweets")
	@Expose
	private Integer retweets;
	@SerializedName("Favorites")
	@Expose
	private Integer favorites;
	@SerializedName("Verfied")
	@Expose
	private String verfied;
	@SerializedName("User_Since")
	@Expose
	private String userSince;
	@SerializedName("Location")
	@Expose
	private String location;
	@SerializedName("Bio")
	@Expose
	private String bio;
	@SerializedName("Profile_Image")
	@Expose
	private String profileImage;
	@SerializedName("Google_Maps")
	@Expose
	private String googleMaps;

	public NewsDetail() {
	}

	public NewsDetail(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getTweetID() {
		return tweetID;
	}

	public void setTweetID(String tweetID) {
		this.tweetID = tweetID;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFollows() {
		return follows;
	}

	public void setFollows(Integer follows) {
		this.follows = follows;
	}

	public Integer getRetweets() {
		return retweets;
	}

	public void setRetweets(Integer retweets) {
		this.retweets = retweets;
	}

	public Integer getFavorites() {
		return favorites;
	}

	public void setFavorites(Integer favorites) {
		this.favorites = favorites;
	}

	public String getVerfied() {
		return verfied;
	}

	public void setVerfied(String verfied) {
		this.verfied = verfied;
	}

	public String getUserSince() {
		return userSince;
	}

	public void setUserSince(String userSince) {
		this.userSince = userSince;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getGoogleMaps() {
		return googleMaps;
	}

	public void setGoogleMaps(String googleMaps) {
		this.googleMaps = googleMaps;
	}
}
