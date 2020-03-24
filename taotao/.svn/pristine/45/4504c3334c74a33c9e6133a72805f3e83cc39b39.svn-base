/**
 * 
 */
package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

/**
 * @author 追梦人
 *
 */
public interface ContentCategoryService {

	/**
	 * 获取CategoryList
	 * 返回一个EUtreeNode
	 * @return
	 */
	List<EUTreeNode> getCatgoryList(long parentId);
	/**
	 * 新增一个contentCategory
	 * @param parentId
	 * @param name
	 * @return
	 */
	TaotaoResult insertContentCategory(long parentId,String name);
	/**
	 * 删除一个contentCategory
	 * @param parentId  父节点id
	 * @param id   本节点id
	 * @return
	 */
	TaotaoResult delectContentCategory(long id);
	/**
	 * 更新contentCategory的名称
	 * @param id    需要更新contentcategory的id
	 * @param name   更新后的name
	 * @return
	 */
	TaotaoResult updateContentCategory(long id ,String name );
}
