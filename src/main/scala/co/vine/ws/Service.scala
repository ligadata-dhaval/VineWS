package co.vine.ws

import com.github.scribejava.apis.TwitterApi
import com.github.scribejava.core.builder.ServiceBuilder
import com.github.scribejava.core.model._

/**
 * Created by dhavalkolapkar on 3/9/16.
 */
class Service {
/*

  /* def encodeKeys(consumerKey: String, consumerSecret: String): String ={
    val encodedConsumerKey=URLEncoder.encode(consumerKey,"UTF-8")
    val encodedConsumerSecret=URLEncoder.encode(consumerSecret,"UTF-8")
    val bearerTokenCredentials=encodedConsumerKey +":"+encodedConsumerSecret
    val encodedBearerTokenCredentials=Base64.encode(bearerTokenCredentials.getBytes()).toString
    encodedBearerTokenCredentials
  }

  def requestBearerToken: Unit ={

  }*/

  def getOAuth2Token: OAuth2Token = {
    var token: OAuth2Token = null
    var cb: ConfigurationBuilder = null
    cb = new ConfigurationBuilder
    cb.setApplicationOnlyAuthEnabled(true)
   /* cb.setOAuthConsumerKey("EvDxkfP3xzlZp9Ss5HoTxBFu4")
    cb.setOAuthConsumerSecret("HoBfu1L2MLlozYhY2Gq99FtF3ZQIWyKVl2hjXEbJIUCAHL4sZ8")
*/
    cb.setOAuthConsumerKey("jK6k4cbCfO191K2tezqm1eZqQ")
    cb.setOAuthConsumerSecret("YkqNYCjkFUHqQLn7Kh5IxpgFJ8hqIrQcZsWPil4PWh6moYbQhg")
    cb.setOAuthAccessToken("220347935-yNr3XU7UV5JcRWxKRZVJLgHWesjVIJdtYap5n7KL")
    cb.setOAuthAccessTokenSecret("11JtXVWzJd4GnCk84dtxEA06x4QkTInNy6W25OWSNhRTZ")
    new TwitterFactory(cb.build()).getInstance().getOAuth2Token
  }

  def viewTweets(screenNames: Array[String],count: Int): Unit = {
    val token: OAuth2Token = getOAuth2Token
    val cb: ConfigurationBuilder = new ConfigurationBuilder()
    cb.setOAuthConsumerKey("jK6k4cbCfO191K2tezqm1eZqQ")
    cb.setOAuthConsumerSecret("YkqNYCjkFUHqQLn7Kh5IxpgFJ8hqIrQcZsWPil4PWh6moYbQhg")
    cb.setOAuth2TokenType(token.getTokenType())
    //cb.setOAuth2AccessToken(token.getAccessToken())
      cb.setOAuthAccessToken("220347935-yNr3XU7UV5JcRWxKRZVJLgHWesjVIJdtYap5n7KL")
    cb.setOAuthAccessTokenSecret("11JtXVWzJd4GnCk84dtxEA06x4QkTInNy6W25OWSNhRTZ")
    cb.setApplicationOnlyAuthEnabled(true)
    val twitter: Twitter = new TwitterFactory(cb.build()).getInstance()

    //get user timeline data
    var paging = new Paging(1, count)

    //var userList = twitter.list().getUserLists("punyacherau")
      var userList=twitter.list().createUserList("test",false,"tst")
    //println("User list size is: "+userList.size())
    //val users = twitter.createUserListMembers(twitter.list().getUserLists("punyacherau").get(0).getId(), screenNames)

  // var statues = twitter.getUserListStatuses(users.getId, paging)
    //statues.toArray().foreach(print)
       //var statuses: ResponseList[Status]=twitter.getUserTimeline(screenNames(0),paging)
    //statuses.toArray().foreach(print)
   /* println("Hi")
   var query=new Query("from%3A[RedDevil96Utd]+OR+from%3A[andhikarzkyp]")
    //var query=new Query("from%3A[Planetbeautiful]%20OR%20from%3A[stayinus]%26count%3D[2]")
    var queryResult=twitter.search().search(query)
    queryResult.getTweets.toArray.foreach(println)
    println("Bye")*/
  }

  def viewStatuses(screenNames: String,count: Int): Unit = {

    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("jK6k4cbCfO191K2tezqm1eZqQ")
      .setOAuthConsumerSecret("YkqNYCjkFUHqQLn7Kh5IxpgFJ8hqIrQcZsWPil4PWh6moYbQhg")
      .setOAuthAccessToken("220347935-yNr3XU7UV5JcRWxKRZVJLgHWesjVIJdtYap5n7KL")
      .setOAuthAccessTokenSecret("11JtXVWzJd4GnCk84dtxEA06x4QkTInNy6W25OWSNhRTZ")
    var tf = new TwitterFactory(cb.build())
    var twitter = tf.getInstance()

    var paging = new Paging(1, count)
   var myList = twitter.list().createUserList(System.currentTimeMillis().toString, false, "tst")
    twitter.createUserListMember(myList.getId,twitter.users.showUser("mrsfunnybones").getId)
    twitter.createUserListMember(myList.getId,twitter.users.showUser("Psilosophy").getId)

    //twitter.list().destroyUserList("PunyacheRau","test")
   var response = twitter.list().getUserListStatuses(myList.getId, paging)
    response.toArray().foreach(println)
  }*/

  def oauthTwitter(screenNames: String,count: Int): Unit ={
    val service = new ServiceBuilder()
      .apiKey("jK6k4cbCfO191K2tezqm1eZqQ")
      .apiSecret("YkqNYCjkFUHqQLn7Kh5IxpgFJ8hqIrQcZsWPil4PWh6moYbQhg")
      .build(TwitterApi.Authenticate.instance())

    val accessToken = new OAuth1AccessToken("220347935-yNr3XU7UV5JcRWxKRZVJLgHWesjVIJdtYap5n7KL","11JtXVWzJd4GnCk84dtxEA06x4QkTInNy6W25OWSNhRTZ")
 /*   val request = new OAuthRequest(Verb.POST, "https://api.twitter.com/1.1/lists/create.json?name=VineAWS1&mode=public&description=For%20life", service)
    service.signRequest(accessToken, request) // the access token from step 4
    val response = request.send()
    println(response.getBody())
 */
    /*val createMembersQuery="https://api.twitter.com/1.1/lists/members/create_all.json?screen_name="+screenNames+"&list_id=708937172829626369"
    val request = new OAuthRequest(Verb.POST,createMembersQuery, service)
    service.signRequest(accessToken, request) // the access token from step 4
    val response = request.send()
    println(response.getBody())*/

    val createMembersQuery="https://api.twitter.com/1.1/lists/statuses.json?slug=VineAWS1&owner_screen_name=PunyacheRau&count=5"
    val request = new OAuthRequest(Verb.GET,createMembersQuery, service)
    service.signRequest(accessToken, request) // the access token from step 4
    val response = request.send()
    println(response.getBody())
  }

}
