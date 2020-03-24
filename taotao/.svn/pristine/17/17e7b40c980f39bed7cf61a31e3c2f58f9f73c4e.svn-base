/**
 * 
 */
package com.taotao.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类管理
 * @author 追梦人
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContentCatgoryController {

	@Resource
	private ContentCategoryService contentCategoryService;
	/**
	 * 根据parentId获取其下所有节点
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList( @RequestParam(value="id",defaultValue = "0")long parentId){
		List<EUTreeNode> list = contentCategoryService.getCatgoryList(parentId);
		return list;
	}
	/**
	 * 增加节点
	 * @param name
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(String name,long parentId) {
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	/**
	 * 删除节点
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(long id) {
		return contentCategoryService.delectContentCategory( id);
	}
	/**
	 * 重命名节点
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public TaotaoResult updateContentCategory(long id,String name) {
		return contentCategoryService.updateContentCategory(id, name);
	}
	
	
	
	
	
	
}
