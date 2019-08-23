package com.example.BookStore;

import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	private BookRepository bookRepository;


	@Test
	public void shouldSendConfirmationMessageWhenBorrowedBook() {

		//given
		int id = 1;

		//when
		String message = bookRepository.borrowBook(1);

		//then
		Assert.assertEquals("You've succefully borrowed book", message);

	}

	@Test
	public void shouldHaveNullOnBooksReturnDate() {

		//given
		int id = 1;

		//when
		String message = bookRepository.borrowBook(1);

		//then
		Assert.assertNull(bookRepository.getBooks().stream().filter(b->b.getId() == id).findFirst().get().getDateOfReturn());
	}

	@Test
	public void shouldSeeTheBookInBooksAfterAdding(){

		//given
		String title = "Potop";
		String author = "Sienkiwicz";

		//when
		bookRepository.addBook(title,author);

		//then
		Assert.assertEquals(author ,bookRepository.getBooks().stream().filter(b->b.getTitle().equals("Potop")).findFirst().get().getAuthor());

	}

	@Test
	public void shouldNotSeeBookInListAfterDelating(){

		//given
			int id = 2;

		//when
			bookRepository.delateBook(id);
		Book book = bookRepository.getBooks().stream().filter(a -> a.getId() == id).findFirst().orElse(null);

		//then
			Assert.assertNull(book);

	}



}
