package com.giobar.guru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.giobar.guru.repository.BookRepository;

@Controller
public class BookController {

	private final BookRepository bookRepository;

	@RequestMapping("/books")
	public String getBooks(Model model) {

		model.addAttribute("books", bookRepository.findAll());
		return "books/list";

	}

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

}
