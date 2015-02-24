if(System.getenv('TRAVIS_BRANCH')) {
    grails.project.repos.grailsCentral.username = System.getenv("GRAILS_CENTRAL_USERNAME")
    grails.project.repos.grailsCentral.password = System.getenv("GRAILS_CENTRAL_PASSWORD")
}

grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.dependency.resolver="maven"
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenCentral()
	}

	dependencies {
		compile 'org.grails:grails-datastore-rest-client:1.0.1.RELEASE'
//		compile 'org.grails:grails-datastore-rest-client:4.0.0.M1'
	}

    plugins {
        build(":release:3.0.1") {
            export = false
            excludes 'rest-client-builder'
        }
    }
}
