define(['backbone', 'util', 'views/projects/list', 'views/home'], function(Backbone, UTIL, ProjectListView, HomeView) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            'projects': 'showProjects',
			'home'	: 'showHome'
        },
        
        showProjects: function() {
            UTIL.renderView(new ProjectListView());
        },
		
		showHome: function() {
            UTIL.renderView(new HomeView());
        }
        
    });

    var initialize = function() {
        new AppRouter();
        Backbone.history.start();
    };
    
    return {
        initialize: initialize
    };
});