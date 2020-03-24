/**
 * 
 */
package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

/**
 * @author 追梦人
 *商品规格参数模板管理
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Resource
	private ItemParamService itemParamServiceImpl;
	/**
	 * 根据商品类型id获取规格参数模板
	 * @param itemCatId
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable long itemCatId) {
	
		TaotaoResult result = itemParamServiceImpl.getItemParamBycId(itemCatId);
		
		return result;
	}
	
	  @RequestMapping("/list")	  
	  @ResponseBody 
	  public EUDataGridResult getItemParamList(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		  EUDataGridResult result = itemParamServiceImpl.getItemParamList(page, rows);
		  return result; 
	  }
	 

	@ResponseBody
	@RequestMapping("/save/{cid}")
	public TaotaoResult insertItemParam(@PathVariable long cid,String paramData) {
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result = itemParamServiceImpl.insertItemParam(itemParam);
		
		return result;
	}
}
