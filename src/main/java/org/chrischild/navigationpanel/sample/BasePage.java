package org.chrischild.navigationpanel.sample;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;

public abstract class BasePage extends WebPage {

    private static final long serialVersionUID = -7416697434511129092L;

    public BasePage(PageParameters parameters) {
        super(parameters);
    }

    public BasePage() {
        // TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see org.apache.wicket.Component#renderHead(org.apache.wicket.markup.head.IHeaderResponse)
     */
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        
        response.render(CssHeaderItem.forReference(FontAwesomeCssReference.instance()));
    }

}
