package com.insert.portlet;

import com.insert.constants.InsertPortletKeys;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.table.model.Userdata;
import com.table.service.UserdataLocalService;
import com.table.service.UserdataLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Insert",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + InsertPortletKeys.INSERT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InsertPortlet extends MVCPortlet {
	@Reference
	private UserdataLocalService _userdataLocalService;
	
	public void insertsubmit(ActionRequest request,ActionResponse response)
	throws IOException, PortletException, java.io.IOException{
		String name= ParamUtil.getString(request,"name");
		String phone= ParamUtil.getString(request,"phone");
		String age= ParamUtil.getString(request,"age");
		String email= ParamUtil.getString(request,"email");
		String pass= ParamUtil.getString(request,"pass");
		Userdata userdata = _userdataLocalService.createUserdata(CounterLocalServiceUtil.increment());
		userdata.setName(name);
		userdata.setPhone(phone);
		userdata.setAge(age);
		userdata.setEmail(email);
		userdata.setPass(pass);
		_userdataLocalService.addUserdata(userdata);
		System.out.println("Data added to table userdata");
		
		System.out.println("the value is: "+UserdataLocalServiceUtil.getUserdatasCount());
	}
	
	public void updatesubmit(ActionRequest request,ActionResponse response)
			throws IOException, PortletException, java.io.IOException, PortalException{
		
				long uid = ParamUtil.getLong(request, "uid");	
				String name= ParamUtil.getString(request,"name");
				String phone= ParamUtil.getString(request,"phone");
				String age= ParamUtil.getString(request,"age");
				String email= ParamUtil.getString(request,"email");
				String pass= ParamUtil.getString(request,"pass");
				
				Userdata userdata = _userdataLocalService.getUserdata(uid);
				
				userdata.setName(name);
				userdata.setPhone(phone);
				userdata.setAge(age);
				userdata.setEmail(email);
				userdata.setPass(pass);
				
				_userdataLocalService.updateUserdata(userdata);
				System.out.println("USER DATA UPDATED");
				
				System.out.println("the value is: "+UserdataLocalServiceUtil.getUserdatasCount());
			}
	
	public void deletesubmit(ActionRequest request,ActionResponse response)
			throws IOException, PortletException, java.io.IOException, PortalException{
				
				long uid = ParamUtil.getLong(request, "uid");
		
				Userdata userdata = _userdataLocalService.getUserdata(uid);
				_userdataLocalService.deleteUserdata(userdata);
				System.out.println("USER DELETED");
				
				System.out.println("the value is: "+UserdataLocalServiceUtil.getUserdatasCount());
			}
}