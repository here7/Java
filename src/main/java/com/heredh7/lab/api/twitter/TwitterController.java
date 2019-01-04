package com.heredh7.lab.api.twitter;


import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

import java.util.List;


@Configuration
public class TwitterController{
   private String app_name;
   private String consumer_key;
   private String consumer_secret;
   private String access_token;
   private String access_token_secret;


   private String profile_id;
   private List<Tweet> last_tl_tweets;
   private List<Tweet> last_own_tweets;

   /**
    * Constructor without parameters. My account by default
    */
   public TwitterController(){
      this.app_name = "****";
      this.consumer_key = "*****";
      this.consumer_secret = "****";
      this.access_token = "******";
      this.access_token_secret = "*****";
   }

   /**
    * Constructor with parameters
    * @param app_name
    * @param consumer_key
    * @param consumer_secret
    * @param access_token
    * @param access_token_secret
    */
   public TwitterController(String app_name, String consumer_key, String consumer_secret, String access_token, String access_token_secret){
      this.app_name = app_name;
      this.consumer_key = consumer_key;
      this.consumer_secret = consumer_secret;
      this.access_token = access_token;
      this.access_token_secret = access_token_secret;
   }

   /**
    * GETTERS
     * @return
    */

   public Twitter getConnection(){
      return new TwitterTemplate(this.getConsumerKey(), this.getConsumerSecret(), this.getAccessToken(), this.getAccessTokenSecret());
   }

   public String getAppName(){
      return this.app_name;
   }

   public String getConsumerKey(){
      return this.consumer_key;
   }

   public String getConsumerSecret(){
      return this.consumer_secret;
   }

   public String getAccessToken() {
      return this.access_token;
   }

   public String getAccessTokenSecret() {
      return this.access_token_secret;
   }

    public String getProfileId() {
      Twitter myObj = this.getConnection();
      profile_id = myObj.userOperations().getScreenName();
      return profile_id;
    }


   /**
    * Last 20 tweets of mu timeline
    * @return
    */
   public List<Tweet> getLastTimeLineTweets(){
      Twitter myObj = this.getConnection();
      last_tl_tweets = myObj.timelineOperations().getHomeTimeline();
      return last_tl_tweets;
   }

   /**
    * My last 20 tweets
    * @return
    */
   public List<Tweet> getLastOwnTweets(){
      Twitter myObj = this.getConnection();
      last_own_tweets = myObj.timelineOperations().getUserTimeline();
      return last_own_tweets;
   }

   /**
    * Share content in Twitter account
    * @return
    */
   public boolean shareTwitter(String msg){
      Boolean result = false;
      if(!msg.isEmpty()){
         Twitter myObj = this.getConnection();
         myObj.timelineOperations().updateStatus(msg);
      }
      return result;
   }


}
