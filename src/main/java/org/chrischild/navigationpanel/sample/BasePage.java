package org.chrischild.navigationpanel.sample;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class BasePage extends WebPage {

    private static final long serialVersionUID = -7416697434511129092L;

    public BasePage(PageParameters parameters) {
        super(parameters);
    }

    public BasePage() {
        // TODO Auto-generated constructor stub
    }

}
