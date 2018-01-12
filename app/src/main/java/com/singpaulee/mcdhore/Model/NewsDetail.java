package com.singpaulee.mcdhore.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 30/12/2017.
 */

public class NewsDetail implements Parcelable {
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

	protected NewsDetail(Parcel in) {
		date = in.readString();
		screenName = in.readString();
		fullName = in.readString();
		tweetText = in.readString();
		tweetID = in.readString();
		app = in.readString();
		if (in.readByte() == 0) {
			followers = null;
		} else {
			followers = in.readInt();
		}
		if (in.readByte() == 0) {
			follows = null;
		} else {
			follows = in.readInt();
		}
		if (in.readByte() == 0) {
			retweets = null;
		} else {
			retweets = in.readInt();
		}
		if (in.readByte() == 0) {
			favorites = null;
		} else {
			favorites = in.readInt();
		}
		verfied = in.readString();
		userSince = in.readString();
		location = in.readString();
		bio = in.readString();
		profileImage = in.readString();
		googleMaps = in.readString();
	}

	public static final Creator<NewsDetail> CREATOR = new Creator<NewsDetail>() {
		@Override
		public NewsDetail createFromParcel(Parcel in) {
			return new NewsDetail(in);
		}

		@Override
		public NewsDetail[] newArray(int size) {
			return new NewsDetail[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(date);
		parcel.writeString(screenName);
		parcel.writeString(fullName);
		parcel.writeString(tweetText);
		parcel.writeString(tweetID);
		parcel.writeString(app);
		if (followers == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(followers);
		}
		if (follows == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(follows);
		}
		if (retweets == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(retweets);
		}
		if (favorites == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(favorites);
		}
		parcel.writeString(verfied);
		parcel.writeString(userSince);
		parcel.writeString(location);
		parcel.writeString(bio);
		parcel.writeString(profileImage);
		parcel.writeString(googleMaps);
	}
}
