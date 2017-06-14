package rest.oauth

import grails.plugin.springsecurity.annotation.Secured

/**
 * Created by sudhir on 09/06/17.
 */
@Secured('ROLE_ADMIN')
class UserController {

	def index() {
		render text: "Hello from User controller"
	}
}
