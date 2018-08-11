package cn.bill.sbmybatisxml.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.bill.sbmybatisxml.entity.Person;
import cn.bill.sbmybatisxml.mapper.PersonMapper;
import cn.bill.sbmybatisxml.service.PersonService;
import cn.bill.sbmybatisxml.util.StringUtil;
import cn.bill.sbmybatisxml.util.TimeUtil;

/**
 * 
 * Description: <br/>
 * Date:2018年8月11日 上午10:08:32 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@CacheConfig(cacheNames={"cn.bill.sbmybatisxml.service.impl.PersonServiceImpl"})
@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	private PersonMapper personMapper;
	
	@Cacheable(cacheNames="cn.bill.sbmybatisxml.service.impl.PersonServiceImpl",key="#p0")
	@Override
	public Person queryById(String id) throws Exception
	{
		return personMapper.queryById(id);
	}
	
	
	/**
	 * 添加或更新
	 * @param p
	 * @return
	 * @throws Exception 
	 */
	//会将返回值直接更新到redis缓存的value中
	//@CachePut(cacheNames="cn.bill.sbmybatisxml.service.impl.PersonServiceImpl",key="#p0.id")
	//如果不返回Person，则删除该key的value即可
	@CacheEvict(cacheNames="cn.bill.sbmybatisxml.service.impl.PersonServiceImpl",key="#p0.id")
	@Override
	public int addOrUpdate(Person person) throws Exception
	{
		if(person!= null)
		{
			if(!StringUtil.isEmpty(person.getId()))
			{
				Person queryPerson = personMapper.queryById(person.getId());
				if(queryPerson != null)
				{
					person.setUpdateTime(TimeUtil.getCurrentTime());
					return personMapper.update(person);
				}
				else
				{
					person.setCreateTime(TimeUtil.getCurrentTime());
					return personMapper.insert(person);
				}
			}
			else
			{
				person.setId(UUID.randomUUID().toString().trim());
				person.setCreateTime(TimeUtil.getCurrentTime());
				return personMapper.insert(person);
			}
			
		}
		//TODO
		return 0;
	}
}
