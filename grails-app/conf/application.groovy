

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.genospace.oauth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.genospace.oauth.UserRole'
grails.plugin.springsecurity.authority.className = 'com.genospace.oauth.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/dbconsole/**', access: ['permitAll']]

]

grails.plugin.springsecurity.rest.login.active = true
grails.plugin.springsecurity.rest.login.endpointUrl = "/api/login"

grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'

grails.plugin.springsecurity.rest.token.storage.useGorm = true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = "com.genospace.oauth.RestOauthToken"
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = "token"

grails.plugin.springsecurity.filterChain.chainMap = [
		//Stateless chain
		[
				pattern: '/api/**',
				filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
		],

		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],

		//Traditional chain
		[
				pattern: '/**',
				filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
		]
]