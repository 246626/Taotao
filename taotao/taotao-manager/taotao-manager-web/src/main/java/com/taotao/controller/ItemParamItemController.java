/**
 * 
 */
package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;

/**
 * @author 追梦人
 *
 */
@Controller
public class ItemParamItemController {

	@Resource
	private ItemParamItemService itemParamItemServiceImpl;
	/**
	 * 展示商品规格参数
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping("/showitem/{itemId}")
	public String showItemId(@PathVariable long itemId,Model model) {
		String string = itemParamItemServiceImpl.getItemParamByItemId(itemId);
		model.addAttribute("itemParam",string);
		return "item";
	}
}