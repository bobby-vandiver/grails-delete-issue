package test

import grails.test.spock.IntegrationSpec

class BookServiceIntegrationSpec extends IntegrationSpec {

    BookService bookService

    void "remove book"() {
        given:
        final String title = 'The Gunslinger'

        Book book = new Book(title: title).save()
        assert Book.findByTitle(title) != null

        Long bookId = book.id

        when:
        bookService.removeBook(title)

        then:
        Book.get(bookId) == null

        and:
        Book.findByTitle(title) == null
    }
}
