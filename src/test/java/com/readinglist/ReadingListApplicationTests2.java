package com.readinglist;

import com.readinglist.dao.ReadingListRepository;
import com.readinglist.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ReadingListApplication.class)
public class ReadingListApplicationTests2 {

	@Autowired
	private ReadingListRepository readingListRepository;

	@Test
	public void contextLoads() {

		List<Book> all = readingListRepository.findAll();

	}

}
