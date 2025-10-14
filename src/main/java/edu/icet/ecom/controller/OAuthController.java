package edu.icet.ecom.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class OAuthController {
    @GetMapping("/oauth/sucess")
    public Map<String, Object> getUserInfo(OAuth2AuthenticationToken auth2AuthenticationToken) {
        return auth2AuthenticationToken.getPrincipal().getAttributes();
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logged out successfully";
    }
}
