package com.mots.repo.depo.framework.client.datasource;

import com.google.gwt.core.client.JavaScriptObject;
import com.mots.repo.depo.framework.client.Constants;
import com.mots.repo.depo.framework.client.util.Configuration;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.JSON;
import com.smartgwt.client.util.SC;

public abstract class AbstractRestDataSource extends RestDataSource {

	public AbstractRestDataSource() {
		setID(SC.generateID("AbstractRestDataSource"));
		setDataFormat(DSDataFormat.JSON);
		setDataProtocol(DSProtocol.POSTMESSAGE);
		setJsonPrefix(null);
		setJsonSuffix(null);
		OperationBinding fetch = new OperationBinding();
		fetch.setOperationType(DSOperationType.FETCH);
		fetch.setDataProtocol(DSProtocol.GETPARAMS);
		fetch.setDataProtocol(DSProtocol.POSTMESSAGE);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("GET");
		fetch.setRequestProperties(fetchProps);

		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		add.setDataProtocol(DSProtocol.POSTMESSAGE);
		DSRequest addProps = new DSRequest();
		addProps.setHttpMethod("POST");
		addProps.setContentType("application/json");
		add.setRequestProperties(addProps);

		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		update.setDataProtocol(DSProtocol.POSTMESSAGE);

		DSRequest updateProps = new DSRequest();
		updateProps.setHttpMethod("PUT");
		updateProps.setContentType("application/json");
		update.setRequestProperties(updateProps);

		OperationBinding remove = new OperationBinding();
		remove.setOperationType(DSOperationType.REMOVE);
		DSRequest removeProps = new DSRequest();
		removeProps.setHttpMethod("DELETE");
		removeProps.setContentType("application/json");
		remove.setRequestProperties(removeProps);
		setOperationBindings(fetch, add, update, remove);

		DataSourceTextField appId = new DataSourceTextField(getPrimaryKeyFieldId(), "ID");
		appId.setPrimaryKey(true);
		appId.setHidden(true);
		appId.setCanEdit(false);
		addField(appId);

		setFetchDataURL(getServiceRoot() + "/all");
		setAddDataURL(getServiceRoot() + "/insert");
		setUpdateDataURL(getServiceRoot() + "/update");
		setRemoveDataURL(getServiceRoot() + "/delete");
		
		setEntityFields();

	}

	protected String getServiceRoot() {
		return Configuration.getServiceUrl() + getServiceName();
	}

	protected abstract void setEntityFields();

	protected abstract String getServiceName();

	protected String getPrimaryKeyFieldId() {
		return Constants.ID;
	}

	@Override
	protected Object transformRequest(DSRequest dsRequest) {
		if (dsRequest.getOperationType() == DSOperationType.UPDATE) {
			final JavaScriptObject basicJSObject = dsRequest.getOldValues().getJsObj();
			final JavaScriptObject latestChanges = dsRequest.getData();
			JSOHelper.addProperties(basicJSObject, latestChanges);
			final String resultString = JSON.encode(basicJSObject);
			return resultString;
		} else if (dsRequest.getOperationType() == DSOperationType.ADD) {
			final JavaScriptObject latestChanges = dsRequest.getData();
			final String resultString = JSON.encode(latestChanges);
			return resultString;
		} else if (dsRequest.getOperationType() == DSOperationType.REMOVE) {
			String primaryKey = dsRequest.getOldValues().getAttribute(getPrimaryKeyFieldId());
			dsRequest.setActionURL(getRemoveDataURL() + "/" + primaryKey);
		}		
		return super.transformRequest(dsRequest);
	}

	@Override
	protected void transformResponse(DSResponse response, DSRequest request, Object data) {
		super.transformResponse(response, request, data);
	}
	
}
