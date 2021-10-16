package com.codeshallwe.Comparator;

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
		docList.add(new BookAdapter(new Fiction())); // It is not possible
		return docList;
	}
}

class BookAdapter implements Document {

	Book book;

	public BookAdapter(Book book) {
		this.book = book;
	}

	@Override
	public void doSomething() {
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

class Fiction implements Book {

	@Override
	public void readTheBook() {
		System.out.println("Reading the book...");
	}
}
