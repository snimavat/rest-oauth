package rest.oauth

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.rest.token.AccessToken
import grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import grails.plugin.springsecurity.rest.token.rendering.AccessTokenJsonRenderer
import grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.plugins.rest.client.RestBuilder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService


@Secured(['permitAll'])
class CasOauthController {

	TokenStorageService tokenStorageService
	TokenGenerator tokenGenerator
	AccessTokenJsonRenderer accessTokenJsonRenderer
	UserDetailsService userDetailsService

	def authenticate(String token) {
		RestBuilder rest = new RestBuilder(registerConverters:false)
		def resp = rest.get("http://localhost:8081/cas/oauth2.0/profile?access_token=${token}")
		println resp.json

		UserDetails ud = userDetailsService.loadUserByUsername(resp.json.attributes.username)
		AccessToken accessToken = tokenGenerator.generateAccessToken(ud)
		accessToken.accessToken = token
		tokenStorageService.storeToken(accessToken.accessToken, ud)
		SecurityContextHolder.context.setAuthentication(accessToken)

		render text: accessTokenJsonRenderer.generateJson(accessToken as AccessToken)

	}
}
