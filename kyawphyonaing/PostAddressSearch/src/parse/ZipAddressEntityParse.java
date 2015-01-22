package parse;

import org.xmlpull.v1.XmlPullParser;

import android.text.TextUtils;
import entity.BaseEntity;
import entity.ZipAddressEntity;

public class ZipAddressEntityParse 
extends BaseXmlParse{
	
	ZipAddressEntity _entity;

	@Override
	protected void onStartTag(XmlPullParser parser) {
		
		if(_entity == null){
			_entity = new ZipAddressEntity();
		}
		
		
		String stateKana = 
				parser.getAttributeValue
				(null,"state_kana");
		if(!TextUtils.isEmpty(stateKana))
			_entity.setStateKana(stateKana);
		
		String cityKana = 
				parser.getAttributeValue(null,"city_kana");
		if(!TextUtils.isEmpty(cityKana))
			_entity.setCityKana(cityKana);
		
		String addressKana = 
				parser.getAttributeValue(null,"address_kana");
		if(!TextUtils.isEmpty(addressKana))
			_entity.setAddressKana(addressKana);

		String companyKana = 
				parser.getAttributeValue(null,"company_kana");
		if(!TextUtils.isEmpty(companyKana))
			_entity.setCompanyKana(companyKana);
		
		String state = 
				parser.getAttributeValue(null,"state");
		if(!TextUtils.isEmpty(state))
			_entity.setState(state);
		
		String city = 
				parser.getAttributeValue(null,"city");
		if(!TextUtils.isEmpty(city))
			_entity.setCity(city);
		
		String address = 
				parser.getAttributeValue(null,"address");
		if(!TextUtils.isEmpty(address))
			_entity.setAddress(address);
		
		String company = 			
				parser.getAttributeValue(null,"company");
		if(!TextUtils.isEmpty(company))
			_entity.setCompany(company);
	}

	@Override
	protected void onEndTag(XmlPullParser parser) {
		// TODO 自動生成されたメソッド・スタブ
		XmlPullParser test = parser;
	}

	@Override
	protected BaseEntity getResponse() {
		return _entity;
	}

}
