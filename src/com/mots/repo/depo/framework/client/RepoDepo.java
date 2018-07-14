package com.mots.repo.depo.framework.client;

import com.google.gwt.core.client.EntryPoint;
import com.mots.repo.depo.framework.client.menu.MainMenuToolStripBar;
import com.mots.repo.depo.framework.client.tab.MainTabSet;
import com.mots.repo.depo.framework.client.template.AbstractTemplate;
import com.mots.repo.depo.framework.client.template.NavigationResultsEditTemplate;
import com.mots.repo.depo.framework.client.template.SearchResultsEditTemplate;
import com.mots.repo.depo.framework.client.util.Configuration;
import com.smartgwt.client.widgets.layout.VLayout;

public class RepoDepo extends VLayout implements EntryPoint {

	private MainMenuToolStripBar mainMenu = new MainMenuToolStripBar();
	private MainTabSet mainTabSet;
	
	@Override
	public void onModuleLoad() {
		
		setWidth100();  
		setHeight100();  
		setMembersMargin(10);  
		
		AbstractTemplate template = new NavigationResultsEditTemplate();
		
		String templateName = Configuration.getTemplateName();
		
		if (templateName.equalsIgnoreCase("NavigationResultsEditTemplate"))
		{
			template = new NavigationResultsEditTemplate();
		}
		else
		{
			template = new SearchResultsEditTemplate();
		}
		
	    mainTabSet = new MainTabSet(template);
	        
	    addMember(mainMenu);
	    addMember(mainTabSet);
	        
	    this.draw();        
	}
	
}
