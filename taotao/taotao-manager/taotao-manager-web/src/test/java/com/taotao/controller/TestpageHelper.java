package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

public class TestpageHelper {
	
	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中获取mapper代理对象
		TbItemMapper mapper = ac.getBean(TbItemMapper.class);
		//执行查询，并分页
		TbItemExample example=new TbItemExample();
		//使用pageHelper分页
		PageHelper.startPage(1, 10);
		//没有查询条件不用创建条件    example.createCriteria();
		
		List<TbItem> items = mapper.selectByExample(example);
		//取商品列表
		for (TbItem tbItem : items) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(items);
		long total = pageInfo.getTotal();
		System.out.println("共有"+total+"种商品");
	}

}
