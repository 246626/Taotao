/**
 * 
 */
package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

/**
 * @author 追梦人
 *
 */
@Service
public class ContentCatgoryServiceImpl implements ContentCategoryService{

	@Resource
	private TbContentCategoryMapper contentCatgoryMapper;
	/**
	 * 根据parentId查询Category所有子节点
	 */
	@Override
	public List<EUTreeNode> getCatgoryList(long parentId) {
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCatgoryMapper.selectByExample(example);
		List<EUTreeNode> result=new ArrayList<EUTreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			EUTreeNode node=new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open  ");
			result.add(node);
		}
		
		return result;
		
	}
	/**
	 * 增加contentCategory
	 */
	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		TbContentCategory contentCategory=new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//状态1为正常，2为删除
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCatgoryMapper.insert(contentCategory);
		//查看父节点的isparent是否为true，不为true则改成true
		TbContentCategory parentCat = contentCatgoryMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			contentCatgoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
		
		
		
		
	}
	/**
	 * 删除节点
	 */
	@Override
	public TaotaoResult delectContentCategory(long id) {
		//获取父节点id
		TbContentCategory contentCategory = contentCatgoryMapper.selectByPrimaryKey(id);
		long parentId=contentCategory.getParentId();
		//删除本节点
		contentCatgoryMapper.deleteByPrimaryKey(id);
		//获取父节点
		TbContentCategory parentCat = contentCatgoryMapper.selectByPrimaryKey(parentId);
		//查询父节点下是否有子节点
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCatgoryMapper.selectByExample(example);
		if(list==null||list.size()==0) {
			parentCat.setIsParent(false);
			contentCatgoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok();
	}
	
	/**
	 * 更新节点的名称
	 */
	@Override
	public TaotaoResult updateContentCategory(long id, String name) {
		// TODO Auto-generated method stub
		TbContentCategory contentCategory = contentCatgoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		int result = contentCatgoryMapper.updateByPrimaryKey(contentCategory);
		if(result!=0) {
			return TaotaoResult.ok(); 
		}else {
			return null;
		}
	}

}
