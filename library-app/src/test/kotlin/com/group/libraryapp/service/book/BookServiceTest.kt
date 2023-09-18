package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus
import com.group.libraryapp.dto.book.request.*
import com.group.libraryapp.dto.book.response.BookStatResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val bookService: BookService,
    private val userLoanHistoryRepository: UserLoanHistoryRepository
) {

    @AfterEach
    fun tearDown() {
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }

    @DisplayName("책 등록이 정상 동작한다")
    @Test
    fun saveBookTest() {
        // given
        val request = BookRequest("이상한 나라의 엘리스", BookType.COMPUTER)

        // when
        bookService.saveBook(request)

        // then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("이상한 나라의 엘리스")
        assertThat(books[0].type).isEqualTo(BookType.COMPUTER)
    }

    @DisplayName("책 대출이 정상 동작한다.")
    @Test
    fun loanBookTest() {
        // given
        bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(User("aaa", null))
        val request = BookLoanRequest("aaa", "이상한 나라의 엘리스")

        // when
        bookService.loanBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].bookName).isEqualTo("이상한 나라의 엘리스")
        assertThat(results[0].user.id).isEqualTo(savedUser.id)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.LOANED)
    }

    @DisplayName("책이 진작 대출되어 있다면, 신규 대출이 실패한다")
    @Test
    fun loanBookFailTest() {
        // given
        bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(User("aaa", null))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser,"이상한 나라의 엘리스"))
        val request = BookLoanRequest("aaa", "이상한 나라의 엘리스")

        // when // then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(request)
        }.message
        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")
    }

    @DisplayName("책 반납이 정상 동작한다.")
    @Test
    fun returnBookTest() {
        // given
        bookRepository.save(Book.fixture("이상한 나라의 엘리스"))
        val savedUser = userRepository.save(User("aaa", null))
        userLoanHistoryRepository.save(UserLoanHistory.fixture(savedUser,"이상한 나라의 엘리스"))
        val request =
            BookReturnRequest("aaa", "이상한 나라의 엘리스")

        // when
        bookService.returnBook(request)

        // then
        val results = userLoanHistoryRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].status).isEqualTo(UserLoanStatus.RETURNED)
    }

    @DisplayName("채 대여 권수를 정상 확인한다")
    @Test
    fun countLoanedBookTest() {
        // given
        val savedUser = userRepository.save(User("A", null))
        userLoanHistoryRepository.saveAll(listOf(
            UserLoanHistory.fixture(savedUser, "책1"),
            UserLoanHistory.fixture(savedUser, "책2"),
            UserLoanHistory.fixture(savedUser, "책3",UserLoanStatus.RETURNED)
        ))

        // when
        val result = bookService.countLoanedBook()

        // then
        assertThat(result).isEqualTo(2)
    }

    @DisplayName("분야별 책 권수를 정상 확인한다")
    @Test
    fun getBookStatisticsTest() {
        // given
        bookRepository.saveAll(listOf(
            Book.fixture("A",BookType.COMPUTER),
            Book.fixture("B",BookType.COMPUTER),
            Book.fixture("C",BookType.SCIENCE),
        ))

        // when
        val results = bookService.getBookStatistics()

        // then
        assertThat(results).hasSize(2)
        asserCount(results, BookType.COMPUTER, 2L)
        asserCount(results, BookType.SCIENCE, 1L)
    }

    private fun asserCount(results: List<BookStatResponse>, type: BookType, count:Long) {
        assertThat(results.first { result -> result.type == type}.count).isEqualTo(count)
    }


}
