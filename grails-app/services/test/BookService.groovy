package test

import grails.transaction.Transactional

@Transactional
class BookService {

    void removeBook(String title) {
        Book book = Book.findByTitle(title)

        if (book) {
            log.info("Deleting book with title ${title}.")
            book.delete()
        }
        else {
            log.info("Book with title ${title} not found.")
        }
    }

    void removeBookThenThrow(String title) {
        removeBook(title)
        throw new RuntimeException("Force transaction rollback")
    }
}
