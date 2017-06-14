package rest.oauth

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class ApiController {


	def index() {
		render text: "Hello from Api controller: Logged in user is ${authenticatedUser.username}"
	}
}
