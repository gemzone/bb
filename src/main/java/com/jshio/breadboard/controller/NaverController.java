package com.jshio.breadboard.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.jshio.breadboard.domain.NaverProfile;
import com.jshio.breadboard.service.BbService;
import com.jshio.oauth.NaverLoginApi;

@Controller
@SessionAttributes({"user", "oauth"})
public class NaverController
{
	private static final Logger logger = LoggerFactory.getLogger(NaverController.class);
	
	@Value("${naver.client_id}")
    private String CLIENT_ID;
	
	@Value("${naver.client_secret}")
    private String CLIENT_SECRET;
	
	@Value("${naver.redirect_uri}")
    private String REDIRECT_URI;
	
	@Value("${naver.profile_api_url}")
    private String PROFILE_API_URL;
    
	@Autowired
	BbService bbService;
	
	@RequestMapping(path = "/naverlogin")
	public String naverlogin(Model model, HttpSession session)
	{
		// oauth session unregister
		if( session.getAttribute("oauth") != null ) { session.removeAttribute("oauth"); }
		if(model.containsAttribute("oauth")) { model.asMap().remove("oauth"); }
		
		// user session unregister
		if( session.getAttribute("user") != null ) { session.removeAttribute("user"); }
		if(model.containsAttribute("user")) { model.asMap().remove("user"); }
		
		
        String state = UUID.randomUUID().toString();	// state random key
        session.setAttribute("oauth", state);
		
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state)
                .build(NaverLoginApi.instance());
        
        String naverAuthUrl = oauthService.getAuthorizationUrl();
        logger.info(naverAuthUrl);
        // model.addAttribute("url", naverAuthUrl);
        return "redirect:" + naverAuthUrl;	
	}
	
	@RequestMapping(path = "/callback")
	public String callback(Model model, HttpSession session,
			@RequestParam String code, 
			@RequestParam String state)
	{
		String sessionState = (String) session.getAttribute("oauth");
		
		System.out.println("세션 UUID : " + sessionState + " " + state);
        if(StringUtils.equals(sessionState, state))
        {
            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(CLIENT_ID)
                    .apiSecret(CLIENT_SECRET)
                    .callback(REDIRECT_URI)
                    .state(state)
                    .build(NaverLoginApi.instance());

            OAuth2AccessToken oAuth2AccessToken = null;
			try
			{
				oAuth2AccessToken = oauthService.getAccessToken(code);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
            
            OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
            oauthService.signRequest(oAuth2AccessToken, request);
            Response response = request.send();
            try
			{
            	String jsonString = response.getBody();
				JSONObject json = new JSONObject(jsonString);
				JSONObject responseJson = json.getJSONObject("response");
				
				NaverProfile naverProfile = new NaverProfile(responseJson.getString("birthday") ,
						responseJson.getString("profile_image"),
						responseJson.getString("gender"),
						responseJson.getString("enc_id"),
						responseJson.getString("nickname"),
						responseJson.getString("name"),
						responseJson.getLong("id"),
						responseJson.getString("email"),
						responseJson.getString("age"));
				
				bbService.setNaverProfile(naverProfile);
				
//				{"birthday":"01-09",
//					"profile_image":"https://ssl.pstatic.net/static/pwe/address/img_profile.png",
//					"gender":"M",
//					"enc_id":"6604251a103272b3918296b7f3ea46e0d22579ddee38045ba10c7acb063c873f",
//					"":"gem****",
//					"":"",
//					"":"18685697",
//					"email":"@naver.com",
//					"":""}
				
				logger.info( "세션 등록" + json.toString() );
				session.setAttribute("owner", naverProfile);
				model.addAttribute("owner", naverProfile);
			}
            catch (Exception e)
			{
            	e.printStackTrace();
			}
            return "redirect:dashboard";
        }
        else
        {
        	return "redirect:naverlogin";
        }
	}
	
	@RequestMapping(path = "/logout")
	public String logout(Model model, HttpSession session,
			@RequestParam( name="ref", required = false , defaultValue = "") String referer)
	{
		session.invalidate();

		// user session unregister
		if( session.getAttribute("user") != null ) { session.removeAttribute("user"); }
		if(model.containsAttribute("user")) { model.asMap().remove("user"); }

		// oauth session unregister
		if( session.getAttribute("oauth") != null ) { session.removeAttribute("oauth"); }
		if(model.containsAttribute("oauth")) { model.asMap().remove("oauth"); }
		
		return "redirect:main";
	}
	
}
