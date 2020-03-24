/**
 * 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;

/**
 * 内容管理
 * @author 追梦人
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	@Resource
	private TbContentMapper contentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	
	/**
	 * 根据CategoryId查询Content
	 */
	@Override
	public EUDataGridResult selectContentByCatId(long categoryId,int page,int rows) {
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		PageHelper.startPage(page, rows); 
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbContent> pagInfo=new PageInfo<TbContent>();
		result.setTotal(pagInfo.getTotal());
		return result;
	}
	/**
	 * 新增内容
	 */
	@Override
	public TaotaoResult insertContent(TbContent content) {
		// TODO Auto-generated method stub
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		try {
			//添加同步，即调用rest的服务删除缓存，再次访问时重新添加缓存
			HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return TaotaoResult.ok();
	}
	/**
	 * 根据id删除内容
	 */
	@Override
	public TaotaoResult deleteContent(long ids) {
		// TODO Auto-generated method stub
		Long parentId = contentMapper.selectByPrimaryKey(ids).getCategoryId();
		int index = contentMapper.deleteByPrimaryKey(ids);
		
		if (index!=0) {
			try {
				//添加同步，即调用rest的服务删除缓存，再次访问时重新添加缓存
				HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+parentId);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return TaotaoResult.ok();
		}else {
			return null;
		}
		
	}
	/**
	 * 根据id编辑内容
	 */
	@Override
	public TaotaoResult updateContent(TbContent content) {
		//content.setCreated(new Date());
		content.setUpdated(new Date());
		int index = contentMapper.updateByPrimaryKey(content);
		if(index!=0) {
			try {
				//添加同步，即调用rest的服务删除缓存，再次访问时重新添加缓存
				HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return TaotaoResult.ok();
		}else {
		return null;
		}
	}

}
