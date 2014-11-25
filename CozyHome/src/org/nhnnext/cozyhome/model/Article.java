package org.nhnnext.cozyhome.model;

public class Article {
	int articleNumber;
	String title;
	String writer;
	String writerId;
	String content;
	String writeDate;
	String imageName;
	
	public Article(int articleNumber, String title, String writer,
			String writerId, String content, String writeDate, String imageName) {
		super();
		this.articleNumber = articleNumber;
		this.title = title;
		this.writer = writer;
		this.writerId = writerId;
		this.content = content;
		this.writeDate = writeDate;
		this.imageName = imageName;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getWriterId() {
		return writerId;
	}

	public String getContent() {
		return content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public String getImageName() {
		return imageName;
	}

	@Override
	public String toString() {
		return "Article [articleNumber=" + articleNumber + ", title=" + title
				+ ", writer=" + writer + ", writerId=" + writerId
				+ ", content=" + content + ", writeDate=" + writeDate
				+ ", imageName=" + imageName + "]";
	}
	
}
