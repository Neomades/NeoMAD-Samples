package com.neomades.httpuploadexample.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;

import com.neomades.io.http.HttpListener;
import com.neomades.io.http.HttpRequest;

public class PostMultipartFormDataService {

	/**
	 * Part of a multipart/form-data entity.
	 */
	private class Part {
		private String name;
		private String filename;
		private byte[] content;

		public Part(String name, String filename, byte[] content) {
			this.name = name;
			this.filename = filename;
			if (content != null) {
				this.content = new byte[content.length];
				System.arraycopy(content, 0, this.content, 0, content.length);
			}
		}

		public String getName() {
			return name;
		}

		public String getFilename() {
			return filename;
		}

		public byte[] getContent() {
			return content;
		}

	}

	private static final String LINE_END = "\r\n";
	private static final String TWO_HYPHENS = "--";

	private String url;
	private HttpListener httpListener;

	private String boundary;
	private Vector parts;

	public PostMultipartFormDataService(String url, HttpListener httpListener) {
		this.url = url;
		this.httpListener = httpListener;
		boundary = "---------------------------" + System.currentTimeMillis();
		parts = new Vector();
	}

	public void addPart(String name, String filename, byte[] content) {
		parts.addElement(new Part(name, filename, content));
	}

	public void upload() throws IOException {
		// Prepare the body of the request.
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		for (int i = 0; i < parts.size(); i++) {
			Part part = (Part) parts.elementAt(i);

			baos.write((TWO_HYPHENS + boundary + LINE_END).getBytes());
			baos.write(("Content-Disposition: form-data; name=\"" + part.getName() + "\"; filename=\"" + part.getFilename() + "\"" + LINE_END).getBytes());
			baos.write(("Content-Type: application/octet-stream" + LINE_END).getBytes());
			baos.write(LINE_END.getBytes());
			baos.write(part.getContent());
			baos.write(LINE_END.getBytes());
		}

		baos.write((TWO_HYPHENS + boundary + TWO_HYPHENS + LINE_END).getBytes());
		baos.flush();
		baos.close();

		// Create the HTTP POST request.
		HttpRequest httpPost = new HttpRequest(url);
		httpPost.setMethodPost();
		httpPost.setHeader("Connection", "Keep-Alive");
		httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + boundary);
		httpPost.setPostContent(baos.toByteArray());
		httpPost.executeAsync(httpListener);
	}
}
