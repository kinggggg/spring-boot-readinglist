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

/**
 * 在SpringBoot的1.4.0 Release Notes中说（https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-1.4-Release-Notes）：
 *	Additionally, Spring Boot 1.4 attempts to rationalize and simplify the various ways that a Spring Boot test can be run. You should migrate the following to use the new @SpringBootTest annotation:
 •	From @SpringApplicationConfiguration(classes=MyConfig.class) to @SpringBootTest(classes=MyConfig.class) 
 */
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
