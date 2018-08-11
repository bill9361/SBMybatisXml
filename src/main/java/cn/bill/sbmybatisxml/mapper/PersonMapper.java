package cn.bill.sbmybatisxml.mapper;

import cn.bill.sbmybatisxml.entity.Person;

/**
 * 
 * Description: <br/>
 * Date:2018年8月11日 上午10:05:54 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
public interface PersonMapper 
{

	/**
	 * 根据id查找人员
	 * @return
	 */
	public Person queryById(String id);
	
	/**
	 * 更新
	 * @param fieldMap 需要更新的字段
	 * @return
	 */
	public int update(Person person);
	
	/**
	 * 新增
	 * @param fieldMap 需要更新的字段
	 * @return
	 */
	public int insert(Person person);


}
