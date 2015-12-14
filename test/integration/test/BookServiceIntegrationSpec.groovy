package test

import grails.test.spock.IntegrationSpec

class BookServiceIntegrationSpec extends IntegrationSpec {

    BookService bookService

    void "remove book"() {
        given:
        final String title = 'The Gunslinger'

        new Book(title: title).save()
        assert Book.findByTitle(title) != null

        when:
        bookService.removeBook(title)

        then:
        Book.findByTitle(title) == null
    }
}
