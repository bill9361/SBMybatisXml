package cn.bill.sbmybatisxml.entity;

/**
 * Description: <br/>
 * Date:2018年8月7日 下午1:25:31 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

@SuppressWarnings("serial")
public class Person extends BaseEntity
{
	private String name;		//姓名
	private String idCardNo;	//身份证号
	private String phoneNo;		//电话号码
	private Integer age;		//年龄
	private String email;		//邮箱

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getIdCardNo()
	{
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo)
	{
		this.idCardNo = idCardNo;
	}

	public String getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	@Override
	public String toString()
	{
		return "Person [name=" + name + ", idCardNo=" + idCardNo + ", phoneNo=" + phoneNo + ", age=" + age + ", email="
				+ email + ", getId()=" + getId() + ", getCreateTime()=" + getCreateTime() + ", getCreateBy()="
				+ getCreateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getUpdateBy()=" + getUpdateBy() + "]";
	}
	
}
