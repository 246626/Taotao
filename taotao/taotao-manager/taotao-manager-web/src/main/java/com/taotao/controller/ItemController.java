package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemServiceImpl;
	
	/**
	 * 通过id获取TbItem对象
	 * @param itemId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable long itemId) {
 		return itemServiceImpl.getItemById(itemId);
	}
	/**
	 * 商品的分页显示
	 * 作为easyui的返回值响应的json数据格式：
	 *  Easyui中datagrid控件要求的数据格式为：
	 *   {total:”2”,rows:[{“id”:”1”,”name”,”张三”},{“id”:”2”,”name”,”李四”}]}
	 * @param rows
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/item/list")
	public EUDataGridResult getItemList(Integer rows,Integer page) {
		System.out.println("rows="+rows+"page="+page);
		EUDataGridResult result = itemServiceImpl.getItemList(page, rows);
		return result;
	}
	@RequestMapping(value="/item/save",method = RequestMethod.POST)
	@ResponseBody
	private TaotaoResult creatItem(TbItem item,String desc,String itemParams) throws Exception {
		TaotaoResult result  = itemServiceImpl.creatItem(item,desc,itemParams);
		return result;
	}
}
