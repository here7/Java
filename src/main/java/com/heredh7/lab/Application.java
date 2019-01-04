package com.heredh7.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@SpringBootApplication
@EnableOAuth2Client
public class Application  extends AuthorizationServerConfigurerAdapter {
	@Autowired
	OAuth2ClientContext oauth2ClientContext;
	static  ClientDetailsServiceConfigurer clients;

	public static void main(String[] args) {


		SpringApplication.run(Application.class, args);

		try{
			String redirect_uri = "****";
			String app_ID = "****";
			String consumer_key = "****";
			String consumer_secret = "****";
			String access_token = "****";
			String access_token_secret = "****";

			TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory( consumer_key, consumer_secret );
			OAuth1Operations oauthOperations = connectionFactory.getOAuthOperations();

			OAuthToken requestToken = oauthOperations.fetchRequestToken(redirect_uri,null);

			OAuthToken accessToken = oauthOperations.exchangeForAccessToken(new AuthorizedRequestToken(requestToken, access_token_secret), null);


		} catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}
