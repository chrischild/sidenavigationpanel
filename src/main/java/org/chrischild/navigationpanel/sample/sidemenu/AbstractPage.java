/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chrischild.navigationpanel.sample.sidemenu;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.chrischild.navigationpanel.NavigationPanel;
import org.chrischild.navigationpanel.NavigationPanel.Builder;
import org.chrischild.navigationpanel.SideNavigationPanel;
import org.chrischild.navigationpanel.sample.BasePage;
import org.chrischild.navigationpanel.sample.HomePage;

/**
 *
 * @author Ron
 */
public abstract class AbstractPage extends BasePage {
    private static final long serialVersionUID = 4685823834238906112L;

    public AbstractPage() {
        super();
        setupMenu(new PageParameters());
    }

    public AbstractPage(PageParameters parameters) {
        super(parameters);
        System.out.println("page " + getPage().toString());
        setupMenu(parameters);
    }

    private void setupMenu(PageParameters parameters) {
        setOutputMarkupId(false);
        Builder builder = new NavigationPanel.Builder("navigation", getPage(), parameters)
            .addMenuItem(Model.of("Home"), HomePage.class, "fa fa-home", false)
            .addMenuItem(Model.of("User"), null, "fa fa-user", true)
            .addSubMenuItem(Model.of("Page1"), Page1.class, "fa fa-user-plus")
            .addSubMenuItem(Model.of("Page2"), Page2.class, "fa fa-phone");
        
        add(new SideNavigationPanel(builder, getPage()));
    }
}
