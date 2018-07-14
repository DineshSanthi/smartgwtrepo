package com.mots.repo.depo.framework.client.tab;

import com.mots.repo.depo.framework.client.Constants;
import com.mots.repo.depo.framework.client.template.AbstractTemplate;
import com.mots.repo.depo.framework.client.template.NavigationResultsEditTemplate;
import com.mots.repo.depo.framework.client.util.Localizer;
import com.smartgwt.client.types.Side;
import com.smartgwt.client.types.TabTitleEditEvent;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;

public class MainTabSet extends AbstractTabSet {
	
	public MainTabSet(final AbstractTemplate tempate)
	{
		
		final String tabTitle = Localizer.getMessage(Constants.MAIN_TAB_DEFAULT_DISPLAY_VALUE);
		Tab tab1 = new Tab(tabTitle);  
		Tab tab2 = new Tab("");
		
        this.setTabBarPosition(Side.TOP);  
        this.setTabBarAlign(Side.LEFT);  
        this.setWidth100();;  
        this.setHeight100();  
        this.setTitleEditEvent(TabTitleEditEvent.DOUBLECLICK);
        
        tab1.setPane(tempate);
        tab1.setCanEditTitle(true);

        this.addTab(tab1);
        
        tab2.addTabSelectedHandler(new TabSelectedHandler() {
			
			@Override
			public void onTabSelected(TabSelectedEvent event) {
				Tab newTab = new Tab(tabTitle);
				newTab.setCanClose(true);
				newTab.setCanEditTitle(true);		        
				newTab.setPane(new NavigationResultsEditTemplate());
				addTab(newTab,getTabs().length - 1);
				selectTab(getTabs().length - 2);
			}
		});
        
        this.addTab(tab2);
        
	}

}
