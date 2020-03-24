/**
 * 
 */
package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * @author 追梦人
 *
 */
@Controller

public class ContentController {
	@Resource
	private ContentService contentService;
	/**
	 * 根据CatergoryId查询content并分页显示
	 * @param categoryId
	 * @param page
	 * @param lows
	 * @return
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EUDataGridResult selectContentByCatId(long categoryId,int page,int rows) {
		return contentService.selectContentByCatId(categoryId, page, rows);
	}
	/**
	 * 新增内容
	 * @param content
	 * @return
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		return contentService.insertContent(content);
	}
	/**
	 * 删除内容
	 * @param ids
	 * @return
	 */
	@RequestMapping("/content/delete")
	@ResponseBody
	public TaotaoResult deleteContent(long ids) {
		return contentService.deleteContent(ids);
	}
	/**
	 * 编辑内容
	 * @param content
	 * @return
	 */
	@RequestMapping("/rest/content/edit")
	@ResponseBody
	public TaotaoResult editContent(TbContent content) {
		return contentService.updateContent(content);
	}
	
}
