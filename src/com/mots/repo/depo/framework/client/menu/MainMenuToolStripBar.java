package com.mots.repo.depo.framework.client.menu;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.Cookies;
import com.mots.repo.depo.framework.client.util.Configuration;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;

public class MainMenuToolStripBar extends AbstractToolStrip{

	private static final String skinCookieName = "skin_name_2_4";
	   
	public MainMenuToolStripBar()
	{

        Label appLabel = new Label();
        appLabel.setContents(Configuration.getApplicationName());
        appLabel.setHeight100();
        appLabel.setWidth(200);
        this.addChild(appLabel);
        
		// push all buttons to the right
		this.addFill();
		
		this.addSeparator();

		ToolStripButton iconButton = new ToolStripButton();
		iconButton.setIcon("silk/printer.png");
		iconButton.setTitle("Print");
		this.addButton(iconButton);

		this.addResizer();

		SelectItem themeItem = new SelectItem();
		themeItem.setShowTitle(false);
		themeItem.setWidth(120);

		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		valueMap.put("Enterprise", "Enterprise");
		valueMap.put("EnterpriseBlue", "Enterprise Blue");
		valueMap.put("Graphite", "Graphite");
		valueMap.put("Simplicity", "Simplicity");
		valueMap.put("Tahoe", "Tahoe");
		valueMap.put("BlackOps", "Black Ops");
		valueMap.put("TreeFrog", "Tree Frog");
		valueMap.put("Stratus", "Stratus");
		valueMap.put("fleet", "Fleet");
		valueMap.put("Obsidian", "Obsidian");
		themeItem.setValueMap(valueMap);
		themeItem.setDefaultValue("Enterprise");
		
        String currentSkin = Cookies.getCookie(skinCookieName);
        if (currentSkin == null) {
            currentSkin = "Enterprise";
        }
        themeItem.setDefaultValue(currentSkin);
        themeItem.setShowTitle(false);
        themeItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                Cookies.setCookie(skinCookieName, (String) event.getValue());
                com.google.gwt.user.client.Window.Location.reload();
            }
        });
		
		this.addFormItem(themeItem);

	}
	
}
