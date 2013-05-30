define(['backbone', 'util', 'views/projects/list'], function(Backbone, UTIL, ProjectListView) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            'projects': 'showProjects'
        },
        
        showProjects: function() {
            UTIL.renderView(new ProjectListView());
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