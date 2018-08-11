package cn.bill.sbmybatisxml.service;

import cn.bill.sbmybatisxml.entity.Person;

/**
 * 
 * Description: <br/>
 * Date:2018年8月11日 上午10:08:26 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface PersonService
{


	int addOrUpdate(Person person) throws Exception;


	Person queryById(String id) throws Exception;

}