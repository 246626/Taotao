/**
 * 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamExtendMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.pojo.TbItemParamExtend;
import com.taotao.service.ItemParamService;


@Service
public class ItemParamServiceImpl implements ItemParamService {
	@Resource
	private TbItemParamMapper itemParamMapper;
	@Resource
	private TbItemParamExtendMapper itemParamExtendMapper;
	
	/**
	 * @author 追梦人
	 *根据商品分类的id查找该类商品的规格模板
	 */
	@Override
	public TaotaoResult getItemParamBycId(long cid) {
		TbItemParamExample example=new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0) {
			//查询成功返回该类商品的规格模板
			return TaotaoResult.ok(list.get(0));
		}else {
			return TaotaoResult.ok();
		}
	
		
	}
	/**
	 * 查询所有商品类型的规格模板
	 */
	 
	
		@Override 
	  public EUDataGridResult getItemParamList(int page, int rows) {  
		  
		  
		  List<TbItemParamExtend> list = itemParamExtendMapper.selecTbItemParamExtends();
		  //创建一个返回值对象
			EUDataGridResult result = null;
		  if(list!=null&&list.size()>0) { 
			  result = new EUDataGridResult();
			  result.setRows(list); 
			  PageInfo<TbItemParam> pageInfo = new  PageInfo<TbItemParam>(); 
			  result.setTotal(pageInfo.getTotal()); 
			  return result;
		  }else { 
			  return null; 
		  }
	  
	  }
	 
	
	/**
	 * 新增商品规格模板
	 */
	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		 
		//将itemParam补全
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入数据库中
		int result = itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

}
