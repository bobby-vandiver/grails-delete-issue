package test

import grails.test.spock.IntegrationSpec

class BookServiceIntegrationSpec extends IntegrationSpec {

    BookService bookService

    String title = 'The Gunslinger'
    Long bookId

    void setup() {
        bookId = new Book(title: title).save().id
        assert Book.findByTitle(title) != null
    }

    void "remove book"() {
        when:
        bookService.removeBook(title)

        then:
        Book.get(bookId) == null

        and:
        Book.findByTitle(title) == null
    }

    void "remove book but runtime exception is thrown after delete"() {
        when:
        bookService.removeBookThenThrow(title)

        then:
        thrown(RuntimeException)

        and:
        Book.get(bookId) != null

        and:
        Book.findByTitle(title) != null
    }
}
