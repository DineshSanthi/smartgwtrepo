package com.mots.repo.depo.framework.client.template;

import com.mots.repo.depo.framework.client.panel.EditLayout;
import com.mots.repo.depo.framework.client.panel.NavigationLayout;
import com.mots.repo.depo.framework.client.panel.ResultsLayout;
import com.mots.repo.depo.framework.client.panel.SearchLayout;
import com.smartgwt.client.rpc.RPCManager;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;

public class SearchResultsEditTemplate extends AbstractTemplate{

	private NavigationLayout navigationLayout = new NavigationLayout();
	private SearchLayout searchLayout = new SearchLayout();
    private ResultsLayout resultsLayout = new ResultsLayout();
    private EditLayout editLayout = new EditLayout();
    
    public SearchResultsEditTemplate() {
    	 
    	setWidth100();
    	setHeight100();
    	setLayoutMargin(10);
        
        RPCManager.setAllowCrossDomainCalls(true);

        SectionStack leftSideLayout = new SectionStack();
        leftSideLayout.setWidth(280);
        leftSideLayout.setShowResizeBar(true);
        leftSideLayout.setVisibilityMode(VisibilityMode.MULTIPLE);
        leftSideLayout.setAnimateSections(true);

        SectionStackSection searchSection = new SectionStackSection("Search");
        searchSection.setExpanded(true);
        searchSection.setItems(searchLayout);

        SectionStackSection navigationSection = new SectionStackSection("Collections");
        navigationSection.setExpanded(true);
        navigationSection.setItems(navigationLayout);

        
        leftSideLayout.setSections(searchSection, navigationSection);

        SectionStack rightSideLayout = new SectionStack();
        rightSideLayout.setVisibilityMode(VisibilityMode.MULTIPLE);
        rightSideLayout.setAnimateSections(true);

        SectionStackSection resultsSection = new SectionStackSection("Results");
        resultsSection.setItems(resultsLayout);
        resultsSection.setExpanded(true);

        SectionStackSection editSection = new SectionStackSection("Collection Details");
        
        editSection.setItems(editLayout);
        editSection.setExpanded(true);
        

        rightSideLayout.setSections(resultsSection, editSection);

        this.addMember(leftSideLayout);
        this.addMember(rightSideLayout);        
        
    }

}
