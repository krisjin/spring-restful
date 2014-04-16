package net.eleword.spring.restful.client;

import net.eleword.spring.restful.domain.News;
import net.eleword.spring.restful.domain.NewsList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-16下午3:20:52
 */

public class NewsClient {

	public static void main(String[] args) {
		HttpEntity<String> entity = prepareGet(MediaType.APPLICATION_XML);
		String uri = "http://localhost:8080/spring-restful/news/1";

		RestTemplate restTemplate = new RestTemplate();

		getNews(restTemplate, uri,entity);

	}

	public static void getAllNews(RestTemplate restTemplate, String uri, HttpEntity<String> entity) {
		ResponseEntity<NewsList> response = restTemplate.exchange(uri, HttpMethod.GET, entity, NewsList.class);
		NewsList newsList = response.getBody();
		for (News news : newsList.getNewses()) {
			System.out.println(news.getId());
			System.out.println(news.getTitle());
			System.out.println(news.getPostDate());
			System.out.println(news.getContent());
			System.out.println("---------------------------------------------------------------------------------------");
		}
	}

	public static void getNews(RestTemplate restTemplate, String uri, HttpEntity<String> entity) {
		ResponseEntity<News> response = restTemplate.exchange(uri, HttpMethod.GET, entity, News.class);
		News news = response.getBody();
			System.out.println(news.getId());
			System.out.println(news.getTitle());
			System.out.println(news.getPostDate());
			System.out.println(news.getContent());
			System.out.println("---------------------------------------------------------------------------------------");
		
	}

	private static HttpEntity<String> prepareGet(MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
}
