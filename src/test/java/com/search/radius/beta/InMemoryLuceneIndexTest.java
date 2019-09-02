package com.search.radius.beta;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Test;

import com.search.radius.services.InMemoryLuceneIndex;

public class InMemoryLuceneIndexTest {

	@Test
	public void searchDocumentPositive() throws IOException, ParseException {

		InMemoryLuceneIndex index = new InMemoryLuceneIndex();
		index.indexDocument("Hello World", "Some Hello World Fellas");

		List<Document> documents = index.searchIndex("body", "Fellas");

		assertEquals("Hello World", documents.get(0).get("title"));
	}

}
