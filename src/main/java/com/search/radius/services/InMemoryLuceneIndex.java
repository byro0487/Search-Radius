package com.search.radius.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class InMemoryLuceneIndex {

	Directory memoryIndex = new RAMDirectory();
	StandardAnalyzer analyzer = new StandardAnalyzer();

	public List<Document> searchIndex(String inField, String queryString) throws ParseException, IOException {

		Query query = new QueryParser(inField, analyzer).parse(queryString);

		IndexReader indexReader = DirectoryReader.open(memoryIndex);
		IndexSearcher searcher = new IndexSearcher(indexReader);
		TopDocs topDocs = searcher.search(query, 10);
		List<Document> documnets = new ArrayList<Document>();
		for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
			documnets.add(searcher.doc(scoreDoc.doc));
		}

		return documnets;
	}

	public void indexDocument(String key, String value) throws IOException {

		// Code for adding the document to the index

		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(memoryIndex, indexWriterConfig);
		Document document = new Document();

		document.add(new TextField("title", key, Field.Store.YES));
		document.add(new TextField("body", value, Field.Store.YES));

		writer.addDocument(document);
		writer.close();

	}

}
