package net.eleword.spring.restful.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.eleword.spring.restful.domain.News;
import net.eleword.spring.restful.domain.NewsList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * TODO 此处填写 class 信息
 * 
 * @author krisjin (mailto:krisjin86@163.com)
 * @date 2014-4-16下午2:02:14
 */
@Controller
public class NewsControllder {
	@RequestMapping(method = RequestMethod.GET, value = "/news/{id}", headers = "Accept=application/xml")
	public @ResponseBody
	News getNews(@PathVariable("id") Long id) {

		return new News(1,"云服务掀起价格战 用户成真正受益方",new Date(),"亚马逊名为“Amazon Web Services”（以下简称AWS）的云服务推出已有8年时间。作为租赁计算能力这一概念的先驱，它帮助企业节约了搭建自有计算主干网所需的资金。截至目前，AWS主要吸引的是像Altos这样的小微企业。");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/news", headers = "Accept=application/xml")
	public @ResponseBody NewsList listNews() {

		List<News> newses = new ArrayList<News>();
		newses.add(new News(1,"云服务掀起价格战 用户成真正受益方",new Date(),"亚马逊名为“Amazon Web Services”（以下简称AWS）的云服务推出已有8年时间。作为租赁计算能力这一概念的先驱，它帮助企业节约了搭建自有计算主干网所需的资金。截至目前，AWS主要吸引的是像Altos这样的小微企业。"));
		newses.add(new News(2,"网秦驳斥浑水做空报告 用回购应对股价暴跌",new Date(),"网秦周二在公司网站中表示，在公司股价因4月10日发布的财报未达预期导致大跌之后，该公司已回购了部分股票。自浑水去年10月做空网秦以来，该公司股价累计跌幅已达到了45%。网秦已否认了浑水的所有指控。"));
		newses.add(new News(3,"谷歌警告：我们会扫描你们的Gmail",new Date(),"“我们的自动化系统将分析你的内容（含电子邮件）以便为你提供相关产品功能，比如定制化搜索结果、量身定制的广告以及垃圾电子邮件和恶意件检测功能。这些分析会在内容被发送、接收和储存的时候进行。”"));
		
		NewsList nl = new NewsList();
		nl.setNewses(newses);
		return nl;
	}

}
