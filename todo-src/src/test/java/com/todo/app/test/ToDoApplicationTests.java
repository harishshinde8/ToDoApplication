package com.todo.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todo.app.ToDoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToDoApplication.class)
@WebAppConfiguration
public class ToDoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
