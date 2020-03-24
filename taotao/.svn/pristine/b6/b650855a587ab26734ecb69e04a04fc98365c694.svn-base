package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
/**
 * 商品分类管理
 * @author 追梦人
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Resource
	private TbItemCatMapper itemCatMapper;
	/**
	 * 根据父菜单查询子菜单，返回子菜单列表
	 */
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//将列表转换为EUTReeNode
		List<EUTreeNode> resultList=new ArrayList<EUTreeNode>();
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node=new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			//System.out.println(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
			//System.out.println(node.toString());
		}
		
		
		
		return resultList;
	}

}
