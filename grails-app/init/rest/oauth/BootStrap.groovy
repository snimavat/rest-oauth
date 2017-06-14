package rest.oauth

import com.genospace.oauth.Role
import com.genospace.oauth.User
import com.genospace.oauth.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def testUser = new User(username: 'jleleu', password: 'jleleu').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }

}
