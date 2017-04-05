Wicket Bootstrap Sidebar Navigation
===================================

4.0.0 - This is a complete rewrite of ronsmits sidenavigationpanel project to work with Wicket Bootstrap 0.10.7 (Wicket 7.6.0 & Bootstrap 3.3.6+). The samples are the only items using Wicket Bootstrap and that was to simply load the font-awesome icons quickly. Added functionality to add sub menus and adding font-awesome icons (other icons might work but were never tested).

Using
=====
SideNavigationPanel uses a Builder to add MenuItems to it. SubMenuItems must follow the MenuItem it is associated with. Top level MenuItems do not need a Class passed into the addMenuItem method since they do not link to a page:

    Builder builder = new NavigationPanel.Builder("navigation", getPage(), parameters)
            .addMenuItem(Model.of("Home"), HomePage.class, "fa fa-home", false)
            .addMenuItem(Model.of("User"), null, "fa fa-user", true)
            .addSubMenuItem(Model.of("Add User"), Page1.class, "a fa-user-plus");
    add(new SideNavigationPanel(builder, getPage()));

the markup is

    <wicket:container wicket:id="navigation"/>

The html coming from this is an unordered list with the bootstrap classes added, in the order that you added them to the builder:

    <ul class="nav nav-list">
        <li>
        		<a href="./HomePage.html">
        			<i class="fa fa-home></i>
        			<span>Home</span>
    			</a>
			</li>
        <li class="treeview active">
        		<a href="">
        			<i class="fa fa-user"></i>
        			<span>User</span>
    			</a>
    			<ul class="treeview-menu">
    				<li>
		        		<a href="./Page1.html">
		        			<i class="fa fa-user-plus"></i>
		        			<span>Add User</span>
		    			</a>
					</li>
    			</ul>
			</li>
    </ul>



The way the builder works you can also add stuff like this:

    Builder builder = new Builder("navigation", getPage());
        builder = builder
                .addMenuItem("Home", HomePage.class, "fa fa-home")
                .addMenuItem("List", ListPage.class, "fa fa-list");
        if (checkLogin()) {
            builder.addMenuItem("Add", AddFilm.class, "fa fa-film");
        }
        add(new SideNavigationPanel(builder));
