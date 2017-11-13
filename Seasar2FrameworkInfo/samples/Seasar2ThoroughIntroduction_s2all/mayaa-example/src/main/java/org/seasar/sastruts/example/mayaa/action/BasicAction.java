package org.seasar.sastruts.example.mayaa.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.sastruts.example.mayaa.dto.UserDto;
import org.seasar.sastruts.example.mayaa.form.BasicForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class BasicAction {

	@Resource
	@ActionForm
	protected BasicForm basicForm;

	public List<UserDto> userList;

	@Execute(validator=false)
	public String index(){
		this.userList = new ArrayList<UserDto>();
		this.userList.add(new UserDto("山田 太郎", "taro@example.com"));
		this.userList.add(new UserDto("山田 花子", "hana@example.com"));

		return "index.html";
	}

}
