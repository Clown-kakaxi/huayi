package com.yuchengtech.emp.ecif.customer.simplegroup.web;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Maps;
import com.yuchengtech.emp.biappframe.base.web.BaseController;
import com.yuchengtech.emp.bione.dao.SearchResult;
import com.yuchengtech.emp.bione.entity.page.Pager;
import com.yuchengtech.emp.ecif.base.util.ResultUtil;
import com.yuchengtech.emp.ecif.customer.entity.perfinance.PersonAsset;
import com.yuchengtech.emp.ecif.customer.simplegroup.service.PersonAssetBS;
@Controller
@RequestMapping("/ecif/perfinance/personasset")
public class PersonAssetController extends BaseController {
	@Autowired
	private PersonAssetBS PersonAssetBS;
	@Autowired
	private ResultUtil resultUtil;
	protected static Logger log = LoggerFactory
			.getLogger(PersonAssetController.class);
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("custId") String custId,
			@RequestParam("URL") String URL) {
		return new ModelAndView(URL, "custId", custId);
	}


	@RequestMapping(value = "/list.*", method = RequestMethod.POST)
	@ResponseBody
		public Map<String, Object> showPersonAsset(Pager pager,@RequestParam("custId") long custId) {
			Map<String, Object> userMap = Maps.newHashMap();
			SearchResult<PersonAsset> searchResult = PersonAssetBS.getPersonAssetList(
					pager.getPageFirstIndex(), pager.getPagesize(),
					pager.getSortname(), pager.getSortorder(),
					pager.getSearchCondition(),custId);
			List<PersonAsset> list = null;
			try {
				list = resultUtil.jpaListObjectsDictTran(searchResult.getResult(), PersonAsset.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
			userMap.put("Rows", list);
			userMap.put("Total", searchResult.getTotalCount());
			return userMap;
		}
	}

