package com.codeshallwe.designPatterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * Let's start.
 * 
 * Let's have our Legacy system ready. Then the Documents it is reading for a good while.
 * 
 * 3 docs are in progress. Now, let's try a different set of doc. One that has a different interface altogether. 
 * 
 * Quickly a small change. We program to the interface just to sleep well later in future. so some amends
 * 
 * This should do for now. Let's focus on the new Document. Missed another piece.
 * Now the new one. The legacy system is expected to read the book as well. Let's try
 * 
 * Let's try and fix this by creating an Adapter.
 * 
 * Idea is that the BookAdapter will take a book and adapt it to interface with the Document.
 * 
 * Error is gone. Let's try running the program.
 * Let's add another type of book.
 * Now the Legacy System can read a new type. Legacy system has to implement to include the Adapter. But otherwise it does not need to know anything about the adapter or what it does. This is how one interface is ada
 */
public class AdapterPatternDemo {
	public static void main(String[] args) {
		// Legacy System implementation
		LegacySystem ls = new LegacySystem();
		// we want it to read a list of Documents
		ls.readDocuments().forEach(doc -> doc.doSomething());
	}
}

class LegacySystem {
	public List<Document> readDocuments() {
		List<Document> docList = new ArrayList<>();
		docList.add(new OldDocument());
		docList.add(new OldDocument());
		docList.add(new OldDocument());
		// This is wher we would want the Adapter to come in.
		docList.add(new BookAdapter(new Fiction())); // It is not possible
		docList.add(new BookAdapter(new Fiction()));
		docList.add(new BookAdapter(new Fiction()));
		docList.add(new BookAdapter(new Comics()));
		return docList;
	}
}

//To add to Type Document, the BookAdapter has to be of type Document.
class BookAdapter implements Document {

	Book book;

	public BookAdapter(Book book) {
		// get the book being passed in from outside.
		this.book = book;
	}

	@Override
	public void doSomething() {
		// The legacy system knows only doSomething(). It is the work of the Adapter to
		// do things when this method is called.
		// the corresponding method in Book is readTheBook.
		book.readTheBook();
	}

}

interface Document {
	void doSomething();
}

class OldDocument implements Document {
	public void doSomething() {
		System.out.println("Reading in progress...");
	}
}

//Yep. So it is not a Document at all. A completely different one
interface Book {
	void readTheBook();
}

class Comics implements Book {

	@Override
	public void readTheBook() {
		System.out.println("Reading ***Comics***...");
	}
}

class Fiction implements Book {

	@Override
	public void readTheBook() {
		System.out.println("Reading ***Fiction***...");
	}
}
