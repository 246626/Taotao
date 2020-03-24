/**
 * 
 */
package com.taotao.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;

/**
 * @author 追梦人
 *商品类目管理
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Resource
	private ItemCatService itemCatService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<EUTreeNode> getCarList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
		System.out.println(parentId);
		System.out.println(itemCatService.getCatList(parentId));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		return itemCatService.getCatList(parentId);
	}
}
