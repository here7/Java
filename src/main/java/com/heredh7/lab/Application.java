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

		System.out.println("HELLO TW");
		try{
			String redirect_uri = "http://localhost:8080/";
			String app_ID = "app_java";
			String consumer_key = "nRB4JjcFT0txCVs9C2IvOvmWB";
			String consumer_secret = "hictAJ1QVEP23kIBIRpIcTTRGLgqQlXqjUlG02RfpMw4VTBPyK";
			String access_token = "1390924771-H1EVjRrTxllGrlDvmS6T47s2uUewHiBQ4Rhtf8t";
			String access_token_secret = "j1qzFIfI4beQsrG3axnhMTChZzRikblWNC9x03NZK4OLr";

			TwitterConnectionFactory connectionFactory = new TwitterConnectionFactory( consumer_key, consumer_secret );
			OAuth1Operations oauthOperations = connectionFactory.getOAuthOperations();

			OAuthToken requestToken = oauthOperations.fetchRequestToken(redirect_uri,null);
			//OAuthToken requestToken = new OAuthToken(access_token, access_token_secret);

			OAuthToken accessToken = oauthOperations.exchangeForAccessToken(new AuthorizedRequestToken(requestToken, access_token_secret), null);


/*
			clients.inMemory()
					.withClient(consumer_key)
					.secret(consumer_secret)
					.authorizedGrantTypes("client_credentials", AUTHORIZATION_CODE, REFRESH_TOKEN, "implicit")
					.scopes("write");*/

			//Twitter twitter =new TwitterTemplate(consumer_key, consumer_secret, access_token, access_token_secret);

		//	 new Twitter();

			//twitter.timelineOperations().updateStatus("Hi! Sharing from Spring boot Twitter API");

			System.out.println("MY TW ACCOUNT");
			//System.out.print(twitter.getProfileId());
//			twitter.shareTwitter("Hi! Sharing from Spring boot Twitter API");
		} catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
}
