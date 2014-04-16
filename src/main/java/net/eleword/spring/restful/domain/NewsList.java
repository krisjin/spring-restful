package net.eleword.spring.restful.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-16下午2:51:49
 */
@XmlRootElement(name = "newses")
public class NewsList {

	private List<News> newses;

	@XmlElement(name="news")
	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

}
