package net.eleword.spring.restful.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-16下午1:49:26
 */
@XmlRootElement(name = "news")
public class News {

	private Long id;

	private String title;

	private Date postDate;

	private String content;

	public News() {
	}

	public News(long id, String title, Date postDate, String content) {
		this.id = id;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
