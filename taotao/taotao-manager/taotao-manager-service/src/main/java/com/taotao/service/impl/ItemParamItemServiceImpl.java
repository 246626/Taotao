/**
 * 
 */
package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.service.ItemParamItemService;

/**
 * @author 追梦人
 *
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
	@Resource
	private TbItemParamItemMapper itemParamItemMapper;
	/**
	 * 展示商品规格参数
	 */
	@Override
	public String getItemParamByItemId(long itemId) {
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()!=0) {
			TbItemParamItem tbItemParamItem = list.get(0);
			//获取规格参数
			String paramData = tbItemParamItem.getParamData();
			//生成html
			//把规格参数转化为Java对象
			List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
			StringBuffer sb = new StringBuffer();
			sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
			sb.append("    <tbody>\n");
			for(Map m1:jsonList) {
				sb.append("        <tr>\n");
				sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
				sb.append("        </tr>\n");
				@SuppressWarnings("unchecked")
				List<Map> list2 = (List<Map>) m1.get("params");
				for(Map m2:list2) {
					sb.append("        <tr>\n");
					sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
					sb.append("            <td>"+m2.get("v")+"</td>\n");
					sb.append("        </tr>\n");
				}
			}
			sb.append("    </tbody>\n");
			sb.append("</table>");
			return sb.toString();
		}else {
			return null;
		}
		
		
		
	
	}

}
