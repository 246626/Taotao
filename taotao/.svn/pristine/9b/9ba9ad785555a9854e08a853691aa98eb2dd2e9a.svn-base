package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
/**
 * 商品管理service
 * @author 追梦人
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Resource
	private TbItemMapper itemMapper;
	@Resource
	private TbItemDescMapper itemDescMaapper;
	@Resource
	private TbItemParamItemMapper itemParamItemMapper;
	/**
	 * 通过id获取商品对象
	 */
	@Override
	public TbItem getItemById(long itemId) {
		
		//根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//创建查询条件,先创建example对象再创建一个条件对象
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> items = itemMapper.selectByExample(example);
		if(items!=null&&items.size()>0) {
			TbItem item = items.get(0);
			return item;
		}
		return null;
	}

	/**
	 * 商品列表查询
	 */
	@Override
	public EUDataGridResult getItemList(int page, int lows) {
		// TODO Auto-generated method stub
		TbItemExample example=new TbItemExample();
		PageHelper.startPage(page, lows);
		List<TbItem> items = itemMapper.selectByExample(example);
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(items);
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(items);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 添加商品
	 * @throws Exception 
	 */
	@Override
	public TaotaoResult creatItem(TbItem item,String desc,String itemParamData) throws Exception {
		//先补全item的信息
		//生成id
		long itemId=IDUtils.genItemId();
		item.setId(itemId);
		//设置状态码  '商品状态，1-正常，2-下架，3-删除'
		item.setStatus((byte) 1);
		//设置创建时间
		item.setCreated(new Date());
		//设置更新时间
		item.setUpdated(new Date());
		//把item插入到数据库
		itemMapper.insert(item);
		//把商品描述添加到数据库
		TaotaoResult result = insertItemDesc(desc, itemId);
	
		if(result.getStatus()!=200) {
			throw new Exception();
		}
		//把商品规格添加到数据库
		insertItemParamItem(itemId, itemParamData);
		if(result.getStatus()!=200) {
			throw new Exception();
		}
		//返回一个自定义的响应结构
		return TaotaoResult.ok();
		
	}
	/**
	 * 添加商品描述
	 * @param desc 商品描述
	 * @param itemId 商品id
	 * @return
	 */
	private TaotaoResult insertItemDesc(String desc,long itemId) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMaapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	/**
	 * 添加规格参数
	 * @param itemId 	商品id
	 * @param itemParamDate 商品规格数据
	 * @return
	 */
	private TaotaoResult insertItemParamItem(Long itemId,String itemParamData) {
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		itemParamItem.setParamData(itemParamData);
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}

}
