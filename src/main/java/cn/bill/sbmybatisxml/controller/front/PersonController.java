package cn.bill.sbmybatisxml.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bill.sbmybatisxml.entity.Person;
import cn.bill.sbmybatisxml.service.PersonService;

/**
 * 
 * Description: <br/>
 * Date:2018年8月11日 上午10:16:23 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@RequestMapping("/person")
@Controller
public class PersonController
{
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/person.do")
	public String intoPersonPage()
	{
		return "front/person";
	}
	

	@RequestMapping("/queryById.do")
	public String queryById(String id, Model model) throws Exception
	{
		System.out.println("PersonController...findById():id:"+id);
		Person person = personService.queryById(id);
		model.addAttribute("person", person);
		return "front/person";
	}


	@RequestMapping("/addOrUpdate.do")
	public String addOrUpdate(Person person, Model model) throws Exception
	{
		System.out.println("PersonController...addOrUpdate():person:"+person);
		//保存或更新
		int addOrUpdateFlag = personService.addOrUpdate(person);
		model.addAttribute("addOrUpdateMessage", (addOrUpdateFlag > 0)?"添加或更新成功！":"添加或更新失败！");
		return "front/person";
	}
	
}
