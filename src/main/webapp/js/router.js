define(['jquery', 'underscore', 'backbone', 'views/projects/list'], function($, _, Backbone, ProjectListView) {
    var AppRouter = Backbone.Router.extend({
        routes: {
            'projects': 'showProjects',
            '*actions': 'defaultAction'
        }
    });

    var initialize = function() {
        var app_router = new AppRouter;
        app_router.on('route:showProjects', function() {
            var projectListView = new ProjectListView();
            projectListView.render();
        });

        app_router.on('route:defaultAction', function(actions) {
            console.log('No route:', actions);
        });

        Backbone.history.start();
    };
    return {
        initialize: initialize
    };
});